package models;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
@Entity
@Table(name = "employee")

@JsonIgnoreProperties("lstOrder")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id", columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name = "full_name", columnDefinition = "VARCHAR(150)", nullable = false)
    private String fullname;
    @Column(columnDefinition = "VARCHAR(150)")
    private String email;
    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    private String phone;
    @Column(columnDefinition = "VARCHAR(250)", nullable = false)
    private String address;
    @Column(columnDefinition = "DATETIME(6)", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dob;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)

    private String status;
   
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> lstOrder;

    public Employee() {
    }

    public Employee(long id) {
        this.id = id;
    }

   

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

 

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Order> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<Order> lstOrder) {
        this.lstOrder = lstOrder;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", status=" + status +
                '}';
    }
}
