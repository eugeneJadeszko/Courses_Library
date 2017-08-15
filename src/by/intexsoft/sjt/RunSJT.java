package by.intexsoft.sjt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.intexsoft.sjt.entity.BookEntity;
import by.intexsoft.sjt.service.BookService;
import by.intexsoft.sjt.service.impl.BookServiceImpl;

public class RunSJT {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.sjt.config");
		BookService service = context.getBean(BookServiceImpl.class);
		// Arrays.asList(context.getBeanDefinitionNames()).forEach(bean ->
		// System.out.println(bean));
		// BookEntity book = new BookEntity();
		// book.author = "author77";
		// book.book = "book77";
		// book.user = "user77";
		// System.out.println(service.save(book) != null ? "done!" : "error...");
		service.findAll().forEach((BookEntity book) -> System.out.println(book.author));
		context.close();
	}
}
