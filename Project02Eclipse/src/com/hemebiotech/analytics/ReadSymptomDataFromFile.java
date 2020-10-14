package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	private String filepath;

	private final static Logger LOGGER = Logger.getLogger(ReadSymptomDataFromFile.class.getName());



	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/* Read the file */
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<>();
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				Collections.sort(result);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
				LOGGER.log(Level.SEVERE, "Fichier non trouvé!");
			}
		}

		return result;
	}

}
