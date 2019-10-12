package org.chaofei.output;

public class OutputHelperSetter {
    IOutputGenerator outputGenerator;

    public void setOutputGenerator(IOutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }
    
    public void generateOutput() {
        outputGenerator.generateoutput();
    }
}
