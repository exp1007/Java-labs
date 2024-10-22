import java.time.LocalDate;

public class Produs {
    private String nume;
    private float pret;
    private int cantitate;
    LocalDate dataExp;

    public Produs(String nume, float pret, int cantitate, LocalDate dataExp){
        this.nume = nume;
        this.pret =  pret;
        this.cantitate = cantitate;
        this.dataExp = dataExp;
    }

    public void afisare(){
        System.out.println(nume.toString() + pret + cantitate + dataExp.toString());
    }

    public boolean comparaNume(String nume2){
        if(nume2 == this.nume)
            return true;
        else return false;
    }

    public void vinde(){
        if(this.cantitate > 1){
            this.cantitate = this.cantitate-1;
        }
    }

    public float retPret(){
        return this.pret;
    }

}
