package Polymorphism;

/**
 * SUBCLASS 3: KapalPenumpang
 * 
 * Kelas ini mewarisi (extends) dari kelas induk 'Kapal'.
 * Menambahkan atribut khusus 'jumlahPenumpang' dan melakukan OVERRIDING
 * pada method 'hitungBiayaTambat' dan 'prosesBongkarMuat'.
 */
public class KapalPenumpang extends Kapal {
    private int jumlahPenumpang;

    // Constructor Subclass
    public KapalPenumpang(String namaKapal, String nomorRegistrasi, double kapasitasTon, int jumlahPenumpang) {
        // Memanggil constructor dari Superclass (Kapal) menggunakan super(...)
        super(namaKapal, nomorRegistrasi, kapasitasTon);
        this.jumlahPenumpang = jumlahPenumpang;
    }

    // =========================================================================
    // METHOD OVERRIDING (Polimorfisme Dinamis)
    // =========================================================================

    /**
     * OVERRIDE 1: Menghitung biaya tambat khusus Kapal Penumpang.
     * Rumus: Biaya dasar tambat + Pas Pelabuhan per penumpang.
     */
    @Override
    public double hitungBiayaTambat(int jumlahHari) {
        double biayaDasar = super.hitungBiayaTambat(jumlahHari);
        double pasPelabuhan = jumlahPenumpang * 10000.0; // Pas pelabuhan Rp 10.000 per orang
        return biayaDasar + pasPelabuhan;
    }

    /**
     * OVERRIDE 2: Menjelaskan proses bongkar muat khusus Kapal Penumpang (menggunakan Garbarata).
     */
    @Override
    public void prosesBongkarMuat() {
        System.out.println("Kapal Penumpang [" + getNamaKapal() + "] membuka garbarata/jembatan dermaga untuk menurunkan " 
            + jumlahPenumpang + " penumpang dan kendaraan penumpang.");
    }
}
