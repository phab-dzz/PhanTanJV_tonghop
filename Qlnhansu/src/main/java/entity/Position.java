package entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "positions")
public class Position  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1474775876410547126L;
	@Id
	@Column(name = "position_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	private double salary;
	private int number;
	
	@OneToMany(mappedBy = "position",fetch = FetchType.LAZY)
	private Set<Candidate> candidates;
	
	@OneToMany(mappedBy = "position",fetch = FetchType.LAZY)
	private Set<Experience> experiences;
	public Position(int id, String name, String description, double salary, int number) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.salary = salary;
		this.number = number;
	}
	public Position() {
		super();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", description=" + description + ", salary=" + salary
				+ ", number=" + number + "]";
	}
	
	
}
