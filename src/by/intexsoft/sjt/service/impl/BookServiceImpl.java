package by.intexsoft.sjt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.sjt.entity.BookEntity;
import by.intexsoft.sjt.repository.BookEntityRepository;
import by.intexsoft.sjt.service.BookService;

@Service
public class BookServiceImpl extends AbstractEntityServiceImpl<BookEntity> implements BookService {

	@Autowired
	BookEntityRepository repository;

	@Override
	public List<BookEntity> findByTittle(String title) {
		return repository.findByTittle(title);
	}
}