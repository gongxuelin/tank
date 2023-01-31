package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void test() {
//		fail("Not yet implemented");
//		assertNotNull(null);
		try {
//			BufferedImage image=ImageIO.read(new File("D:/elipseProject/tank/src/bulletD.gif"));
			//相对路劲加载对象
			BufferedImage image=ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			BufferedImage image2=ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/bulletD.gif"));
			assertNotNull(image);
			assertNotNull(image2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
