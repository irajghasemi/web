package se.datalayer.guards.repository;

import java.io.InputStream;

import org.springframework.stereotype.Repository;

import se.guard.UploadImage;
import se.guard.User;

@Repository
public interface ImageUploadRepsoitory
{

	UploadImage relativPathDB(UploadImage uploadimage);

	void saveToFile(InputStream uploadedInputStream, String destinationPath);

	boolean doUserExist(User user);


}
