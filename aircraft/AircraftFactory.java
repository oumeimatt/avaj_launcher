package aircraft;
import aircraft.Coordinates;
import interfaces.Flayable;

public class AircraftFactory{
    private AircraftFactory(){}
    private static int aircraftId = 0;
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