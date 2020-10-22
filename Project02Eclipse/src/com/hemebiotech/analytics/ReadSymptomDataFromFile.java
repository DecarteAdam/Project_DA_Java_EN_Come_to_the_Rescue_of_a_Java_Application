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
 * Read the the txt file
 */
public class ReadSymptomDataFromFile implements ISymptomReader {
	private final String filepath;
	private final static Logger LOGGER = Logger.getLogger(ReadSymptomDataFromFile.class.getName());

	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/* Read the file */
	/**
	 * @return result an arrayList of elements in txt file
	 */
	@Override
	public List<String> getSymptoms() {
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
