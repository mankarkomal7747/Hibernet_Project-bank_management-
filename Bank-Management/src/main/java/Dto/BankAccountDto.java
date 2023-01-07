package Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
	@Table(name="Bankaccount")
	public class BankAccountDto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private String bname;
		private long accno;
		private String ifsc;
		private double balance;
		
		@OneToOne
		private CustomerDto customers;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getBname() {
			return bname;
		}

		public void setBname(String bname) {
			this.bname = bname;
		}

		public long getAccno() {
			return accno;
		}

		public void setAccno(long accno) {
			this.accno = accno;
		}

		public String getIfsc() {
			return ifsc;
		}

		public void setIfsc(String ifsc) {
			this.ifsc = ifsc;
		}

		public CustomerDto getCustomers() {
			return customers;
		}

		public void setCustomers(CustomerDto customers) {
			this.customers = customers;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

	
			
			
		

			
		}

		
		

			
		
		
		
		
	

