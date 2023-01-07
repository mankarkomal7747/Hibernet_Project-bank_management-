package controller;

import java.util.Scanner;

import Dto.ManagerDto;
import Service.ManagerService;

public class GetManagerById {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your id");
		int id= sc.nextInt();
		
		ManagerService managerService=new ManagerService();
		ManagerDto managerDto= managerService.getManagerById(id);
		if(managerDto!=null) {
		System.out.println("==========================================================");
		System.out.print(managerDto.getId()+"\t");
		System.out.print(managerDto.getName()+"\t");
		System.out.print(managerDto.getGmail()+"\t");
		System.out.print(managerDto.getPassword()+"\t");
		System.out.print(managerDto.getStatus()+"\t");
		}else {
			System.out.println("Manager not found");
		}
	}

}
