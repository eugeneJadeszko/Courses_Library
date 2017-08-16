package by.intexsoft.sjt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.sjt.entity.UserEntity;
import by.intexsoft.sjt.repository.UserEntityRepository;
import by.intexsoft.sjt.service.UserService;

@Service
public class UserServiceImpl extends AbstractEntityServiceImpl<UserEntity> implements UserService {
	@Autowired
	UserEntityRepository repository;
}
