package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
	
private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
private static CountryService countryService;

	private static void testGetAllCountries()
	{
		 LOGGER.info("Start");
		 
		 List<Country> countries = countryService.getAllCountries();
		 LOGGER.debug("countries={}", countries);
		 LOGGER.info("End");
	}

	public static void main(String[] args)throws CountryNotFoundException {
		//SpringApplication.run(OrmLearnApplication.class, args);
	ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
	countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		countryService.addCountry(new Country("A","A1"));
		countryService.addCountry(new Country("B","B1"));
		testGetAllCountries();
		
		Country c=null;
		 LOGGER.info("Start : find country by code");
		c=countryService.findCountryByCode("A");
		if(c==null)
			throw new CountryNotFoundException("Country Not Found!");	
		
		 LOGGER.debug("Country:{}", c);
		 LOGGER.info("End");
		 
		 LOGGER.info("Start: update country");
			countryService.updateCountry("A","ABCDEF");			
		LOGGER.info("End");
		
		LOGGER.info("Start: delete country");
		countryService.deleteCountry("A");			
		LOGGER.info("End");
	}
	
	

}
