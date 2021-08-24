package com.example.erarest.erarest;

import java.io.IOException;
import com.opencsv.exceptions.CsvException;

public class runProject {
    public static String Output(long l) throws IOException, CsvException{
    
		String[] s1 = ReadDataFromCsv.readDataFromCsv(l).split("<");  // full string is : binRecord in json string < country
		String cur = HashCsv.hashCsv(s1[1]); //passing country to get map its currency
        return s1[0]+"\n"+ApiCalls.apiCallByCountry(cur); //final output
    }
}