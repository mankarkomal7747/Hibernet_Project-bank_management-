package controller;

import java.util.Scanner;

import Dto.CustomerDto;
import Service.CustomerService;

public class SaveCustomer {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your name");
		String name=sc.next();
		System.out.println("Enter your Gender");
		String gender=sc.next();
		System.out.println("Enter your Date Of Birth");
		String dob=sc.next();
		System.out.println("Enter your AadharCard no ");
		long adharno=sc.nextLong();
		System.out.println("defalut Customers Status is unapproved");
		CustomerDto customersDto=new CustomerDto();
		customersDto.setName(name);
		customersDto.setGender(gender);
		customersDto.setDob(dob);
		customersDto.setAdharno(adharno);
		
		
		CustomerService customerService= new CustomerService();
		customerService.saveCustomers(customersDto);
	}
}

