package BangunDatar;

public class PersegiPanjang {
    // Atribut bertipe integer
    public int panjang;
    public int lebar;

    // Method menghitung luas
    public int hitungLuas() {
        return panjang * lebar;
    }

    // Method menghitung keliling
    public int hitungKeliling() {
        return 2 * (panjang + lebar);
    }
}