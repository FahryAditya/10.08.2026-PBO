public class OperasiBilangan {

    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void info() {
        System.out.println("Nilai A      : " + getA());
        System.out.println("Nilai B      : " + getB());
        System.out.println("Hasil A + B  : " + (getA() + getB()));
        System.out.println("Hasil A - B  : " + (getA() - getB()));
        System.out.println("Hasil A * B  : " + (getA() * getB()));
        System.out.println("-----------------------------");
    }
}
