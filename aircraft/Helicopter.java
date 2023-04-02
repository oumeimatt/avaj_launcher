package aircraft;
import aircraft.Aircraft;
import aircraft.Coordinates;

public class Helicopter extends Aircraft{

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates){
        this._id = p_id;
        this._name = p_name;
        this._coordinates = p_coordinates;
    }
    public void updateConditions(){}
}