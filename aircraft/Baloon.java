package aircraft;
import aircraft.Coordinates;
import aircraft.Aircraft;
import weather.WeatherTower;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Baloon";
    }
    public void updateConditions(){
        System.out.println("Baloon updated");
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch(weather){
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
            case "RAIN":
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
            case "FOG":
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
        }
    }
    public void registerTower(WeatherTower weatherTower){        weatherTower.register(this);
        weatherTower.register(this);
    }

}