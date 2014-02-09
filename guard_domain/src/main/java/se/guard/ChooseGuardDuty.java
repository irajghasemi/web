package se.guard;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "PICKED_GUARD_DUTY")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChooseGuardDuty
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_PICKED_DATE_ID", unique = true, nullable = false)
	@XmlElement
	private int pickedService_id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE ,CascadeType.DETACH})
	@JoinColumn(name = "USER_ONE_ID")
	@XmlElement
	private User userOne;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE ,CascadeType.DETACH})
	@JoinColumn(name = "USER_TWO_ID")
	@XmlElement
	private User userTwo;
	
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE ,CascadeType.DETACH})
	@JoinColumn(name = "DATEANDTIME_ID")
	@XmlElement
	private DateAndTime dateAndTime;
	

	public ChooseGuardDuty()
	{
	}
	

	public ChooseGuardDuty(int pickingDatesAndTimes_id)
	{
		this.pickedService_id = pickingDatesAndTimes_id;
	}


	public ChooseGuardDuty(User userOne, User userTow, DateAndTime dateAndTime)
	{
		this.userOne = userOne;
		this.userTwo = userTow;
		this.dateAndTime = dateAndTime;
	}

	public ChooseGuardDuty(int pickingDatesAndTimes_id, User userOne, User userTwo, DateAndTime dateAndTime)
	{
		this.pickedService_id = pickingDatesAndTimes_id;
		this.userOne = userOne;
		this.userTwo = userTwo;
		this.dateAndTime = dateAndTime;
	}

	
	
	public ChooseGuardDuty(int pickedService_id, User userOne, DateAndTime dateAndTime)
	{
		this.pickedService_id = pickedService_id;
		this.userOne = userOne;
		this.dateAndTime = dateAndTime;
	}


	public ChooseGuardDuty(User userOne, User userTwo)
	{
		this.userOne = userOne;
		this.userTwo = userTwo;
	}


	public ChooseGuardDuty(int pickedService_id, User userOne, User userTwo)
	{
		this.pickedService_id = pickedService_id;
		this.userOne = userOne;
		this.userTwo = userTwo;
	}


	public User getUserOne()
	{
		return userOne;
	}

	public void setUserOne(User userOne)
	{
		this.userOne = userOne;
	}

	public User getUserTwo()
	{
		return userTwo;
	}

	public void setUserTwo(User userTwo)
	{
		this.userTwo = userTwo;
	}

	

	public int getPickedService_id()
	{
		return pickedService_id;
	}


	public void setPickedService_id(int pickedService_id)
	{
		this.pickedService_id = pickedService_id;
	}


	public DateAndTime getDateAndTime()
	{
		return dateAndTime;
	}

	public void setDateAndTime(DateAndTime dateAndTime)
	{
		this.dateAndTime = dateAndTime;
	}
	


	@Override
	public int hashCode()
	{
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(getPickedService_id());
		builder.append(getDateAndTime());
		builder.append(getUserOne());
		builder.append(getUserTwo());
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof User)
		{
			ChooseGuardDuty other = (ChooseGuardDuty) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(getPickedService_id(), other.pickedService_id);
			builder.append(getUserOne(), other.userOne);
			builder.append(getUserTwo(), other.userTwo);
			builder.append(getDateAndTime(), other.dateAndTime);

			return builder.isEquals();
		}
		return false;
	}

	@Override
	public String toString()
	{
		return new ToStringCreator(this)
		.append("DATE_PICKER_ID ", this.getPickedService_id())
		.append("USER_ONE", this.getUserOne())
		.append("USER_TWO", this.getUserTwo())
		.append("DATEANDTIME_ID", this.getDateAndTime())
		.toString();
	}

}
