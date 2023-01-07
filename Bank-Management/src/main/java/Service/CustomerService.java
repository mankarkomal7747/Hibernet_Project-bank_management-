package Service;

import java.util.List;

import Dao.CustomerDao;
import Dto.BankAccountDto;
import Dto.CustomerDto;

public class CustomerService {
CustomerDao customerDao=new CustomerDao();
	
	// save customers
		public CustomerDto saveCustomers(CustomerDto customersDto) {
			return customerDao.saveCustomers(customersDto);
		}
		
		
	
	
	
	// update customers name by id
		public CustomerDto updateCustomersNameById(int id,String name) {
			return customerDao.updateCustomersNameById(id,name);
		}
		
		
	// update customers dob by id
	public CustomerDto updateCustomersDobById(int id,String dob) {
		return customerDao.updateCustomersDobById(id,dob);
	}
	
	

	// update customers gender by id
	public CustomerDto updateCustomersGenderById(int id,String gender) {
		return customerDao.updateCustomersGenderById(id,gender);
	}
	
	// get customers by Id
	public CustomerDto getCustomersById(int id) {
		return customerDao.getCustomersById(id);
	}
	
	//Get all customers 
		public List<CustomerDto> getAllCustomers(){
			return customerDao.getAllCustomers();
		}
	// save bank detail
		public BankAccountDto saveBankDetail(int id,BankAccountDto bankAccountDto) {
			return customerDao.saveBankDetail(id,bankAccountDto);
		}
		
	// update bank detail
		public BankAccountDto updateBankName(int id,String name) {
			return customerDao.updateBankName(id, name);
		}
		
	// deposite money
	public BankAccountDto depositeMoney(int customersId, int bankId, double ammount) {
		return customerDao.depositeMoney(customersId,bankId, ammount);
	}
	
	// transfer money
	public BankAccountDto transferMoney(int customerId,int sender,int receiver,double ammountTranfer) {
		return customerDao.transferMoney(customerId,sender, receiver, ammountTranfer);
	}
	
	// bank detail of Customers
	public List<BankAccountDto> getBankDetailOfCustomers(int customesrId){
		return customerDao.getBankDetailOfCustomers(customesrId);
	}
	
}

