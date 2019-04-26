package wis.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import wis.utils.View.ShowCourseAttending;
import wis.utils.View.ShowStudentYear;

//Student

@Entity
@Where(clause = "deleted = 'false'")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Size(max = 50)
	private String firstName;

	@Column(nullable = false)
	@Size(max = 50)
	private String JMBG;

	@Column(nullable = false)
	@Size(max = 50)
	private String lastName;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@JsonView(ShowCourseAttending.class)
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseAttending> courseAttendings;

	@JsonView(ShowStudentYear.class)
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<StudentYear> studentYears;

	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;

	public Student() {

	}

	public Student(@Size(max = 50) String firstName, @Size(max = 50) String jMBG, @Size(max = 50) String lastName,
			@NotNull Boolean deleted, int version, Set<CourseAttending> courseAttendings, Set<StudentYear> studentYears,
			Address address) {
		super();
		this.firstName = firstName;
		JMBG = jMBG;
		this.lastName = lastName;
		this.deleted = deleted;
		this.version = version;
		this.courseAttendings = courseAttendings;
		this.studentYears = studentYears;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Set<CourseAttending> getCourseAttendings() {
		return courseAttendings;
	}

	public void setCourseAttendings(Set<CourseAttending> courseAttendings) {
		this.courseAttendings = courseAttendings;
	}

	public Set<StudentYear> getStudentYears() {
		return studentYears;
	}

	public void setStudentYears(Set<StudentYear> studentYears) {
		this.studentYears = studentYears;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Student object = (Student) o;
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
