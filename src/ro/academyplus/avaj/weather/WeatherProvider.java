package src.ro.academyplus.avaj.weather;
import src.ro.academyplus.avaj.simulator.Coordinates;

public class WeatherProvider {
    private static String[] weather = new String[]{"RAIN","FOG","SUN","SNOW"};
    
    private static WeatherProvider instance = null;
    
    private WeatherProvider(){}

    public static synchronized WeatherProvider getInstance(){
        if (instance == null)
            instance = new WeatherProvider();
        return instance;
    }
    
    public static String getCurrentWeather(Coordinates p_coordinates){
        int n = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
        return weather[n % 4]; 
    }
}