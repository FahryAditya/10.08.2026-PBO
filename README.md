# LAPORAN ISU & REKAPITULASI PROYEK 

| | |
|---|---|
| **Nama** | Fahry Aditya Setiwan |
| **Kelas** | XI PPLG |
| **Mata Pelajaran** | Pemrograman Berorientasi Obyek (PBO) |
| **Tanggal** | 10 Agustus 2026 |

---

## 1. Rekap Proyek — Apa Saja yang Sudah Dibuat

Proyek berisi kumpulan latihan/tugas Java dengan struktur:

```
pertemuan-4/
├── .vscode/              # konfigurasi VS Code (tasks, launch, run.ps1, dll)
├── src/                  # source code (.java)
├── bin/                  # hasil kompilasi (.class)
├── notes/                # catatan & laporan
└── lib/                  # kosong (belum ada dependency JAR)
```

Build check: `javac` semua file → **berhasil (exit 0)**, tanpa error kompilasi.

---

### 2. Rincian per Folder (Tugas & Isinya)

| Folder / File | Tugas | Status |
|---|---|---|
| **`src/belajarjava/`** | Latihan dasar package java | Selesai |
| &nbsp;&nbsp;`Main.java` | Output "Halo dari package belajarjava!" | OK |
| &nbsp;&nbsp;`Innerfunction.java` | Hitung luas persegi + validasi input Scanner | OK |
| **`src/dasar/`** | Konsep method & OOP dasar | Sebagian |
| &nbsp;&nbsp;`ContohMethod.java` | void, return, overloading, rekursif, constructor | OK |
| &nbsp;&nbsp;`ContohNonStatic.java` | OOP objek mobil (non-static, method gas/rem/info) | OK |
| &nbsp;&nbsp;`Genap.java` | Looping genap/ganjil 0–20 | OK |
| &nbsp;&nbsp;`BangunDatar.java` | Rencana tugas bangun datar | **KOSONG (0 byte)** |
| &nbsp;&nbsp;`HitungLuas.java` | Rencana program hitung luas | **KOSONG (0 byte)** |
| **`src/enkapsulasi/`** | Enkapsulasi (getter/setter) — LKPD 01 | Selesai |
| &nbsp;&nbsp;`Enkapsulasi.java` | Class HP + main (3 objek) | OK |
| &nbsp;&nbsp;`TokoHp.java` | Class pendukung TokoHp | OK |
| **`src/kasir/`** | Small program kasir | Selesai |
| &nbsp;&nbsp;`AplikasiKasir.java` | Kalkulator total belanja (Scanner) | OK |
| **`src/BangunDatar/`** | TUGAS 1 — bangun datar | Selesai |
| &nbsp;&nbsp;`Persegi.java`, `PersegiPanjang.java`, `Lingkaran.java` | Atribut + method hitungLuas/hitungKeliling | OK |
| &nbsp;&nbsp;`BangunDatarMain.java` | Main: objek + DecimalFormat | OK |
| **`src/OperasiBilangan/`** | TUGAS 2 — operasi bilangan | Selesai |
| &nbsp;&nbsp;`OperasiBilangan.java` | Atribut `bil1`,`bil2` + 4 method operasi | OK |
| &nbsp;&nbsp;`MyProject.java` | Main: input Scanner → hasil operasi | OK |
| **`src/MenghitungDerajat/`** | Konversi suhu | Selesai |
| &nbsp;&nbsp;`Termometer.java` | Constructor + konversi °C→°F/°R/K | OK |
| &nbsp;&nbsp;`Main.java` | Input suhu → tampil semua konversi | OK |
| **`src/LKPD/`** | Folder tugas LKPD | Belum selesai |
| &nbsp;&nbsp;`LKPD.java` | (file kosong) | **KOSONG (0 byte)** |
| &nbsp;&nbsp;`PRABOWOGABUT.java` | main masih kosong | **BELUM DIISI** |
| **`src/` (root)** | Latihan awal | Selesai |
| &nbsp;&nbsp;`App.java` | Main uji class OperasiBilangan | **ADA BUG (lihat isu)** |
| &nbsp;&nbsp;`OperasiBilangan.java` | Class operasi bilangan (package default) | **ADA BUG (lihat isu)** |

**Dokumen yang sudah dibuat di `notes/`:**
- `catatan.md` — catatan material (static vs non-static, void vs return, akses modifier)
- `LKPD.md` — ringkasan langkah LKPD
- `laporan_lkpd.01.md` + `.docx` — laporan LKPD 01 (enkapsulasi)
- `laporan_tugas.md` — laporan Tugas 1 & 2 (BangunDatar, OperasiBilangan)

---

## 3. Daftar Isu / Masalah yang Ditemukan

### 🔴 ISU-1 — App.java: hasil operasi selalu 0 (bug logika)
**File:** `src/App.java:8-12`
`setHasil()` tidak pernah dipanggil, padahal `getHasil()` dipakai untuk semua operator.
```
10 + 20 = 0
10 - 20 = 0
...
```
Semua baris menampilkan `= 0`. Saran: gunakan hasil dari tujuan operasi yang sesuai, mis. `getA()+getB()`, atau panggil `setHasil()` dengan operator yang tepat per baris.

### 🟠 ISU-2 — Pembagian integer menghasilkan 0
**File:** `src/App.java` (`OperasiBilangan.java:37`)
`getA() / getB()` memakai `int`, jadi `10/20 = 0`. Jika ingin desimal, atribut harus `double`.
(Pada `src/OperasiBilangan/` versi tugas sudah benar memakai `double`.)

### 🟠 ISU-3 — Method `setHasil` tidak konsisten
**File:** `src/OperasiBilangan.java:15-17`
`setHasil(int a, int b)` hanya menjumlahkan (`a + b`), bukan operasi yang diminta.
Menimbulkan kebingungan: tidak dipakai di `App.java`, dan namanya tidak menggambarkan operasi spesifik.

### 🟡 ISU-4 — File kosong (belum dikerjakan)
- `src/dasar/BangunDatar.java` (0 byte)
- `src/dasar/HitungLuas.java` (0 byte)
- `src/LKPD/LKPD.java` (0 byte)

### 🟡 ISU-5 — PRABOWOGABUT.java masih template
**File:** `src/LKPD/PRABOWOGABUT.java`
`main` kosong, belum ada logika/program.

### 🟡 ISU-6 — Dua class `OperasiBilangan` berbeda (potensial rancu)
Ada dua class bernama sama di lokasi berbeda:
- `src/OperasiBilangan.java` (package default, atribut `int`)
- `src/OperasiBilangan/OperasiBilangan.java` (package `OperasiBilangan`, atribut `double`)

Tidak bentrok saat kompilasi (beda package), tetapi bisa membingungkan saat dikerjakan kembali.

### 🟡 ISU-7 — README belum memuat program terbaru
**File:** `README.md`
Tabel perintah menjalankan belum menyertakan `MenghitungDerajat.Main`, `BangunDatar.BangunDatarMain`, `OperasiBilangan.MyProject`, dan belum menyebut README struktur `BangunDatar/`, `OperasiBilangan/`, `MenghitungDerajat/`, `LKPD/`.

### 🟡 ISU-8 — Paket kosong & file pendukung
- Folder `lib/` kosong (tidak masalah bila tidak butuh JAR, sebaiknya hapus atau isi).
- File `notes/Enkapsulation.png`, `NewOBject.png`, `TokoHp.png` adalah screenshot lampiran laporan (ok).
- `Bawaan`: `.vscode/tasks copy.json` — file salinan, bisa dihapus agar bersih.

---

## 4. Ringkasan Kesimpulan

| Aspek | Kondisi |
|---|---|
| Total file source `.java` | 21 file |
| Program yang jalan & benar | ±8 (belajarjava, dasar, enkapsulasi, kasir, BangunDatar, OperasiBilangan/MyProject, MenghitungDerajat) |
| File kosong | 3 (BangunDatar.java, HitungLuas.java, LKPD.java) |
| File belum diisi | 1 (PRABOWOGABUT.java) |
| Bug logika | 1 (App.java → hasil selalu 0) |
| Kompilasi | Sukses (exit 0) |
| Laporan dokumen | LKPD 01 & Tugas 1–2 sudah dilaporkan |
