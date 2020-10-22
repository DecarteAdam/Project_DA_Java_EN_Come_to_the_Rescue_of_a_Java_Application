package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AnalyticsCounter {
	Map<String, Integer> result;
	ArrayList<String> list;

	public static void main(String args[]) throws Exception {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter();
		analyticsCounter.readSymptoms();
		analyticsCounter.calculSymptoms();
		analyticsCounter.generateSymptoms();
	}

	private void generateSymptoms() throws IOException {
		/* Generate a new 'result.out' output file
		 result is map of counted symptoms */
		GenerateSymptomsDataFile generateSymptomsDataFile = new GenerateSymptomsDataFile(result);
		generateSymptomsDataFile.generate();
	}

	private void calculSymptoms() {
		/* Compute symptoms in 'symptoms.txt' file
		  list is an arrayList of symptoms */
		CalculSymptoms calculSymptoms = new CalculSymptoms(list);
		result =  calculSymptoms.calculSymptoms();
		System.out.println(result);
	}

	public void readSymptoms(){
		/* Read the 'symptoms.txt file filepath is a path to the file t read */
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("/Users/adam/Documents/OC_Projects/Project_2/Project02Eclipse/symptoms.txt");
		list = (ArrayList<String>) readSymptomDataFromFile.getSymptoms();
	}
}
