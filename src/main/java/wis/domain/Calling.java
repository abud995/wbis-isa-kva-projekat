package wis.domain;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

//Zvanje

@Entity
@Where(clause = "deleted = 'false'")
public class Calling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50)
	private Date dateOfChoice;

	@Size(max = 50)
	private Date dateOfEnd;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@ManyToOne(cascade = CascadeType.ALL)
	private ScientificField scientificField;

	@ManyToOne(cascade = CascadeType.ALL)
	private CallingType callingType;

	@ManyToOne(cascade = CascadeType.ALL)
	private Teacher teacher;

	public Calling() {

	}

	public Calling(@Size(max = 50) Date dateOfChoice, @Size(max = 50) Date dateOfEnd, @NotNull Boolean deleted,
			int version, ScientificField scientificField, CallingType callingType, Teacher teacher) {
		super();
		this.dateOfChoice = dateOfChoice;
		this.dateOfEnd = dateOfEnd;
		this.deleted = deleted;
		this.version = version;
		this.scientificField = scientificField;
		this.callingType = callingType;
		this.teacher = teacher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateOfChoice() {
		return dateOfChoice;
	}

	public void setDateOfChoice(Date dateOfChoice) {
		this.dateOfChoice = dateOfChoice;
	}

	public Date getDateOfEnd() {
		return dateOfEnd;
	}

	public void setDateOfEnd(Date dateOfEnd) {
		this.dateOfEnd = dateOfEnd;
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

	public ScientificField getScientificField() {
		return scientificField;
	}

	public void setScientificField(ScientificField scientificField) {
		this.scientificField = scientificField;
	}

	public CallingType getCallingType() {
		return callingType;
	}

	public void setCallingType(CallingType callingType) {
		this.callingType = callingType;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Calling object = (Calling) o;
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
