package by.intexsoft.sjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity extends AbstractEntity {

	private static final long serialVersionUID = 673826331106990643L;

	@Column(name = "book")
	public String book;
	@Column(name = "author")
	public String author;
	@Column(name = "users")
	public String user;
	@Column(name = "board")
	public int board;
}
