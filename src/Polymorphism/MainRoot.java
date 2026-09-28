package Polymorphism;

/**
 * MAIN CLASS: MainRoot
 * 
 * Kelas utama untuk menjalankan dan menguji penerapan konsep Polimorfisme:
 * 1. Dynamic Polymorphism (Method Overriding): Variabel bertipe Superclass (Kapal)
 *    dapat menampung berbagai objek dari Subclass (KapalKargo, KapalTanker, KapalPenumpang).
 * 2. Static Polymorphism (Method Overloading): Pemanggilan method 'cetakManifest'
 *    dengan variasi parameter yang berbeda-beda.
 */
public class MainRoot {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("    SISTEM MANAJEMEN OPERASIONAL PELABUHAN TANJUNG PRIOK");
        System.out.println("==========================================================\n");

        // -----------------------------------------------------------------
        // 1. DEMO METHOD OVERRIDING (Polimorfisme Dinamis / Runtime)
        // -----------------------------------------------------------------
        // PERHATIKAN: Tipe variabel adalah 'Kapal' (Superclass), 
        // tetapi objek yang dibuat adalah instansi Subclass masing-masing.
        Kapal kargo = new KapalKargo("MV Ocean Express", "KG-8891", 15000.0, 120);
        Kapal tanker = new KapalTanker("MT Pertamina Hero", "TK-4021", 25000.0, 5000000.0);
        Kapal penumpang = new KapalPenumpang("KMP Dharma Rencana", "PN-1044", 5000.0, 450);

        System.out.println("=== 1. PROSES BONGKAR MUAT (METHOD OVERRIDING) ===");
        // Walaupun dipanggil melalui tipe Kapal, Java secara otomatis mengeksekusi
        // method prosesBongkarMuat() versi subclass masing-masing di runtime!
        kargo.prosesBongkarMuat();
        tanker.prosesBongkarMuat();
        penumpang.prosesBongkarMuat();

        System.out.println("\n=== 2. HITUNG BIAYA TAMBAT / BERLABUH (OVERRIDING - 3 HARI) ===");
        // Method hitungBiayaTambat() yang dipanggil adalah versi override dari masing-masing subclass
        System.out.println("Biaya Tambat " + kargo.getNamaKapal() + "      : Rp " + String.format("%,.0f", kargo.hitungBiayaTambat(3)));
        System.out.println("Biaya Tambat " + tanker.getNamaKapal() + "    : Rp " + String.format("%,.0f", tanker.hitungBiayaTambat(3)));
        System.out.println("Biaya Tambat " + penumpang.getNamaKapal() + " : Rp " + String.format("%,.0f", penumpang.hitungBiayaTambat(3)));

        System.out.println("\n----------------------------------------------------------\n");

        // -----------------------------------------------------------------
        // 2. DEMO METHOD OVERLOADING (Polimorfisme Statis / Compile-time)
        // -----------------------------------------------------------------
        System.out.println("=== 3. CETAK MANIFEST KAPAL (METHOD OVERLOADING) ===");

        // Overload 1: Memanggil cetakManifest() tanpa parameter
        System.out.println("\n[Format 1: Tanpa Parameter]");
        kargo.cetakManifest();

        // Overload 2: Memanggil cetakManifest(String) dengan 1 parameter (nama kapten)
        System.out.println("\n[Format 2: Dengan Nama Kapten]");
        tanker.cetakManifest("Capt. Hendra Wijaya");

        // Overload 3: Memanggil cetakManifest(String, int) dengan 2 parameter (nama kapten & jumlah ABK)
        System.out.println("\n[Format 3: Dengan Nama Kapten & Jumlah ABK]");
        penumpang.cetakManifest("Capt. Agus Santoso", 35);

        System.out.println("\n==========================================================");
    }
}
