package net.codejava;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends CrudRepository<Stock, Integer> {
	
	public List<Stock> findById(int id);
	
	@Query("SELECT s FROM Stock s where s.code='FB' and s.date like '2019-09-%'")
	public List<Stock> facebookDetails();
	
	@Query("SELECT s FROM Stock s WHERE s.code= :code and s.open> :price")
	public List<Stock> stockGreaterThan(@Param("code") String code, @Param("price") double price);
	
	@Query("SELECT s FROM Stock s order by s.volume desc")
	public List<Stock> highestVolumeTransactions(Pageable paegable);
	
	@Query("SELECT s FROM Stock s where s.code= :code order by s.open,s.close")
	public List<Stock> lowestTransactions(@Param("code") String code,Pageable paegable);
}
