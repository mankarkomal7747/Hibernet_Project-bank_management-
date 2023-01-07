package controller;

import java.util.Scanner;

import Dto.CustomerDto;
import Service.CustomerService;

public class GetCutomerById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id");
		int id = sc.nextInt();
		CustomerService customerService = new CustomerService();
		CustomerDto customers=customerService.getCustomersById(id);
		if(customers!=null) {
			System.out.println("================================================");
			System.out.print(customers.getId()+"\t");
			System.out.print(customers.getName()+"\t");
			System.out.print(customers.getGender()+"\t");
			System.out.print(customers.getDob()+"\t");
			System.out.print(customers.getStatus()+"\t");
//			System.out.print(customers.getBankaccount());
		}
	}
}
