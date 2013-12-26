import com.fuzzylite.*;
import com.fuzzylite.defuzzifier.*;
import com.fuzzylite.factory.*;
import com.fuzzylite.hedge.*;
import com.fuzzylite.imex.*;
import com.fuzzylite.norm.*;
import com.fuzzylite.norm.s.*;
import com.fuzzylite.norm.t.*;
import com.fuzzylite.rule.*;
import com.fuzzylite.term.*;
import com.fuzzylite.variable.*;

public class sltbu_fl{
public static void main(String[] args){
Engine engine = new Engine();
engine.setName("sltbu");

InputVariable inputVariable1 = new InputVariable();
inputVariable1.setEnabled(true);
inputVariable1.setName("distance");
inputVariable1.setRange(0.00000000, 25.00000000);
inputVariable1.addTerm(new ZShape("near", 1.00000000, 2.00000000));
inputVariable1.addTerm(new SShape("far", 1.00000000, 2.00000000));
engine.addInputVariable(inputVariable1);

InputVariable inputVariable2 = new InputVariable();
inputVariable2.setEnabled(true);
inputVariable2.setName("control1");
inputVariable2.setRange(-0.78500000, 0.78500000);
engine.addInputVariable(inputVariable2);

InputVariable inputVariable3 = new InputVariable();
inputVariable3.setEnabled(true);
inputVariable3.setName("control2");
inputVariable3.setRange(-0.78500000, 0.78500000);
engine.addInputVariable(inputVariable3);

OutputVariable outputVariable = new OutputVariable();
outputVariable.setEnabled(true);
outputVariable.setName("control");
outputVariable.setRange(-0.78500000, 0.78500000);
outputVariable.setLockOutputRange(false);
outputVariable.setLockValidOutput(false);
outputVariable.setDefaultValue(Double.NaN);
outputVariable.setDefuzzifier(new WeightedAverage());
outputVariable.fuzzyOutput().setAccumulation(new Maximum());
outputVariable.addTerm(Linear.create("out1mf1", engine.getInputVariables(), 0.00000000, 0.00000000, 1.00000000, 0.00000000));
outputVariable.addTerm(Linear.create("out1mf2", engine.getInputVariables(), 0.00000000, 1.00000000, 0.00000000, 0.00000000));
engine.addOutputVariable(outputVariable);

RuleBlock ruleBlock = new RuleBlock();
ruleBlock.setEnabled(true);
ruleBlock.setName("");
ruleBlock.setConjunction(new AlgebraicProduct());
ruleBlock.setDisjunction(new Maximum());
ruleBlock.setActivation(new AlgebraicProduct());
ruleBlock.addRule(Rule.parse("if distance is near then control is out1mf1", engine));
ruleBlock.addRule(Rule.parse("if distance is far then control is out1mf2", engine));
engine.addRuleBlock(ruleBlock);


}
}
