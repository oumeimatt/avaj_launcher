package weather;
import aircraft.Coordinates;

public class WeatherProvider {
    private static String[] weather = new String[]{"RAIN","FOG","SUN","SNOW"};
    private WeatherProvider(){}

    public static String getCurrentWeather(Coordinates p_coordinates){
        int n = p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight();
        return weather[n % 4]; 
    }
}