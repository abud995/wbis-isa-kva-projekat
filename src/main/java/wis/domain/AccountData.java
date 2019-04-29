package wis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = 'false'")
public class AccountData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private Boolean deleted = false;

	@Version
	private int version = 0;

	@Column(nullable = false)
	@Size(max = 50)
	private String username;

	@Column(nullable = false)
	@Size(max = 50)
	private String password;

	@Column(nullable = false)
	@Size(max = 50)
	private String email;

	@Column(nullable = false)
	@Size(max = 50)
	private String firstName;

	@Column(nullable = false)
	@Size(max = 50)
	private String lastName;

	@Column(nullable = false)
	@Size(max = 13)
	private String JMBG;

	@Column(nullable = false)
	@Size(max = 150)
	private String pictureLink;

	@Column(nullable = false)
	@Size(max = 7)
	private String accountType; // moze samo "student" "teacher" "admin"

	public AccountData() {
	}

	public AccountData(@NotNull Boolean deleted, int version, @Size(max = 50) String username,
			@Size(max = 50) String password, @Size(max = 50) String email, @Size(max = 50) String firstName,
			@Size(max = 50) String lastName, @Size(max = 13) String jMBG, @Size(max = 150) String pictureLink,
			@Size(max = 7) String accountType) {
		super();
		this.deleted = deleted;
		this.version = version;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		JMBG = jMBG;
		this.pictureLink = pictureLink;
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getPictureLink() {
		return pictureLink;
	}

	public void setPictureLink(String pictureLink) {
		this.pictureLink = pictureLink;
	};

}
