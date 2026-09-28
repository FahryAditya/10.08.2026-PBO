package Polymorphism;

/**
 * SUBCLASS 2: KapalTanker
 * 
 * Kelas ini mewarisi (extends) dari kelas induk 'Kapal'.
 * Menambahkan atribut khusus 'volumeLiters' (muatan cair/minyak) dan melakukan OVERRIDING
 * pada method 'hitungBiayaTambat' dan 'prosesBongkarMuat'.
 */
public class KapalTanker extends Kapal {
    private double volumeLiters;

    // Constructor Subclass
    public KapalTanker(String namaKapal, String nomorRegistrasi, double kapasitasTon, double volumeLiters) {
        // Memanggil constructor dari Superclass (Kapal) menggunakan super(...)
        super(namaKapal, nomorRegistrasi, kapasitasTon);
        this.volumeLiters = volumeLiters;
    }

    // =========================================================================
    // METHOD OVERRIDING (Polimorfisme Dinamis)
    // =========================================================================

    /**
     * OVERRIDE 1: Menghitung biaya tambat khusus Kapal Tanker.
     * Rumus: Biaya dasar tambat + Biaya penanganan risiko bahan berbahaya (Hazard Safety Fee).
     */
    @Override
    public double hitungBiayaTambat(int jumlahHari) {
        double biayaDasar = super.hitungBiayaTambat(jumlahHari);
        double biayaHazard = 2000000.0; // Biaya keamanan bahan berbahaya Rp 2.000.000
        return biayaDasar + biayaHazard;
    }

    /**
     * OVERRIDE 2: Menjelaskan proses bongkar muat khusus Kapal Tanker (menggunakan pompa pipa cair).
     */
    @Override
    public void prosesBongkarMuat() {
        System.out.println("Kapal Tanker [" + getNamaKapal() + "] menghubungkan pipa penyalur keselamatan tinggi untuk menyedot " 
            + String.format("%.0f", volumeLiters) + " liter bahan bakar ke tangki penyimpanan dermaga.");
    }
}
