package se.datalayer.guards.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.datalayer.guards.repository.ImageUploadRepsoitory;
import se.guard.UploadImage;
import se.guard.User;

public class ImageUploadService implements ImageUploadRepsoitory
{
	@Autowired(required = true)
	private ImageUploadRepsoitory imageUploadRepsoitory;
	
	@PersistenceContext(unitName = "ImageUploadService")
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guards");
	@PersistenceContext(unitName = "ImageUploadService")
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UploadImage relativPathDB(UploadImage uploadimage)
	{
		if (entityManager.isOpen() != true)
		{
			if(!doUserExist(uploadimage.getUser())){
			entityManager.merge(uploadimage);
			entityManager.getTransaction().commit();
			}
			return uploadimage;
		}
		else
		{
			entityManager.getTransaction().begin();
			entityManager.merge(uploadimage);
			entityManager.getTransaction().commit();
			return uploadimage;

		}

	}

	public void saveToFile(InputStream inputStream, String destinationPath)
	{
		try
		{
			OutputStream out = null;
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(destinationPath));
			while ((read = inputStream.read(bytes)) != -1)
			{
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public boolean doUserExist(User user)
	{
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Collection<User> userList = entityManager.createQuery("select u from User u", User.class).getResultList();

		for (User foundedUser : userList)
		{
			if (foundedUser.getUserid() == user.getUserid())
			{
				return true;
			}
		}

		return false;

	}

	


}
