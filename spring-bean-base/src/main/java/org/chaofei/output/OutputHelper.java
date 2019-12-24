package org.chaofei.output;

public class OutputHelper {
    IOutputGenerator outputGenerator;

    public OutputHelper() {
        super();
    }
    
    public OutputHelper(IOutputGenerator outputGenerator) {
        super();
        this.outputGenerator = outputGenerator;
    }

    public void generateOutput() {
        outputGenerator.generateoutput();
    }
    
}
