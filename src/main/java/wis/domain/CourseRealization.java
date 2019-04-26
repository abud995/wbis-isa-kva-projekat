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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import wis.utils.View.ShowCourseTeaching;

//RealizacijaPredmeta

@Entity
@Where(clause = "deleted = 'false'")
public class CourseRealization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@JsonView(ShowCourseTeaching.class)
	@OneToMany(mappedBy = "courseRealization", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private Set<CourseTeaching> courseTeachings;

	@OneToMany(mappedBy = "courseRealization", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	private Set<CourseAttending> courseAttendings;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;

	public CourseRealization() {

	}

	public CourseRealization(@NotNull Boolean deleted, int version, Set<CourseTeaching> courseTeachings,
			Set<CourseAttending> courseAttendings, Course course) {
		super();
		this.deleted = deleted;
		this.version = version;
		this.courseTeachings = courseTeachings;
		this.courseAttendings = courseAttendings;
		this.course = course;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public Set<CourseTeaching> getCourseTeachings() {
		return courseTeachings;
	}

	public void setCourseTeachings(Set<CourseTeaching> courseTeachings) {
		this.courseTeachings = courseTeachings;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CourseRealization object = (CourseRealization) o;
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
