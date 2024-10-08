public class Vers{
    static private String line;
    public int retNrVocale(){
        int vocale = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'a' || line.charAt(i) == 'e'
                    || line.charAt(i) == 'i'
                    || line.charAt(i) == 'o'
                    || line.charAt(i) == 'u') {
                // count increments if there is vowel in
                // char[i]
                vocale++;
            }
        }

        return vocale;
    }
    public int retNrCuvinte(){
        int nrcuvinte = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                nrcuvinte++;
            }
        }
        return nrcuvinte;
    }

    public void setLine(String curVers){
        line = curVers;
    }

    public String retLine(){
        return line;
    }
}
