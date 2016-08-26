package module3;

//Java utilities libraries
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;

//Parsing library
import parsing.ParseFeed;

/** EarthquakeCityMap
 * An application with an interactive map displaying earthquake data.
 * Author: UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 * Date: July 17, 2015
 * */
public class EarthquakeCityMap extends PApplet {

	// You can ignore this.  It's to keep eclipse from generating a warning.
	private static final long serialVersionUID = 1L;

	// IF YOU ARE WORKING OFFLINE, change the value of this variable to true
	private static final boolean offline = false;
	
	// Less than this threshold is a light earthquake
	public static final float THRESHOLD_MODERATE = 5;
	// Less than this threshold is a minor earthquake
	public static final float THRESHOLD_LIGHT = 4;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// The map
	private UnfoldingMap map;
	
	//feed with magnitude 2.5+ Earthquakes
	private String earthquakesURL = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_week.atom";

	
	public void setup() {
		size(950, 600, OPENGL);

		if (offline) {
		    map = new UnfoldingMap(this, 200, 50, 700, 500, new MBTilesMapProvider(mbTilesString));
		    earthquakesURL = "2.5_week.atom"; 	// Same feed, saved Aug 7, 2015, for working offline
		}
		else {
			map = new UnfoldingMap(this, 125, 50, 700, 500, new Google.GoogleMapProvider());
			// IF YOU WANT TO TEST WITH A LOCAL FILE, uncomment the next line
			//earthquakesURL = "2.5_week.atom";
		}
		
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);	
	    
	    // create 3 PointFeature and setup its location and properties with random data
	    PointFeature earthquake = new PointFeature(new Location(-38.14f, -73.03f));
	    earthquake.addProperty("title", "Valdivia, Chile");
	    earthquake.addProperty("magnitude", 9.5);
	    earthquake.addProperty("date", "May 22, 1960");
	    earthquake.addProperty("year", 1960);
	    
	    PointFeature alaskaEq = new PointFeature(new Location(38.14f, -73.03f));
	    alaskaEq.addProperty("title", "Alaska");
	    alaskaEq.addProperty("magnitude", 7.5);
	    alaskaEq.addProperty("date", "April 2, 1994");
	    alaskaEq.addProperty("year", 1996);
	    
	    PointFeature sumatraEq = new PointFeature(new Location(-38.14f, 73.03f));
	    sumatraEq.addProperty("title", "Sumatra");
	    sumatraEq.addProperty("magnitude", 4.5);
	    sumatraEq.addProperty("date", "October 12, 2004");
	    sumatraEq.addProperty("year", 2008);
	    
	    //create List of PointFeature and add 3 PointFeature that was created
	    List<PointFeature> bigEqs = new ArrayList<PointFeature>();
	    bigEqs.add(earthquake);
	    bigEqs.add(alaskaEq);
	    bigEqs.add(sumatraEq);
			
	    // Create a List of marker that will be populated with SimplePointMarker
	    List<Marker> markers = new ArrayList<Marker>();
	    for(PointFeature pf : bigEqs){
	    	SimplePointMarker simplePointMarker = new SimplePointMarker(pf.getLocation(), pf.getProperties());
	    	
	    	// Check the "magnitude" property and change the color of the marker base on the magnitude
	    	if((double)simplePointMarker.getProperty("magnitude") > 9){
	    		simplePointMarker.setColor(color(255, 0, 0));
	    	}else if ((double)simplePointMarker.getProperty("magnitude") > 7) {
				simplePointMarker.setColor(color(255, 255, 0));
			} else {
				simplePointMarker.setColor(color(150, 150, 150));
			}
	    	
	    	markers.add(simplePointMarker);
	    }
	    
	    map.addMarkers(markers);
	    

	    //Use provided parser to collect properties for each earthquake
	    //PointFeatures have a getLocation method
	    List<PointFeature> earthquakes = ParseFeed.parseEarthquake(this, earthquakesURL);
	    
	    // These print statements show you (1) all of the relevant properties 
	    // in the features, and (2) how to get one property and use it
	    if (earthquakes.size() > 0) {
	    	PointFeature f = earthquakes.get(0);
	    	System.out.println(f.getProperties());
	    	Object magObj = f.getProperty("magnitude");
	    	float mag = Float.parseFloat(magObj.toString());
	    	// PointFeatures also have a getLocation method
	    }
	    
	    // Here is an example of how to use Processing's color method to generate 
	    // an int that represents the color yellow.  
	    int yellow = color(255, 255, 0);
	    
	    //TODO: Add code here as appropriate
	}
		
	// A suggested helper method that takes in an earthquake feature and 
	// returns a SimplePointMarker for that earthquake
	// TODO: Implement this method and call it from setUp, if it helps
	private SimplePointMarker createMarker(PointFeature feature)
	{
		// finish implementing and use this method, if it helps.
		return new SimplePointMarker(feature.getLocation());
	}
	
	public void draw() {
	    background(129, 129, 129);
	    map.draw();
	    addKey();
	}


	// helper method to draw key in GUI
	// TODO: Implement this method to draw the key
	private void addKey() 
	{	
		// Remember you can use Processing's graphics methods here
	
	}
}
