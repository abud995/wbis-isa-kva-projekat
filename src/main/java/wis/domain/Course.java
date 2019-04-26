package wis.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import wis.utils.View.ShowResult;

//Predmet

@Entity
@Where(clause = "deleted = 'false'")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Size(max = 50)
	private String title;

	private int ects;

	private boolean obligatory;

	private int numberOfLectures;

	private int numberOfExcercises;

	private int otherFormsOfActivities;

	private int researchPaper;

	private int otherClasses;

	@Version
	private int version = 0;

	@OneToOne(mappedBy = "course")
	private CourseRealization courseRealizations;

	@JsonView(ShowResult.class)
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Result> sylabus;

	@ManyToOne(cascade = CascadeType.ALL)
	private YearOfStudy yearOfStudy;

	@ManyToOne(fetch = FetchType.LAZY)
	private Faculty faculty;

	public Course() {

	}

	public Course(@NotNull Boolean deleted, @Size(max = 50) String title, int ects, boolean obligatory,
			int numberOfLectures, int numberOfExcercises, int otherFormsOfActivities, int researchPaper,
			int otherClasses, int version, CourseRealization courseRealizations, Set<Result> sylabus,
			YearOfStudy yearOfStudy, Faculty faculty) {
		super();
		this.deleted = deleted;
		this.title = title;
		this.ects = ects;
		this.obligatory = obligatory;
		this.numberOfLectures = numberOfLectures;
		this.numberOfExcercises = numberOfExcercises;
		this.otherFormsOfActivities = otherFormsOfActivities;
		this.researchPaper = researchPaper;
		this.otherClasses = otherClasses;
		this.version = version;
		this.courseRealizations = courseRealizations;
		this.sylabus = sylabus;
		this.yearOfStudy = yearOfStudy;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

	public boolean isObligatory() {
		return obligatory;
	}

	public void setObligatory(boolean obligatory) {
		this.obligatory = obligatory;
	}

	public int getNumberOfLectures() {
		return numberOfLectures;
	}

	public void setNumberOfLectures(int numberOfLectures) {
		this.numberOfLectures = numberOfLectures;
	}

	public int getNumberOfExcercises() {
		return numberOfExcercises;
	}

	public void setNumberOfExcercises(int numberOfExcercises) {
		this.numberOfExcercises = numberOfExcercises;
	}

	public int getOtherFormsOfActivities() {
		return otherFormsOfActivities;
	}

	public void setOtherFormsOfActivities(int otherFormsOfActivities) {
		this.otherFormsOfActivities = otherFormsOfActivities;
	}

	public int getResearchPaper() {
		return researchPaper;
	}

	public void setResearchPaper(int researchPaper) {
		this.researchPaper = researchPaper;
	}

	public int getOtherClasses() {
		return otherClasses;
	}

	public void setOtherClasses(int otherClasses) {
		this.otherClasses = otherClasses;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public CourseRealization getCourseRealizations() {
		return courseRealizations;
	}

	public void setCourseRealizations(CourseRealization courseRealizations) {
		this.courseRealizations = courseRealizations;
	}

	public Set<Result> getSylabus() {
		return sylabus;
	}

	public void setSylabus(Set<Result> sylabus) {
		this.sylabus = sylabus;
	}

	public YearOfStudy getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(YearOfStudy yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
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
		Course object = (Course) o;
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
