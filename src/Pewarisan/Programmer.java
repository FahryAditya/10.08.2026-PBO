package Pewarisan;

// Subclass: mewarisi atribut dan method dari superclass Karyawan via keyword 'extends'
public class Programmer extends Karyawan {
    // Enkapsulasi: atribut khusus Programmer, dibatasi hanya bisa diakses langsung
    // dalam class ini
    private String bahasaPemrograman;

    // Constructor Subclass: menerima data umum karyawan sekaligus atribut spesifik
    // programmer
    public Programmer(String nama, String idKaryawan, double gajiPokok, String bahasaPemrograman) {
        // Memanggil constructor superclass (Karyawan) untuk inisialisasi nama,
        // idKaryawan, dan gajiPokok
        super(nama, idKaryawan, gajiPokok);

        // Menyimpan nilai parameter ke variabel instans objek Programmer
        this.bahasaPemrograman = bahasaPemrograman;
    }

    // Method Overriding: memperkaya fungsionalitas method tampilkanData() milik
    // superclass
    @Override
    public void tampilkanData() {
        // Menjalankan logika tampilkanData() dari class induk (menampilkan ID, Nama,
        // dan Gaji)
        super.tampilkanData();

        // Menambahkan rincian output khusus posisi Programmer
        System.out.println("Posisi      : Programmer");
        System.out.println("Bahasa Pemg : " + bahasaPemrograman);
    }
}