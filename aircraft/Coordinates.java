package aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    void finalize(int p_longitude, int p_latitude, int p_height){}

    public int getLongitude(){
        return this.longitude;
    }
    public int getLatitude(){
        return this.latitude;
    }
    public int getHeight(){
        return this.height;
    }
    public void setLongitude(int newLongitude){
        this.longitude = newLongitude;
    }
    public void setLatitude(int newLatitude){
        this.latitude = newLatitude;
    }
    public void setHeight(int newHeight){
        if (this.height <= 100)
            this.height = newHeight;
    }
}