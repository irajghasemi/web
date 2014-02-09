package se.datalayer.guards.repository;

import java.awt.image.BufferedImage;
import java.io.InputStream;

import org.springframework.stereotype.Repository;

@Repository
public interface ResizeBufferedImageRepository
{

	BufferedImage saveToFileAsBufferedImage(BufferedImage buff, String destinationPath);
	BufferedImage saveResizedImageAsBufferedImage(InputStream uploadedInputStream, String destinationPath);
	
}
