package controller;

import java.util.Scanner;

import Service.AdminService;

public class UpdateAdminGmail {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id");
		int id = sc.nextInt();
		System.out.println("Enter your new Gmail");
		String gmail = sc.next();

		AdminService adminService = new AdminService();
		adminService.updateAdminNameById(id, gmail);
	
}
}
