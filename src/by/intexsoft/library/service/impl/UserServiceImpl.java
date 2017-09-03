package by.intexsoft.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.library.entity.UserEntity;
import by.intexsoft.library.repository.UserEntityRepository;
import by.intexsoft.library.service.UserService;

/**
 * Implementation for {@link UserService}
 */
@Service
public class UserServiceImpl extends AbstractEntityServiceImpl<UserEntity> implements UserService {
	@Autowired
	UserEntityRepository repository;
}
