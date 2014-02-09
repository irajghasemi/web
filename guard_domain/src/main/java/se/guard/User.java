package se.guard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "USER")
@XmlType(name = "userType")
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD) 
public class User
{
	

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private int userid;

	@XmlElement
	@Column(name = "FIRSTNAME", nullable = true, unique = false)
	private String firstname;

	@XmlElement
	@Column(name = "LASTNAME", nullable = true, unique = false)
	private String lastname;

	@XmlElement
	@Column(name = "USERNAME", nullable = true, unique = false)
	private String username;

	@XmlElement
	@Column(name = "PASSWORD", nullable = false, unique = false,length = 255)
	private String password;

	@XmlElement
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;

	@XmlElement
	@Column(name = "ISENABLED", nullable = true, unique = false)
	private Boolean isEnabled;

	@Embedded
	@XmlElement
	private Address address;

	@XmlElement
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
	private List<Role> roles = new ArrayList<Role>();
	
	@XmlElement
	@Column(name = "CIVIC_REG_NUMBER", nullable = false, unique = false)
	private String civicregnumber;
	
	@Transient
	@XmlElement
	@OneToMany(mappedBy="user")
	private Collection<ChooseGuardDuty> userOne;
	@Transient
	@XmlElement
	@OneToMany(mappedBy="user")
	private Collection<ChooseGuardDuty> userTwo;

	public User()
	{
	}
	
	public User(int userId, String firstName, String lastName, String userName, String password, String email, Boolean isEnabled, Address address)
	{
		this.userid = userId;
		this.firstname = firstName;
		this.lastname = lastName;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.isEnabled = isEnabled;
		this.address = address;
	}

	public User(int userid, String firstname, String lastname, String civicRegNumber, String username, String password, String email, Boolean isEnabled, Address address)
	{
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isEnabled = isEnabled;
		this.address = address;
		this.civicregnumber = civicRegNumber;
	}
	


	public User(String firstname, String lastname, String civicRegNumber, String username, String password, String email, Boolean isEnabled, Address address, List<Role> roles)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isEnabled = isEnabled;
		this.address = address;
		this.roles = roles;
		this.civicregnumber = civicRegNumber;
	}


	public User(String firstname, String lastname, String civicRegNumber, String username, String password, String email, Boolean isEnabled, Address address)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isEnabled = isEnabled;
		this.address = address;
		this.civicregnumber = civicRegNumber;
	}




	public User(int userid, String firstname, String lastname, String civicRegNumber, String username, String password, String email, Boolean isEnabled, Address address, List<Role> roles)
	{
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isEnabled = isEnabled;
		this.address = address;
		this.roles = roles;
		this.civicregnumber = civicRegNumber;
	}


	public User(int userId, String firstName, String lastName, String userName, String password, String email, Boolean isEnabled, Address address, List<Role> roles)
	{
		this.userid = userId;
		this.firstname = firstName;
		this.lastname = lastName;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.isEnabled = isEnabled;
		this.address = address;
		this.roles = roles;
	}


	public User(String firstName, String lastName, String userName, String password, String email, Boolean isEnabled, Address address, List<Role> roles)
	{
		this.firstname = firstName;
		this.lastname = lastName;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.isEnabled = isEnabled;
		this.address = address;
		this.roles = roles;
	}


	public User(String firstName, String lastName, String userName, String password, String email, Boolean isEnabled, Address address)
	{
		this.firstname = firstName;
		this.lastname = lastName;
		this.username = userName;
		this.password = password;
		this.email = email;
		this.isEnabled = isEnabled;
		this.address = address;
	}
	

	public User(int userid, String firstname, String lastname, String email,String password)
	{
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password=password;
	}

	
	
	

	public User(int userid, String firstname, String lastname, String username, String password, String email, Boolean isEnabled, Address address, List<Role> roles,
			String civicregnumber, Collection<ChooseGuardDuty> userOne, Collection<ChooseGuardDuty> userTwo)
	{
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isEnabled = isEnabled;
		this.address = address;
		this.roles = roles;
		this.civicregnumber = civicregnumber;
		this.userOne = userOne;
		this.userTwo = userTwo;
	}

	/** GETTERS/SETTERS **/


	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Boolean getIsEnabled()
	{
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled)
	{
		this.isEnabled = isEnabled;
	}

	public List<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(List<Role> roles)
	{
		this.roles = roles;
	}


	public String getCivicregnumber()
	{
		return civicregnumber;
	}

	public void setCivicregnumber(String civicregnumber)
	{
		this.civicregnumber = civicregnumber;
	}

	public int getUserid()
	{
		return userid;
	}


	public void setUserid(int userid)
	{
		this.userid = userid;
	}


	public String getFirstname()
	{
		return firstname;
	}


	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}


	public String getLastname()
	{
		return lastname;
	}


	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}


	public String getUsername()
	{
		return username;
	}


	public void setUsername(String username)
	{
		this.username = username;
	}


	public Collection<ChooseGuardDuty> getUserOne()
	{
		return userOne;
	}

	public void setUserOne(Collection<ChooseGuardDuty> userOne)
	{
		this.userOne = userOne;
	}

	public Collection<ChooseGuardDuty> getUserTwo()
	{
		return userTwo;
	}

	public void setUserTwo(Collection<ChooseGuardDuty> userTwo)
	{
		this.userTwo = userTwo;
	}

	@Override
	public int hashCode()
	{
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(getUserid());
		builder.append(getPassword());
		builder.append(getCivicregnumber());
		builder.append(getAddress());
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof User)
		{
			User other = (User) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(getUserid(), other.getUserid());
			builder.append(getUsername(), other.getUsername());
			builder.append(getPassword(), other.getPassword());
			builder.append(getCivicregnumber(), other.getCivicregnumber());
			builder.append(getAddress(), other.getAddress());
			return builder.isEquals();
		}
		return false;
	}
	//Get the name of roles from the list
	@Transient
	public List<String> getRoleNames()
	{
		List<String> roleNames = new ArrayList<String>();
		
		for (Role role : getRoles())
		{
			roleNames.add(role.getRolename());
		}
		
		return roleNames;
	}

	@Override
	public String toString()
	{
		return new ToStringCreator(this)
		.append("USERID ", this.userid)
		.append("Firstname ", this.firstname)
		.append("Lastname", this.lastname)
		.append("CivicRegNumber", this.civicregnumber)
		.append("Username", this.username)
		.append("Password", this.password)
		.append("Email", this.email)
		.append("IsEnabled", this.isEnabled)
		.append("Address", this.address)
		.append("Roles", this.getRoleNames())
				.toString();
	}



}
