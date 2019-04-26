package wis.domain;

import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import wis.utils.View.ShowCourse;
import wis.utils.View.ShowStudentYear;

//GodinaStudija

@Entity
@Where(clause = "deleted = 'false'")
public class YearOfStudy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@Column(nullable = false)
	private Date year;

	@JsonView(ShowCourse.class)
	@OneToMany(mappedBy = "yearOfStudy", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Course> courses;

	@JsonView(ShowStudentYear.class)
	@OneToMany(mappedBy = "yearOfStudy", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<StudentYear> studentsYear;

	@ManyToMany(mappedBy = "yearsOfStudy", fetch = FetchType.LAZY)
	private Set<StudyProgram> studyPrograms;

	public YearOfStudy() {
	}

	public YearOfStudy(@NotNull Boolean deleted, int version, Date year, Set<Course> courses,
			Set<StudentYear> studentsYear, Set<StudyProgram> studyPrograms) {
		super();
		this.deleted = deleted;
		this.version = version;
		this.year = year;
		this.courses = courses;
		this.studentsYear = studentsYear;
		this.studyPrograms = studyPrograms;
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

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<StudentYear> getStudentsYear() {
		return studentsYear;
	}

	public void setStudentsYear(Set<StudentYear> studentsYear) {
		this.studentsYear = studentsYear;
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
		YearOfStudy object = (YearOfStudy) o;
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
