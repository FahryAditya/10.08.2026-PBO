package BangunDatar;

public class Lingkaran {
    // Atribut bertipe double untuk mendukung hasil desimal
    public double jariJari;

    // Method menghitung luas
    public double hitungLuas() {
        return Math.PI * jariJari * jariJari;
    }

    // Method menghitung keliling
    public double hitungKeliling() {
        return 2 * Math.PI * jariJari;
    }
}