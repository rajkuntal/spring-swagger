package com.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmployeeController
{
	
	@RequestMapping(value = "/test/string", method = RequestMethod.GET)
	@ResponseBody
	public Employee test()
	{
		return new Employee(2, "Shoooooooooo", "Last name");
	}
	
	public class Employee
	{
		private Integer id;
		private String name;
		private Object lastName;
		
		public Employee(int id, String name, Object lastName)
		{
			this.name = name;
			this.id = id;
			this.lastName = lastName;
		}

		public Integer getId()
		{
			return id;
		}

		public void setId(Integer id)
		{
			this.id = id;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public Object getLastName()
		{
			return lastName;
		}

		public void setLastName(Object lastName)
		{
			this.lastName = lastName;
		}
	}

}
