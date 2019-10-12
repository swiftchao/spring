package org.chaofei.output;

public class OutputHelperConstructor {
    IOutputGenerator outputGenerator;

    public OutputHelperConstructor(IOutputGenerator outputGenerator) {
        super();
        this.outputGenerator = outputGenerator;
    }
    
    public void generateOutput() {
        outputGenerator.generateoutput();
    }
    
}
