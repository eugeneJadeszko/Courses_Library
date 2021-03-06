package by.intexsoft.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Model for users table 
 */
@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {

	private static final long serialVersionUID = 1221835412535177784L;

	/**
	 * First name of user
	 */
	@Column(name = "first_name")
	public String name;
	
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "book_user", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
//	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
//	public Set<BookEntity> books;

}
