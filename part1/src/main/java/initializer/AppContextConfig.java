package initializer;

/**
 * Created by Girevoy.T on 03.11.2016.
 */

import calc.Calc;
import calc.CalcImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
@ComponentScan("")
public class AppContextConfig {

	@Bean (name = "calcu")
	public Calc calc() {
		return new CalcImpl();
	}
	@Bean
	public RmiServiceExporter rmiServiceExporter() {
		RmiServiceExporter result = new RmiServiceExporter();
		result.setServiceName("CalcRmi");
		result.setService(calc());
		result.setServiceInterface(Calc.class);
		result.setRegistryPort(1199);
		return result;
	}
}
