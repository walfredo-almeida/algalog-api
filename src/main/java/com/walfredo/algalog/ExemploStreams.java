package com.walfredo.algalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExemploStreams {

	public static void main(String[] args) {
		//declare and initialize the array list
		 List<String> randomValues = Arrays.asList(
		 "E11", "D12", "A13", "F14", "C15", "A16",
		 "B11", "B12", "C13", "B14", "B15", "B16",
		 "F12", "E13", "C11", "C14", "A15", "C16",
		 "F11", "C12", "D13", "E14", "D15", "D16"
		 );
		
//		 //declare the array list will store needed values
//		 List<String> requiredValues = new ArrayList<>();
//		 //extracting the required values and storing them in reqquiredValues
//		 randomValues.forEach(value -> {
//		 if(value.startsWith("C")) {
//		 requiredValues.add(value);
//		 }
//		 });
//		 //sort the requiredValues in ascending order
//		 requiredValues.sort((String value1, String value2) -> value1.compareTo(value2));
//		 //print each value to the console
//		 requiredValues.forEach((String value) -> System.out.println(value));
		 
		//retrieves only values that start with C, sort them, and print them to the console.
		 randomValues.stream().filter(value->value.startsWith("C")).sorted().forEach(System.out::println);
		 

	}

}
