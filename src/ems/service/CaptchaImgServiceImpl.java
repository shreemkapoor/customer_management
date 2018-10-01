package ems.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
@Service
public class CaptchaImgServiceImpl implements CaptchaImgService {
	
	private String captchastring="";
	private static final String CHAR_LIST = 
		        "ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnpqrsuvwxyz123456789"; // character set for captcha. doesnt contains I and l as they looks similar in image. 
	 
	    private int getRandomNumber() { // generates a single random number from 0 to length of char list above.
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }
	@Override
	public byte[] createBytes() {
		int width=160;  // setting size for the captcha image.
		int height=50;
		StringBuffer randStr = new StringBuffer();
       for(int i=0; i<6; i++) // generating 6 digits of captcha.
        {
        int number = getRandomNumber();
        char ch = CHAR_LIST.charAt(number);
        randStr.append(ch);
        }
       String str=randStr.toString();
       captchastring = str;    // captcha string generated.
      // System.out.println(captchastring);
     //  Color background = new Color(224,224,224);
       Color background = new Color(255,255,255); // setting captcha background color. currently white.

		Color fbl = new Color(0,51,102);  // captcha font color.



		BufferedImage cpimg =new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  // creating image bytes.
		Graphics2D g2d = cpimg.createGraphics();  
		//Graphics g = cpimg.createGraphics(); 

		g2d.setColor(background); 

		g2d.fillRect(0,0,width,height); 

		g2d.setColor(fbl); 
		Font font = new Font("SansSerif", Font.BOLD, 30);
		g2d.setFont(font);
		
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

		g2d.drawString(str,25,40); 

		g2d.setColor(background);
		byte[] imageInByte=null;
       
		try{
					
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( cpimg, "jpg", baos );
			baos.flush();
			 imageInByte = baos.toByteArray();
			baos.close();
					
			}catch(IOException e){
				System.out.println(e.getMessage());
			}	
		
		return imageInByte;
	}

	public String getCaptchastring() {
		return captchastring;
	}

	public void setCaptchastring(String captchastring) {
		this.captchastring = captchastring;
	}

}
