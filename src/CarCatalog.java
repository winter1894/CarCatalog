import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**@author Matthew Winter
 *
 *Starting location of program.
 */
public class CarCatalog extends Applet{

	/**
	 * Object for initiating applet.
	 */
	private Catalog catalog;

	/**
	 * Starts the car catalog program
	 */
	public void init()
	{
		catalog = new Catalog(this);

		setBackground(Color.lightGray);
	}

	/**
	**	The paint method simply passes the buck to the demo itself.
	*/
	public void paint(Graphics page)
	{
		if ( catalog != null )
			catalog.paint(page);
	}

} 
