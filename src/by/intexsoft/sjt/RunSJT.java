package by.intexsoft.sjt;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import by.intexsoft.sjt.entity.BookEntity;
import by.intexsoft.sjt.service.BookService;
import by.intexsoft.sjt.service.BookServiceImpl;

public class RunSJT {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.sjt.config");
		BookService service = context.getBean(BookServiceImpl.class);
		// Arrays.asList(context.getBeanDefinitionNames()).forEach(bean ->
		// System.out.println(bean));
		BookEntity book = new BookEntity();
		book.setAuthor("author77");
		book.setBook("book77");
		book.setUser("user77");
		System.out.println(service.addBook(book) != null ? "done!" : "error...");
		context.close();
	}
}
