package dasar;

public class ContohMethod {

    String nama;

    public ContohMethod(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public static void sapa() {
        System.out.println("Halo!");
    }

    public static int tambah(int a, int b) {
        return a + b;
    }

    public static double tambah(double a, double b) {
        return a + b;
    }

    public static int faktorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * faktorial(n - 1);
    }

    public void perkenalan() {
        System.out.println("Nama saya " + nama);
    }

    public static void main(String[] args) {
        sapa();

        System.out.println("2 + 3 = " + tambah(2, 3));
        System.out.println("2.5 + 3.5 = " + tambah(2.5, 3.5));

        System.out.println("5! = " + faktorial(5));

        ContohMethod orang = new ContohMethod("Fahry");
        orang.perkenalan();
        orang.setNama("Budi");
        System.out.println("Nama baru: " + orang.getNama());
    }
}
