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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 50)
	private String firstName;

	@Size(max = 50)
	private String lastName;
	
	@Size(max = 50)
	private String JMBG;

	@Size(max = 20)
	private String personalIdentificationNumber;

	@NotNull
	private Boolean deleted = false;
	
	@OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseTeaching> courseTeachings;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
	
	@ManyToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
	private Set<Faculty> faculties;
	
	@ManyToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
	private Set<University> universities;
	
	@ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
	private Set<StudyProgram> studyPrograms;

	@Version
	private int version = 0;
	
	
	
	public Teacher() {

	}

	public Teacher(@Size(max = 50) String firstName, @Size(max = 50) String lastName, @Size(max = 50) String jMBG,
			@Size(max = 20) String personalIdentificationNumber, @NotNull Boolean deleted,
			Set<CourseTeaching> courseTeachings, Address address, Set<Faculty> faculties, Set<University> universities,
			Set<StudyProgram> studyPrograms, int version) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		JMBG = jMBG;
		this.personalIdentificationNumber = personalIdentificationNumber;
		this.deleted = deleted;
		this.courseTeachings = courseTeachings;
		this.address = address;
		this.faculties = faculties;
		this.universities = universities;
		this.studyPrograms = studyPrograms;
		this.version = version;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
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
	
	

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public Set<StudyProgram> getStudyPrograms() {
		return studyPrograms;
	}

	public void setStudyPrograms(Set<StudyProgram> studyPrograms) {
		this.studyPrograms = studyPrograms;
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
