package controller;

import java.util.Scanner;

import Dto.ManagerDto;
import Service.ManagerService;

public class SaveManager {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your name");
		String name=sc.next();
		System.out.println("Enter your gmail");
		String gmail=sc.next();
		System.out.println("Enter your Password");
		String password=sc.next();
		System.out.println("defalut Manager Status is unapproved");
		
		ManagerDto managerDto= new ManagerDto();
		managerDto.setName(name);
		managerDto.setGmail(gmail);
		managerDto.setPassword(password);
		
		ManagerService managerService=new ManagerService();
		managerService.saveManager(managerDto);
		
	}
}

