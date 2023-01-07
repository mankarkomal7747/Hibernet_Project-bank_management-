package controller;

import java.util.Scanner;

import Service.ManagerService;

public class DeleteManager {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id");
		int id=sc.nextInt();
		ManagerService managerService= new ManagerService();
		managerService.deleteManagerById(id);
	}

}
