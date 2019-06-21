package com.Ksotis.EmployeeApp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class EmployeeDAO implements IEmployeeDAO {

	public EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("EmployeeApp");

	@Inject
	private Employee employee;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;

		try {

			et = em.getTransaction();
			et.begin();
			em.persist(employee);
			et.commit();
		} catch (Exception ex) {

			if (et != null) {

				et.rollback();
			}
			ex.printStackTrace();

		} finally {
			em.close();
		}
	}

	@Override
	public void changeFirstName(int id, String firstName) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;

		try {

			et = em.getTransaction();
			et.begin();
			employee = em.find(Employee.class, id);
			employee.setFirstName(firstName);
			em.persist(employee);
			et.commit();

		}

		catch (Exception ex) {

			if (et != null) {

				et.rollback();
			}
			ex.printStackTrace();

		}

		finally {
			em.close();
		}

	}

	@Override
	public void deleteEmployee(int id) {

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;

		try {

			et = em.getTransaction();
			et.begin();
			employee = em.find(Employee.class, id);
			em.remove(employee);
			et.commit();

		}

		catch (Exception ex) {

			if (et != null) {

				et.rollback();
			}
			ex.printStackTrace();

		}

		finally {
			em.close();
		}

	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;

		et = em.getTransaction();
		et.begin();
		employee = em.find(Employee.class, id);
		return employee;

	}

	@Override
	public List<Employee> getAllEmployees() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		
		List<Employee> listEmployees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
		return listEmployees;
		
	}
	
	

}
