package aircraft;
import aircraft.Coordinates;
import weather.Flayable;

public class Aircraft extends Flayable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates){
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

}