import java.util.Vector;

public class Parabola {
    private static int a,b,c;
    public Parabola(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Vector2d varf(){
        float varfX = 0;
        float varfY = 0 ;
        float delta = this.b*this.b-4*this.a*this.c;
        varfX = -this.b/2*this.a;
        varfY = -delta / 4*this.a;
        Vector2d varf = new Vector2d(varfX, varfY);
        return varf;
    }

    public Vector2d calculeazaMijlocSegment(Parabola parabola) {
        Vector2d varfCurent = this.varf();
        Vector2d varfParametru = parabola.varf();

        float mijlocX = (varfCurent.x + varfParametru.x) / 2;
        float mijlocY = (varfCurent.y + varfParametru.y) / 2;

        return new Vector2d(mijlocX, mijlocY);
    }

    public static Vector2d calculeazaMijlocSegment2(Parabola p1, Parabola p2) {
        Vector2d varf1 = p1.varf();
        Vector2d varf2 = p2.varf();

        float mijlocX = (varf1.x + varf2.x) / 2;
        float mijlocY = (varf1.y + varf2.y) / 2;

        return new Vector2d ( mijlocX, mijlocY );
    }

    public float calculeazaLungimeaSegment(Parabola parabola) {
        Vector2d varfCurent = this.varf();
        Vector2d varfParametru = parabola.varf();

        float distanta = (float) Math.hypot(varfParametru.x - varfCurent.x, varfParametru.y - varfCurent.y);

        return distanta;
    }

    public float calculeazaLungimeaSegment(Parabola p1, Parabola p2) {
        Vector2d varfCurent = p1.varf();
        Vector2d varfParametru = p2.varf();

        float distanta = (float) Math.hypot(varfParametru.x - varfCurent.x, varfParametru.y - varfCurent.y);

        return distanta;
    }
}
