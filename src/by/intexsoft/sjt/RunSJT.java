package by.intexsoft.sjt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.intexsoft.sjt.entity.BoardEntity;
import by.intexsoft.sjt.service.BoardService;
import by.intexsoft.sjt.service.impl.BoardServiceImpl;

public class RunSJT {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.sjt.config");
		BoardService boardService = context.getBean(BoardServiceImpl.class);
		// Arrays.asList(context.getBeanDefinitionNames()).forEach(bean ->
		// System.out.println(bean));
		BoardEntity bobobo = new BoardEntity();
		bobobo.number = 3;
		boardService.save(bobobo);
		boardService.findAll().forEach((BoardEntity board) -> System.out.println(board.number));
		context.close();
	}
}
