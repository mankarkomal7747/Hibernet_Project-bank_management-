package controller;

import java.util.List;

import Dto.CustomerDto;
import Service.CustomerService;

public class AllCustomerDetails {
	
		public static void main(String[] args) {
			CustomerService customerService= new CustomerService();
			List<CustomerDto> c=customerService.getAllCustomers();
			for (CustomerDto customers : c) {
				System.out.println("================================================");
				System.out.print(customers.getId()+"\t");
				System.out.print(customers.getName()+"\t");
				System.out.print(customers.getGender()+"\t");
				System.out.print(customers.getDob()+"\t");
				System.out.print(customers.getStatus()+"\t");
				
			}
		}

}
