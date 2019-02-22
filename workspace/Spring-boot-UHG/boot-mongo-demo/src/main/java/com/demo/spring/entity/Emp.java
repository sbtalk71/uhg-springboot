package com.demo.spring.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="emp")

public class Emp {
	@Id
	private String empid;
	private String name;
	
	@Field("address")
	private String city;
	private double salary;

	public Emp() {
		
	}

	
	public Emp(String empid, String name, String city, double salary) {
		this.empid = empid;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}


	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
@Override
public String toString() {
	
	return empid+" "+name+" "+city+" "+salary;
}
}
