package weather;
import java.util.ArrayList;
import weather.WeatherTower;
import interfaces.Flayable;
import java.util.Iterator;


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
    public void unregister(Flayable p_flayable) {
        System.out.print("Tower says: " + p_flayable.getType());
        System.out.print("#" + p_flayable.getName());
        System.out.print("(" + p_flayable.getId());
        System.out.println(") unregistered from weather tower.");
        this.observers.remove(p_flayable);
        // System.out.println(" removed ");
    }
    protected void conditionChanged() {
        for (int i = 0; i < observers.size(); i++)
        {
            observers.get(i).updateConditions();
            if (observers.get(i).isLanding()){
                System.out.print(observers.get(i).getType() + "#");
                System.out.print(observers.get(i).getName() + "(");
                System.out.println(observers.get(i).getId() + ") landing.");
                this.unregister(observers.get(i));
                i--;
            }
        }
    }
}