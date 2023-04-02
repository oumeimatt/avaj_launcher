package aircraft;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public int getLongitude(){
        return this.longitude;
    }
    public int getLatitude(){
        return this.latitude;
    }
    public int getHeight(){
        return this.height;
    }
    void finalize(int p_longitude, int p_latitude, int p_height){}
}