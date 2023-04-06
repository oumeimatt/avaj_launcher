package aircraft;
import aircraft.Coordinates;
import weather.Flayable;
import java.util.UUID;

public class AircraftFactory{
    private static AircraftFactory(){}
    private static aircraftId = 0;
    public static Flayable newAircraft(String p_type, String p_name, Coordinates p_coordinates){
        this.aircraftId++;
        switch (p_type) {
            case "Baloon":
                return (new Baloon(this.aircraftId, p_name, p_coordinates));
            case "Helicopter":
                return (new Helicopter(this.aircraftId, p_name, p_coordinates));
            case "JetPlane":
                return (new JetPlane(this.aircraftId, p_name, p_coordinates)); 
        }
    }
}