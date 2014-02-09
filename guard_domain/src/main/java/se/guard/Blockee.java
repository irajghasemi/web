package se.guard;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "BLOCKEE")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Blockee
{
	@Id
	@Column(name = "BLOCKEE_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlElement
	private int blockee_id;

	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "BLOCKER_ID")
	@XmlElement
	private User blocker_id;

	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "BLOCKED_ID")
	@XmlElement
	private User blocked_id;

	// Constructors

	/** default constructor */
	public Blockee()
	{
	}

	/** minimal constructor */
	public Blockee(int id)
	{
		this.blockee_id = id;
	}

	/** full constructor */
	public Blockee(int id, User blocker_id, User blocked_id)
	{
		this.blockee_id = id;
		this.blocker_id = blocker_id;
		this.blocked_id = blocked_id;
	}

	public Blockee(User blocker_id, User blocked_id)
	{
		this.blocker_id = blocker_id;
		this.blocked_id = blocked_id;
	}

	

	public int getBlockee_id()
	{
		return blockee_id;
	}

	public void setBlockee_id(int blockee_id)
	{
		this.blockee_id = blockee_id;
	}

	public User getBlocker_id()
	{
		return blocker_id;
	}

	public void setBlocker_id(User blocker_id)
	{
		this.blocker_id = blocker_id;
	}

	public User getBlocked_id()
	{
		return blocked_id;
	}

	public void setBlocked_id(User blocked_id)
	{
		this.blocked_id = blocked_id;
	}

	

	@Override
	public int hashCode()
	{
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(getBlockee_id());
		builder.append(getBlocked_id());
		builder.append(getBlocker_id());
		return builder.toHashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof User)
		{
			Blockee other = (Blockee) obj;
			EqualsBuilder builder = new EqualsBuilder();
			builder.append(getBlockee_id(), other.blockee_id);
			builder.append(getBlocker_id(), other.blocker_id);
			builder.append(getBlocked_id(), other.blocked_id);

			return builder.isEquals();
		}
		return false;
	}

	@Override
	public String toString()
	{
		return new ToStringCreator(this)
		.append("BLOCKEE_ID ", this.getBlockee_id())
		.append("BLOCKER_ID", this.getBlocker_id())
		.append("BLOCKED_ID ", this.getBlocked_id())
		.toString();
	}

}
