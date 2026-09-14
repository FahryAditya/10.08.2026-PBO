package Pewarisan;

// Main Class: Titik masuk utama (entry point) program untuk menguji pembuatan objek dan konsep pewarisan
public class MainPerusahaan {
    public static void main(String[] args) {
        // Menampilkan header program di terminal/konsol
        System.out.println("==================================================");
        System.out.println("   SISTEM MANAJEMEN KARYAWAN SOFTWARE HOUSE");
        System.out.println("==================================================\n");

        // --- INSTANSIASI OBJEK DARI SUBCLASS 1 (PROGRAMMER) ---
        System.out.println("--- DATA PROGRAMMER ---");
        // Membuat objek 'programmer1' dan memicu constructor Programmer beserta
        // super(...) milik Karyawan
        Programmer programmer1 = new Programmer("Adresteia Fahry", "PG-001", 8500000, "Java & Python");
        // Menjalankan method tampilkanData() versi override milik class Programmer
        programmer1.tampilkanData();

        // Garis pemisah visual antar-data objek
        System.out.println("\n--------------------------------------------------\n");

        // --- INSTANSIASI OBJEK DARI SUBCLASS 2 (PROJECT MANAGER) ---
        System.out.println("--- DATA PROJECT MANAGER ---");
        // Membuat objek 'pm1' dengan mengirim data identitas, gaji pokok, dan jumlah
        // proyek yang dikelola
        ProjectManager pm1 = new ProjectManager("Siti Aminah", "PM-001", 12000000, 5);
        // Menjalankan method tampilkanData() versi override milik class ProjectManager
        pm1.tampilkanData();

        // Footer penutup batas tampilan program
        System.out.println("\n==================================================");
    }
}