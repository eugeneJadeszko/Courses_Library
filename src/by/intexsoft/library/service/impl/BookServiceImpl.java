package by.intexsoft.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.library.entity.BookEntity;
import by.intexsoft.library.repository.BookEntityRepository;
import by.intexsoft.library.service.BookService;

/**
 * Implementation for {@link BookService}
 */
@Service
public class BookServiceImpl extends AbstractEntityServiceImpl<BookEntity> implements BookService {

	@Autowired
	BookEntityRepository repository;

	@Override
	public List<BookEntity> findByTitle(String title) {
		return repository.findByTitle(title);
	}
}