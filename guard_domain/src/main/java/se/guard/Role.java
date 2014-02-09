package se.guard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "ROLE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) 
public class Role
{

	@Id
	@Column(name = "ROLE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private int roleid;

	@Column(name = "ROLE_NAME")
	@XmlElement
	private String rolename;


	public Role()
	{
	}
	

	public Role(String rolename)
	{
		this.rolename = rolename;
	}

	public Role(int roleid, String rolename)
	{
		this.roleid = roleid;
		this.rolename = rolename;
	}

	/** GETTERS/SETTERS **/

	public int getRoleid()
	{
		return roleid;
	}

	public void setRoleid(int roleid)
	{
		this.roleid = roleid;
	}

	public String getRolename()
	{
		return rolename;
	}

	public void setRolename(String rolename)
	{
		this.rolename = rolename;
	}
	@Override
	public String toString()
	{
		return new ToStringCreator(this)
		.append("ROLEID ", this.roleid)
		.append("ROLENAME ", this.rolename)
				.toString();
	}


}
