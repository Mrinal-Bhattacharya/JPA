package com.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.eclipse.persistence.annotations.JoinFetch;
import org.eclipse.persistence.annotations.JoinFetchType;

@Entity
public class Department {
	// http://jpwh.org/examples/jpwh2/jpwh-2e-examples-20151103/model/src/main/java/org/jpwh/model/fetching/proxy/Category.java
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="DEPT_ID")
	private int id;
	private String name;

	@JoinColumn(name = "DEPT_ID")
	//@JoinFetch(JoinFetchType.INNER)
	@OneToMany(fetch=FetchType.LAZY)
	private List<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String deptName) {
		this.name = deptName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}