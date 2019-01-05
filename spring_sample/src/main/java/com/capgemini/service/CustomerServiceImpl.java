package com.capgemini.service;

import java.util.List;

import com.capgemini.model.Customer;
import com.capgemini.repsitory.CustomerRepsitory;
import com.capgemini.repsitory.HibernateCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerRepsitory customerRepository = new HibernateCustomerRepositoryImpl();
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.CustomerService#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

}
