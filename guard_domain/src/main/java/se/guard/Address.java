package se.guard;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.core.style.ToStringCreator;

@Embeddable
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
	

	@Column(name="STREET")
	@XmlElement
	private String street;
	
	@Column(name="ZIPCODE")
	@XmlElement
	private String zipcode;
	
	@Column(name="CITY")
	@XmlElement
	private String city;
	
	
	public Address() {
	}
	
	
	public Address(String street, String zipcode, String city)
	{
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	@Override
	public int hashCode() {
		HashCodeBuilder builder= new HashCodeBuilder();
		builder.append(getStreet());
		builder.append(getZipcode());
		builder.append(getCity());
		return builder.toHashCode();
	}
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Address){
			Address other= (Address) obj;
			EqualsBuilder builder= new EqualsBuilder();
			builder.append(getCity(), other.getCity());
			builder.append(getStreet(), other.getStreet());
			builder.append(getZipcode(), other.getZipcode());
			return builder.isEquals();
		}
		
		return false;
	}

	@Override
	public String toString()
	{
		return new ToStringCreator(this)
		.append("USERID ", this.street)
		.append("Firstname ", this.city)
		.append("Lastname", this.zipcode)
				.toString();
	}

}
