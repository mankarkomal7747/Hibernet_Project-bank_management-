package controller;

import java.util.Scanner;

import Dto.AdminDto;
import Service.AdminService;

public class GetAdminById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id");
		int id = sc.nextInt();
		AdminService adminService = new AdminService();
		AdminDto ad = adminService.getAdminById(id);
		if (ad != null) {
			System.out.println("===========================================================");
			System.out.print(ad.getId() + " \t ");
			System.out.print(ad.getName() + " \t ");
			System.out.print(ad.getGmail() + " \t ");
			System.out.print(ad.getPassword() + " \t ");
			System.out.println();
		}
	}
}
