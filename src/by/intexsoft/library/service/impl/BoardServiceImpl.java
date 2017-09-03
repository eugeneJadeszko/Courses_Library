package by.intexsoft.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.library.entity.BoardEntity;
import by.intexsoft.library.repository.BoardEntityRepository;
import by.intexsoft.library.service.BoardService;

/**
 * Implementation for {@link BoardService}
 */
@Service
public class BoardServiceImpl extends AbstractEntityServiceImpl<BoardEntity> implements BoardService {

	@Autowired
	BoardEntityRepository repository;
}
