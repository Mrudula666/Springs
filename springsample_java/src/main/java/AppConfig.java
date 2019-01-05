import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.capgemini.repsitory.CustomerRepsitory;
import com.capgemini.repsitory.HibernateCustomerRepositoryImpl;
import com.capgemini.service.CustomerService;
import com.capgemini.service.CustomerServiceImpl;

@Configuration
public class AppConfig {

	public CustomerService customerService;
	@Bean(name="customerService")
	public CustomerService getCustomerService() {
		 CustomerServiceImpl customerService = new CustomerServiceImpl();
		 customerService.setCustomerRepository(getCustomerRepsitory());
		 return customerService;
	}
	public CustomerRepsitory getCustomerRepsitory() {
		return new HibernateCustomerRepositoryImpl();
	}
}
