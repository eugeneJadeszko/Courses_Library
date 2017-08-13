package by.intexsoft.sjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.sjt.entity.BookEntity;

public interface BookEntityRepository extends JpaRepository<BookEntity, Long> {
}
