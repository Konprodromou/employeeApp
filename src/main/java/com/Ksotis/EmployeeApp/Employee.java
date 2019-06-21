package com.Ksotis.EmployeeApp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



	@Entity
	@Table(name = "emp_db")
	public class Employee implements Serializable {

		 private static final long serialVersionUID = 1L;
		
		@Id
		 @GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "id")
		private int id;
		
		@Column(name = "firstName")
		private String firstName;

		@Column(name = "lastName")
		private String lastName;
		
		@Column(name = "dept")
		private String dept;

		public Employee(int id, String firstName, String lastName, String dept) {
			
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.dept = dept;
			
		}
		
		public Employee() {
			
		
	
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getDept() {
			return dept;
		}

		public void setDept(String dept) {
			this.dept = dept;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dept=" + dept
					+ "]";
		}
		
		
		
		
	}
