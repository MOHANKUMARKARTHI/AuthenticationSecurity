package com.pasanabeysekara.securitywithswagger.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pasanabeysekara.securitywithswagger.entity.meta.User;
import com.pasanabeysekara.securitywithswagger.entity.meta.User1;

@Repository
public interface User1Repository extends JpaRepository<User1, Integer>{

	User save(User user);

	void deleteById(User user);

	List<User> findAll(User user);

	

}
