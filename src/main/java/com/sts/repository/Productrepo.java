package com.sts.repository;
import com.sts.model.Products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Productrepo extends JpaRepository<Products, Integer> {
	@Query("select p.id, p.name , p.price, p.currstock from Products p where p.currstock > 0")
	List<String> isavailable();
	@Query("select p.id, p.name , p.price, p.currstock from Products p where p.clas = :clas")
	List<String> getbyclas(String clas);
}
