package com.cognizant.ormlearn.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;	
	
	@Transactional
	public List<Country> getAllCountries()
	{		
		List<Country> list=countryRepository.findAll();
		return list;
	}
	
	@Transactional
	public void addCountry(Country country)
	{
		countryRepository.save(country);	
		
	}
	
	@Transactional
	public Country findCountryByCode(String code)throws CountryNotFoundException
	{
		Country country=countryRepository.findOne(code);
		return country;		
	}
	
	@Transactional
	public void updateCountry(String code,String newName)
	{
		Country c=countryRepository.findOne(code);
		c.setName(newName);			
		countryRepository.save(c);
		
	}
	
	@Transactional
	public void deleteCountry(String code)
	{				
		countryRepository.delete(code);		
	}

}
