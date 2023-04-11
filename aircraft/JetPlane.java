package aircraft;
import aircraft.Aircraft;
import aircraft.Coordinates;
import weather.WeatherTower;

public class JetPlane extends Aircraft{

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "JetPlane";
    }
    
    public void updateConditions(){
        System.out.println("Jetplane updated");

        String weather = this.weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
            case "RAIN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        }
    }

    public void registerTower(WeatherTower weatherTower){        weatherTower.register(this);
        weatherTower.register(this);
    }

}