package Pewarisan;

// Superclass (class induk) yang menjadi cetak biru umum untuk seluruh jenis karyawan
public class Karyawan {
    // Modifier 'protected': memungkinkan atribut diakses langsung oleh subclass
    // (anak kelas)
    // serta kelas-kelas lain yang berada dalam satu package
    protected String nama;
    protected String idKaryawan;
    protected double gajiPokok;

    // Constructor Superclass: menginisialisasi atribut dasar saat objek dibuat
    public Karyawan(String nama, String idKaryawan, double gajiPokok) {
        // Keyword 'this' digunakan untuk membedakan variabel instans dari parameter
        // konstruktor
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.gajiPokok = gajiPokok;
    }

    // Method dasar untuk menampilkan data, dirancang agar nantinya bisa di-override
    // oleh subclass
    public void tampilkanData() {
        System.out.println("ID Karyawan : " + idKaryawan);
        System.out.println("Nama        : " + nama);
        // String.format "%,.0f" digunakan untuk memformat angka dengan pemisah ribuan
        System.out.println("Gaji Pokok  : Rp " + String.format("%,.0f", gajiPokok));
       // tanpa desimal
     }
}