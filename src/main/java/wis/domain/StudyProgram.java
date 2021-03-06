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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

//StudijskiProgram

@Entity
@Where(clause = "deleted = 'false'")
public class StudyProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@Column(nullable = false)
	@Size(max = 50)
	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<YearOfStudy> yearsOfStudy;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Teacher> teachers;

	@ManyToOne(cascade = CascadeType.ALL)
	private Faculty faculty;

	public StudyProgram() {

	}

	public StudyProgram(@NotNull Boolean deleted, int version, @Size(max = 50) String name,
			Set<YearOfStudy> yearsOfStudy, Set<Teacher> teachers, Faculty faculty) {
		super();
		this.deleted = deleted;
		this.version = version;
		this.name = name;
		this.yearsOfStudy = yearsOfStudy;
		this.teachers = teachers;
		this.faculty = faculty;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<YearOfStudy> getYearsOfStudy() {
		return yearsOfStudy;
	}

	public void setYearsOfStudy(Set<YearOfStudy> yearsOfStudy) {
		this.yearsOfStudy = yearsOfStudy;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		StudyProgram object = (StudyProgram) o;
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
