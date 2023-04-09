package interfaces;
import weather.weatherTower;

public interface Flayable {
    protected WeatherTower weatherTower;
    public abstract void updateConditions();
    public void registerTower(WeatherTower p_tower);
}