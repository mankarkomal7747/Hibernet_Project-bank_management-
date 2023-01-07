package controller;

import java.util.Scanner;

import Dto.BankAccountDto;
import Service.CustomerService;

public class DepositeMoney {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your  Customer  id");
		int CustomerId = sc.nextInt();
		System.out.println("Enter your bank id");
		int bankId = sc.nextInt();
		System.out.println("Enter your Amount to deposite");
		double amount = sc.nextDouble();
		
		if(amount>0) {
		CustomerService customerService = new CustomerService();
		BankAccountDto bankAccountDto = customerService.depositeMoney(CustomerId, bankId, amount);
		if (bankAccountDto != null) {
			System.out.println("transacation succesfull");
		} else {
			System.out.println("transacation failed");
		}
		}else {
			System.out.println("invalid Amount");
		}
	}
}

