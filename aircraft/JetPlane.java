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
        String weather = this.weatherTower.getWeather(this.coordinates);
        System.out.println("Jetplane weather == " + weather);
        switch(weather){
            case "SUN":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");
                System.out.println("This is hot.");
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");                
                System.out.println("It's raining. Better watch out for lightings.");
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                break;
            case "FOG":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");                
                System.out.println("Let's enjoy the good weather and take some pics.");
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                System.out.print(this.type + "#");
                System.out.print(this.name + "(");
                System.out.print(this.id + ")");                
                System.out.println("My rotor is going to freeze!");
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
}

}