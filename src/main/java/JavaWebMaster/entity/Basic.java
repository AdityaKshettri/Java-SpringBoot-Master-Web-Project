package JavaWebMaster.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Basic")
public class Basic 
{
	@Id
	@GeneratedValue
	private int id;
	
	@Column
	private String name;
	
	@OneToOne
	private User owner;

	public Basic() {
	}

	public Basic(String name, User owner) {
		this.name = name;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Basic [id=" + id + ", name=" + name + ", owner=" + owner + "]";
	}
	
}
