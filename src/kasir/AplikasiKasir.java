package kasir;

import java.util.Scanner;

public class AplikasiKasir {

    static double hitungTotalHarga(double hargaSatuan, int jumlahBarang) {
        return hargaSatuan * jumlahBarang;
    }

    static void tampilkanRincian(double hargaSatuan, int jumlahBarang, double totalHarga) {
        System.out.println("========== RINCIAN PEMBELIAN ==========");
        System.out.println("Harga Satuan    : Rp " + hargaSatuan);
        System.out.println("Jumlah Barang   : " + jumlahBarang);
        System.out.println("----------------------------------------");
        System.out.println("Total Belanja    : Rp " + totalHarga);
        System.out.println("=======================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== PROGRAM KALKULATOR TOKO ALAT TULIS =====");
        System.out.println();

        System.out.print("Masukkan harga satuan barang (Rp): ");
        double hargaSatuan = scanner.nextDouble();

        System.out.print("Masukkan jumlah barang yang dibeli: ");
        int jumlahBarang = scanner.nextInt();

        double totalHarga = hitungTotalHarga(hargaSatuan, jumlahBarang);

        System.out.println();
        tampilkanRincian(hargaSatuan, jumlahBarang, totalHarga);

        scanner.close();
    }
}