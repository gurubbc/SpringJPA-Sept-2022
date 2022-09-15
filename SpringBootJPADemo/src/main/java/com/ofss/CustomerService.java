package com.ofss;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	CustomerRepository cr;
	
	public String addCustomer(Customer cust)
	{
		System.out.println("Adding customer object using CustomerRepository");
		cr.save(cust); // this will generate all the required SQL quries behind the scene
		return "Successfully added";
	}
	
	public List<Customer> getAllCustomers()
	{
		Iterable<Customer> custList=cr.findAll(); // This will generate SELECT * query
		List<Customer> allCustomers=new ArrayList<>();
		for (Customer c:custList)
		{
			allCustomers.add(c);
		}
		return allCustomers;
	}
	
	public String deleteACustomer(int custId)
	{
		cr.deleteById(custId);
		return "Successfully deleted";
	}
}
