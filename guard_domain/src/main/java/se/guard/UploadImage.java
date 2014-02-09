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

import org.springframework.core.style.ToStringCreator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Entity
@Table(name="UPLOADIMAGE")
public class UploadImage
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IMAGE_ID")
	private int imageid;
	
	@Column(name="FILE_NAME")
	private String fileName;
	
	@Column(name="FILE_PATH")
	private String filePath;
	
	
	@Column(name="CONTENTTYPE")
	private String contetnttype;
	
//	@JoinTable(name="IMAGE_TABLE",joinColumns={@JoinColumn(name="IMAGE_ID")},inverseJoinColumns=@JoinColumn(table="USER",name="USER_ID"))
//	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE})

	@JoinColumn(name="USER_ID")
	@OneToOne(cascade= CascadeType.DETACH)
	private User user;
	
	@Column(name="FILE_DATA")
	private CommonsMultipartFile FileData;
	
	public UploadImage()
	{
		
	}
	public UploadImage(int imageid, String fileName, String filePath, User user)
	{
		this.imageid = imageid;
		this.fileName = fileName;
		this.filePath = filePath;
		this.user = user;
	}

	
	public UploadImage(String fileName, String filePath, User user)
	{
		this.fileName = fileName;
		this.filePath = filePath;
		this.user = user;
	}
	
	
	
	public UploadImage(String fileName, String filePath, String contetnttype, User user)
	{
		this.fileName = fileName;
		this.filePath = filePath;
		this.contetnttype = contetnttype;
		this.user = user;
	}
	public UploadImage(String fileName, String filePath, User user, CommonsMultipartFile fileData)
	{
		this.fileName = fileName;
		this.filePath = filePath;
		this.user = user;
		FileData = fileData;
	}
	public int getImageid()
	{
		return imageid;
	}

	public void setImageid(int imageid)
	{
		this.imageid = imageid;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFilePath()
	{
		return filePath;
	}

	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}
	public String getContetnttype()
	{
		return contetnttype;
	}
	public void setContetnttype(String contetnttype)
	{
		this.contetnttype = contetnttype;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
	public CommonsMultipartFile getFileData()
	{
		return FileData;
	}
	public void setFileData(CommonsMultipartFile fileData)
	{
		FileData = fileData;
	}
	
	
	@Override
	public String toString()
	{
		return new ToStringCreator(this)
		.append("IMAGEID ", this.imageid)
		.append("FFILENAME ", this.fileName)
		.append("FILEPATH", this.filePath)
		.append("CONTENTTYPE", this.contetnttype)
		.append("USER", this.user)
				.toString();
	}


}
