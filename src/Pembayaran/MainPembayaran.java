package Pembayaran;

import java.util.ArrayList;
import java.util.List;

// =============================================================================
// 1. INTERFACE PEMBAYARAN
// =============================================================================
interface Pembayaran {
    // Method abstrak yang wajib di-override oleh kelas implementasi
    double hitungTotalBayar(double jumlah);
    void prosesTransaksi(double jumlah);
}

// =============================================================================
// 2. KELAS IMPLEMENTASI 1: TRANSFER BANK
// =============================================================================
class TransferBank implements Pembayaran {
    private String namaBank;
    private String nomorRekening;
    private double biayaAdminTetap;

    public TransferBank(String namaBank, String nomorRekening, double biayaAdminTetap) {
        this.namaBank = namaBank;
        this.nomorRekening = nomorRekening;
        this.biayaAdminTetap = biayaAdminTetap;
    }

    // --- METHOD OVERRIDING (Interface Pembayaran) ---
    @Override
    public double hitungTotalBayar(double jumlah) {
        return jumlah + biayaAdminTetap;
    }

    @Override
    public void prosesTransaksi(double jumlah) {
        double total = hitungTotalBayar(jumlah);
        System.out.println("[TRANSFER BANK - " + namaBank + "]");
        System.out.println("  No. Rekening : " + nomorRekening);
        System.out.println("  Jumlah Tagihan: Rp " + String.format("%,.2f", jumlah));
        System.out.println("  Biaya Admin   : Rp " + String.format("%,.2f", biayaAdminTetap));
        System.out.println("  TOTAL BAYAR   : Rp " + String.format("%,.2f", total));
        System.out.println("  Status        : BERHASIL MEMPROSES TRANSFER\n");
    }

    // --- METHOD OVERLOADING (Overload hitungTotalBayar) ---
    // Overload 1: Hitung total bayar dengan tambahan biaya admin kustom
    public double hitungTotalBayar(double jumlah, double biayaAdminTambahan) {
        return jumlah + biayaAdminTetap + biayaAdminTambahan;
    }

    // Overload 2: Hitung total bayar dengan kode promo diskon
    public double hitungTotalBayar(double jumlah, String kodePromo) {
        double diskon = 0.0;
        if (kodePromo.equalsIgnoreCase("HEMATBANK")) {
            diskon = 5000.0;
            System.out.println("  -> Promo 'HEMATBANK' diterapkan (Potongan Rp 5.000)");
        }
        return (jumlah - diskon) + biayaAdminTetap;
    }
}

// =============================================================================
// 3. KELAS IMPLEMENTASI 2: E-WALLET (DOMPET DIGITAL)
// =============================================================================
class EWallet implements Pembayaran {
    private String namaPenyedia;
    private String nomorHP;
    private double persentaseAdmin; // Misal 1.5%

    public EWallet(String namaPenyedia, String nomorHP, double persentaseAdmin) {
        this.namaPenyedia = namaPenyedia;
        this.nomorHP = nomorHP;
        this.persentaseAdmin = persentaseAdmin;
    }

    // --- METHOD OVERRIDING (Interface Pembayaran) ---
    @Override
    public double hitungTotalBayar(double jumlah) {
        double biayaAdmin = jumlah * (persentaseAdmin / 100.0);
        return jumlah + biayaAdmin;
    }

    @Override
    public void prosesTransaksi(double jumlah) {
        double total = hitungTotalBayar(jumlah);
        double biayaAdmin = jumlah * (persentaseAdmin / 100.0);
        System.out.println("[E-WALLET - " + namaPenyedia + "]");
        System.out.println("  No. HP/Akun   : " + nomorHP);
        System.out.println("  Jumlah Tagihan: Rp " + String.format("%,.2f", jumlah));
        System.out.println("  Biaya Admin (" + persentaseAdmin + "%): Rp " + String.format("%,.2f", biayaAdmin));
        System.out.println("  TOTAL BAYAR   : Rp " + String.format("%,.2f", total));
        System.out.println("  Status        : BERHASIL DIPROSES VIA E-WALLET\n");
    }

    // --- METHOD OVERLOADING ---
    // Overload 1: Hitung total bayar dengan potongan persentase diskon
    public double hitungTotalBayar(double jumlah, double persentaseDiskon) {
        double nilaiDiskon = jumlah * (persentaseDiskon / 100.0);
        double jumlahSetelahDiskon = jumlah - nilaiDiskon;
        double biayaAdmin = jumlahSetelahDiskon * (persentaseAdmin / 100.0);
        return jumlahSetelahDiskon + biayaAdmin;
    }

    // Overload 2: Hitung total bayar dengan kode promo khusus
    public double hitungTotalBayar(double jumlah, String kodePromo) {
        double diskon = 0.0;
        if (kodePromo.equalsIgnoreCase("CASHOF10")) {
            diskon = jumlah * 0.10; // Diskon 10%
            System.out.println("  -> Promo 'CASHOF10' diterapkan (Diskon 10%)");
        }
        double biayaAdmin = (jumlah - diskon) * (persentaseAdmin / 100.0);
        return (jumlah - diskon) + biayaAdmin;
    }
}

// =============================================================================
// 4. KELAS IMPLEMENTASI 3: KARTU KREDIT
// =============================================================================
class KartuKredit implements Pembayaran {
    private String nomorKartu;
    private String namaPemilik;
    private double persenBiayaService;

    public KartuKredit(String nomorKartu, String namaPemilik, double persenBiayaService) {
        this.nomorKartu = nomorKartu;
        this.namaPemilik = namaPemilik;
        this.persenBiayaService = persenBiayaService;
    }

    // --- METHOD OVERRIDING (Interface Pembayaran) ---
    @Override
    public double hitungTotalBayar(double jumlah) {
        double serviceFee = jumlah * (persenBiayaService / 100.0);
        return jumlah + serviceFee;
    }

    @Override
    public void prosesTransaksi(double jumlah) {
        double total = hitungTotalBayar(jumlah);
        double serviceFee = jumlah * (persenBiayaService / 100.0);
        System.out.println("[KARTU KREDIT]");
        System.out.println("  No. Kartu     : ****-****-****-" + nomorKartu.substring(nomorKartu.length() - 4));
        System.out.println("  Pemilik       : " + namaPemilik);
        System.out.println("  Jumlah Tagihan: Rp " + String.format("%,.2f", jumlah));
        System.out.println("  Service Fee (" + persenBiayaService + "%): Rp " + String.format("%,.2f", serviceFee));
        System.out.println("  TOTAL BAYAR   : Rp " + String.format("%,.2f", total));
        System.out.println("  Status        : OTORISASI KARTU KREDIT SUKSES\n");
    }

    // --- METHOD OVERLOADING ---
    // Overload 1: Hitung total dengan penambahan biaya penanganan kustom (handling fee)
    public double hitungTotalBayar(double jumlah, double handlingFee) {
        double serviceFee = jumlah * (persenBiayaService / 100.0);
        return jumlah + serviceFee + handlingFee;
    }
}

// =============================================================================
// 5. MAIN CLASS: UJI COBA POLIMORFISME DENGAN KOLEKSI/ARRAY OBJEK
// =============================================================================
public class MainPembayaran {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("   SIMULASI SISTEM PEMBAYARAN ONLINE (INTEGRASI POLIMORFISME)");
        System.out.println("==================================================================\n");

        // ---------------------------------------------------------------------
        // A. PENGUJIAN POLIMORFISME DINAMIS DENGAN ARRAY / KOLEKSI OBJEK
        // ---------------------------------------------------------------------
        System.out.println(">>> 1. UJI COBA POLIMORFISME DINAMIS (ARRAY / LIST OBJEK) <<<\n");

        // Membuat daftar koleksi objek bertipe interface 'Pembayaran'
        List<Pembayaran> daftarPembayaran = new ArrayList<>();

        // Memasukkan berbagai instansi subclass ke dalam koleksi interface Pembayaran
        daftarPembayaran.add(new TransferBank("Bank BCA", "1234567890", 6500.0));
        daftarPembayaran.add(new EWallet("GoPay", "08123456789", 1.5));
        daftarPembayaran.add(new KartuKredit("4567890123456789", "Adresteia Fahry", 2.5));

        double tagihanBelanja = 500000.0; // Tagihan belanja Rp 500.000

        // Mengiterasi koleksi objek secara polimorfis
        // Java akan memanggil method 'prosesTransaksi' dari masing-masing implementasi di runtime!
        int i = 1;
        for (Pembayaran p : daftarPembayaran) {
            System.out.println("--- Transaksi #" + (i++) + " ---");
            p.prosesTransaksi(tagihanBelanja);
        }

        System.out.println("------------------------------------------------------------------\n");

        // ---------------------------------------------------------------------
        // B. PENGUJIAN METHOD OVERLOADING (OVERLOAD DENGAN EXTRA ADMIN / PROMO)
        // ---------------------------------------------------------------------
        System.out.println(">>> 2. UJI COBA METHOD OVERLOADING (DISKON & ADMIN) <<<\n");

        TransferBank bca = new TransferBank("Bank Mandiri", "9876543210", 6500.0);
        EWallet gopay = new EWallet("OVO", "08987654321", 2.0);

        System.out.println("[Overloading TransferBank]");
        System.out.println("  Total standar (500rb)               : Rp " + String.format("%,.2f", bca.hitungTotalBayar(500000.0)));
        System.out.println("  Total + Admin Tambahan (2rb)       : Rp " + String.format("%,.2f", bca.hitungTotalBayar(500000.0, 2000.0)));
        System.out.println("  Total + Promo 'HEMATBANK'           : Rp " + String.format("%,.2f", bca.hitungTotalBayar(500000.0, "HEMATBANK")));

        System.out.println("\n[Overloading EWallet]");
        System.out.println("  Total standar (500rb)               : Rp " + String.format("%,.2f", gopay.hitungTotalBayar(500000.0)));
        System.out.println("  Total + Diskon 20%                  : Rp " + String.format("%,.2f", gopay.hitungTotalBayar(500000.0, 20.0)));
        System.out.println("  Total + Promo 'CASHOF10'            : Rp " + String.format("%,.2f", gopay.hitungTotalBayar(500000.0, "CASHOF10")));

        System.out.println("\n==================================================================");
    }
}
