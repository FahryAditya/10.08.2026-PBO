package dasar;

public class Genap {
    public static void main(String[] args) {
        for (int angka = 0; angka <= 20; angka++) {
            if (angka % 2 == 0) {
                System.out.println(angka + " -> Genap");
            } else {
                System.out.println(angka + " -> Ganjil");
            }
        }
    }
}
