import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javafx.scene.transform.Scale;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class SaveImageServlet
 */
public class SaveImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	static final int RESIZE_IMG_WIDTH = 100;
	static final int RESIZE_IMG_HEIGHT = 100;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String absolutePath = "C:/eclipse_juno/eclipse/workspace/SaveImage/WebContent/";
		String url = request.getParameter("imgSRC");
		String extensionImg = url.substring(url.indexOf('/')+1,url.indexOf(';')); // recogemos extension
		String dataURI = url.substring(url.indexOf(',')+1); // Eliminamos cabecera de imagen en base64	
		
		try {
			BufferedImage originalImgage = null;  
	        byte[] imageByte;  
	        try {  
	            BASE64Decoder decoder = new BASE64Decoder();  
	            imageByte = decoder.decodeBuffer(dataURI);  
	            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte); 
	            originalImgage = ImageIO.read(bis);
	            bis.close();  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } 
			int x = Integer.parseInt(request.getParameter("x"));
			int y = Integer.parseInt(request.getParameter("y"));
			int w = Integer.parseInt(request.getParameter("w"));
			int h = Integer.parseInt(request.getParameter("h"));
			System.out.println("Dimension imagen original: "+originalImgage.getWidth()+"x"+originalImgage.getHeight());
			BufferedImage SubImgage = originalImgage.getSubimage(x, y, w, h);
//			SAVE IMAGE - Guarda Imagen recortada			
//			System.out.println("Cropped image dimension: "+SubImgage.getWidth()+"x"+SubImgage.getHeight());
//			File outputfile = new File(absolutePath + "imageCropped/imagenRecortada."+extensionImg);
//			ImageIO.write(SubImgage, extensionImg, outputfile);
//			System.out.println("Image cropped successfully: "+outputfile.getPath());
//			response.sendRedirect("result.jsp");
			
			/* RESIZE - Guarda imagen redimensionada*/
	        int type = SubImgage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : SubImgage.getType();
			BufferedImage resizeImageJpg = resizeImage(SubImgage, type, RESIZE_IMG_WIDTH, RESIZE_IMG_HEIGHT);
			System.out.println("Dimension imagen recortada: "+SubImgage.getWidth()+"x"+SubImgage.getHeight());
			File outputfile = new File(absolutePath + "imageCropped/imagenRecortada."+extensionImg);
			ImageIO.write(resizeImageJpg, extensionImg, outputfile);
			System.out.println("Imagen recortada correctamente: "+outputfile.getPath());
			response.sendRedirect("result.jsp");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error ");
		}
	}
	
	private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) {
	    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
	    Graphics2D g = resizedImage.createGraphics();
	    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
	    g.dispose();

	    return resizedImage;
	}
	
	}