package com.ofss;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	CustomerService cs;
	
	@RequestMapping(value="customers", method=RequestMethod.POST)
	public String addACustomer(@RequestBody Customer cust)
	{
		return cs.addCustomer(cust);
	}
	
	@RequestMapping(value="customers", method=RequestMethod.GET)
	public List<Customer> getAllCustomers()
	{
		return cs.getAllCustomers();
	}
	
	@RequestMapping(value="customers/{custId}", method=RequestMethod.DELETE)
	public String deleteACustomer(@PathVariable("custId") int cid)
	{
		try {
		return cs.deleteACustomer(cid);
		}
		catch(org.springframework.dao.EmptyResultDataAccessException ee)
		{
			return "No such customer exists";
		}
	}
}
