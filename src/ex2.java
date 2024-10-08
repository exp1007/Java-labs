import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Random;


public class ex2 {
    public static void main(String[] args) {
        StringBuilder cantec = new StringBuilder();
        int indexJudet = 0;

        try {
            File myObj = new File("D:\\lucru_java_intellij\\Lab2-Andrei\\src\\cantec_in.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                StringBuilder line = new StringBuilder();
                line.append(myReader.nextLine());

                Vers currentVers = new Vers();
                currentVers.setLine(line.toString());
                int nrcuvinte = currentVers.retNrCuvinte();
                int vocale = currentVers.retNrCuvinte();

                Random rand = new Random();
                float rand_float = rand.nextFloat(1);
                boolean randTest = false;
                if(rand_float < 0.1)
                    randTest = true;

                cantec.append(currentVers.retLine().toString() + (randTest == true ? " | * " : " | ") + " Nr cuvinte: " + Integer.toString(nrcuvinte) + " Nr vocale: " + Integer.toString(vocale) + '\n');
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("D:\\lucru_java_intellij\\Lab2-Andrei\\src\\cantec_out.txt");
            myWriter.write(cantec.toString());
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
