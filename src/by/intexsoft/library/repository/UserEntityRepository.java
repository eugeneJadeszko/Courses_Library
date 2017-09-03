package by.intexsoft.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.library.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}
