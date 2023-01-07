package Dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
	@Table(name="manager")
	public class ManagerDto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String gmail;
		private String password;
		private String status;
		
		@ManyToOne
		@JoinColumn
		private AdminDto admin;
		
		@OneToMany(mappedBy = "managerDto", cascade = CascadeType.ALL)
		private List<CustomerDto> customersDto;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		public String getGmail() {
			return gmail;
		}

		public void setGmail(String gmail) {
			this.gmail = gmail;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public AdminDto getAdmin() {
			return admin;
		}

		public void setAdmin(AdminDto admin) {
			this.admin = admin;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public List<CustomerDto> getCustomersDto() {
			return customersDto;
		}

		public void setCustomersDto(List<CustomerDto> customersDto) {
			this.customersDto = customersDto;
		}


		
		
	}
	

