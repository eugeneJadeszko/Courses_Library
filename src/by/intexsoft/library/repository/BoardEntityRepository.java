package by.intexsoft.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.library.entity.BoardEntity;

public interface BoardEntityRepository extends JpaRepository<BoardEntity, Long> {
}
