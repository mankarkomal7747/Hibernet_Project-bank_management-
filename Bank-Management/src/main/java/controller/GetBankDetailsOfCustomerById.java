package controller;

import java.util.Scanner;

import Service.CustomerService;

public class GetBankDetailsOfCustomerById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Customer id ");
		int customerId= sc.nextInt();
		
		CustomerService customerService= new CustomerService();
		customerService.getBankDetailOfCustomers(customerId);
		
	}
}
