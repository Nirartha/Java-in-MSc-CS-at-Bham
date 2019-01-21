
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

/**
 *  The class creates an image in form of a greyscale image which is
 *  read in from a file. It contains a method to crop the left upper
 *  half of the picture and write it out again.
 *
 *  @version 2018-08-24
 *  @author Manfred Kerber
 */

public class PPMImage{
    private int width;
    private int height;
    private int maxShade;
    private String typeOfFile;
    private short[][][] pixels;

    /**
     *  @param filename The name of a file that contains an image in pgm format of type P2.
     *
     */
    public PPMImage(String filename) {
        // try since the file may not exist.
        try {
            // we read from the scanner s which is linked to the file filename.
            Scanner s = new Scanner(new File(filename));

            /* The field variables are assigned by reading in from a
               file. The file should start with something like
               P2
               150 176
               255

               where P2 is the file type, 150 the width of the image, 176
               the height, and 255 the maximal grey value. Then follow
               150*176 grey values between 0 and 255.
            */
    
            // We read the initial element that is in our case "P2"
            setTypeOfFile(s.next());
            // Next we read the width, the height, and the maxShade.
            setWidth(s.nextInt());
            setHeight(s.nextInt());
            setMaxShade(s.nextInt());
            //We initialize and read in the different pixels.
            //pixels[height][width][colour]; *colour = 3(RGB)
            int colour = 3;
            pixels = new short[height][width][colour];
            for (int i = 0; i < height; i++){
                for (int j = 0; j < width; j++) {
                	for (int k = 0; k < colour; k++) {
                		pixels[i][j][k] = s.nextShort();
                	}
                }
            }
        }
        catch (IOException e){
            //If the file is not found, an error message is printed, and an empty image is created.
            System.out.println("File not found.");

            typeOfFile = "P2";
            width = 0;
            height = 0;
            maxShade = 0;
            pixels = new short[width][height][3];
        }
    }
    
    /**
     *  Setter for the width. The width of the image is updated.
     *  @param width The new width of the updated image.
     */
    public void setWidth(Integer width){
        this.width = width;
    }
    
    /**
     *  Setter for the height. The height of the image is updated.
     *  @param height The new height of the updated image.
     */
    public void setHeight(Integer height){
        this.height = height;
    }
    
    /**
     *  Setter for the maxShade. The maxShade of the image is updated.
     *  @param maxShade The new maxShade of the updated image.
     */
    public void setMaxShade(Integer maxShade){
        this.maxShade = maxShade;
    }
    
    /**
     *  Setter for the typeOfFile. The typeOfFile of the image is updated.
     *  @param typeOfFile The new typeOfFile of the updated image.
     *  In this case, should set typeOfFile = "P2"
     */
    public void setTypeOfFile(String typeOfFile){
        this.typeOfFile = "P2";
    }

    /**
     *  @return The width of the image.
     */
    public int getWidth(){
        return width;
    }

    /**
     *  @return The height of the image.
     */
    public int getHeight(){
        return height;
    }
    
    /**
     *  @return The maximal grey value of the image.
     */
    public int getMaxShade(){
        
	    short tempGreyPixels = 0;
	    short getNewMaxShade = 0, tempMaxShade = 0;
	    int colour = 3; //*colour = 3(RGB)
        
	    for (int i = 0; i < getHeight(); i++){
			for (int j = 0; j < getWidth(); j++){
				tempGreyPixels = 0;
				for (int k =0; k < colour; k++) {
					tempGreyPixels += getPixels()[i][j][k];
				}
				
				tempMaxShade = (short)Math.round(tempGreyPixels*1.0/3);
				
				if(tempMaxShade > getNewMaxShade) {
					getNewMaxShade = tempMaxShade;
				}
			}
	    }
	    
	    return maxShade != getNewMaxShade ? getNewMaxShade : maxShade;
    }

    /**
     *  @return The file type of the image.
     */
    public String getTypeOfFile(){
        return typeOfFile;
    }

    /**
     *  @return The matrix representing the pixels of the image.
     */
    public short[][][] getPixels(){
        return pixels;
    }
    
    
    /**
     * makeGrey to convert the file pgm type of file = P2
     * @return short[][] greyPixels
     */
    public short[][] makeGrey(String filename){
    	
    	short[][] greyPixels = new short[getHeight()][getWidth()];
    	try {
    	    BufferedWriter out = new BufferedWriter(new FileWriter(filename));
    	    // We write the file type to out.
    	    out.write(getTypeOfFile() + "\n");

    	    // We write the dimensions to out.
    	    out.write((getWidth()) + " " + (getHeight()) +"\n");
    	    
    	    // We write maximal number.
    	    out.write(getMaxShade() + "\n");
    	    
    	    byte counter = 0;
    	    short tempGreyPixels = 0;
    	    //pixels[height][width][colour]; *colour = 3(RGB)
            int colour = 3;
            
    	    for (int i = 0; i < getHeight(); i++){
    			for (int j = 0; j < getWidth(); j++){
    				tempGreyPixels = 0;
    				for (int k =0; k < colour; k++) {
    					tempGreyPixels += getPixels()[i][j][k];
        			    counter++;
    				}
    				
    				greyPixels[i][j] = (short)Math.round(tempGreyPixels*1.0/3);
    				out.write(greyPixels[i][j] + " ");
    			}
    			if (counter == 15){		 
	                out.write("\n");
	                counter = 0;
	            }
    	    }
    	    
    	    out.write("\n");
    	    // We close the file.
    	    out.close();
    	}
    	catch (IOException e){
                //Errors are caught.
                System.out.println("File not found.");
        }
    	
    	return greyPixels;
    }
}
