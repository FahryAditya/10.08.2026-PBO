package TugasConstructor;
public class Buku {
    // Atribut
    String judul;
    String penulis;
    double harga;
    int stok;

    // Constructor berparameter untuk inisialisasi data
    public Buku(String judul, String penulis, double harga, int stok) {
        this.judul = judul;
        this.penulis = penulis;
        this.harga = harga;
        this.stok = stok;
    }

    // Method untuk menampilkan informasi detail buku
    public void tampilkanInfo() {
        System.out.println("---------------------------------");
        System.out.println("Judul   : " + judul);
        System.out.println("Penulis : " + penulis);
        System.out.println("Harga   : Rp " + harga);
        System.out.println("Stok    : " + stok + " eksemplar");
        System.out.println("---------------------------------");
    }

    // Method untuk menghitung total harga dan memproses transaksi
    public double hitungTotalHarga(int jumlahBeli) {
        if (jumlahBeli <= 0) {
            System.out.println("Jumlah pembelian harus lebih dari 0!");
            return 0;
        }

        // Pengecekan ketersediaan stok
        if (jumlahBeli <= stok) {
            double total = harga * jumlahBeli;
            stok -= jumlahBeli; // Memperbarui (mengurangi) sisa stok
            System.out.println("Transaksi Berhasil!");
            System.out.println("Membeli " + jumlahBeli + " eksemplar '" + judul + "'");
            System.out.println("Total Bayar : Rp " + total);
            return total;
        } else {
            System.out.println("Transaksi Gagal! Stok '" + judul + "' tidak mencukupi.");
            System.out.println("Stok tersedia: " + stok + " | Jumlah diminta: " + jumlahBeli);
            return 0;
        }
    }
}