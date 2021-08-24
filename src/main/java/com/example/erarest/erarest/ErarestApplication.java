package com.example.erarest.erarest;

import java.io.IOException;
import com.opencsv.exceptions.CsvException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class ErarestApplication {

	public static void main(String[] args) throws IOException, CsvException {
		
		StopWatch timeMeasure = new StopWatch();

		timeMeasure.start();
		
		SpringApplication.run(ErarestApplication.class, args);
		
		
		timeMeasure.stop();

		System.out.println("Total Time : " 
					+ timeMeasure.getTotalTimeSeconds());  
		
	}
}

