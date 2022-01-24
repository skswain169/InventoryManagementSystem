package com.accenture.ims.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.ims.entity.LoginDetailEntity;

public interface LoginDao extends CrudRepository<LoginDetailEntity, String> {

}
