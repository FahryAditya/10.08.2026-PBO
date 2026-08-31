package StudiKasusConstructor;

import java.util.Scanner;

/**
 * Class HalamanLogin
 * Menyediakan simulasi registrasi akun interaktif dengan Scanner.
 */
public class HalamanLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("   STUDI KASUS: REGISTRASI AKUN BARU");
        System.out.println("=================================================\n");

        System.out.println("--- 1. REGISTRASI PAKAI CONSTRUCTOR ---");
        System.out.print("Masukkan Email    : ");
        String emailInput = scanner.nextLine();

        System.out.print("Masukkan Password : ");
        String passwordInput = scanner.nextLine();

        System.out.println("\nMemproses registrasi dengan Constructor...");
        // Constructor berparameter dipanggil saat instansiasi objek
        AkunDenganConstructor akunUser = new AkunDenganConstructor(emailInput, passwordInput);

        System.out.println("\nHasil Profil Akun:");
        akunUser.tampilkanInfo();

        System.out.println("\n-------------------------------------------------\n");

        System.out.println("--- 2. DEMO TANPA CONSTRUCTOR ---");
        System.out.println("Objek terbuat di memori tanpa memasukkan data awal...");
        AkunTanpaConstructor akunRusak = new AkunTanpaConstructor();

        System.out.println("\nHasil Profil Akun Tanpa Constructor:");
        akunRusak.tampilkanInfo();

        System.out.println("\n=================================================");
        scanner.close();
    }
}
