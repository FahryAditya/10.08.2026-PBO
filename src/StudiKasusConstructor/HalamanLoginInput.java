package StudiKasusConstructor; //ini adalah package

import java.util.Scanner;// ini adalah scanner untuk menginputkan sesuatu

/**
 * Class HalamanLoginInput
 * Menyediakan antarmuka interaktif berbasis terminal menggunakan Scanner
 * untuk menguji registrasi akun secara langsung dari inputan pengguna.
 */
public class HalamanLoginInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("     FORM REGISTRASI AKUN BARU (INTERAKTIF)");
        System.out.println("=================================================\n");

        System.out.println("Pilih Mode Simulasi:");
        System.out.println("1. Registrasi TANPA Constructor (Objek dibuat duluan, data diisi belakangan)");
        System.out.println("2. Registrasi PAKAI Constructor (Wajib input Email & Password sekaligus)");
        System.out.print("PILIHAN ANDA (1/2): ");    // ini cuman teks

        String pilihan = scanner.nextLine().trim(); //fungsi trim adalah buat menghapus spasi kosong yang ada di inputan

        System.out.println("\n-------------------------------------------------");

        if (pilihan.equals("1")) {
            System.out.println("\n[MODE 1: TANPA CONSTRUCTOR]");
            System.out.println("1. Membuat objek akun terlebih dahulu...");
            
            // Objek terbuat tanpa passing data
            AkunTanpaConstructor akun = new AkunTanpaConstructor();
            System.out.println(" Status objek awal -> Akun sudah tercipta di memori.");

            System.out.print("\nApakah Anda ingin menginputkan Email & Password? (y/n): ");
            String jawab = scanner.nextLine().trim();

            if (jawab.equalsIgnoreCase("y")) {
                System.out.print("Input Email    : ");
                akun.email = scanner.nextLine();
                
                System.out.print("Input Password : ");
                akun.password = scanner.nextLine();
            } else {
                System.out.println("⚠️ Pengisian data dilewati. Email dan Password tetap kosong!");
            }

            System.out.println("\n--- HASIL AKHIR AKUN ---");
            akun.tampilkanInfo();

        } else if (pilihan.equals("2")) {
            System.out.println("\n[MODE 2: PAKAI CONSTRUCTOR]");
            System.out.println("Silakan masukkan data pendaftaran:");

            System.out.print("Input Email    : ");
            String emailInput = scanner.nextLine();

            System.out.print("Input Password : ");
            String passwordInput = scanner.nextLine();

            System.out.println("\nMemproses instansiasi objek dengan Constructor...");
            System.out.print("Proses -> ");
            
            // Memanggil Constructor berparameter dengan inputan user
            AkunDenganConstructor akun = new AkunDenganConstructor(emailInput, passwordInput);

            System.out.println("\n--- HASIL AKHIR AKUN ---");
            akun.tampilkanInfo();

        } else {
            System.out.println("❌ Pilihan tidak valid. Silakan jalankan ulang program.");
        }

        System.out.println("\n=================================================");
        scanner.close();
    }
}
