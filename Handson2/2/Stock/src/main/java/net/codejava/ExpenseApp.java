package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
public class ExpenseApp implements CommandLineRunner {

	@Autowired
	StockRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExpenseApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		Iterable<Stock> iterator = repository.findAll();
	iterator.forEach(item -> System.out.println(item));
	
	List<Stock> fb = repository.facebookDetails();
	System.out.println("\nFB details of September: ");
	fb.forEach(item -> System.out.println(item));
	
	
		
		List<Stock> stocks = repository.stockGreaterThan("GOOGL",1250);
		System.out.println("\nStocks Greater Than: ");
		stocks.forEach(item -> System.out.println(item));
		
		int limit=3;
		List<Stock> transactions = repository.highestVolumeTransactions(new PageRequest(0,limit));
		System.out.println("\nHighest Volume Transactions: ");
		transactions.forEach(item -> System.out.println(item));
		
		limit=3;
		List<Stock> newtransactions = repository.lowestTransactions("NFLX",new PageRequest(0,limit));
		System.out.println("\nLowest Transactions: ");
		newtransactions.forEach(item -> System.out.println(item));
		
		
	}
}
