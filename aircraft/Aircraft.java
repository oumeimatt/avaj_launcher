package aircraft;
import aircraft.Coordinates;
import interfaces.Flayable;

public abstract class Aircraft implements Flayable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;
    protected WeatherTower weatherTower;


    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates){
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
        this.type = "default"
    }

    public abstract void updateConditions();
    public 

}