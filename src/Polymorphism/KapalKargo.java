package Polymorphism;

/**
 * SUBCLASS 1: KapalKargo
 * 
 * Kelas ini mewarisi (extends) dari kelas induk 'Kapal'.
 * Menambahkan atribut khusus 'jumlahKontainer' dan melakukan OVERRIDING
 * pada method 'hitungBiayaTambat' dan 'prosesBongkarMuat'.
 */
public class KapalKargo extends Kapal {
    private int jumlahKontainer;

    // Constructor Subclass
    public KapalKargo(String namaKapal, String nomorRegistrasi, double kapasitasTon, int jumlahKontainer) {
        // Memanggil constructor dari Superclass (Kapal) menggunakan super(...)
        super(namaKapal, nomorRegistrasi, kapasitasTon);
        this.jumlahKontainer = jumlahKontainer;
    }

    // =========================================================================
    // METHOD OVERRIDING (Polimorfisme Dinamis)
    // -------------------------------------------------------------------------
    // Anotasi @Override menandakan bahwa method ini menggantikan/menimpa
    // method dengan nama dan parameter yang sama di Superclass (Kapal).
    // =========================================================================

    /**
     * OVERRIDE 1: Menghitung biaya tambat khusus Kapal Kargo.
     * Rumus: Biaya dasar tambat (dari super.hitungBiayaTambat) + sewa crane per kontainer.
     */
    @Override
    public double hitungBiayaTambat(int jumlahHari) {
        double biayaDasar = super.hitungBiayaTambat(jumlahHari); // Memanggil logika biaya dasar dari kelas Kapal
        double biayaKontainer = jumlahKontainer * 50000.0;     // Tambahan Rp 50.000 per kontainer
        return biayaDasar + biayaKontainer;
    }

    /**
     * OVERRIDE 2: Menjelaskan proses bongkar muat khusus Kapal Kargo (menggunakan Gantry Crane).
     */
    @Override
    public void prosesBongkarMuat() {
        System.out.println("Kapal Kargo [" + getNamaKapal() + "] mengoperasikan derek pelabuhan (Gantry Crane) untuk memindahkan " 
            + jumlahKontainer + " kontainer ke area penumpukan (Yard).");
    }
}
