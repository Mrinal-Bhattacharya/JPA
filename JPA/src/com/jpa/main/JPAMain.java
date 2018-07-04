package com.jpa.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jpa.entity.Department;
import com.jpa.entity.Employee;

public class JPAMain {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAUnit");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Department department = new Department();
		department.setName("Development");
		Department department1 = new Department();
		department1.setName("Test");
		//department.setEmployeelist(emplist);

		// Store Department
		entitymanager.persist(department);
		entitymanager.persist(department1);
		// Create Employee1 Entity
		Employee employee1 = new Employee();
		employee1.setEname("Satish");
		employee1.setSalary(45000.0);
		employee1.setDeg("Technical Writer");
		employee1.setDept(department);
		// Create Employee2 Entity
		Employee employee2 = new Employee();
		employee2.setEname("Krishna");
		employee2.setSalary(45000.0);
		employee2.setDeg("Technical Writer");
		employee2.setDept(department1);
		// Create Employee3 Entity
		Employee employee3 = new Employee();
		employee3.setEname("Masthanvali");
		employee3.setSalary(50000.0);
		employee3.setDeg("Technical Writer");
		employee3.setDept(department);
		// Store Employee
		entitymanager.persist(employee1);
		entitymanager.persist(employee2);
		entitymanager.persist(employee3);

		// Create Employeelist
		List<Employee> emplist = new ArrayList();
		emplist.add(employee1);
		emplist.add(employee2);
		emplist.add(employee3);

		// Create Department Entity
		
		entitymanager.flush();
		entitymanager.clear();
		entitymanager.getTransaction().commit();
		
		entitymanager.getTransaction().begin();
		Query createQuery = entitymanager.createQuery(" from Department d");
		List<Department> employeelist = createQuery.getResultList();
		for (Department employee : employeelist) {
			System.out.println(employee.getId() +" : ");
			List<Employee> employees = employee.getEmployees();
			for (Employee employee4 : employees) {
				System.out.println(employee4.getEid());
			}
		}
		//
		//
		

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();

	}

}
