package belajarjava;

import java.util.Scanner;

public class Innerfunction {
    public static int hitungluaspersegi(int panjang, int lebar) {
        return panjang * lebar;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan panjang: ");
        int panjang = scanner.nextInt();

        System.out.print("Masukkan lebar: ");
        int lebar = scanner.nextInt();

        int luas = hitungluaspersegi(panjang, lebar);
        System.out.println("Luas persegi: " + luas);
    }
}