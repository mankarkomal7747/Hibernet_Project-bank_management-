package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.AdminDto;
import Dto.ManagerDto;

public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Komal");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save admin
	public AdminDto saveAdmin(AdminDto admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}

	// Delete
	public AdminDto deletetAdminById(int id) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		if(admin!=null) {
			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();
			System.out.println(admin.getName()+" deleted Succesfully");
		}else {
			System.out.println("Admin not found");
		}
		

		return admin;
	}

	// Update name by id
	public AdminDto updateAdminNameById(int id, String name) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		if(admin!=null) {
		admin.setName(name);
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		System.out.println("Admin Name Updated");
		}else {
			System.out.println("Admin not found");
		}
		return admin;
	}

	// Update gmail by id
	public AdminDto updateAdminGmailById(int id, String gmail) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		if(admin!=null) {
		admin.setGmail(gmail);
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		System.out.println("Admin Gmail Updated");
		}else {
			System.out.println("Admin not found");
		}
		return admin;
	}

	// Update password by id
	public AdminDto updateAdminPasswordById(int id, String password) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		if(admin!=null) {
		admin.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		System.out.println("Admin Password Updated");
		}else {
			System.out.println("Admin not found");
		}
		return admin;
	}

	// Get By ID
	public AdminDto getAdminById(int id) {
		return entityManager.find(AdminDto.class, id);

	}

	// get all detail
	public List<AdminDto> getAllAdmin() {
		String sql = "Select a from AdminDto a";
		Query query = entityManager.createQuery(sql);

		List<AdminDto> a = query.getResultList();

		return a;
	}

	//Approved Manager
	public List<ManagerDto> approvedManager(int id) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		List<ManagerDto> managerDto=null;
		if (admin != null) {

			ManagerDao managerDao = new ManagerDao();
			 managerDto = managerDao.getAllManager();
			for (ManagerDto manager : managerDto) {
				if (manager.getStatus().equals("unapproved")) {
					manager.setStatus("approved");
					manager.setAdmin(admin);
					System.out.println("manager approved");
					entityTransaction.begin();
					entityManager.merge(manager);
					entityTransaction.commit();
				}
			}
		}else {
			System.out.println("no such Admin id");
		}
		return managerDto;
	}

}

