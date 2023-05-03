package launcher;
import launcher.Coordinates;
import launcher.WeatherProvider;

public class WeatherTower extends Tower{

    public String getWeather(Coordinates p_coordinates){
        // return "SUN";
        return WeatherProvider.getCurrentWeather(p_coordinates);
    }
    public void changeWeather(){
        this.conditionChanged();
    }
}