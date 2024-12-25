package entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "certificates")
public class Certificate implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2894416978008078032L;

	/**
	 * 
	 */

	
	@Id
	@Column(name = "certificate_id")
	private String id;
	
	private String name;
	private String organization;
	
	@Column(name = "issued_date")
	private LocalDate issuedDate;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;



	public Certificate(String id, String name, String organization, LocalDate issuedDate, Candidate candidate) {
		super();
		this.id = id;
		this.name = name;
		this.organization = organization;
		this.issuedDate = issuedDate;
		this.candidate = candidate;
	}


	public Certificate() {
		super();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public LocalDate getIssuedDate() {
		return issuedDate;
	}


	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}


	public Candidate getCandidate() {
		return candidate;
	}


	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Certificate [id=" + id + ", name=" + name + ", organization=" + organization + ", issuedDate="
				+ issuedDate + ", candidate=" + candidate + "]";
	}




}
