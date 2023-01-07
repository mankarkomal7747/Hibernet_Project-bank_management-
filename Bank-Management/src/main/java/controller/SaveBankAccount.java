package controller;

import java.util.Scanner;

import Dto.BankAccountDto;
import Service.CustomerService;

public class SaveBankAccount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your  Customer  id");
		int id = sc.nextInt();
//		System.out.println("Enter your  bank name");
//		String name = sc.next();
//		System.out.println("Enter your AccountNumber");
//		long accno=sc.nextLong();
//		System.out.println("Enter your IFSC");
//		String ifcs = sc.next();
		System.out.println("Enter your Intinal Balance");
		double amount = sc.nextDouble();
		if (amount > 999) {
			BankAccountDto bankAccountDto = new BankAccountDto();
//			bankAccountDto.setBname(name);
//			bankAccountDto.setAccno(accno);
//			bankAccountDto.setIfsc(ifcs);
			bankAccountDto.setBalance(amount);

			CustomerService customerService = new CustomerService();
			customerService.saveBankDetail(id, bankAccountDto);
		} else {
			System.out.println("Opening Balance must be more 1000 ");
		}

	}
}

