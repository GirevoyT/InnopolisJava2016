package calc;

import org.springframework.stereotype.Service;

/**
 * Created by Arxan on 10.11.2016.
 */
@Service ("calc")
public class CalcImpl implements Calc{

	@Override
	public String hello(String name) {
		return "Hello "+name;
	}
}
