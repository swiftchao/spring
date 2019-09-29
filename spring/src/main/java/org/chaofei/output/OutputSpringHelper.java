package org.chaofei.output;

public class OutputSpringHelper {
    IOutputGenerator outputGenerator;
    
    public void generateOutput() {
        outputGenerator.generateoutput();
    }
    
    public void setOutputGenerator(IOutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }
}
