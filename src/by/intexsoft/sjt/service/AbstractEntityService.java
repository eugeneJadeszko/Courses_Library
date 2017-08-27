package by.intexsoft.sjt.service;

import java.util.List;

import by.intexsoft.sjt.entity.AbstractEntity;

public interface AbstractEntityService<T extends AbstractEntity> {

	List<T> findAll();

	void deleteAll();

	T save(T entity);

	T findById(Long id);

	void deleteById(Long id);
}
