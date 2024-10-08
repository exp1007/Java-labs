import java.time.LocalDate;
import java.util.Scanner;

class Persoana {
    private String nume;
    private String cnp;

    // Constructor
    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    // Gettere
    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }
    public int getVarsta() {
        int an = Integer.parseInt(cnp.substring(1, 3));
        int luna = Integer.parseInt(cnp.substring(3, 5));
        int zi = Integer.parseInt(cnp.substring(5, 7));
        if (cnp.charAt(0) == '1' || cnp.charAt(0) == '2') {
            an += 1900;
        } else if (cnp.charAt(0) == '5' || cnp.charAt(0) == '6') {
            an += 2000;
        }
        LocalDate dataNasterii = LocalDate.of(an, luna, zi);
        LocalDate dataCurenta = LocalDate.now();
        return dataCurenta.getYear() - dataNasterii.getYear() -
                (dataCurenta.getDayOfYear() < dataNasterii.getDayOfYear() ? 1 : 0);
    }


    public String toString() {
        return nume + ", " + cnp + ", " + getVarsta();
    }
}
public class ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numarul de persoane: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Persoana[] persoane = new Persoana[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Introduceti numele persoanei " + (i + 1) + ": ");
            String nume = scanner.nextLine();

            String cnp;
            while (true) {
                System.out.print("Introduceti CNP-ul persoanei " + (i + 1) + ": ");
                cnp = scanner.nextLine();

                if (isCnpValid(cnp)) {
                    break;
                } else {
                    System.out.println("CNP invalid! Va rugam sa reintroduceti.");
                }
            }

            persoane[i] = new Persoana(nume, cnp);
        }
        System.out.println("\nInformațiile introduse:");
        for (Persoana persoana : persoane) {
            System.out.println(persoana);
        }

        scanner.close();
    }

    private static boolean isCnpValid(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }
        if (!cnp.matches("\\d+")) {
            return false;
        }
        char primaCifra = cnp.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false;
        }
        return isCnpCifraControlValid(cnp);
    }
    private static boolean isCnpCifraControlValid(String cnp) {
        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;

        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(cnp.charAt(i)) * coeficienti[i];
        }

        int cifraControl = suma % 11;
        if (cifraControl == 10) {
            cifraControl = 1;
        }

        return cifraControl == Character.getNumericValue(cnp.charAt(12));
    }
}