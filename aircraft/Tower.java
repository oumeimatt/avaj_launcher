package aircraft;
import java.util.ArrayList;
import aircraft.WeatherTower;
import aircraft.Flayable;

public class Tower extends WeatherTower {
    private ArrayList<Flayable> observers = new ArrayList<Flayable>;
    
    public void register(Flayable * p_flayable) {
        this.observers.add(p_flayable);
    }
    public void uregister(Flayable * p_flayable) {
        this.observers.remove(p_flayable);
    }
    protected void conditionChanged() {}
}