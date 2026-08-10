public class OperasiBilangan {

    private int a;
    private int b;
    private int hasil;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setHasil(int a, int b) {
        this.hasil = a + b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getHasil() {
        return hasil;
    }

    public void info() {
        System.out.println("Nilai A      : " + getA());
        System.out.println("Nilai B      : " + getB());
        System.out.println("Hasil A + B  : " + (getA() + getB()));
        System.out.println("Hasil A - B  : " + (getA() - getB()));
        System.out.println("Hasil A * B  : " + (getA() * getB()));
        System.out.println("Hasil A / B  : " + (getA() / getB()));
        System.out.println("Hasil A % B  : " + (getA() % getB()));
        System.out.println("-----------------------------");
    }
}
