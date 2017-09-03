package by.intexsoft.library.service;

import java.util.List;

import by.intexsoft.library.entity.BookEntity;
import by.intexsoft.library.repository.BookEntityRepository;

/**
 * Service for {@link BookEntityRepository}
 */
public interface BookService extends AbstractEntityService<BookEntity> {
	/**
	 * This method returns books where column title = title
	 * 
	 * @param title
	 *            - title of book
	 * @return List<BookEntity>
	 */
	List<BookEntity> findByTitle(String title);
}
