package se.datalayer.guards.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

import se.datalayer.guards.repository.ResizeBufferedImageRepository;

public class ResizeBufferedImageService implements ResizeBufferedImageRepository
{


	public BufferedImage saveToFileAsBufferedImage(BufferedImage img, String destinationPath)
	{

		try
		{
			img = Scalr.resize(img, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH, 150, 100, Scalr.OP_ANTIALIAS);
			ImageIO.write(img, "png", new File(destinationPath + ".png"));
			return img = Scalr.pad(img, 200);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}

	}

	
	public BufferedImage saveResizedImageAsBufferedImage(InputStream uploadedInputStream, String fileName)
	{
		int dstWidth = 100;
		int dstHeight = 100;
		InputStream imageStream = uploadedInputStream;
		BufferedImage srcImage = null;
		try
		{
			srcImage = ImageIO.read(imageStream);
			if (srcImage == null)
			{
				System.err.println("NO SOURCE IMAGE!");
			}
			BufferedImage dstImage = new BufferedImage(dstWidth, dstHeight, BufferedImage.TYPE_INT_RGB);
			dstImage.getGraphics().drawImage(srcImage, 0, 0, dstWidth, dstHeight, null);

			ImageIO.write(dstImage, "png", new File(fileName + ".png"));
			return srcImage;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}


}
