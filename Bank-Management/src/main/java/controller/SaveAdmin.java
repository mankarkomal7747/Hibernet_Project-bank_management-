package controller;

import java.util.Scanner;

import Dto.AdminDto;
import Service.AdminService;

public class SaveAdmin {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your name");
		String name=sc.next();
		System.out.println("Enter your gmail");
		String gmail=sc.next();
		System.out.println("Enter your Password");
		String password=sc.next();
		AdminDto adminDto=new AdminDto();
		adminDto.setName(name);
		adminDto.setGmail(gmail);
		adminDto.setPassword(password);
		
		
		
		
		AdminService adminService= new AdminService();
		adminService.saveAdmin(adminDto);

	

		
	}
}

