package com.ayantsoft.springbootdeploy.springbootdeploy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayantsoft.springbootdeploy.springbootdeploy.model.Address;


public interface AddressRepository extends JpaRepository<Address,Integer>,Serializable{

	
}
