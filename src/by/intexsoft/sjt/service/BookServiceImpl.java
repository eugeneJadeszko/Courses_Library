package by.intexsoft.sjt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.sjt.entity.BookEntity;
import by.intexsoft.sjt.repository.BookEntityRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookEntityRepository repository;

	public BookEntity addBook(BookEntity book) {
		BookEntity saveBook = repository.saveAndFlush(book);
		return saveBook;
	}

	@Override
	public List<BookEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}
}