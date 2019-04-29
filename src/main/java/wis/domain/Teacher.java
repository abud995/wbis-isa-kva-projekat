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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import wis.utils.View.ShowCalling;
import wis.utils.View.ShowCourseTeaching;

//Nastavnik

@Entity
@Where(clause = "deleted = 'false'")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Size(max = 50)
	private String biography;

	@NotNull
	private Boolean deleted = false;

	@JsonView(ShowCourseTeaching.class)
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseTeaching> courseTeachings;

	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;

	@ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
	private Set<Faculty> faculties;

	@ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
	private Set<University> universities;

	@ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
	private Set<StudyProgram> studyPrograms;

	@JsonView(ShowCalling.class)
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Calling> callings;

	@Version
	private int version = 0;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private AccountData accountData;

	public Teacher() {

	}

	public Teacher(@Size(max = 50) String biography, @NotNull Boolean deleted, Set<CourseTeaching> courseTeachings,
			Address address, Set<Faculty> faculties, Set<University> universities, Set<StudyProgram> studyPrograms,
			Set<Calling> callings, int version, AccountData accountData) {
		super();
		this.biography = biography;
		this.deleted = deleted;
		this.courseTeachings = courseTeachings;
		this.address = address;
		this.faculties = faculties;
		this.universities = universities;
		this.studyPrograms = studyPrograms;
		this.callings = callings;
		this.version = version;
		this.accountData = accountData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Set<CourseTeaching> getCourseTeachings() {
		return courseTeachings;
	}

	public void setCourseTeachings(Set<CourseTeaching> courseTeachings) {
		this.courseTeachings = courseTeachings;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

	public Set<University> getUniversities() {
		return universities;
	}

	public void setUniversities(Set<University> universities) {
		this.universities = universities;
	}

	public Set<StudyProgram> getStudyPrograms() {
		return studyPrograms;
	}

	public void setStudyPrograms(Set<StudyProgram> studyPrograms) {
		this.studyPrograms = studyPrograms;
	}

	public Set<Calling> getCallings() {
		return callings;
	}

	public void setCallings(Set<Calling> callings) {
		this.callings = callings;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		Teacher object = (Teacher) o;
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
