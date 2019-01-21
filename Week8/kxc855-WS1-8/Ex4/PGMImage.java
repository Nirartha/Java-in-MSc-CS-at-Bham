import java.io.*;
import java.util.Scanner;

/**
 * Line 132 out.write(getPixels()[i][j] + " "); is the main reason lead to the photo would not be rotated successfully.
   {1, 2, 3}	  {4, 1} 
   {4, 5, 6}   -> {5, 2} 
   	       	      {6, 3}
   a[x][y]=b[ymax-x][x]
   a[0][0]=b[2][0] 
   a[0][1]=b[1][0] 
   a[0][2]=b[0][0]
   -> but the array start at 0, answer should add - 1   => a[x][y]=b[ymax-1-x][x]
 * switching the i and j first. then switch for loop to run width firstly and height secondly.
 */

/**
 *  The class creates an image in form of a greyscale image which is
 *  read in from a file. It contains a method that is supposed to
 *  rotate the image and write it out again. However, it does not work
 *  properly, the images written out do not show anything meaningful.
 *
 *  @version 2018-11-19
 *  @author Manfred Kerber
 */
public class PGMImage{
    private int width;
    private int height;
    private int maxShade;
    private String typeOfFile;
    private short[][] pixels;

    /**
     *  @param filename The name of a file that contains an image in
     *  pgm format of type P2.
     *
     */
    public PGMImage(String filename) {
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
            typeOfFile = s.next();
            // Next we read the width, the height, and the maxShade.
            width = s.nextInt();
            height = s.nextInt();
            maxShade = s.nextInt();
            //We initialize and read in the different pixels.
            pixels = new short[height][width];
            for (int i=0; i<height; i++){
                for (int j=0; j<width; j++) {
                    pixels[i][j] = s.nextShort();
                }
            }
        }
        catch (IOException e){
            //If the file is not found, an error message is printed,
            //and an empty image is created.
            System.out.println("File not found.");

            typeOfFile = "P2";
            width = 0;
            height = 0;
            maxShade = 0;
            pixels = new short[width][height];
        }
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
        return maxShade;
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
    public short[][] getPixels(){
        return pixels;
    }


    /**
     *  The method is to rotate a PGMImage by 90 degrees clockwise.
     *  There is a problem with the method and the rotated images are
     *  not correct.
     *  @param filename The filename of the file in which the rotated
     *  image should be saved.
     */
    public void rotate (String filename){
	try {
	    BufferedWriter out = 
		new BufferedWriter(new FileWriter(filename));
	    // We write the file type to out.
	    out.write(getTypeOfFile() + "\n");

	    // We write the dimensions to out.
	    out.write(getHeight() + " " + getWidth() +"\n");
	    
	    // We write maximal number.
	    out.write(getMaxShade() + "\n");
	    
	    byte counter = 0;
            for (int i=0; i<getWidth(); i++) {
                for (int j=0; j<getHeight(); j++){
                    out.write(getPixels()[getHeight()-1-j][i] + " ");
                    counter++;
                    if (counter == 15){		 
                        out.write("\n"); // in order not to have too long lines
                        counter = 0;
                    }
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
    }

    /*
     * An example.
     */
    public static void main(String[] args) {
        PGMImage cs = new PGMImage("ComputerScience.pgm");
        cs.rotate("ComputerScienceRotate.pgm");
    }
}
