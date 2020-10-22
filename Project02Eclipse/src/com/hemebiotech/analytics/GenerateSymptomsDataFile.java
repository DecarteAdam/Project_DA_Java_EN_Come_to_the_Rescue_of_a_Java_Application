package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * Generates an output file with computed elements.
 */
public class GenerateSymptomsDataFile implements IGenerate {
    Map<String, Integer> result;

    public GenerateSymptomsDataFile(Map<String, Integer> list) {
        this.result = list;
    }

    /**
     * Transform a Map to ArrayList then generate the output
     */
    @Override
    public void generate() throws IOException {

        /* Transform Map to ArrayList */
        Set<Map.Entry<String, Integer>> entrySet = result.entrySet();
        ArrayList<Map.Entry<String, Integer>> listOfEntry = new ArrayList<>(entrySet);

        /*Write the the file line by line*/
        FileWriter writer = new FileWriter ("result.out");
        for (Map.Entry<String, Integer> stringIntegerEntry : listOfEntry) {
            writer.write(stringIntegerEntry + "\n");
        }
        writer.close();

    }
}
