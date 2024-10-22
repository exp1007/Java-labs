public class Main {
    public static void main(String[] args) {
        Parabola p1 = new Parabola(5, 7, 12);
        float x = p1.varf().x;
        float y = p1.varf().y;
        System.out.println(Float.toString(x) + " " + Float.toString(y));
    }
}
