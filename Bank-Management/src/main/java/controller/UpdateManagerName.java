package controller;

import java.util.Scanner;

import Service.ManagerService;

public class UpdateManagerName {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id");
		int id= sc.nextInt();
		System.out.println("Enter your name");
		String name=sc.next();
		
		ManagerService managerService=new ManagerService();
		managerService.updateManagerNameById(id, name);
	}

}
