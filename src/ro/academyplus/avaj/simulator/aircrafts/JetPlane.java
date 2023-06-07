package src.ro.academyplus.avaj.simulator.aircrafts;
import src.ro.academyplus.avaj.simulator.Coordinates;
import src.ro.academyplus.avaj.simulator.aircrafts.Aircraft;
import src.ro.academyplus.avaj.weather.WeatherTower;

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
                Message = this.type + "#" + this.name + "(" + this.id + "): The weather is wonderful! I love the sun.\n";
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
                    + "): The fog is killing me. Request permission to land.\n";
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                Message = this.type + "#" + this.name + "(" + this.id 
                    + "):  OMG! Winter is coming! !\n";                
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        }
        registerMessage(Message);
    }


    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }

}