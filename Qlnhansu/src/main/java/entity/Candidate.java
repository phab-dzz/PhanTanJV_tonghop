package entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5730376804255679624L;
	
	@Id
	@Column(name = "candidate_id",nullable = false)
	private String id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "year_of_birth")
	private int yearOfBirth;
	
	@OneToMany(mappedBy = "candidate")
	private List<Certificate> certificates;
	
	@JoinColumn(name = "position_id")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Position position;
	
	@OneToMany(mappedBy = "candidate")
	private List<Experience> experiences;

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidate(String id, String description, String email, String fullName, String gender, String phone,
			int yearOfBirth, List<Certificate> certificates, Position position, List<Experience> experiences) {
		super();
		this.id = id;
		this.description = description;
		this.email = email;
		this.fullName = fullName;
		this.gender = gender;
		this.phone = phone;
		this.yearOfBirth = yearOfBirth;
		this.certificates = certificates;
		this.position = position;
		this.experiences = experiences;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public List<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", description=" + description + ", email=" + email + ", fullName=" + fullName
				+ ", gender=" + gender + ", phone=" + phone + ", yearOfBirth=" + yearOfBirth + ", certificates="
				+ certificates + ", position=" + position + ", experiences=" + experiences + "]";
	}
	
	
	
}
