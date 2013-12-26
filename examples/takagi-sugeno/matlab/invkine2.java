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

public class invkine2{
public static void main(String[] args){
Engine engine = new Engine();
engine.setName("invkine2");

InputVariable inputVariable1 = new InputVariable();
inputVariable1.setEnabled(true);
inputVariable1.setName("input1");
inputVariable1.setRange(-6.28700000, 17.00000000);
inputVariable1.addTerm(new Bell("in1mf1", -5.76300000, 3.01500000, 1.85100000));
inputVariable1.addTerm(new Bell("in1mf2", -1.62400000, 3.13000000, 2.11100000));
inputVariable1.addTerm(new Bell("in1mf3", 3.55200000, 3.19300000, 2.10400000));
inputVariable1.addTerm(new Bell("in1mf4", 8.27300000, 2.90700000, 1.98500000));
inputVariable1.addTerm(new Bell("in1mf5", 13.23200000, 2.70800000, 2.05600000));
inputVariable1.addTerm(new Bell("in1mf6", 17.78300000, 1.63500000, 1.89700000));
engine.addInputVariable(inputVariable1);

InputVariable inputVariable2 = new InputVariable();
inputVariable2.setEnabled(true);
inputVariable2.setName("input2");
inputVariable2.setRange(0.00000000, 16.97200000);
inputVariable2.addTerm(new Bell("in2mf1", 0.00500000, 1.87700000, 1.99500000));
inputVariable2.addTerm(new Bell("in2mf2", 3.31200000, 2.01700000, 1.82900000));
inputVariable2.addTerm(new Bell("in2mf3", 6.56800000, 2.26100000, 1.79300000));
inputVariable2.addTerm(new Bell("in2mf4", 10.11100000, 2.74100000, 1.97800000));
inputVariable2.addTerm(new Bell("in2mf5", 14.95200000, 2.04500000, 1.78300000));
inputVariable2.addTerm(new Bell("in2mf6", 17.91000000, 0.82400000, 1.73400000));
engine.addInputVariable(inputVariable2);

OutputVariable outputVariable = new OutputVariable();
outputVariable.setEnabled(true);
outputVariable.setName("output");
outputVariable.setRange(0.00000000, 3.10000000);
outputVariable.setLockOutputRange(false);
outputVariable.setLockValidOutput(false);
outputVariable.setDefaultValue(Double.NaN);
outputVariable.setDefuzzifier(new WeightedAverage());
outputVariable.fuzzyOutput().setAccumulation(new Maximum());
outputVariable.addTerm(Linear.create("out1mf1", engine.getInputVariables(), -0.04800000, 1.45600000, 2.22200000));
outputVariable.addTerm(Linear.create("out1mf2", engine.getInputVariables(), -0.21800000, -0.30500000, 2.04200000));
outputVariable.addTerm(Linear.create("out1mf3", engine.getInputVariables(), 0.02600000, -0.14100000, 3.06700000));
outputVariable.addTerm(Linear.create("out1mf4", engine.getInputVariables(), 0.05200000, -0.15000000, 3.41900000));
outputVariable.addTerm(Linear.create("out1mf5", engine.getInputVariables(), 0.11300000, -0.18900000, 4.33900000));
outputVariable.addTerm(Linear.create("out1mf6", engine.getInputVariables(), 2.54300000, 0.36100000, -2.73800000));
outputVariable.addTerm(Linear.create("out1mf7", engine.getInputVariables(), 2.51700000, -6.80900000, 23.35300000));
outputVariable.addTerm(Linear.create("out1mf8", engine.getInputVariables(), -0.20800000, -0.39400000, 4.47200000));
outputVariable.addTerm(Linear.create("out1mf9", engine.getInputVariables(), -0.04600000, -0.30000000, 4.45200000));
outputVariable.addTerm(Linear.create("out1mf10", engine.getInputVariables(), -0.00600000, -0.21700000, 4.19500000));
outputVariable.addTerm(Linear.create("out1mf11", engine.getInputVariables(), 0.08900000, -0.25400000, 4.99200000));
outputVariable.addTerm(Linear.create("out1mf12", engine.getInputVariables(), -0.03300000, 0.10300000, -2.01200000));
outputVariable.addTerm(Linear.create("out1mf13", engine.getInputVariables(), 1.35500000, 1.22800000, -5.67800000));
outputVariable.addTerm(Linear.create("out1mf14", engine.getInputVariables(), -0.24500000, -0.12400000, 3.75300000));
outputVariable.addTerm(Linear.create("out1mf15", engine.getInputVariables(), -0.09900000, -0.11100000, 3.30400000));
outputVariable.addTerm(Linear.create("out1mf16", engine.getInputVariables(), -0.05200000, -0.16300000, 3.56000000));
outputVariable.addTerm(Linear.create("out1mf17", engine.getInputVariables(), 0.09900000, -0.26000000, 4.66200000));
outputVariable.addTerm(Linear.create("out1mf18", engine.getInputVariables(), 0.08200000, -1.84900000, 31.10400000));
outputVariable.addTerm(Linear.create("out1mf19", engine.getInputVariables(), 2.18000000, -2.96300000, -0.06100000));
outputVariable.addTerm(Linear.create("out1mf20", engine.getInputVariables(), -0.98200000, 0.51000000, 5.65700000));
outputVariable.addTerm(Linear.create("out1mf21", engine.getInputVariables(), -0.08700000, -0.17900000, 3.74400000));
outputVariable.addTerm(Linear.create("out1mf22", engine.getInputVariables(), -0.12400000, -0.16100000, 4.09400000));
outputVariable.addTerm(Linear.create("out1mf23", engine.getInputVariables(), 0.38300000, 0.00700000, -1.55900000));
outputVariable.addTerm(Linear.create("out1mf24", engine.getInputVariables(), -8.41500000, 2.08300000, 5.17700000));
outputVariable.addTerm(Linear.create("out1mf25", engine.getInputVariables(), 1.72100000, -15.07900000, -0.68700000));
outputVariable.addTerm(Linear.create("out1mf26", engine.getInputVariables(), -1.04300000, -0.78600000, 20.51000000));
outputVariable.addTerm(Linear.create("out1mf27", engine.getInputVariables(), -0.24900000, -0.39600000, 6.99500000));
outputVariable.addTerm(Linear.create("out1mf28", engine.getInputVariables(), -0.07600000, -0.24500000, 4.41600000));
outputVariable.addTerm(Linear.create("out1mf29", engine.getInputVariables(), 0.76500000, -1.48800000, 17.38400000));
outputVariable.addTerm(Linear.create("out1mf30", engine.getInputVariables(), -21.21000000, -43.02200000, -2.52200000));
outputVariable.addTerm(Linear.create("out1mf31", engine.getInputVariables(), -0.66100000, 3.52300000, 6.21500000));
outputVariable.addTerm(Linear.create("out1mf32", engine.getInputVariables(), -1.99800000, 1.58200000, 33.25600000));
outputVariable.addTerm(Linear.create("out1mf33", engine.getInputVariables(), -2.06800000, 5.67300000, 6.52000000));
outputVariable.addTerm(Linear.create("out1mf34", engine.getInputVariables(), -5.04400000, 7.09300000, 3.51600000));
outputVariable.addTerm(Linear.create("out1mf35", engine.getInputVariables(), -46.04900000, -35.02100000, -2.92600000));
outputVariable.addTerm(Linear.create("out1mf36", engine.getInputVariables(), -0.44800000, -0.77000000, -0.04100000));
engine.addOutputVariable(outputVariable);

RuleBlock ruleBlock = new RuleBlock();
ruleBlock.setEnabled(true);
ruleBlock.setName("");
ruleBlock.setConjunction(new AlgebraicProduct());
ruleBlock.setDisjunction(new Maximum());
ruleBlock.setActivation(new AlgebraicProduct());
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf1 then output is out1mf1", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf2 then output is out1mf2", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf3 then output is out1mf3", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf4 then output is out1mf4", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf5 then output is out1mf5", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf1 and input2 is in2mf6 then output is out1mf6", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf1 then output is out1mf7", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf2 then output is out1mf8", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf3 then output is out1mf9", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf4 then output is out1mf10", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf5 then output is out1mf11", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf2 and input2 is in2mf6 then output is out1mf12", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf1 then output is out1mf13", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf2 then output is out1mf14", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf3 then output is out1mf15", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf4 then output is out1mf16", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf5 then output is out1mf17", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf3 and input2 is in2mf6 then output is out1mf18", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf1 then output is out1mf19", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf2 then output is out1mf20", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf3 then output is out1mf21", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf4 then output is out1mf22", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf5 then output is out1mf23", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf4 and input2 is in2mf6 then output is out1mf24", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf1 then output is out1mf25", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf2 then output is out1mf26", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf3 then output is out1mf27", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf4 then output is out1mf28", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf5 then output is out1mf29", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf5 and input2 is in2mf6 then output is out1mf30", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf1 then output is out1mf31", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf2 then output is out1mf32", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf3 then output is out1mf33", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf4 then output is out1mf34", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf5 then output is out1mf35", engine));
ruleBlock.addRule(Rule.parse("if input1 is in1mf6 and input2 is in2mf6 then output is out1mf36", engine));
engine.addRuleBlock(ruleBlock);


}
}
