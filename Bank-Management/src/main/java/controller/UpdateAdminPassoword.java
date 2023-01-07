package controller;

import java.util.Scanner;

import Service.AdminService;

public class UpdateAdminPassoword {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id");
		int id = sc.nextInt();
		System.out.println("Enter your new Password");
		String password = sc.next();

		AdminService adminService = new AdminService();
		adminService.updateAdminNameById(id, password);
	}
}
