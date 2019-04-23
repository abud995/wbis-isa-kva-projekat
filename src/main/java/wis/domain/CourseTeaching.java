package wis.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class CourseTeaching {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;
	
	private int numberOfClasses;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Teacher teacher;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CourseRealization courseRealization;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ClassType classType;
	
	
	
	public CourseTeaching() {

	}

	public CourseTeaching(@NotNull Boolean deleted, int version, int numberOfClasses, Teacher teacher,
			CourseRealization courseRealization, ClassType classType) {
		super();
		this.deleted = deleted;
		this.version = version;
		this.numberOfClasses = numberOfClasses;
		this.teacher = teacher;
		this.courseRealization = courseRealization;
		this.classType = classType;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public CourseRealization getCourseRealization() {
		return courseRealization;
	}

	public void setCourseRealization(CourseRealization courseRealization) {
		this.courseRealization = courseRealization;
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

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CourseTeaching object = (CourseTeaching) o;
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
