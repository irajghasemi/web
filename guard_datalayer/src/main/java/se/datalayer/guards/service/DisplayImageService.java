package se.datalayer.guards.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import se.datalayer.guards.repository.DisplayImageRepository;
import se.guard.UploadImage;

@Service
public class DisplayImageService
{

	@Autowired
	private static DisplayImageRepository displayImageRepository;

	@PersistenceContext(unitName = "DisplayImageService")
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guards");
	@PersistenceContext(unitName = "DisplayImageService")
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public void removeImage(int userid)
	{
		Query query = entityManager.createQuery("DELETE FROM IMAGE_TABLE where USER_ID=:id");
		entityManager.getTransaction().begin();
		query.setParameter("id", userid);
		query.getResultList();
		entityManager.getTransaction().commit();

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<UploadImage> showAllPictures()
	{
		TypedQuery<UploadImage> query = entityManager.createQuery("from UploadImage", UploadImage.class);
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UploadImage showImageByUserId(int userid)
	{
		TypedQuery<UploadImage> query = entityManager.createQuery("SELECT up From UploadImage up WHERE USER_ID=:id", UploadImage.class);

		entityManager.getTransaction().begin();
		query.setParameter("id", userid);
		entityManager.getTransaction().commit();

		return query.getSingleResult();

	}

	public byte[] getImage(String filename)
	{
		byte[] result = null;
		String fileLocation = filename;
		File f = new File(fileLocation);
		result = new byte[(int) f.length()];
		try
		{
			@SuppressWarnings("resource")
			FileInputStream in = new FileInputStream(fileLocation);
			in.read(result);
		}
		catch (Exception ex)
		{
			System.out.println("GET IMAGE PROBLEM :: " + ex);
			ex.printStackTrace();
		}
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UploadImage showImageByImageId(int imageid)
	{
//		String askedQuery = "From UploadImage WHERE IMAGE_ID=:id";
		String askedQuery = "SELECT up From UploadImage up WHERE IMAGE_ID=:id";
		TypedQuery<UploadImage> query = entityManager.createQuery(askedQuery, UploadImage.class);
		if (entityManager.getTransaction().isActive())
		{
			entityManager.clear();

		}
//		entityManager.getTransaction().begin();
		query.setParameter("id", imageid);
//		entityManager.getTransaction().commit();
		return query.getSingleResult();

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Collection<UploadImage> showAllImagesByImageId(int imageid)
	{
		String askedQuery = "SELECT up From UploadImage up WHERE IMAGE_ID=:id";
		TypedQuery<UploadImage> query = entityManager.createQuery(askedQuery, UploadImage.class);

		entityManager.getTransaction().begin();
		query.setParameter("id", imageid);
		entityManager.getTransaction().commit();
		return query.getResultList();
	}

	public byte[] readImage(String fileNameandPath) throws IOException
	{
		FileInputStream fi = new FileInputStream(fileNameandPath);
		System.out.println("Avail : " + fi.available());
		FileChannel fic = fi.getChannel();
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024); // direct buffer

		long size = fic.size(), n = 0;

		// time to play the old game - clear, read, flip and write
		while (n < size)
		{
			buffer.clear(); // makes the buffer ready by resetting the pointers
			if (fic.read(buffer) < 0) // fill the buffer by reading from channel
				break;
			buffer.flip(); // makes the buffer writing the data just read
			// buffer.
			// n+= fcout.write(buffer);
		}

		fic.close();
		fi.close();
		return null;
	}

}