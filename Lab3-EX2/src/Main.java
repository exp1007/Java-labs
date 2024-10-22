import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.security.ProtectionDomain;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {
        ArrayList<Produs> listaProduse = new ArrayList<Produs>();

        try {
            File myObj = new File("produse.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] splitted = line.split(" ");
                String nume = splitted[0];
                float pret = Float.parseFloat(splitted[1]);
                int cantitate = Integer.parseInt(splitted[2]);
                LocalDate dataExp = LocalDate.parse(splitted[3]);

                Produs p = new Produs(nume, pret, cantitate, dataExp);
                listaProduse.add(p);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter option");
        int myint = keyboard.nextInt();

        switch(myint) {
            case 0:
                for (Produs prod : listaProduse) {
                    prod.afisare();
                }
                break;
            case 1:
                for (Produs prod : listaProduse) {
                    if(prod.dataExp.isAfter(LocalDate.now())){
                        prod.afisare();
                    }
                }
                break;
            case 2:
                System.out.println("Nume produs ");

                String numeProdCautat = keyboard.nextLine();
            for (Produs prod : listaProduse) {
                if(prod.comparaNume(numeProdCautat) == true){
                    prod.vinde();
                    prod.afisare();
                }
            }
                break;
            case 3:
                float min = 5000;
                for (Produs prod : listaProduse) {
                    if(prod.retPret() < min) {
                        min = prod.retPret();
                    }
                    else if(prod.retPret() == min){
                        System.out.println(prod.retPret());
                    }
                }
                break;
            case 4:
                System.out.println("Pret minim ");
                float pretDef = keyboard.nextInt();
                for (Produs prod : listaProduse) {
                    if(prod.retPret() < pretDef) {
                        prod.afisare();
                    }
                }
                break;
            default:
                // code block
        }

    }
}
