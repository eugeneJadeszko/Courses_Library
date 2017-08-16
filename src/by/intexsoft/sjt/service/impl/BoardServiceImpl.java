package by.intexsoft.sjt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.sjt.entity.BoardEntity;
import by.intexsoft.sjt.repository.BoardEntityRepository;
import by.intexsoft.sjt.service.BoardService;

@Service
public class BoardServiceImpl extends AbstractEntityServiceImpl<BoardEntity> implements BoardService {

	@Autowired
	BoardEntityRepository repository;
}
