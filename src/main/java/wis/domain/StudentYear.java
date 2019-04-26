package wis.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

//StudentNaGodini

@Entity
@Where(clause = "deleted = 'false'")
public class StudentYear {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@Column(nullable = false)
	private Date registrationDate;

	@Column(nullable = false)
	@Size(max = 10)
	private String numIndex;

	@ManyToOne(cascade = CascadeType.ALL)
	private YearOfStudy yearOfStudy;

	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;

	public StudentYear() {

	}

	public StudentYear(@NotNull Boolean deleted, int version, Date registrationDate, @Size(max = 10) String numIndex,
			YearOfStudy yearOfStudy, Student student) {
		super();
		this.deleted = deleted;
		this.version = version;
		this.registrationDate = registrationDate;
		this.numIndex = numIndex;
		this.yearOfStudy = yearOfStudy;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getNumIndex() {
		return numIndex;
	}

	public void setNumIndex(String numIndex) {
		this.numIndex = numIndex;
	}

	public YearOfStudy getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(YearOfStudy yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StudentYear object = (StudentYear) o;
		if (object.id == null || id == null) {
			return false;
		}
		return Objects.equals(id, object.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

}
