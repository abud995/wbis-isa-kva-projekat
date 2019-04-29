package wis.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private AccountData accountData;

	public Student() {

	}

	public Student(@NotNull Boolean deleted, int version, Set<CourseAttending> courseAttendings,
			Set<StudentYear> studentYears, Address address, AccountData accountData) {
		super();
		this.deleted = deleted;
		this.version = version;
		this.courseAttendings = courseAttendings;
		this.studentYears = studentYears;
		this.address = address;
		this.accountData = accountData;
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

	public AccountData getAccountData() {
		return accountData;
	}

	public void setAccountData(AccountData accountData) {
		this.accountData = accountData;
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
