import org.springframework.context.annotation.Configuration;

import com.capgemini.service.CustomerService;
import com.capgemini.service.CustomerServiceImpl;

@Configuration
public class AppConfig {

	
	public CustomerService customerService = new CustomerServiceImpl();
}
