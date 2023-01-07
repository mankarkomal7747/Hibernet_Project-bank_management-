package controller;

import java.util.Scanner;

import Service.ManagerService;

public class ApprovedBankManager {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your Manager id");
		int id= sc.nextInt();
		ManagerService managerService= new ManagerService();
		managerService.approvedCustomers(id);
	}

}
