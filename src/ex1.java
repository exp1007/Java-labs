import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files

public class ex1 {
    public static void main(String[] args) {
        String[] listaJudete = new String[32];
        int indexJudet = 0;

        try {
            File myObj = new File("D:\\lucru_java_intellij\\Lab2-Andrei\\src\\judete_in.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                listaJudete[indexJudet] = myReader.nextLine();
                indexJudet++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Arrays.sort(listaJudete, 0, indexJudet);

        //System.out.println("Judete: ");

        Scanner keyboard = new Scanner(System.in);
        String judetCautat = keyboard.nextLine();

        for(int index = 0; index < 30; index++){
            if(listaJudete[index] == null)
                break;
            if(listaJudete[index].equals(judetCautat))
                System.out.println(index);
        }
    }
}
