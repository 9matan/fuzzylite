#include <fl/Headers.h>

int main(int argc, char** argv){
fl::Engine* engine = new fl::Engine;
engine->setName("Investment-Portfolio");

fl::InputVariable* inputVariable1 = new fl::InputVariable;
inputVariable1->setEnabled(true);
inputVariable1->setName("Age");
inputVariable1->setRange(20.00000000, 100.00000000);
inputVariable1->addTerm(new fl::ZShape("Young", 30.00000000, 90.00000000));
inputVariable1->addTerm(new fl::SShape("Old", 30.00000000, 90.00000000));
engine->addInputVariable(inputVariable1);

fl::InputVariable* inputVariable2 = new fl::InputVariable;
inputVariable2->setEnabled(true);
inputVariable2->setName("RiskTolerance");
inputVariable2->setRange(0.00000000, 10.00000000);
inputVariable2->addTerm(new fl::ZShape("Low", 2.00000000, 8.00000000));
inputVariable2->addTerm(new fl::SShape("High", 2.00000000, 8.00000000));
engine->addInputVariable(inputVariable2);

fl::OutputVariable* outputVariable = new fl::OutputVariable;
outputVariable->setEnabled(true);
outputVariable->setName("PercentageInStocks");
outputVariable->setRange(0.00000000, 100.00000000);
outputVariable->setLockOutputRange(false);
outputVariable->setDefaultValue(fl::nan);
outputVariable->setLockValidOutput(false);
outputVariable->setDefuzzifier(new fl::Centroid(200));
outputVariable->fuzzyOutput()->setAccumulation(new fl::EinsteinSum);
outputVariable->addTerm(new fl::Gaussian("AboutFifteen", 15.00000000, 10.00000000));
outputVariable->addTerm(new fl::Gaussian("AboutFifty", 50.00000000, 10.00000000));
outputVariable->addTerm(new fl::Gaussian("AboutEightyFive", 85.00000000, 10.00000000));
engine->addOutputVariable(outputVariable);

fl::RuleBlock* ruleBlock = new fl::RuleBlock;
ruleBlock->setEnabled(true);
ruleBlock->setName("");
ruleBlock->setConjunction(new fl::EinsteinProduct);
ruleBlock->setDisjunction(new fl::EinsteinSum);
ruleBlock->setActivation(new fl::EinsteinProduct);
ruleBlock->addRule(fl::Rule::parse("if Age is Young or RiskTolerance is High then PercentageInStocks is AboutEightyFive", engine));
ruleBlock->addRule(fl::Rule::parse("if Age is Old or RiskTolerance is Low then PercentageInStocks is AboutFifteen", engine));
ruleBlock->addRule(fl::Rule::parse("if Age is not extremely Old and RiskTolerance is not extremely Low then PercentageInStocks is AboutFifty with 0.50000000", engine));
ruleBlock->addRule(fl::Rule::parse("if Age is not extremely Young and RiskTolerance is not extremely High then PercentageInStocks is AboutFifty with 0.50000000", engine));
engine->addRuleBlock(ruleBlock);


}
