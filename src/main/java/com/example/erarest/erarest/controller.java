package com.example.erarest.erarest;

import java.io.IOException;
import com.opencsv.exceptions.CsvException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
	
	@GetMapping("/binrecord/{binValue}")
	public String getData(@PathVariable String binValue) throws NumberFormatException, IOException, CsvException{
		
		return runProject.Output(Long.parseLong(binValue));
	}
}