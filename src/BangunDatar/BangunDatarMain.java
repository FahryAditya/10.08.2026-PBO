package BangunDatar;

import java.text.DecimalFormat;

public class BangunDatarMain {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        String baris = "=========================================";

        // ===== PERSEGI PANJANG =====
        System.out.println(baris);
        System.out.println("PERSEGI PANJANG");
        System.out.println(baris);

        PersegiPanjang pp = new PersegiPanjang();
        pp.panjang = 25;
        pp.lebar = 38;

        System.out.printf("%-12s : %d%n", "Panjang", pp.panjang);
        System.out.printf("%-12s : %d%n", "Lebar", pp.lebar);
        System.out.printf("%-12s : %d%n", "Luas", pp.hitungLuas());
        System.out.printf("%-12s : %d%n", "Keliling", pp.hitungKeliling());
        System.out.println();

        // ===== PERSEGI =====
        System.out.println(baris);
        System.out.println("PERSEGI");
        System.out.println(baris);

        Persegi persegiA = new Persegi();
        persegiA.sisi = 10;
        System.out.println("Persegi A (sisi = 10):");
        System.out.printf("  %-10s : %d%n", "Luas", persegiA.hitungLuas());
        System.out.printf("  %-10s : %d%n", "Keliling", persegiA.hitungKeliling());

        Persegi persegiB = new Persegi();
        persegiB.sisi = 15;
        System.out.println("Persegi B (sisi = 15):");
        System.out.printf("  %-10s : %d%n", "Luas", persegiB.hitungLuas());
        System.out.printf("  %-10s : %d%n", "Keliling", persegiB.hitungKeliling());
        System.out.println();

        // ===== LINGKARAN =====
        System.out.println(baris);
        System.out.println("LINGKARAN");
        System.out.println(baris);

        Lingkaran lingkaranX = new Lingkaran();
        lingkaranX.jariJari = 25;
        System.out.println("Lingkaran X (r = 25):");
        System.out.printf("  %-10s : %s%n", "Luas", df.format(lingkaranX.hitungLuas()));
        System.out.printf("  %-10s : %s%n", "Keliling", df.format(lingkaranX.hitungKeliling()));

        Lingkaran lingkaranZ = new Lingkaran();
        lingkaranZ.jariJari = 37;
        System.out.println("Lingkaran Z (r = 37):");
        System.out.printf("  %-10s : %s%n", "Luas", df.format(lingkaranZ.hitungLuas()));
        System.out.printf("  %-10s : %s%n", "Keliling", df.format(lingkaranZ.hitungKeliling()));
        System.out.println(baris);

        // fungsi %sn%n adalah untuk membuat baris baru
        // fungsi %-12s adalah untuk membuat spasi 12 karakter
        // fungsi %d adalah untuk membuat bilangan bulat
        // fungsi %s adalah untuk membuat string
        // fungsi %n adalah untuk membuat baris baru
    }
}