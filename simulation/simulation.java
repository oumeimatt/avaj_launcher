package avaj_launcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import exceptions.FileException;
// import java.util.Scanner;

// import java.io.NumberFormatException;

public class simulation {


    class MyException extends Exception {
        public MyException(String s){
            super(s);
        }
    }
    
    static boolean validCoordinates(String[] coord){
        try {
            int longitude = Integer.parseInt(coord[2]);
            int latitude = Integer.parseInt(coord[3]);
            int height = Integer.parseInt(coord[4]);
            if (longitude <= 0 || latitude <= 0 || height <= 0)
                return false;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid Coordinates!");
            return (false);
        }
        return true;
    }

    static boolean isDataValid(String data[]){
        if (data.length == 5){
            if (!data[0].equals("Baloon") && !data[0].equals("JetPlane") 
                && !data[0].equals("Helicopter"))
                return false;
            if (validCoordinates(data))
                System.out.println("valid Coordinates :)");
            else{
                return false;
            }
        }
        return true;
    }


    public static void main(String args[]){
        int n = 0;
        // System.out.println(args[0]);
        BufferedReader reader;
        if (args.length == 1){
            try {

                reader = new BufferedReader(new FileReader(args[0]));
                String line = reader.readLine();
                reader.close();
                // File myObj = new File(args[0]);
                // Scanner myReader = new Scanner(myObj);
                // while(myReader.hasNextLine()){
                //     String line = myReader.nextLine();
                //     System.out.println(line);
                //     String data[] = line.split(" ");
                //     isDataValid(data);
                // }
                // myReader.close();
            } catch (IOException e){
                try {
                    throw new FileException("PLease check File Name or path", e);
                }
                catch (FileException e2){
                    System.out.println("im in hehe");
                    System.out.println(e2.toString());
                }
            }

        }
        
    }
}