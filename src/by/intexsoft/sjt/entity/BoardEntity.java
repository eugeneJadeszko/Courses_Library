package by.intexsoft.sjt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Model for board table 
 */
@Entity
@Table(name = "board")
public class BoardEntity extends AbstractEntity {

	private static final long serialVersionUID = -3302159904799304288L;

	/**
	 * number of board
	 */
	@Column(name = "board_number")
	public int number;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "board", fetch = FetchType.EAGER)
//	public Set<BookEntity> book;
}
