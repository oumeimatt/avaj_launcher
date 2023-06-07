package src.ro.academyplus.avaj.simulator.aircrafts;
import src.ro.academyplus.avaj.simulator.Coordinates;
import src.ro.academyplus.avaj.simulator.aircrafts.Flayable;

public class AircraftFactory{
    private static int aircraftId = 0;
    
    public static AircraftFactory instance = null;
    
    private AircraftFactory(){}

    public static synchronized AircraftFactory getInstance(){
        if (instance == null){
            instance = new AircraftFactory();
        }
        return instance;
    }
    
    public static Flayable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        aircraftId++;
        switch (p_type) {
            case "Baloon":
                return (new Baloon(aircraftId, p_name, p_coordinates));
            case "Helicopter":
                return (new Helicopter(aircraftId, p_name, p_coordinates));
            case "JetPlane":
                return (new JetPlane(aircraftId, p_name, p_coordinates)); 
        }
        return null;
    }
}