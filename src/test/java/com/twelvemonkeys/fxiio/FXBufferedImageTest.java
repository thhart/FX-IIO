package com.twelvemonkeys.fxiio;

import java.io.*;
import java.time.Duration;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import org.junit.Test;

public class FXBufferedImageTest {
	@Test
	public void saveTiff() throws IOException {
		final BufferedImage read = ImageIO.read(FXBufferedImageTest.class.getResourceAsStream("/road-1072823.jpg"));
		final WritableImage writableImage = SwingFXUtils.toFXImage(read, null);
		final FXBufferedImage fxBufferedImage = new FXBufferedImage(writableImage);
		long timer;

		timer = System.nanoTime();
		ImageIO.write(read, "png", new ByteArrayOutputStream());

		System.out.println("standard png generation done in: " + Duration.ofNanos(System.nanoTime() - timer));
		timer = System.nanoTime();

		ImageIO.write(fxBufferedImage, "png", new ByteArrayOutputStream());
		System.out.println("fx png generation done in: " + Duration.ofNanos(System.nanoTime() - timer));

		timer = System.nanoTime();
		ImageIO.write(read, "tiff", new ByteArrayOutputStream());

		System.out.println("standard tiff generation done in: " + Duration.ofNanos(System.nanoTime() - timer));
		timer = System.nanoTime();

		ImageIO.write(fxBufferedImage, "tiff", new ByteArrayOutputStream());
		System.out.println("fx tiff generation done in: " + Duration.ofNanos(System.nanoTime() - timer));
	}

}