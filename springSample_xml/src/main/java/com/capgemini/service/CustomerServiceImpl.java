package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Customer;
import com.capgemini.repsitory.CustomerRepsitory;
import com.capgemini.repsitory.HibernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepsitory customerRepository = new HibernateCustomerRepositoryImpl();
	
	
	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}


	public void setCustomerRepository(CustomerRepsitory customerRepsitory) {
		this.customerRepository = customerRepsitory;			
	}

}
