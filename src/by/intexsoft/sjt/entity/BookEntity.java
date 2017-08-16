package by.intexsoft.sjt.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity extends AbstractEntity {

	private static final long serialVersionUID = 673826331106990643L;

	@Column(name = "tittle")
	public String tittle;
	@Column(name = "author")
	public String author;
	@ManyToOne
	@JoinColumn(name = "board_id")
	public BoardEntity board;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "book_user", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	public Set<UserEntity> users;
}
