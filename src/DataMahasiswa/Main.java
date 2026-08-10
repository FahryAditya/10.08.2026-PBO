package DataMahasiswa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== FORM INPUT DATA MAHASISWA ===");

        System.out.print("Masukkan Nama    : ");
        String nama = input.nextLine();

        System.out.print("Masukkan NIM     : ");
        String nim = input.nextLine();

        System.out.print("Masukkan Jurusan : ");
        String jurusan = input.nextLine();

        // Membuat objek dan mengisi data dari input
        Data_Mhs mhs = new Data_Mhs(nama, nim, jurusan);

        // Menampilkan hasil secara langsung
        mhs.tampilkanData();

        input.close();
    }
}