package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.BankAccountDto;
import Dto.CustomerDto;


public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Komal");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save customers
	public CustomerDto saveCustomers(CustomerDto customersDto) {
		List<CustomerDto> c=getAllCustomers();
		for (CustomerDto customers : c) {
			if(customers.getAdharno()==customersDto.getAdharno()) {
				System.out.println("Customers Allready Exist");
				return null;
			}
		}
		customersDto.setStatus("Unapproved");
		entityTransaction.begin();
		entityManager.persist(customersDto);
		entityTransaction.commit();
		System.out.println("Customers save");
		return customersDto;
	}

	// update customers name by id
	public CustomerDto updateCustomersNameById(int id, String name) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		if (customersDto != null) {
			customersDto.setName(name);
			entityTransaction.begin();
			entityManager.merge(customersDto);
			entityTransaction.commit();
			System.out.println("Customers Name Updated");
		} else {
			System.out.println("Customers not Found");
		}
		return customersDto;
	}

	// update customers dob by id
	public CustomerDto updateCustomersDobById(int id, String dob) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		if (customersDto != null) {
			customersDto.setDob(dob);
			entityTransaction.begin();
			entityManager.merge(customersDto);
			entityTransaction.commit();
			System.out.println("Customers Date of birth Updated");
		} else {
			System.out.println("Customers not Found");
		}
		return customersDto;
	}

	// update customers gender by id
	public CustomerDto updateCustomersGenderById(int id, String gender) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		if (customersDto != null) {
			customersDto.setGender(gender);
			entityTransaction.begin();
			entityManager.merge(customersDto);
			entityTransaction.commit();
			System.out.println("Customers Gender Updated");
		} else {
			System.out.println("Customers not Found");
		}
		return customersDto;
	}

	// get customers by Id
	public CustomerDto getCustomersById(int id) {

		return entityManager.find(CustomerDto.class, id);
	}

	// Get all customers
	public List<CustomerDto> getAllCustomers() {

		String sql = "Select c from CustomersDto c";

		Query query = entityManager.createQuery(sql);
		List<CustomerDto> c = query.getResultList();

//		for (CustomersDto customers : c) {
//			System.out.println("============================================================");
//			System.out.print(customers.getId());
//			System.out.print(customers.getName());
//			System.out.print(customers.getGender());
//			System.out.print(customers.getDob());
//			System.out.print(customers.getBankaccount());
//		}
		return c;
	}

	// Save bank Accoount
	public BankAccountDto saveBankDetail(int CustomerId, BankAccountDto bankAccountDto) {
		List<BankAccountDto> b=ALlBankDetail();
		for(BankAccountDto bankAccount:b) {
			if(bankAccount.getCustomers().getId()==CustomerId) {
				System.out.println("You Allready have an Account");
				return null;
			}
		}

		CustomerDto customersDto = entityManager.find(CustomerDto.class, CustomerId);
		if (customersDto != null) {
			if (customersDto.getStatus().equals("approved")) {
				bankAccountDto.setCustomers(customersDto);
				bankAccountDto.setName(customersDto.getName());
				bankAccountDto.setBname("jSpider_Bank");
				bankAccountDto.setAccno(49221000+customersDto.getId());
				bankAccountDto.setIfsc("JSP0JAVA");
				entityTransaction.begin();
				entityManager.persist(bankAccountDto);
				entityTransaction.commit();
			} else {
				System.out.println("You are not approved Customers");
			}
		} else {
			System.out.println("customers not found");
		}
		return bankAccountDto;
	}

	// update bank detail
	public BankAccountDto updateBankName(int id, String name) {
		BankAccountDto bankAccountDto = entityManager.find(BankAccountDto.class, id);
		bankAccountDto.setBname(name);
		entityTransaction.begin();
		entityManager.merge(bankAccountDto);
		entityTransaction.commit();

		return bankAccountDto;
	}

	// deposite money
	public BankAccountDto depositeMoney(int customersId, int bankId, double amount) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, customersId);
		BankAccountDto bankAccountDto = bankAccountDto = entityManager.find(BankAccountDto.class, bankId);
		if (customersDto != null) {
			if (bankAccountDto != null) {
				if (customersDto.getStatus().equals("approved")
						&& bankAccountDto.getCustomers().getId() == customersId ) {

					bankAccountDto.setBalance(bankAccountDto.getBalance() + amount);

					entityTransaction.begin();
					entityManager.merge(bankAccountDto);
					entityTransaction.commit();

				} else {
					System.out.println("Your are not Approved");
					return null;
				}
			} else {
				System.out.println("Customer'Ss BankId" + bankId + " not found");
			}
		} else {
			System.out.println("Customers " + customersId + " not found");
			return null;
		}
		return bankAccountDto;
	}

	// Transfer money
	public BankAccountDto transferMoney(int customerId, int sender, int receiver, double ammountTranfer) {

		CustomerDto customersDto = entityManager.find(CustomerDto.class, customerId);
		BankAccountDto bankAccount1 = entityManager.find(BankAccountDto.class, sender);
		BankAccountDto bankAccount2 = entityManager.find(BankAccountDto.class, receiver);
		if (customersDto.getStatus().equals("approved") && bankAccount1.getCustomers().getId() == customerId) {

			if (bankAccount1 != null && bankAccount2 != null) {

				if (bankAccount1.getBalance() >= ammountTranfer) {
					bankAccount1.setBalance(bankAccount1.getBalance() - ammountTranfer);
					bankAccount2.setBalance(bankAccount2.getBalance() + ammountTranfer);

					entityTransaction.begin();
					entityManager.merge(bankAccount1);
					entityManager.merge(bankAccount2);
					entityTransaction.commit();
				} else {
					System.out.println("insufficent bank balance");
					return null;
				}
			} else {
				System.out.println("no such account");
				return null;
			}
		} else {
			System.out.println("You are not approved Or  Enter valid Crenditial");
			return null;
		}
		return bankAccount2;
	}

	// no of account to customers
	public List<BankAccountDto> getBankDetailOfCustomers(int customesrId) {
		String sql = "Select b from BankAccountDto b";
		Query query = entityManager.createQuery(sql);
		List<BankAccountDto> b = query.getResultList();
		for (BankAccountDto bankAccountDto : b) {
			if (bankAccountDto.getCustomers().getId() == customesrId) {
				System.out.println("==================================================================");
				System.out.print("Customers name :-" + bankAccountDto.getCustomers().getName()+"\t");
				System.out.print(bankAccountDto.getId()+"\t");
				System.out.print(bankAccountDto.getBname()+"\t");
				System.out.print(bankAccountDto.getAccno()+"\t");
				System.out.print(bankAccountDto.getBalance()+"\t");
				System.out.println();
			}
		}
		return b;
	}
	
	
	public List<BankAccountDto> ALlBankDetail(){
		String sql="Select b from BankAccountDto b";
		Query query=entityManager.createQuery(sql);
		List<BankAccountDto> b=query.getResultList();
		
	
		return b;
	}

}

