package launcher.aircraft;
import launcher.WeatherTower;

public interface Flayable {
    // protected WeatherTower weatherTower;
    public abstract void updateConditions();
    public void registerTower(WeatherTower p_tower);
    public String getType();
    public long getId();
    public String getName();
    public boolean isLanding();
}