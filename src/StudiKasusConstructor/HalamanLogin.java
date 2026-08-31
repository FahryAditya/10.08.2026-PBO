package StudiKasusConstructor;

import java.util.Scanner;

/**
 * Class HalamanLogin
 * Menerima inputan langsung dari pengguna untuk memunculkan simulasi
 * registrasi akun tanpa constructor maupun pakai constructor.
 */
public class HalamanLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("   STUDI KASUS: REGISTRASI AKUN BARU (INPUT)");
        System.out.println("=================================================\n");

        System.out.println("--- 1. INPUT UNTUK REGISTRASI PAKAI CONSTRUCTOR ---");
        System.out.print("Masukkan Email Anda    : ");
        String emailInput = scanner.nextLine();

        System.out.print("Masukkan Password Anda : ");
        String passwordInput = scanner.nextLine();

        System.out.println("\nMemproses Registrasi dangan Constructor...");
        System.out.print("Status Sistem -> ");
        
        // Memangil Constructor berparameter dengan inputan user
        AkunDenganConstructor akunUser = new AkunDenganConstructor(emailInput, passwordInput);

        System.out.println("\nHasil Pencatatan Akun:");
        akunUser.tampilkanInfo();

        System.out.println("\n-------------------------------------------------\n");

        System.out.println("--- 2. DEMO REGISTRASI TANPA CONSTRUCTOR ---");
        System.out.println("Skenario: Klik 'Daftar', objek akun terbuat duluan di memori tanpa data...");
        
        // Objek akun terbuat tanpa data
        AkunTanpaConstructor akunRusak = new AkunTanpaConstructor();
        
        System.out.println("\nHasil Pencatatan Akun Tanpa Constructor:");
        akunRusak.tampilkanInfo();

        System.out.println("\n=================================================");
        scanner.close();
    }
}
