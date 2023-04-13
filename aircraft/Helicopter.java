package aircraft;
import aircraft.Aircraft;
import aircraft.Coordinates;
import weather.WeatherTower;

public class Helicopter extends Aircraft{

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates){
        super(p_id, p_name, p_coordinates);
        this.type = "Helicopter";

    }
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);
        // System.out.println("Helicopeter weather == " + weather);
        // String weather = "SUN";
        switch(weather){
            case "SUN":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");
                System.out.println("This is hot.");
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");                
                System.out.println("It's raining. Better watch out for lightings.");
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                break;
            case "FOG":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");                
                System.out.println("Let's enjoy the good weather and take some pics.");
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                break;
            case "SNOW":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");                
                System.out.println("My rotor is going to freeze!");
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;

    }

}