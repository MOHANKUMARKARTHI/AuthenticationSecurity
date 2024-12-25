package com.pasanabeysekara.securitywithswagger.service;

import com.pasanabeysekara.securitywithswagger.entity.meta.User;

import java.util.List;

public interface DemoService {

    List<User> listOfRegisteredUsers(int page, int size);
}
