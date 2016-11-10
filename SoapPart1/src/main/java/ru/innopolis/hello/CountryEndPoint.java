package ru.innopolis.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.innopolis.hello.gs_producing_web_service.GetCountryRequest;
import ru.innopolis.hello.gs_producing_web_service.GetCountryResponse;

/**
 * Created by Arxan on 10.11.2016.
 */
@Endpoint
@ComponentScan("ru.innopolis.hello")
public class CountryEndPoint {
	private static final String NAMESPACE_URI = "http://innopolis.ru/hello/gs-producing-web-service";

	static {
		System.out.println();
	}

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndPoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
}