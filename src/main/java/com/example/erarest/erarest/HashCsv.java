package com.example.erarest.erarest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HashCsv {
	static String hashCsv(String s) throws IOException {
		HashMap<String, String> csvHash = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader("F:\\visaProject\\MC-SBART\\out4.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				csvHash.put(values[0], values[1]);
			}
		}
		return (csvHash.get(s)); // currency
	}
}