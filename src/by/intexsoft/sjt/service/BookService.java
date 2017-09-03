package by.intexsoft.sjt.service;

import java.util.List;

import by.intexsoft.sjt.entity.BookEntity;
import by.intexsoft.sjt.repository.BookEntityRepository;

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
