package TugasConstructor;

public class TokoUtama {
    public static void main(String[] args) {
        // 1. Instansiasi objek menggunakan Constructor
        Buku buku1 = new Buku("Pemrograman Java PBO", "Budi Raharjo", 85000.0, 10);
        Buku buku2 = new Buku("Struktur Data & Algoritma", "Siti Aminah", 95000.0, 4);

        // 2. Menampilkan informasi awal kedua buku
        System.out.println("=== INFORMASI AWAL INVENTARIS TOKO BUKU ===");
        buku1.tampilkanInfo();
        buku2.tampilkanInfo();

        // 3. Simulasi Transaksi Pembelian
        System.out.println("\n=== SIMULASI TRANSAKSI PEMBELIAN ===");
        System.out.println("Memproses pembelian 3 eksemplar buku pertama...");
        buku1.hitungTotalHarga(3);

        // 4. Menampilkan kembali informasi buku1 untuk membuktikan stok berkurang
        System.out.println("\n=== INFORMASI BUKU SETELAH TRANSAKSI ===");
        buku1.tampilkanInfo();
    }
}