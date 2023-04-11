package weather;
import java.util.ArrayList;
import weather.WeatherTower;
import interfaces.Flayable;

public class Tower {
    private ArrayList<Flayable> observers = new ArrayList<Flayable>();
    
    public Tower(){}
    public void register(Flayable p_flayable) {
        System.out.print("Tower says: " + p_flayable.getType());
        System.out.print("#" + p_flayable.getName());
        System.out.print("(" + p_flayable.getId());
        System.out.println(") registered to weather tower.");
        this.observers.add(p_flayable);
    }
    public void uregister(Flayable p_flayable) {
        // System.out.print("Tower says: " + p_flayable.getType());
        // System.out.print("#" + p_flayable.getName());
        // System.out.print("(" + p_flayable.getId());
        System.out.println(") unregistered from weather tower.");
        this.observers.remove(p_flayable);
    }
    protected void conditionChanged() {
        for (Flayable observer : observers){
            observer.updateConditions();
        }
    }
}