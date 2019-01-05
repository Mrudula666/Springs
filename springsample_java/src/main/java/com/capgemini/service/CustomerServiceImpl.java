package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Customer;
import com.capgemini.repsitory.CustomerRepsitory;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepsitory customerRepository;

	// setter for the customer repository
	public void setCustomerRepository(CustomerRepsitory customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

}
