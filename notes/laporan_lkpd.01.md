# LAPORAN LKPD 01 — Pendahuluan Pemrograman Berorientasi Obyek (PBO)

| | |
|---|---|
| **Nama** | Fahry Aditya Setiwan |
| **Kelas** | XI PPLG  |
| **Mata Pelajaran** | Pemrograman Berorientasi Obyek |
| **Pokok Bahasan** | Pendahuluan PBO |
| **Tanggal** | 3 Agustus 2026 |

---

## A. Tujuan Pembelajaran

1. Membuat package dengan benar
2. Membuat class dan main-class Java dengan benar
3. Mendefinisikan atribut dari sebuah class dengan benar
4. Membuat method sederhana di dalam sebuah class dengan benar
5. Membuat obyek dengan benar dari class yang telah didefinisikan
6. Menjalankan project Java dengan benar

## B. Alat dan Bahan

| No | Alat/Bahan | Keterangan |
|----|------------|------------|
| 1 | Laptop / Komputer | Sistem operasi Windows |
| 2 | JDK (Java Development Kit) | JDK 24.0.2 |
| 3 | IDE / Text Editor | Visual Studio Code + ekstensi Java (pengganti NetBeans) |
| 4 | Windows Explorer | Untuk mengamati struktur direktori project |

> **Catatan:** Pada LKPD asli langkah praktikum menggunakan **NetBeans** dan nama project **MyProject1**. Karena saya tidak menggunakan NetBeans, praktikum dikerjakan dengan **Visual Studio Code** yang memiliki konsep struktur project yang sama (folder `src` = *Source Packages*). Hasil dan kesimpulannya tetap sesuai.

---

## KEGIATAN 1 — MEMBUAT PROJECT JAVA BARU

### Langkah-langkah
1. Buka IDE (Visual Studio Code).
2. Buat/buka folder project (pada praktikum ini: folder `pertemuan-4`).
3. Buat folder `src` sebagai tempat penyimpanan *source code* (sama seperti *Source Packages* di NetBeans).
4. Buat file Java pertama di dalam folder `src`.

### Hasil — Pengamatan Struktur Direktori Project (Windows Explorer)

Setelah project dibuat, berikut struktur direktori yang tampak:

```
pertemuan-4/
├── .vscode/          # folder konfigurasi VS Code
├── src/              # Source Packages (tempat file .java)
├── bin/              # tempat hasil kompilasi (.class)
└── README.md
```

Saat project dibuka di Windows Explorer, terlihat bahwa:
- Terdapat folder utama project (`pertemuan-4`).
- Di dalamnya ada folder **`src`** tempat menyimpan semua kode sumber, folder **`bin`** sebagai tempat hasil kompilasi, dan file konfigurasi IDE.

### Jawaban Kegiatan 1
> **Apa kesimpulan Anda terhadap struktur direktorinya?**
>
> Akan terbentuk sebuah project Java yang berada di dalam folder utama project. Project tersebut terdiri dari folder **`src`** (tempat *source code*) dan folder hasil kompilasi, sehingga struktur project menjadi terorganisir dan rapi. Hal ini sejalan dengan jawaban acuan bahwa "terbentuk project di dalam folder NetBeans" — di praktikum ini project terbentuk di dalam folder `pertemuan-4`.

---

## KEGIATAN 2 — MEMBUAT PACKAGE

### Langkah-langkah
1. Klik kanan pada folder `src` (*Source Packages* / *Default Package*).
2. Pilih **New → Java Package** (di VS Code: buat folder baru lalu deklarasikan `package ...;` di tiap file).
3. Beri nama package, contoh: `mypackage` (pada praktikum ini: **`enkapsulasi`**).
4. Klik Finish.

### Hasil — Pengamatan Struktur Direktori Setelah Pembuatan Package

Setelah package dibuat, struktur direktori `src` berubah menjadi:

```
src/
└── enkapsulasi/       # package baru
    ├── Enkapsulasi.java
    └── TokoHp.java
```

Package lain yang juga dibuat pada praktikum ini:

```
src/
├── belajarjava/       # package
├── dasar/             # package
├── enkapsulasi/       # package
└── kasir/             # package
```

### Jawaban Kegiatan 2
> **Apa yang terjadi terhadap struktur direktori project setelah pembuatan package?**
>
> Setelah package dibuat, akan terbentuk **folder baru di dalam folder `src`** yang namanya sama dengan nama package. Folder tersebut berfungsi sebagai wadah untuk menempatkan class-class Java. Jadi, package benar-benar direpresentasikan sebagai folder dalam struktur project. Ini sesuai jawaban acuan bahwa "terbentuk folder di dalam folder `src` yang bernama sama".

---

## KEGIATAN 3 — MEMBUAT CLASS DI DALAM PACKAGE

Setelah package `enkapsulasi` dibuat, selanjutnya membuat class `Enkapsulasi` dan class pendukung `TokoHp` di dalam package tersebut.

### Langkah-langkah
1. Klik kanan pada package `enkapsulasi`.
2. Pilih **New → Java Class**.
3. Beri nama class, contoh: `Enkapsulasi`.
4. Klik Finish.

### Kode Program

**File: `src/enkapsulasi/Enkapsulasi.java`**

```java
package enkapsulasi;

public class Enkapsulasi {

    private String merek;
    private String warna;
    private int harga;

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getMerek() {
        return merek;
    }

    public String getWarna() {
        return warna;
    }

    public int getHarga() {
        return harga;
    }

    public void info() {
        System.out.println("Merek : " + getMerek());
        System.out.println("Warna : " + getWarna());
        System.out.println("Harga : Rp " + getHarga());
        System.out.println("----------------------------");
    }
}
```

**File: `src/enkapsulasi/TokoHp.java`**

```java
package enkapsulasi;

public class TokoHp {

    private String namaToko;
    private String alamat;

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public String getAlamat() {
        return alamat;
    }

    public void infoToko() {
        System.out.println("===== TOKO HP =====");
        System.out.println("Nama Toko : " + getNamaToko());
        System.out.println("Alamat    : " + getAlamat());
        System.out.println("===================");
    }
}
```

---

## KEGIATAN 4 — MENDEFINISIKAN ATRIBUT DARI CLASS

Atribut adalah variabel yang dimiliki oleh sebuah class. Class `Enkapsulasi` memiliki atribut sebagai berikut:

| No | Atribut | Tipe Data | Keterangan |
|----|---------|-----------|------------|
| 1 | `merek` | String | Merk handphone |
| 2 | `warna` | String | Warna handphone |
| 3 | `harga` | int | Harga handphone |

Sedangkan class `TokoHp` memiliki atribut:

| No | Atribut | Tipe Data | Keterangan |
|----|---------|-----------|------------|
| 1 | `namaToko` | String | Nama toko |
| 2 | `alamat` | String | Alamat toko |

Atribut di atas dibuat dengan akses **`private`**, artinya hanya dapat diakses di dalam class itu sendiri (konsep enkapsulasi).

---

## KEGIATAN 5 — MEMBUAT METHOD DI DALAM CLASS

Method adalah fungsi/prosedur yang dimiliki class. Class `Enkapsulasi` memiliki beberapa method:

| No | Method | Fungsi |
|----|--------|--------|
| 1 | `setMerek(String merek)` | Mengisi nilai atribut `merek` |
| 2 | `setWarna(String warna)` | Mengisi nilai atribut `warna` |
| 3 | `setHarga(int harga)` | Mengisi nilai atribut `harga` |
| 4 | `getMerek()` | Mengambil nilai atribut `merek` |
| 5 | `getWarna()` | Mengambil nilai atribut `warna` |
| 6 | `getHarga()` | Mengambil nilai atribut `harga` |
| 7 | `info()` | Menampilkan seluruh data handphone |

Method `set...()` disebut **setter** (untuk mengisi data), method `get...()` disebut **getter** (untuk mengambil data), dan method `info()` adalah method sederhana yang menampilkan output.

---

## KEGIATAN 6 — MEMBUAT OBJEK DARI CLASS

Objek adalah instance (realisasi) dari sebuah class, dibuat menggunakan kata kunci **`new`**.

Kode pembuatan objek (dalam method `main`):

```java
TokoHp toko = new TokoHp();          // objek dari class TokoHp
toko.setNamaToko("Adresteia Phone Store");
toko.setAlamat("Balikpapan");

Enkapsulasi hp1 = new Enkapsulasi(); // objek 1 dari class Enkapsulasi
hp1.setMerek("Samsung S24 Ultra");
hp1.setWarna("Hitam");
hp1.setHarga(21000000);

Enkapsulasi hp2 = new Enkapsulasi(); // objek 2
hp2.setMerek("Oppo Reno 5G");
hp2.setWarna("Putih");
hp2.setHarga(3000000);

Enkapsulasi hp3 = new Enkapsulasi(); // objek 3
hp3.setMerek("Vivo V29 Pro");
hp3.setWarna("Biru");
hp3.setHarga(8000000);
```

Pada program di atas dibuat:
- **1 objek** dari class `TokoHp` (objek `toko`).
- **3 objek** dari class `Enkapsulasi` (objek `hp1`, `hp2`, `hp3`).

---

## KEGIATAN 7 — MEMBUAT MAIN CLASS DAN MENJALANKAN PROJECT

### Main Class
Main class adalah class yang memiliki method **`main()`**, yaitu titik awal program dijalankan. Pada program ini, method `main` berada di dalam class `Enkapsulasi`:

```java
public static void main(String[] args) {
    TokoHp toko = new TokoHp();
    toko.setNamaToko("Adresteia Phone Store");
    toko.setAlamat("Balikpapan");

    toko.infoToko();

    Enkapsulasi hp1 = new Enkapsulasi();
    hp1.setMerek("Samsung S24 Ultra");
    hp1.setWarna("Hitam");
    hp1.setHarga(21000000);

    Enkapsulasi hp2 = new Enkapsulasi();
    hp2.setMerek("Oppo Reno 5G");
    hp2.setWarna("Putih");
    hp2.setHarga(3000000);

    Enkapsulasi hp3 = new Enkapsulasi();
    hp3.setMerek("Vivo V29 Pro");
    hp3.setWarna("Biru");
    hp3.setHarga(8000000);

    System.out.println("\n===== DAFTAR HP =====");
    hp1.info();
    hp2.info();
    hp3.info();
}
```

### Menjalankan Project
Cara menjalankan:
1. Buka file `Enkapsulasi.java` pada editor.
2. Klik tombol **Run (▶)** di pojok kanan atas editor, atau
3. Jalankan perintah: `java -cp bin enkapsulasi.Enkapsulasi`

### Hasil Output Program

```
===== TOKO HP =====
Nama Toko : Adresteia Phone Store
Alamat    : Balikpapan
===================

===== DAFTAR HP =====
Merek : Samsung S24 Ultra
Warna : Hitam
Harga : Rp 21000000
----------------------------
Merek : Oppo Reno 5G
Warna : Putih
Harga : Rp 3000000
----------------------------
Merek : Vivo V29 Pro
Warna : Biru
Harga : Rp 8000000
----------------------------
```

Program berhasil dijalankan tanpa error (compile dan run sukses).

---

## E. Struktur Direktori Akhir Project

```
pertemuan-4/
├── .vscode/
│   ├── settings.json
│   ├── tasks.json
│   └── run.ps1
├── src/
│   ├── App.java
│   ├── belajarjava/
│   │   ├── Innerfunction.java
│   │   └── Main.java
│   ├── dasar/
│   │   ├── ContohMethod.java
│   │   ├── ContohNonStatic.java
│   │   └── Genap.java
│   ├── enkapsulasi/
│   │   ├── Enkapsulasi.java
│   │   └── TokoHp.java
│   └── kasir/
│       └── AplikasiKasir.java
├── bin/                # hasil kompilasi (.class)
└── notes/
```

---

## F. Kesimpulan

1. **Package** adalah folder pengelompokan class dalam project; setelah dibuat, muncul folder bernama sama di dalam folder `src`.
2. **Class** adalah template yang memiliki **atribut** (data) dan **method** (perilaku), contohnya class `Enkapsulasi` dengan atribut `merek`, `warna`, `harga`.
3. **Atribut** didefinisikan sebagai variabel di dalam class dan dibuat `private` agar aman (enkapsulasi).
4. **Method** digunakan untuk mengisi dan mengambil data (getter/setter) serta menampilkan data (`info()`).
5. **Objek** dibuat dari sebuah class menggunakan kata kunci `new`, misalnya objek `hp1`, `hp2`, `hp3`.
6. **Main class** dengan method `main()` adalah titik awal eksekusi program.
7. Dengan memahami package, class, atribut, method, objek, dan main class, program Java menjadi terstruktur, rapi, dan mudah dikembangkan.
