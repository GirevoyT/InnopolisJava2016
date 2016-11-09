package initializer;

/**
 * Created by Girevoy.T on 03.11.2016.
 */

import calc.Calc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
@ComponentScan("/calc")
public class AppContextConfig {
	@Bean
	public Calc rmiProxy() {
		RmiProxyFactoryBean result = new RmiProxyFactoryBean();
		result.setServiceUrl("rmi://localhost:1199/CalcRmi");
		result.setServiceInterface(Calc.class);
		return (Calc)result.getObject();
	}
}
