package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {

		Map<String, Integer> result;
		ArrayList<String> list;

		/**
		 * Read the 'symptoms.txt file
		 * @param filepath is a path to the file t read
		 */
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile("/Users/adam/Documents/OC_Projects/Project_2/Project02Eclipse/symptoms.txt");
		list = (ArrayList<String>) readSymptomDataFromFile.getSymptoms();
		System.out.println(list);


		/** Compute symptoms in 'symptoms.txt' file
		 * @param list is an arrayList of symptoms
		 * */
		CalculSymptoms calculSymptoms = new CalculSymptoms(list);
		result =  calculSymptoms.calculSymptoms();
		System.out.println(result);

		/** Generate a new 'result.out' output file
		 * @param result is map of calculated symptoms
		 * */
		GenerateSymptomsDataFile generateSymptomsDataFile = new GenerateSymptomsDataFile(result);
		generateSymptomsDataFile.generate();

	}
}
