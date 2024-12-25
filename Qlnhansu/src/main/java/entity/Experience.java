package entity;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "experiences")
public class Experience implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8546677692620432919L;
	
	@Id
	@Column(name = "company_name")

	private String companyName;
	
	private String description;
	
	@Column(name = "from_date")
	private LocalDate fromDate;
	@Column(name = "to_date")
	private LocalDate toDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	private Position position;

	public Experience(String companyName, String description, LocalDate fromDate, LocalDate toDate) {
		super();
		this.companyName = companyName;
		this.description = description;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Experience(String companyName, String description, LocalDate fromDate, LocalDate toDate, Candidate candidate,
			Position position) {
		super();
		this.companyName = companyName;
		this.description = description;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.candidate = candidate;
		this.position = position;
	}

	public Experience() {
		super();
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Experience [companyName=" + companyName + ", description=" + description + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", candidate=" + candidate + ", position=" + position + "]";
	}
	
	
	
	

}
