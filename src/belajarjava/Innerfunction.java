package belajarjava;

import java.util.Scanner;

public class Innerfunction {
    public static int hitungLuasPersegi(int panjang, int lebar) {
        return panjang * lebar;
    }

    public static int inputAngka(Scanner scanner, String label) {
        while (true) {
            System.out.print(label);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Input tidak valid, masukkan angka bulat!");
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int panjang = inputAngka(scanner, "Masukkan panjang: ");
        int lebar = inputAngka(scanner, "Masukkan lebar: ");

        int luas = hitungLuasPersegi(panjang, lebar);
        System.out.println("Luas persegi: " + luas);
    }
}