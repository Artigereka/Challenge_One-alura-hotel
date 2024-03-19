package com.alura.hotel.test;

import com.alura.hotel.utils.Validations;

public class TestValidations {
	
	public static void main(String[] args) {

		System.out.println(Validations.isValidNumber("20"));
		System.out.println(Validations.isValidString("pedro"));
		System.out.println(Validations.isValidDate("2023-06-03"));
		System.out.println(Validations.isValidPayment("Efectivo"));
		System.out.println(Validations.isValidNationality("paraguaya"));
		System.out.println(Validations.capitalize("pEdRo"));
		
	}

}
