package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class GenerateSymptomsDataFile implements IGenerate {
    Map<String, Integer> result;

    /**
     * generate output
     * */

    public GenerateSymptomsDataFile(Map<String, Integer> list) {
        this.result = list;
    }

    @Override
    public ArrayList<Map.Entry<String, Integer>> generate() throws IOException {

        /** Transform Map to ArrayList
         * */
        Set<Map.Entry<String, Integer>> entrySet = result.entrySet();
        ArrayList<Map.Entry<String, Integer>> listOfEntry = new ArrayList<>(entrySet);

        /**
         * Write the the file line by line
         * @return a list of entries
         * */
        FileWriter writer = new FileWriter ("result.out");
        for (Map.Entry<String, Integer> stringIntegerEntry : listOfEntry) {
            writer.write(stringIntegerEntry + "\n");
        }
        writer.close();
        return listOfEntry;

    }
}
