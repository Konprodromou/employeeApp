package com.Ksotis.EmployeeRestService;

import java.awt.List;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.Ksotis.EmployeeApp.Employee;
import com.Ksotis.EmployeeApp.EmployeeDAO;

@Path("/employees")
@Produces("application/json")
@Consumes("application/json")
public class EmployeeResource {

	@GET
	@Path("/all")
	public Response getAllEmployees() {

		EmployeeDAO empDAO = new EmployeeDAO();
		return Response.status(200).entity(empDAO.getAllEmployees()).build();

	}

	@GET
	@Path("{id}")
	public Response getEmployee(@PathParam("id") int id) {

		try {
			EmployeeDAO empDAO = new EmployeeDAO();
			return Response.status(200).entity(empDAO.getEmployeeById(id)).build();
		}

		catch (Exception e) {

			e.printStackTrace();
			return Response.status(403).build();

		}

	}

	@POST
	public Response addEmployee(Employee employee) {
		try {
			EmployeeDAO empDAO = new EmployeeDAO();
			empDAO.addEmployee(employee);
			return Response.status(201).build();
		}

		catch (Exception e) {

			e.printStackTrace();
			return Response.status(403).build();

		}
	}

	@PUT
	@Path("{id}/{name}")
	public Response updateEmployee(@PathParam("id") int id, @PathParam("name") String name) {

		try {

			EmployeeDAO empDAO = new EmployeeDAO();
			empDAO.changeFirstName(id, name);
			return Response.status(200).build();

		}

		catch (Exception ex) {

			ex.printStackTrace();
			return Response.status(403).build();
		}
	}

	@DELETE
	@Path("{id}")
	public Response deleteEmployee(@PathParam("id") int id) {

		try {

			EmployeeDAO empDAO = new EmployeeDAO();
			empDAO.deleteEmployee(id);
			return Response.status(201).build();
		}

		catch (Exception e) {

			e.printStackTrace();
			return Response.status(403).build();

		}

	}

}
