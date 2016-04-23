import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import automobile.Automobile;

/**
 * A class dedicated to handling the car pictures, and
 * accessing and storing them for output into the GUI.
 * @author Matthew
 */
public class Images extends Component{

	/**
	 * Creates an object of an image file already stored outside of the
	 * src folder.
	 */
	private BufferedImage tempImage, imgOne, imgTwo, imgThree, imgFour, imgFive;

	/**
	 * Takes in the pixel ratios from the actual picture files for use in scaling.
	 */
	private double imageWidthOne, imageHeightOne, imageWidthTwo, imageHeightTwo,
	imageWidthThree, imageHeightThree, imageWidthFour, imageHeightFour, imageWidthFive, imageHeightFive;

	/**
	 * Collection of cars to paint
	 */
	private Collection drawCollect=new Collection();

	/**
	 * Default constructor for Images.
	 */
	public Images(){

		setImages();
	}

	/**
	 * This constructor takes in the value of the array home for
	 * picture and information display.
	 */
	public Images(Collection collection){
		drawCollect=null;
		this.drawCollect=collection;
		setImages();
	}

	/**
	 * Controls the storage of the pictures and when they will be accessed.
	 */
	private void setImages(){

		//grabs whatever car is in the node
		Automobile someCar=null;

		//Used temporarily to simplify switch statement during picture selection.
		String carType=null;

		drawCollect.reset();
		//Runs through bestFive to connect the proper car type to the correct picture.
		for(int i=0; i<5; i++){
			someCar=(Automobile)(drawCollect.next());
			carType=someCar.getType();

			try { 
				switch (carType){
				//case=car type
				//SUVs
				case "Hyundai SantaFe Sport":
					tempImage=ImageIO.read(new File("../src/images/Hyundai SantaFe Sport.JPG"));
					break;
				case "Honda CR-V": 
					tempImage=ImageIO.read(new File("../src/images/Honda CR-V.JPG"));
					break;
				case "Chevy Equinox": 
					tempImage=ImageIO.read(new File("../src/images/Chevy Equinox.JPG"));
					break;
				case "Dodge Journey": 
					tempImage=ImageIO.read(new File("../src/images/Dodge Journey.JPG"));
					break;
				case "BMW x1 xDrive28i": 
					tempImage=ImageIO.read(new File("../src/images/BMW x1 xDrive28i.JPG"));
					break;

					//Coupes
				case "Honda Civic":
					tempImage=ImageIO.read(new File("../src/images/Honda Civic.JPG"));
					break;
				case "BMW 228i": 
					tempImage=ImageIO.read(new File("../src/images/BMW 228i.JPG"));
					break;
				case "Subaru BRZ": 
					tempImage=ImageIO.read(new File("../src/images/Subaru BRZ.JPG"));
					break;
				case "VolksWagen Golf GTI":
					tempImage=ImageIO.read(new File("../src/images/VolksWagen Golf GTI.JPG"));
					break;
				case "Ford Mustang GT": 
					tempImage=ImageIO.read(new File("../src/images/Ford Mustang GT.JPG"));
					break;

					//Sedans
				case "Honda Accord": 
					tempImage=ImageIO.read(new File("../src/images/Honda Accord.JPG"));
					break;
				case "Dodge Charger":
					tempImage=ImageIO.read(new File("../src/images/Dodge Charger.JPG"));
					break;
				case "Ford Fusion":
					tempImage=ImageIO.read(new File("../src/images/Ford Fusion.JPG"));
					break;
				case "Mazda 6": 
					tempImage=ImageIO.read(new File("../src/images/Mazda 6.JPG"));
					break;
				case "Hyundai Sonata":
					tempImage=ImageIO.read(new File("../src/images/Hyundai Sonata.JPG"));
					break;

					//Trucks
				case "Toyota Tacoma":
					tempImage=ImageIO.read(new File("../src/images/Toyota Tacoma.JPG"));
					break;
				case "Nissan Titan": 
					tempImage=ImageIO.read(new File("../src/images/Nissan Titan.JPG"));
					break;
				case "Ram 1500":
					tempImage=ImageIO.read(new File("../src/images/Ram 1500.JPG"));
					break;
				case "GMC Sierra 1500":
					tempImage=ImageIO.read(new File("../src/images/GMC Sierra 1500.JPG"));
					break;
				case "Chevrolet Silverado 1500":
					tempImage=ImageIO.read(new File("../src/images/Chevrolet Silverado 1500.JPG"));
					break;
				case "Ford F-150":
					tempImage=ImageIO.read(new File("../src/images/Ford F-150.JPG"));
					break;

					//Vans
				case "Honda Odyssey":
					tempImage=ImageIO.read(new File("../src/images/Honda Odyssey.JPG"));
					break;
				case "Chrysler Town and Country":
					tempImage=ImageIO.read(new File("../src/images/Chrysler Town and Country.JPG"));
					break;
				case "Toyota Sienna": 
					tempImage=ImageIO.read(new File("../src/images/Toyota Sienna.JPG"));
					break;
				case "Nissan Quest":
					tempImage=ImageIO.read(new File("../src/images/Nissan Quest.JPG"));
					break;
				case "Kia Sedona":
					tempImage=ImageIO.read(new File("../src/images/Kia Sedona.JPG"));
					break; 
				}
			}
			catch (IOException e) {
			}

			//Takes temporary values from above and stores it in correct place
			switch (i){
			case 0: imgOne=tempImage;
			break;
			case 1: imgTwo=tempImage;
			break; 
			case 2: imgThree=tempImage;
			break;
			case 3: imgFour=tempImage;
			break;
			case 4: imgFive=tempImage;
			break;
			}
		}

		Frame window=new Frame();

		//Looks at the original image size to assist in resizing.
		imageWidthOne=imgOne.getWidth(null);
		imageHeightOne=imgOne.getHeight(null);
		imageWidthTwo=imgTwo.getWidth(null);
		imageHeightTwo=imgTwo.getHeight(null);
		imageWidthThree=imgThree.getWidth(null);
		imageHeightThree=imgThree.getHeight(null);
		imageWidthFour=imgFour.getWidth(null);
		imageHeightFour=imgFour.getHeight(null);
		imageWidthFive=imgFive.getWidth(null);
		imageHeightFive=imgFive.getHeight(null);

		window.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		window.add(this);
		window.pack();
	}

	/**
	 * Paints in another window for now. This will later come up in the
	 * same GUI panel that the user will see first when the program starts.
	 */
	public void paint(Graphics pane){

		//Values for placing the pictures, evenly spaced and the same size.
		final int STARTX=450;
		final int ENDX=665;
		final int STARTY=55;
		final int SIZEY=140;
		final int YSPACE=12;
		//This shows all the car pictures in order depending on user input.
		//Note to self: name, startx, starty, endx, endy, cropping
		pane.drawImage(imgOne, STARTX, STARTY, ENDX, STARTY+SIZEY, 0, 0, 
				(int)imageWidthOne, (int)imageHeightOne, null);
		pane.drawImage(imgTwo, STARTX, STARTY+(SIZEY+YSPACE), ENDX, STARTY+(SIZEY*2)+(YSPACE*1), 0, 0, 
				(int)imageWidthTwo, (int)imageHeightTwo, null);
		pane.drawImage(imgThree, STARTX, STARTY+(SIZEY+YSPACE)*2, ENDX, STARTY+(SIZEY*3)+(YSPACE*2), 0, 0, 
				(int)imageWidthThree, (int)imageHeightThree, null);
		pane.drawImage(imgFour, STARTX, STARTY+(SIZEY+YSPACE)*3, ENDX, STARTY+(SIZEY*4)+(YSPACE*3), 0, 0, 
				(int)imageWidthFour, (int)imageHeightFour, null);
		pane.drawImage(imgFive, STARTX, STARTY+(SIZEY+YSPACE)*4, ENDX, STARTY+(SIZEY*5)+(YSPACE*4), 0, 0, 
				(int)imageWidthFive, (int)imageHeightFive, null);
	}

}
