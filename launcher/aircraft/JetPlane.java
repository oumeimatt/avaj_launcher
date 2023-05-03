package launcher.aircraft;
import launcher.aircraft.Aircraft;
import launcher.Coordinates;
import launcher.WeatherTower;

public class JetPlane extends Aircraft{

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "JetPlane";
    }
    
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        String Message = "";
        switch(weather){
            case "SUN":
                Message = this.type + "#" + this.name + "(" + this.id + "): This is hot.\n";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "): It's raining. Better watch out for lightings.\n";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "FOG":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "): Let's enjoy the good weather and take some pics.\n";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "):  My rotor is going to freeze !\n";                
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        }
        registerMessage(Message);
    }


    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }

}