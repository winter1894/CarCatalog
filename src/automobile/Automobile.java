package automobile;

import java.awt.*;

/**
 * Every individual Node will contain information on a single car
 */
public class Automobile {

	/**
	 * automobile statistics
	 */
	protected int MPG, power, seats, price=0;
	/**
	 * type of individual car
	 */
	protected String type;
	/**
	 * the perk of the type of vehicle
	 */
	protected String perk;
	/**
	 * for returning particular automobile
	 */
	protected Automobile automobile;

	/**
	 * Default constructor of Automobile
	 */
	protected Automobile(){}

	/**
	 * Method takes in all values of a particular car
	 * @param type
	 * @param MPG
	 * @param power
	 * @param seats
	 * @param price
	 */
	protected Automobile setAutomobile(String type, int MPG, int power, int seats, int price){
		//pushes the corresponding information into its setter method
		setType(type);
		setMPG(MPG);
		setPower(power);
		setSeat(seats);
		setPrice(price);

		return automobile;
	}

	/**
	 * returns the name of the car
	 */
	public String getType(){
		return type;
	}

	/**
	 * sets the name of the car
	 * @param type
	 */
	public void setType(String type){
		this.type=type; 
	}

	/**
	 * get Miles per Gallon
	 */
	public int getMPG(){
		return MPG;
	}
	/**
	 * set Miles per Gallon
	 * @param someValue
	 */
	public void setMPG(int someValue){
		MPG = someValue;
	}

	/**
	 * get horsepower
	 */
	public int getPower(){
		return power;
	}
	/**
	 * set horsepower
	 * @param someValue
	 */
	public void setPower(int someValue){
		power=someValue;
	}

	/**
	 * get number of seats
	 */
	public int getSeat(){
		return seats;
	}
	/**
	 * set number of seats
	 * @param someValue
	 */
	public void setSeat(int someValue){
		seats=someValue;
	}

	/**
	 * get price of car
	 */
	public int getPrice(){
		return price;
	}
	/**
	 * set price of car
	 * @param someValue
	 */
	public void setPrice(int someValue){
		price=someValue;
	}

	/**
	 * get perk of particular car
	 */
	public String getPerk(){
		return perk;
	}

	/**
	 * set perk of car
	 * @param somePerk
	 */
	public void setPerk(String somePerk){
		perk=somePerk;
	}
}
