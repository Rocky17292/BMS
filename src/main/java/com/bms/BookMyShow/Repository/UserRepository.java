package com.bms.BookMyShow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.BookMyShow.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
