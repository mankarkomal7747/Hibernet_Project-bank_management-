package controller;

import java.util.List;

import Dto.ManagerDto;
import Service.ManagerService;

public class AllManagerDetails {
	public static void main(String[] args) {
		ManagerService managerService= new ManagerService();
		List<ManagerDto> m=managerService.getAllManager();
		for (ManagerDto managerDto : m) {
			System.out.println("=================================================================");
			System.out.print(managerDto.getId()+"\t");
			System.out.print(managerDto.getName()+'\t');
			System.out.print(managerDto.getGmail()+"\t");
			System.out.print(managerDto.getPassword()+"\t");
			System.out.print(managerDto.getStatus()+"\t");
		}
	}
}
