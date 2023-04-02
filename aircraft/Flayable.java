package aircraft;
import aircraft.WeatherTower;

public abstract class Flayable {
    protected WeatherTower weatherTower;
    public abstract void updateConditions(){}
    public void registerTower(WeatherTower *p_tower){}
}