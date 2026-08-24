# Refleksi Tugas Constructor

---

## Pertanyaan 1 (Q1)
> **Apa keuntungan menggunakan constructor dibandingkan mengisi nilai atribut satu per satu secara manual setelah objek dibuat?**

### Jawaban (A1)
* **Efisiensi Kode:** Pengisian nilai atribut dapat dilakukan langsung dalam satu baris saat objek diinstansiasi (`new Buku(...)`), tanpa perlu menetapkan atribut satu per satu secara berulang (`buku.judul = ...`, `buku.penulis = ...`).
* **Keamanan & Konsistensi Data:** Memastikan setiap objek yang dibuat langsung memiliki keadaan awal (*state*) data yang valid dan mencegah adanya objek yang tidak lengkap atau bernilai kosong (`null`/`0`) saat digunakan.

---

## Pertanyaan 2 (Q2)
> **Mengapa method `hitungTotalHarga` perlu melakukan pengecekan kondisi apakah `jumlahBeli <= stok`? Apa dampaknya jika logika tersebut tidak ada di dalam program?**

### Jawaban (A2)
* **Alasan:** Pengecekan ini diperlukan untuk menjamin ketersediaan barang di inventaris sebelum transaksi diproses dan mencegah stok fisik bernilai minus.
* **Dampak Jika Tidak Ada Logika:** Transaksi akan tetap diproses seolah-olah berhasil meskipun pembeli meminta barang melebihi stok yang ada. Hal ini mengakibatkan data inventaris menjadi tidak akurat (stok negatif) dan memicu kerugian finansial atau kekacauan operasional toko.