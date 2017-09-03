package by.intexsoft.library;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.intexsoft.library.entity.BoardEntity;
import by.intexsoft.library.service.BoardService;
import by.intexsoft.library.service.impl.BoardServiceImpl;

public class RunSJT {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.sjt.config");
		BoardService boardService = context.getBean(BoardServiceImpl.class);
		// Arrays.asList(context.getBeanDefinitionNames()).forEach(bean ->
		// System.out.println(bean));
//		BoardEntity bobobo = new BoardEntity();
//		bobobo.number = 3;
//		boardService.save(bobobo);
		boardService.findAll().forEach((BoardEntity board) -> System.out.println(board.number));
		context.close();
	}
}
