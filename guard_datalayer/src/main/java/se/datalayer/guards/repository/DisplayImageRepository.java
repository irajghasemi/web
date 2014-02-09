package se.datalayer.guards.repository;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import se.guard.UploadImage;

@Repository
public interface DisplayImageRepository
{
	UploadImage showImageByUserId(int userid);
	Collection<UploadImage> showIfUserHaveServeralImages(int userid);

	UploadImage showImageByImageId(int imageid);
	Collection<UploadImage>showIfSameUsersHaveMoreImages(int imageid);

	Collection<UploadImage> showAllImagesByImageId(int imageid);

	Collection<UploadImage> showAllPictures();

	byte[] getImage(String filename);

	byte[] readImage(String fileNameandPath);
	
	


}
