package com.pasanabeysekara.securitywithswagger.service.impl;

import com.pasanabeysekara.securitywithswagger.entity.meta.User;
import com.pasanabeysekara.securitywithswagger.repo.UserRepository;
import com.pasanabeysekara.securitywithswagger.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> listOfRegisteredUsers(int page, int size) {

        Pageable firstPageWithTwoElements = PageRequest.of(page, size);
        Page<User> userPageList = userRepository.findAll(firstPageWithTwoElements);

        System.out.println("Total elements: " + userPageList.getTotalElements()); //103
        System.out.println("Total Pages: " + userPageList.getTotalPages()); // 3

        return userPageList.toList();
    }
}
