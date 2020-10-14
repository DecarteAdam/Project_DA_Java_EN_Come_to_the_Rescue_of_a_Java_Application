package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface IGenerate {
    ArrayList<Map.Entry<String, Integer>> Generate() throws IOException;
}
