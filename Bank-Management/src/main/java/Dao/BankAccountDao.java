package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.BankAccountDto;

public class BankAccountDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("Komal");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
//	
//	BankAccountDto bankAccountDto= new BankAccountDto();
//	
//	// Save bank detail
	public BankAccountDto saveBankDetail(BankAccountDto bankAccountDto) {
		bankAccountDto.setBalance(10000);
		entityTransaction.begin();
		entityManager.persist(bankAccountDto);
		entityTransaction.commit();
		return bankAccountDto;
	}
	// update bank detail
	public BankAccountDto updateBankName(int id,String name) {
		BankAccountDto bankAccountDto=entityManager.find(BankAccountDto.class,id);
		bankAccountDto.setBname(name);
		entityTransaction.begin();
		entityManager.merge(bankAccountDto);
		entityTransaction.commit();
		
		return bankAccountDto;
	}
	
	
	public List<BankAccountDto> ALlBankDetail(){
		String sql="Select b from BankAccountDto b";
		Query query=entityManager.createQuery(sql);
		List<BankAccountDto> b=query.getResultList();
		
	
		return b;
	}
}