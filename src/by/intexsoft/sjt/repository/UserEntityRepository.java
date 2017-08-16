package by.intexsoft.sjt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.sjt.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}
