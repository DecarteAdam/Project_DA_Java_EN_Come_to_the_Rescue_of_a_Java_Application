package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CalculSymptoms implements ICalculSymptoms {

    ArrayList<String> result;

    public CalculSymptoms(ArrayList<String> list) {
        this.result = list;
    }

    /** Count duplicates of elements
     * @return a map with counted symptoms
     * */
    @Override
    public Map<String, Integer> calculSymptoms() {

        Map<String, Integer> newArr = new TreeMap<>(String::compareTo);
        for (String i: result){
            Integer j = newArr.get(i);
            newArr.put(i, (j == null) ? 1 : j + 1);
        }
        return newArr;
    }
}
