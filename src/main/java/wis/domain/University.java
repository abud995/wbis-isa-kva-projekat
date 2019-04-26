package wis.domain;

import java.sql.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import wis.utils.View.ShowFaculty;

//Univerzitet

@Entity
@Where(clause = "deleted = 'false'")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@Size(max = 50)
	private String name;

	@Column(nullable = false)
	@Size(max = 50)
	private Date dateOfEstablishment;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@JsonView(ShowFaculty.class)
	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Faculty> Faculties;

	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;

	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Teacher> teachers;

	public University() {

	}

	public University(@Size(max = 50) String name, @Size(max = 50) Date dateOfEstablishment, @NotNull Boolean deleted,
			int version, Set<Faculty> faculties, Address address, Set<Teacher> teachers) {
		super();
		this.name = name;
		this.dateOfEstablishment = dateOfEstablishment;
		this.deleted = deleted;
		this.version = version;
		Faculties = faculties;
		this.address = address;
		this.teachers = teachers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfEstablishment() {
		return dateOfEstablishment;
	}

	public void setDateOfEstablishment(Date dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
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

	public Set<Faculty> getFaculties() {
		return Faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		Faculties = faculties;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
		University object = (University) o;
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
