package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//repo to favorites

@Repository
public interface FavRepository extends CrudRepository<Favorites, Integer> {
    List<Favorites> findAll();	//just in case
    List<Favorites> findByUserid(int id);	//get all favorite books
}
