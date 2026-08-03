package OperasiBilangan;
import java.util.Scanner;
public class MyProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Membuat objek dari class OperasiBilangan
        OperasiBilangan op = new OperasiBilangan();

        System.out.print("Masukkan Bilangan Pertama : ");
        op.bil1 = input.nextDouble();

        System.out.print("Masukkan Bilangan Kedua   : ");
        op.bil2 = input.nextDouble();

        System.out.println("--- Hasil Operasi Bilangan ---");
        System.out.println("Penjumlahan : " + op.hitungPenjumlahan());
        System.out.println("Pengurangan : " + op.hitungPengurangan());
        System.out.println("Perkalian   : " + op.hitungPerkalian());
        System.out.println("Pembagian   : " + op.hitungPembagian());
    }
}
