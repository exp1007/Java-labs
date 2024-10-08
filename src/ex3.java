import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        StringBuilder mainString = new StringBuilder();

        Scanner keyboard = new Scanner(System.in);
        String line = keyboard.nextLine();

        String line2 = keyboard.nextLine();

        int position = keyboard.nextInt();
        StringBuilder finalString = new StringBuilder(line);
        finalString.insert(position, line2);

        System.out.println(finalString.toString());
        int position2 = keyboard.nextInt();
        int position3 = keyboard.nextInt();
        finalString.delete(position2, position3);

        System.out.println(finalString.toString());

    }
}
