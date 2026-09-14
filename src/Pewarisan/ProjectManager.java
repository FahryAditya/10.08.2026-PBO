package Pewarisan;

// Subclass: mewarisi karakteristik dan perilaku dari superclass Karyawan via keyword 'extends'
public class ProjectManager extends Karyawan {
    // Enkapsulasi: atribut privat yang hanya dapat diakses langsung di dalam class
    // ProjectManager
    private int jumlahTim;

    // Constructor Subclass: menerima parameter data umum karyawan dan data khusus
    // Project Manager
    public ProjectManager(String nama, String idKaryawan, double gajiPokok, int jumlahTim) {
        // Memanggil constructor superclass (Karyawan) untuk inisialisasi nama,
        // idKaryawan, dan gajiPokok
        super(nama, idKaryawan, gajiPokok);

        // Menyimpan nilai parameter ke variabel instans objek ProjectManager
        this.jumlahTim = jumlahTim;
    }

    // Method Overriding: memperluas fungsionalitas method tampilkanData() milik
    // class induk
    @Override
    public void tampilkanData() {
        // Menjalankan implementasi tampilkanData() dari class induk (Karyawan)
        super.tampilkanData();

        // Menambahkan rincian output khusus untuk posisi Project Manager
        System.out.println("Posisi      : Project Manager");
        System.out.println("Jumlah Tim  : " + jumlahTim + " Orang");
    }
}