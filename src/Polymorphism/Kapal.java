package Polymorphism;

/**
 * SUPERCLASS (Parent Class): Kapal
 * 
 * Class ini menjadi fondasi/induk untuk semua tipe kapal di wilayah pelabuhan.
 * Di dalam kelas ini disiapkan:
 * 1. Method yang akan di-OVERRIDE oleh subclass (Method Overriding).
 * 2. Method dengan beberapa variasi parameter yang sama (Method Overloading).
 */
public class Kapal {
    // Atribut yang dimiliki oleh semua jenis kapal
    private String namaKapal;
    private String nomorRegistrasi;
    private double kapasitasTon;

    // Constructor Superclass
    public Kapal(String namaKapal, String nomorRegistrasi, double kapasitasTon) {
        this.namaKapal = namaKapal;
        this.nomorRegistrasi = nomorRegistrasi;
        this.kapasitasTon = kapasitasTon;
    }

    // Getter untuk mengakses atribut private
    public String getNamaKapal() {
        return namaKapal;
    }

    public String getNomorRegistrasi() {
        return nomorRegistrasi;
    }

    public double getKapasitasTon() {
        return kapasitasTon;
    }

    // =========================================================================
    // 1. CONTOH METHOD OVERRIDING (Polimorfisme Dinamis / Runtime)
    // -------------------------------------------------------------------------
    // Method di bawah ini merupakan method bawaan dari Superclass.
    // Subclass (KapalKargo, KapalTanker, KapalPenumpang) akan menimpa/mengganti
    // (OVERRIDE) isi dari method ini sesuai dengan logika khusus masing-masing kapal.
    // =========================================================================
    
    /**
     * Menghitung biaya tambat/berlabuh dasar di pelabuhan per hari.
     * @param jumlahHari Durasi berlabuh dalam hari.
     * @return Biaya tambat dasar.
     */
    public double hitungBiayaTambat(int jumlahHari) {
        // Biaya dasar standar pelabuhan: Rp 500.000 / hari
        return jumlahHari * 500000.0;
    }

    /**
     * Menjelaskan prosedur proses bongkar muat kapal secara umum.
     */
    public void prosesBongkarMuat() {
        System.out.println("Kapal " + namaKapal + " sedang melakukan proses bongkar muat standar pelabuhan.");
    }

    // =========================================================================
    // 2. CONTOH METHOD OVERLOADING (Polimorfisme Statis / Compile-time)
    // -------------------------------------------------------------------------
    // Method di bawah ini memiliki NAMA YANG SAMA ('cetakManifest'),
    // tetapi memiliki JUMLAH / TIPE PARAMETER YANG BERBEDA.
    // Java menentukan method mana yang dijalankan berdasarkan argumen yang dikirim saat pemanggilan.
    // =========================================================================

    /**
     * Overload 1: Cetak manifest kapal tanpa parameter tambahan.
     */
    public void cetakManifest() {
        System.out.println("--- MANIFEST KAPAL ---");
        System.out.println("Nama Kapal       : " + namaKapal);
        System.out.println("No. Registrasi   : " + nomorRegistrasi);
        System.out.println("Kapasitas (Ton)  : " + kapasitasTon + " Ton");
    }

    /**
     * Overload 2: Cetak manifest dengan 1 parameter (Nama Kapten).
     * @param namaKapten Nama kapten yang memimpin kapal.
     */
    public void cetakManifest(String namaKapten) {
        cetakManifest(); // Memanggil Overload 1 agar tidak redundan
        System.out.println("Kapten Kapal     : " + namaKapten);
    }

    /**
     * Overload 3: Cetak manifest dengan 2 parameter (Nama Kapten & Jumlah ABK).
     * @param namaKapten Nama kapten yang memimpin kapal.
     * @param jumlahABK Jumlah Anak Buah Kapal (kru).
     */
    public void cetakManifest(String namaKapten, int jumlahABK) {
        cetakManifest(namaKapten); // Memanggil Overload 2 agar tidak redundan
        System.out.println("Jumlah ABK       : " + jumlahABK + " orang");
    }
}
