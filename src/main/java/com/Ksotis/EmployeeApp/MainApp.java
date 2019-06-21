package com.Ksotis.EmployeeApp;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainApp {


	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

	
		
//		emp1.setId(1);
//		emp1.setFirstName("Kostis");
//		emp1.setLastName("Prodromou");
//		emp1.setDept("dev");
//		
//		emp2.setId(2);
//		emp2.setFirstName("Marios");
//		emp2.setLastName("Prodromou");
//		emp2.setDept("marketing");
//		
		EmployeeDAO empDAO = new EmployeeDAO();
//		empDAO.addEmployee(emp2);
//		empDAO.changeFirstName(2, "Panos");
//		empDAO.deleteEmployee(2);
		
		//System.out.println(empDAO.getEmployeeById(1).toString());
		System.out.println(empDAO.getAllEmployees());
	}

}
