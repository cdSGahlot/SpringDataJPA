package com.cognizant.ormlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@Controller
public class SearchController {
	@Autowired
	CountryService countryService;


	@GetMapping("/")
	public String searchPage() {
		return "search";
	}
	@PostMapping("/")
	public String searchResult(@RequestParam String country, ModelMap model) {
		List<Country> searchResults=countryService.search(country);
		model.put("countryList",searchResults);
		return "search";
	}

}