package by.intexsoft.sjt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.sjt.entity.BookEntity;

public interface BookEntityRepository extends JpaRepository<BookEntity, Long> {
	/**
	 * This method returns books where column title = title
	 * 
	 * @param title
	 *            - title of book
	 * @return List<BookEntity>
	 */
	List<BookEntity> findByTitle(String title);
}
