package controller;

import java.util.Scanner;

import Service.CustomerService;

public class UpdateCustomerGender {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id");
		int id=sc.nextInt();
		System.out.println("Enter your Gender");
		String gender=sc.next();
		
		CustomerService customerService= new CustomerService();
		customerService.updateCustomersGenderById(id, gender);
	}

}
