package automobile;

/**
 * 
 * @author Matthew
 * A SUV is an Automobile
 */
public class SUV extends Automobile{

	/**
	 * default constructor for SUV
	 */
	public SUV(){}

	/**
	 * Takes in all information of a particular SUV
	 * @param type
	 * @param MPG
	 * @param power
	 * @param seats
	 * @param price
	 */
	public SUV(String type, int MPG, int power, int seats, int price){
		//sends broad information to automobile
		setAutomobile(type, MPG, power, seats, price);
		//sets a custom perk of the particular automobile
		setPerk();
	}

	/**
	 * Automobile setter for referencing parent class
	 */
	public Automobile setAutomobile(String type, int MPG, int power, int seats, int price){
		super.setAutomobile(type, MPG, power, seats, price);
		return automobile;
	}

	/**
	 * sets AWD perk to all SUVs 
	 */
	public void setPerk(){
		perk="this SUV features all wheel drive";
		super.setPerk(perk);
	}

	/**
	 * returns the perk when requested
	 */
	public String getPerk(){
		return perk;
	}

}
