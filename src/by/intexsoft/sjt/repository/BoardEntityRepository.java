package by.intexsoft.sjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.sjt.entity.BoardEntity;

public interface BoardEntityRepository extends JpaRepository<BoardEntity, Long> {

}
