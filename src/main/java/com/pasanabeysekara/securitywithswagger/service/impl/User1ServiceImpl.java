package com.pasanabeysekara.securitywithswagger.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pasanabeysekara.securitywithswagger.entity.meta.User;
import com.pasanabeysekara.securitywithswagger.repo.User1Repository;
import com.pasanabeysekara.securitywithswagger.service.User1Service;

@Service
public class User1ServiceImpl implements User1Service{
	
	@Autowired
	private User1Repository user1Repository;
	
	@Override
	public User addUser(User user) {
		return user1Repository.save(user);
	}

	@Override
	public void deleteUserById(User user) {
		user1Repository.deleteById(user);
	}
	
	@Override
	public List<User> getAllUser(User user) {
		return user1Repository.findAll(user);
	}
	
	@Override
	public void updateUser(User user) {
		Scanner sc=new Scanner(System.in);
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/user_db";
		String username="root";
		String password="root";
		System.out.println("Enter the name");
		String name = sc.next();
		
		System.out.println("Enter the email");
		String email =sc.next();
		
		System.out.println("Enter the id");
		int id=sc.nextInt();
		try {
			Class.forName(driver);
			Connection c=DriverManager.getConnection(url);
			PreparedStatement ps= c.prepareStatement("update user1 set name=?,email=? where id=?");
			ps.setString(1,"name");
			ps.setString(2,"email");
			ps.setInt(3,id);
			
			ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
