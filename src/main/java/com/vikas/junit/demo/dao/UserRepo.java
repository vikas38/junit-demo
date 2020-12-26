package com.vikas.junit.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vikas.junit.demo.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
