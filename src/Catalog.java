import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import automobile.*;

/**@author Matthew Winter
 *
 *Controls the interaction of the user and GUI
 */
public class Catalog implements MouseListener{

	/**
	 * Applet object controls the GUI aspect
	 */
	protected Applet theApplet;
	/**
	 * x and y location for button placement
	 */
	protected int x, y;

	/**
	 * Collection of relevant automobiles.
	 */
	protected Collection collection;
	/**
	 * Sorting buttons in GUI
	 */
	private Abutton MPG, price, power, seats;
	/**
	 * boolean values for sorting method
	 */
	boolean MPGOn, priceOn, powerOn, seatsOn;

	/**
	 * Car type option buttons in GUI
	 */
	private Abutton coupe, sedan, SUV, truck, van;
	/**
	 * boolean values for car type
	 */
	boolean coupeOn, sedanOn, SUVOn, truckOn, vanOn;

	/**
	 * Mouse click location.
	 */
	protected int lastX, lastY;

	/**
	 * Object for storing all relevant images of top cars
	 */
	private Images displayCars;

	/**
	 * Default constructor does nothing
	 */
	public Catalog(){}

	/**
	 * Forms the applet for GUI creation
	 */
	public Catalog(Applet someApplet){

		//play music
		setMusic();

		//Applet now exists
		theApplet = someApplet;
		//Size of open upon startup
		theApplet.setSize(750,850);

		//Realizes mouse clicks.
		theApplet.addMouseListener(this);	//	This class will handle the mouse

		//button initial locations
		x = 20;
		y = 30;

		//draw MPG button
		MPG = new Abutton("Best MPG", Color.green, x, y);
		//adjust y position for next button
		y += 1.1*Abutton.BUTTON_HEIGHT;
		//draw price button
		price = new Abutton("Best Price", Color.orange, x, y);
		//adjust y position for next button
		y += 1.1*Abutton.BUTTON_HEIGHT;
		//draw power button
		power = new Abutton("Best power", Color.cyan, x, y);
		//adjust y position for next button
		y += 1.1*Abutton.BUTTON_HEIGHT;
		//draw seats button
		seats = new Abutton("Best seat", Color.pink, x, y);

		//separate sorting option and car type options
		y=y+60;

		//draw Coupe button
		coupe = new Abutton("Coupe", Color.yellow, x, y);
		//adjust y position for next button
		y += 1.1*Abutton.BUTTON_HEIGHT;
		//draw Sedan button
		sedan = new Abutton("Sedan", Color.yellow, x, y);
		//adjust y position for next button
		y += 1.1*Abutton.BUTTON_HEIGHT;
		//draw SUV button
		SUV = new Abutton("SUV", Color.yellow, x, y);
		//adjust y position for next button
		y += 1.1*Abutton.BUTTON_HEIGHT;
		//draw Truck button
		truck = new Abutton("Truck", Color.yellow, x, y);
		//adjust y position for next button
		y += 1.1*Abutton.BUTTON_HEIGHT;
		//draw Van button
		van = new Abutton("Van", Color.yellow, x, y);

	}

	/**
	 * Controls what clicks of a button will do.
	 */
	protected void check()
	{
		//****Car type option buttons below****
		//depresses and elevate buttons, and setting booleans to corresponding button action
		if (coupe.isInside(lastX, lastY)){
			//sets boolean value
			if (coupeOn==false)
				coupeOn=true;
			else
				coupeOn=false;
			//flips button
			coupe.flip();
		}
		else if (sedan.isInside(lastX, lastY)){
			//sets boolean value
			if (sedanOn==false)
				sedanOn=true;
			else
				sedanOn=false;
			//flips button
			sedan.flip();
		}
		else if (SUV.isInside(lastX, lastY)){
			//sets boolean value
			if (SUVOn==false)
				SUVOn=true;
			else
				SUVOn=false;
			//flips button
			SUV.flip();
		}
		else if (truck.isInside(lastX, lastY)){
			//sets boolean value
			if (truckOn==false)
				truckOn=true;
			else
				truckOn=false;
			//flips button
			truck.flip();
		}
		else if (van.isInside(lastX, lastY)){
			//sets boolean value
			if (vanOn==false)
				vanOn=true;
			else
				vanOn=false;
			//flips button
			van.flip();
		}

		//go to library and grab all relevant cars, flip buttons, and sort
		//only if a button is pressed.
		if (MPG.isInside(lastX, lastY) || power.isInside(lastX, lastY) || 
				seats.isInside(lastX, lastY) || price.isInside(lastX, lastY) ||
				coupe.isInside(lastX, lastY) || sedan.isInside(lastX, lastY) ||
				SUV.isInside(lastX, lastY) || truck.isInside(lastX, lastY) ||
				van.isInside(lastX, lastY)){
			//go to library
			library();

			//reset status bar
			theApplet.showStatus(" ");

			//****Sorting buttons below****
			//Makes MPG depressed, and pops up buttons depressed prior.
			if (MPG.isInside(lastX, lastY)) {
				if (priceOn==true)
					price.flip();
				else if (powerOn==true)
					power.flip();
				else if (seatsOn==true)
					seats.flip();
				//set what button is truly on
				powerOn=priceOn=seatsOn=false;
				if (MPGOn==false)
					MPGOn=true;
				else
					MPGOn=false;
				//remains depressed
				MPG.flip();
			}
			//Makes power depressed, and pops up buttons depressed prior.
			else if (power.isInside(lastX, lastY)) {
				if (priceOn==true)
					price.flip();
				else if (MPGOn==true)
					MPG.flip();
				else if (seatsOn==true)
					seats.flip();
				//set what button is truly on
				MPGOn=priceOn=seatsOn=false;
				if (powerOn==false)
					powerOn=true;
				else
					powerOn=false;
				//remains depressed
				power.flip();
			}
			//Makes price depressed, and pops up buttons depressed prior.
			else if (price.isInside(lastX, lastY)) {
				if (MPGOn==true)
					MPG.flip();
				else if (powerOn==true)
					power.flip();
				else if (seatsOn==true)
					seats.flip();
				//set what button is truly on
				MPGOn=powerOn=seatsOn=false;
				if (priceOn==false)
					priceOn=true;
				else
					priceOn=false;
				//remains depressed
				price.flip();
			}
			//Makes seats depressed, and pops up buttons depressed prior.
			else if (seats.isInside(lastX, lastY)) {
				if (priceOn==true)
					price.flip();
				else if (powerOn==true)
					power.flip();
				else if (MPGOn==true)
					MPG.flip();
				//set what button is truly on
				MPGOn=powerOn=priceOn=false;
				if (seatsOn==false)
					seatsOn=true;
				else
					seatsOn=false;
				//remains depressed
				seats.flip();
			}

			//Goes to respective sorting methods
			if (MPGOn==true || powerOn==true || seatsOn==true)
				ascendingSort();
			else if (priceOn==true)
				priceSort();
			//if you miss a button it will guide you
			else  {
				theApplet.showStatus("Please press a button");
			}

			//locate top five car images for painting into GUI
			if (MPGOn==true || powerOn==true || seatsOn==true||priceOn==true)
				displayCars=new Images(collection);
		}
	}

	/**
//	The only "graphical" method of the class is the paint method.
	 */
	public void paint(Graphics pane)
	{
		//the placement of the text in GUI
		int yPlace=0;
		//temporarily store the output car being printed
		Automobile outputCar=null;
		//all the values for the current output car.
		int MPGVal, powerVal, priceVal, seatsVal;
		//the type of car of the output car.
		String carType;
		//the perk of the output car
		String perk;
		//the spacing of lines between text for it to be literate.
		final int WORDSPACING=13;
		//x starting location for printing reamins the same.
		final int XPRINT=125;

		//all of the buttons.
		MPG.paint(pane);
		power.paint(pane);
		seats.paint(pane);
		price.paint(pane);

		coupe.paint(pane);
		sedan.paint(pane);
		SUV.paint(pane);
		truck.paint(pane);
		van.paint(pane);

		//Only start printing things if a sorting criteria has been chosen.
		if (priceOn==true || MPGOn==true || powerOn==true || seatsOn==true){
			//Tell user that all are new 2014 cars
			pane.drawString("*All automobiles below are based on 2014 models only", XPRINT, 25);

			//confirm we are at head prior to printing
			collection.reset();
			//cycle through to show best five cars
			for (int i=0; i<5; i++){
				//move y place
				yPlace=yPlace+100;
				//next car in the collection
				outputCar=(Automobile)(collection.next());
				//Get all values
				carType=outputCar.getType();
				MPGVal=outputCar.getMPG();
				powerVal=outputCar.getPower();
				priceVal=outputCar.getPrice();
				seatsVal=outputCar.getSeat();
				perk=outputCar.getPerk();

				//Print the following statements for user to read
				pane.drawString("The " + carType + " gets " + MPGVal + " miles per gallon,", XPRINT, yPlace);
				yPlace=yPlace+WORDSPACING;
				pane.drawString("and can output " + powerVal + " horsepower.", XPRINT, yPlace);
				yPlace=yPlace+WORDSPACING;
				pane.drawString("It can seat a total of " + seatsVal + " people and", XPRINT, yPlace);
				yPlace=yPlace+WORDSPACING;
				pane.drawString(perk + ".", XPRINT, yPlace);
				yPlace=yPlace+WORDSPACING;
				pane.drawString("This vehicle is all yours for $" + priceVal + ".", XPRINT, yPlace);
			}

			//If there are cars, go to Images paint method and paint them.
			try{
				displayCars.paint(pane);
			}
			catch(NullPointerException e){
			}	
		}
	}

	/**
	 * Checks when a mouse has been clicked and released
	 */
	public void mouseClicked(MouseEvent event)
	{
		//Handle mouse click
		check();
	}
	/**
	 * Checks when a mouse has been pressed
	 */
	public void mousePressed(MouseEvent event)
	{
		//Update mouse click location
		lastX = event.getX();
		lastY = event.getY();

		//Flips button if user hit it
		flipWhenInside();
	}
	/**
	 * Checks when a mouse has been released
	 */
	public void mouseReleased(MouseEvent event)
	{
		//Once mouse click is released, reflip button.
		flipWhenInside();
	}
	/**
	 * Checks when mouse has entered an area (not used)
	 */
	public void mouseEntered(MouseEvent event) {}
	/**
	 * Checks when mouse has exited an area (not used)
	 */
	public void mouseExited(MouseEvent event) {}

	/**
	 * Flips buttons when they are clicked.
	 */
	protected void flipWhenInside()
	{
		//responds to mouse button click with button depression
		if (MPG.isInside(lastX, lastY))
			MPG.flip();
		else if (price.isInside(lastX, lastY))
			price.flip();
		else if (power.isInside(lastX, lastY))
			power.flip();
		else if (seats.isInside(lastX, lastY))
			seats.flip();
		else if (coupe.isInside(lastX, lastY))
			coupe.flip();
		else if (sedan.isInside(lastX, lastY))
			sedan.flip();
		else if (SUV.isInside(lastX, lastY))
			SUV.flip();
		else if (truck.isInside(lastX, lastY))
			truck.flip();
		else if (van.isInside(lastX, lastY))
			van.flip();

		//update applet view
		theApplet.repaint();
	}

	/**
	 * Library of all cars
	 * Add cars to collection depending on what options user selected
	 */
	private void library(){

		//make new collection for storing new values
		collection=new Collection();

		//Add SUVs if user selected SUV option
		//Adds SUVs if no options are selected
		if (SUVOn==true || 
				(coupeOn==false && sedanOn==false && SUVOn==false && truckOn==false && vanOn==false)){
			collection.add(new SUV("Hyundai SantaFe Sport", 22, 190, 5, 26700));
			collection.add(new SUV("Honda CR-V", 25, 185, 5, 24195));
			collection.add(new SUV("Chevy Equinox", 23, 182, 5, 26190));
			collection.add(new SUV("Dodge Journey", 19, 283, 5, 24895));
			collection.add(new SUV("BMW x1 xDrive28i", 26, 240, 5, 32700));
		}

		//Add coupes if user selected SUV option
		//Adds coupes if no options are selected
		if (coupeOn==true || 
				(coupeOn==false && sedanOn==false && SUVOn==false && truckOn==false && vanOn==false)){
			collection.add(new Coupe("Honda Civic", 33, 143, 5, 18190));
			collection.add(new Coupe("BMW 228i", 28, 240, 5, 32100));
			collection.add(new Coupe("Subaru BRZ", 28, 200, 5, 25595));
			collection.add(new Coupe("VolksWagen Golf GTI", 27, 210, 5, 24395));
			collection.add(new Coupe("Ford Mustang GT", 20, 420, 4, 29035));
		}

		//Add sedans if user selected SUV option
		//Adds sedans if no options are selected
		if (sedanOn==true || 
				(coupeOn==false && sedanOn==false && SUVOn==false && truckOn==false && vanOn==false)){
			collection.add(new Sedan("Honda Accord", 30, 185, 5, 22755));
			collection.add(new Sedan("Dodge Charger", 23, 292, 5, 26995));
			collection.add(new Sedan("Ford Fusion", 26, 175, 5, 21970));
			collection.add(new Sedan("Mazda 6", 32, 184, 5, 21190));
			collection.add(new Sedan("Hyundai Sonata", 28, 190, 5, 21450));
		}

		//Add trucks if user selected SUV option
		//Adds trucks if no options are selected
		if (truckOn==true || 
				(coupeOn==false && sedanOn==false && SUVOn==false && truckOn==false && vanOn==false)){
			collection.add(new Truck("Toyota Tacoma", 19, 159, 3, 23105));
			collection.add(new Truck("Nissan Titan", 15, 317, 6, 29360));
			collection.add(new Truck("Ram 1500", 19, 305, 3, 24610));
			collection.add(new Truck("GMC Sierra 1500", 18, 285, 5, 26465));
			collection.add(new Truck("Chevrolet Silverado 1500", 19, 285, 3, 25575));
			collection.add(new Truck("Ford F-150", 19, 302, 3, 24735));
		}

		//Add vans if user selected SUV option
		//Adds vans if no options are selected
		if (vanOn==true || 
				(coupeOn==false && sedanOn==false && SUVOn==false && truckOn==false && vanOn==false)){
			collection.add(new Van("Honda Odyssey", 22, 248, 7, 28825));
			collection.add(new Van("Chrysler Town and Country", 20, 283, 7, 30765));
			collection.add(new Van("Toyota Sienna", 21, 266, 8, 30490));
			collection.add(new Van("Nissan Quest", 21, 260, 7, 26220));
			collection.add(new Van("Kia Sedona", 20, 269, 7, 25900));
		}

		//reset collection for future manipulation
		collection.reset();
	}

	/**
	 * sorts so catalog can grab highest values
	 */
	private void ascendingSort(){

		//to hold five best values
		Collection sorted=new Collection();
		//temporarily store largest value from current run
		int bigValue=0;
		//stores cars temporarily as for loop runs through
		Automobile someCar=null;
		//temporarily stores best car from current run
		Automobile bestCar=null;
		/*stores the best five individually for order manipulation
		(to control which order they output later)*/
		Automobile first,second,third,fourth,fifth;
		//set all individual best cars to null initially
		first=second=third=fourth=fifth=null;
		//We are sorting by MPG value in this case
		int someValue;

		//go through 5 times, finding best 5
		for (int j=0; j<5; j++){
			//confirms collection is back to head
			collection.reset();
			bigValue=0;
			//gets size of linked list from collection class
			int size=collection.getSize();
			//goes through linked list, finding best result
			for (int i=0; i<size; i++){
				someCar=(Automobile)(collection.next());
				//if we want highest MPG, get MPG values
				if (MPGOn==true)
					someValue=someCar.getMPG();
				//if we want highest power, get power values
				else if (powerOn==true)
					someValue=someCar.getPower();
				//only other case using this sort is seat values
				else {
					someValue=someCar.getSeat();
				}

				//deciphers if new largest value has been found
				if (someValue>=bigValue){
					//store new largest value into bigValue
					bigValue=someValue;
					//best car in current run
					bestCar=someCar;
				}	
			}

			//returns to best car of single run...
			collection.reset(bestCar);
			//then removes it from the list for next run.
			collection.remove();

			//store the newest best and push down old 'bests'.
			fifth=fourth;
			fourth=third;
			third=second;
			second=first;
			first=bestCar;
		}

		//Add them this way to reverse the order they are outputted later
		sorted.add(first);
		sorted.add(second);
		sorted.add(third);
		sorted.add(fourth);
		sorted.add(fifth);

		//sorted is now collection for printing
		collection=sorted;
	}

	/**
	 * sorts so catalog can grab lowest values
	 */
	private void priceSort(){

		//to hold five best values
		Collection sorted=new Collection();
		//temporarily store smallest value from current run
		//Starts at insane value (Bugatti Veyron Super Sport is still cheaper than this insane value)
		int smallValue=9999999;
		//stores cars temporarily as for loop runs through
		Automobile someCar=null;
		//temporarily stores best car from current run
		Automobile bestCar=null;
		/*stores the best five individually for order manipulation
		(to control which order they output later)*/
		Automobile first,second,third,fourth,fifth;
		//set all individual best cars to null initially
		first=second=third=fourth=fifth=null;
		//We are sorting by MPG value in this case
		int priceValue;

		//go through 5 times, finding best 5
		for (int j=0; j<5; j++){
			//confirms collection is back to head
			collection.reset();
			//current priceValue is reset
			priceValue=0;
			//resets smallValue for next run
			smallValue=9999999;
			//gets size of linked list from collection class
			int size=collection.getSize();
			//goes through linked list, finding best result
			for (int i=0; i<size; i++){
				someCar=(Automobile)(collection.next());
				priceValue=someCar.getPrice();

				//deciphers if new smallest value has been found
				if (priceValue<=smallValue){
					//store new lowest value into smallValue
					smallValue=priceValue;
					//best car in current run
					bestCar=someCar;
				}	
			}
			//returns to best car of single run...
			collection.reset(bestCar);
			//then removes it from the list for next run.
			collection.remove();

			//store the newest best and push down old 'bests'.
			fifth=fourth;
			fourth=third;
			third=second;
			second=first;
			first=bestCar;
		}

		//Add them this way to reverse the order they are outputted later
		sorted.add(first);
		sorted.add(second);
		sorted.add(third);
		sorted.add(fourth);
		sorted.add(fifth);

		//sorted is now collection for printing
		collection=sorted;
	}

	/**
	 *	Play fancy music while looking at cars
	 */
	private void setMusic()
	{
		//grab file
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("../src/music/Night birds.WAV"));
			Clip c = AudioSystem.getClip();
			//open file
			c.open(audio);
			//start playing music
			c.start();
			//keep playing it
			c.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (UnsupportedAudioFileException e) {
			System.out.println("Wrong file type");
		} catch (IOException e) {
			System.out.println("Could find clip");
		} catch (LineUnavailableException e) {
			System.out.println("Something went wrong");
		}
	}
}
