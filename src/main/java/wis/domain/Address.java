package wis.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

import wis.utils.View.ShowFaculty;
import wis.utils.View.ShowStudent;
import wis.utils.View.ShowTeacher;
import wis.utils.View.ShowUniversity;

//Adresa

@Entity
@Where(clause = "deleted = 'false'")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@Size(max = 50)
	private String streetName;

	@Size(max = 50)
	private String number;

	@ManyToOne(cascade = CascadeType.ALL)
	private Place place;

	@JsonView(ShowFaculty.class)
	@OneToMany(mappedBy = "address")
	private Set<Faculty> faculties;

	@JsonView(ShowUniversity.class)
	@OneToMany(mappedBy = "address")
	private Set<University> universities;

	@JsonView(ShowStudent.class)
	@OneToMany(mappedBy = "address")
	private Set<Student> students;

	@JsonView(ShowTeacher.class)
	@OneToMany(mappedBy = "address")
	private Set<Teacher> teachers;

	public Address() {
	}

	public Address(@NotNull Boolean deleted, int version, @Size(max = 50) String streetName,
			@Size(max = 50) String number, Place place, Set<Faculty> faculties, Set<University> universities,
			Set<Student> students, Set<Teacher> teachers) {
		super();
		this.deleted = deleted;
		this.version = version;
		this.streetName = streetName;
		this.number = number;
		this.place = place;
		this.faculties = faculties;
		this.universities = universities;
		this.students = students;
		this.teachers = teachers;
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

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
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

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address object = (Address) o;
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
