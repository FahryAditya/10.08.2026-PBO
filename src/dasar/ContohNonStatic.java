package dasar;

public class ContohNonStatic {

    String merek;
    String warna;
    int kecepatan;

    public ContohNonStatic(String merek, String warna) {
        this.merek = merek;
        this.warna = warna;
        this.kecepatan = 0;
    }

    public void gas() {
        kecepatan += 20;
        System.out.println(merek + " ngebut, kecepatan sekarang " + kecepatan + " km/jam");
    }

    public void rem() {
        kecepatan = 0;
        System.out.println(merek + " berhenti, kecepatan " + kecepatan + " km/jam");
    }

    public void info() {
        System.out.println("Mobil " + merek + " warna " + warna);
    }

    public static void main(String[] args) {
        ContohNonStatic mobilA = new ContohNonStatic("Toyota", "Merah");
        ContohNonStatic mobilB = new ContohNonStatic("Honda", "Hitam");

        mobilA.info();
        mobilA.gas();
        mobilA.gas();

        System.out.println("---");

        mobilB.info();
        mobilB.gas();
        mobilB.rem();

        System.out.println("---");
        System.out.println("Kecepatan Toyota: " + mobilA.kecepatan);
        System.out.println("Kecepatan Honda : " + mobilB.kecepatan);
    }
}
