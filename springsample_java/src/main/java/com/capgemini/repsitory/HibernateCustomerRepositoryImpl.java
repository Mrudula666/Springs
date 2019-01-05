package com.capgemini.repsitory;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepsitory {
	
	/* (non-Javadoc)
	 * @see com.capgemini.repsitory.CustomerRepsitory#findAll()
	 */
	@Override
	public List<Customer> findAll(){
		List<Customer> customersList = new ArrayList<Customer>();
		Customer customer = new Customer();
		
		customer.setFirstName("Mrudulaa");
		customer.setLastName("Nimmala");
		customersList.add(customer);
		return customersList;
	}

}
