package org.chaofei.output;

import org.chaofei.output.impl.CsvOutputGenerator;

public class OutputHelper {
    IOutputGenerator outputGenerator;
    
    public OutputHelper() {
        outputGenerator = new CsvOutputGenerator();
    }
    
    public void generateOutput() {
        outputGenerator.generateoutput();
    }
}
