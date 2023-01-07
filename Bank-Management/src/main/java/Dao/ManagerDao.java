package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Dto.CustomerDto;
import Dto.ManagerDto;

public class ManagerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Komal");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// Save Manager
	public ManagerDto saveManager(ManagerDto manager) {
		manager.setStatus("unapproved");
		entityTransaction.begin();
		entityManager.persist(manager);
		entityTransaction.commit();
		return manager;
	}

	// delete Manager
	public ManagerDto deleteManagerById(int id) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		if (manager != null) {
			entityTransaction.begin();
			entityManager.remove(manager);
			entityTransaction.commit();
			System.out.println(manager.getName() + " deleted Succesfully");
		} else {
			System.out.println("Manager not found");
		}
		return manager;
	}

	// Update Manager name by id
	public ManagerDto updateManagerNameById(int id, String name) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		if (manager != null) {
			manager.setName(name);
			entityTransaction.begin();
			entityManager.merge(manager);
			entityTransaction.commit();
			System.out.println("Manager name updated");
		} else {
			System.out.println("Manager not found");
		}
		return manager;
	}

	// Update Manager gmail by id
	public ManagerDto updateManagerGmailById(int id, String gmail) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		if (manager != null) {
			manager.setGmail(gmail);
			entityTransaction.begin();
			entityManager.merge(manager);
			entityTransaction.commit();
			System.out.println("Manager Gmail updated");
		} else {
			System.out.println("Manager not found");
		}
		return manager;
	}

	// Update Manager password by id
	public ManagerDto updateManagerPasswordById(int id, String password) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		if (manager != null) {
			manager.setPassword(password);
			entityTransaction.begin();
			entityManager.merge(manager);
			entityTransaction.commit();
			System.out.println("Manager Password updated");
		} else {
			System.out.println("Manager not found");
		}
		return manager;
	}

	// get Manager ID
	public ManagerDto getManagerById(int id) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		return manager;
	}

	// get All MAnager
	public List<ManagerDto> getAllManager() {
		String sql = "Select m from ManagerDto m";

		Query query = entityManager.createQuery(sql);

		List<ManagerDto> m = query.getResultList();

		return m;
	}

	// delete customers by own Manger
	public CustomerDto deleteCustomersById(int managerId, int CustomerId) {
		ManagerDto manager = entityManager.find(ManagerDto.class, managerId);
		CustomerDto customersDto = entityManager.find(CustomerDto.class, CustomerId);
		if (manager != null) {
			if (customersDto != null) {
				if(customersDto.getManagerDto().getId()==managerId) {
				entityTransaction.begin();
				entityManager.remove(customersDto);
				entityTransaction.commit();
				System.out.println(customersDto.getName() + " deleted Succesfully");
				}else {
					System.out.println(customersDto.getName()+" is not your Customers");
				}
			} else {
				System.out.println("Customers not Found");
			}
		} else {
			System.out.println("invalid Manager Credential");
		}
		return customersDto;
	}
	

	// approved customers
	public List<CustomerDto> approvedCustomers(int id) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		List<CustomerDto> customers = null;
		if (manager != null) {
			if (manager.getStatus().equals("approved")) {
				String sql = "select c from CustomersDto c";
				Query query = entityManager.createQuery(sql);

				customers = query.getResultList();
				for (CustomerDto c : customers) {
					if (c.getStatus().equals("Unapproved")) {
						c.setStatus("approved");
						c.setManagerDto(manager);
						entityTransaction.begin();
						entityManager.merge(c);
						entityTransaction.commit();
						System.out.println(c.getName() + " is approved");
					}
				}
			} else {
				System.out.println("you are not approved manager");
			}
		} else {
			System.out.println("Manager " + id + " does not exist");
		}
		return customers;
	}


}
