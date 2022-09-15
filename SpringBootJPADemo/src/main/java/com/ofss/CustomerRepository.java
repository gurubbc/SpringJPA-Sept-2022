package com.ofss;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	// You don't need to write anything here
	// You will get all CRUD operations for free
}
