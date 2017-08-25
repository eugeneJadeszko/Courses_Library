package by.intexsoft.sjt.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.sjt.entity.BoardEntity;
import by.intexsoft.sjt.service.BoardService;
import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/board")
public class BoardController {
	private static Logger logger = (Logger) LoggerFactory.getLogger(BoardController.class.getName());

	@Autowired
	BoardService boardService;

	@RequestMapping("/add/{number}")
	public ResponseEntity<?> add(@PathVariable("number") int number) {
		logger.info("Creation of a new board with the number: " + number);
		BoardEntity board = new BoardEntity();
		board.number = number;
		try {
			return new ResponseEntity<BoardEntity>(boardService.save(board), HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error("Error while saving new board with number: " + number);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/all")
	public ResponseEntity<?> findAll() {
		logger.info("Getting all boards");
		List<BoardEntity> rezList = boardService.findAll();
		return new ResponseEntity<List<BoardEntity>>(rezList, HttpStatus.OK);
	}
}
