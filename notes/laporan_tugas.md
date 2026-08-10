# LAPORAN TUGAS PBO — Bangun Datar & Operasi Bilangan

| | |
|---|---|
| **Nama** | Fahry Aditya Setiwan |
| **Kelas** | XI PPLG |
| **Mata Pelajaran** | Pemrograman Berorientasi Obyek |
| **Pokok Bahasan** | Class, Atribut, Method, Objek |
| **Tanggal** | 10 Agustus 2026 |

---

## A. Tujuan Pembelajaran

1. Membuat package dengan benar
2. Membuat class, atribut, dan method dengan benar
3. Membuat objek dari sebuah class
4. Membuat program utama (*main class*) yang memanfaatkan objek
5. Menjalankan project Java dengan benar

## B. Alat dan Bahan

| No | Alat/Bahan | Keterangan |
|----|------------|------------|
| 1 | Laptop / Komputer | Sistem operasi Windows |
| 2 | JDK (Java Development Kit) | JDK 24 |
| 3 | IDE / Text Editor | Visual Studio Code + ekstensi Java |
| 4 | Windows Explorer | Untuk mengamati struktur direktori project |

---

## TUGAS 1 — BANGUN DATAR

### Konsep yang Digunakan

Membuat package `BangunDatar` berisi 3 class bangun datar (masing-masing class memiliki **atribut** dan **method**), lalu sebuah *main class* untuk membuat objek dan menghitung luas & kelilingnya.

### Kode Program

**File: `src/BangunDatar/Persegi.java`**

```java
package BangunDatar;

public class Persegi {
    // Atribut bertipe integer
    public int sisi;

    // Method menghitung luas
    public int hitungLuas() {
        return sisi * sisi;
    }

    // Method menghitung keliling
    public int hitungKeliling() {
        return 4 * sisi;
    }
}
```

**File: `src/BangunDatar/PersegiPanjang.java`**

```java
package BangunDatar;

public class PersegiPanjang {
    // Atribut bertipe integer
    public int panjang;
    public int lebar;

    // Method menghitung luas
    public int hitungLuas() {
        return panjang * lebar;
    }

    // Method menghitung keliling
    public int hitungKeliling() {
        return 2 * (panjang + lebar);
    }
}
```

**File: `src/BangunDatar/Lingkaran.java`**

```java
package BangunDatar;

public class Lingkaran {
    // Atribut bertipe double untuk mendukung hasil desimal
    public double jariJari;

    // Method menghitung luas
    public double hitungLuas() {
        return Math.PI * jariJari * jariJari;
    }

    // Method menghitung keliling
    public double hitungKeliling() {
        return 2 * Math.PI * jariJari;
    }
}
```

**File: `src/BangunDatar/BangunDatarMain.java`**

```java
package BangunDatar;

import java.text.DecimalFormat;

public class BangunDatarMain {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        String baris = "=========================================";

        // ===== PERSEGI PANJANG =====
        System.out.println(baris);
        System.out.println("PERSEGI PANJANG");
        System.out.println(baris);

        PersegiPanjang pp = new PersegiPanjang();
        pp.panjang = 25;
        pp.lebar = 38;

        System.out.printf("%-12s : %d%n", "Panjang", pp.panjang);
        System.out.printf("%-12s : %d%n", "Lebar", pp.lebar);
        System.out.printf("%-12s : %d%n", "Luas", pp.hitungLuas());
        System.out.printf("%-12s : %d%n", "Keliling", pp.hitungKeliling());
        System.out.println();

        // ===== PERSEGI =====
        System.out.println(baris);
        System.out.println("PERSEGI");
        System.out.println(baris);

        Persegi persegiA = new Persegi();
        persegiA.sisi = 10;
        System.out.println("Persegi A (sisi = 10):");
        System.out.printf("  %-10s : %d%n", "Luas", persegiA.hitungLuas());
        System.out.printf("  %-10s : %d%n", "Keliling", persegiA.hitungKeliling());

        Persegi persegiB = new Persegi();
        persegiB.sisi = 15;
        System.out.println("Persegi B (sisi = 15):");
        System.out.printf("  %-10s : %d%n", "Luas", persegiB.hitungLuas());
        System.out.printf("  %-10s : %d%n", "Keliling", persegiB.hitungKeliling());
        System.out.println();

        // ===== LINGKARAN =====
        System.out.println(baris);
        System.out.println("LINGKARAN");
        System.out.println(baris);

        Lingkaran lingkaranX = new Lingkaran();
        lingkaranX.jariJari = 25;
        System.out.println("Lingkaran X (r = 25):");
        System.out.printf("  %-10s : %s%n", "Luas", df.format(lingkaranX.hitungLuas()));
        System.out.printf("  %-10s : %s%n", "Keliling", df.format(lingkaranX.hitungKeliling()));

        Lingkaran lingkaranZ = new Lingkaran();
        lingkaranZ.jariJari = 37;
        System.out.println("Lingkaran Z (r = 37):");
        System.out.printf("  %-10s : %s%n", "Luas", df.format(lingkaranZ.hitungLuas()));
        System.out.printf("  %-10s : %s%n", "Keliling", df.format(lingkaranZ.hitungKeliling()));
        System.out.println(baris);
        System.out.println("   Created By : Prabowo Galih Wibowo");
    }
}
```

### Penjelasan Kode

- Pada masing-masing class (`Persegi`, `PersegiPanjang`, `Lingkaran`) didefinisikan **atribut** dan dua **method** yaitu `hitungLuas()` dan `hitungKeliling()` yang mengembalikan nilai (`return`).
- Pada *main class* `BangunDatarMain`, dibuat beberapa **objek** dengan kata kunci `new`, contohnya objek `pp`, `persegiA`, `persegiB`, `lingkaranX`, `lingkaranZ`.
- Atribut diisi langsung lewat objek, misalnya `pp.panjang = 25`.
- `DecimalFormat("0.00")` dipakai untuk membulatkan hasil desimal lingkaran menjadi 2 angka di belakang koma.

### Hasil Output Program

```
=========================================
PERSEGI PANJANG
=========================================
Panjang      : 25
Lebar        : 38
Luas         : 950
Keliling     : 126

=========================================
PERSEGI
=========================================
Persegi A (sisi = 10):
  Luas       : 100
  Keliling   : 40
Persegi B (sisi = 15):
  Luas       : 225
  Keliling   : 60

=========================================
LINGKARAN
=========================================
Lingkaran X (r = 25):
  Luas       : 1963,50
  Keliling   : 157,08
Lingkaran Z (r = 37):
  Luas       : 4300,84
  Keliling   : 232,48
=========================================
   Created By : Prabowo Galih Wibowo
```

Program berhasil dikompilasi dan dijalankan tanpa error.

---

## TUGAS 2 — OPERASI BILANGAN

### Konsep yang Digunakan

Membuat class `OperasiBilangan` (dengan atribut `bil1`, `bil2` dan method operasi matematika) lalu *main class* `MyProject` untuk membaca input dari user dengan `Scanner` dan menampilkan hasilnya.

### Kode Program

**File: `src/OperasiBilangan/OperasiBilangan.java`**

```java
package OperasiBilangan;

public class OperasiBilangan {
    // Atribut untuk menyimpan dua bilangan (bisa double agar fleksibel)
    public double bil1;
    public double bil2;

    // Method penjumlahan
    public double hitungPenjumlahan() {
        return bil1 + bil2;
    }

    // Method pengurangan
    public double hitungPengurangan() {
        return bil1 - bil2;
    }

    // Method perkalian
    public double hitungPerkalian() {
        return bil1 * bil2;
    }

    // Method pembagian (menggunakan double)
    public double hitungPembagian() {
        return bil1 / bil2;
    }
}
```

**File: `src/OperasiBilangan/MyProject.java`**

```java
package OperasiBilangan;
import java.util.Scanner;
public class MyProject {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Membuat objek dari class OperasiBilangan
        OperasiBilangan op = new OperasiBilangan();

        System.out.print("Masukkan Bilangan Pertama : ");
        op.bil1 = input.nextDouble();

        System.out.print("Masukkan Bilangan Kedua   : ");
        op.bil2 = input.nextDouble();

        System.out.println("--- Hasil Operasi Bilangan ---");
        System.out.println("Penjumlahan : " + op.hitungPenjumlahan());
        System.out.println("Pengurangan : " + op.hitungPengurangan());
        System.out.println("Perkalian   : " + op.hitungPerkalian());
        System.out.println("Pembagian   : " + op.hitungPembagian());
    }
}
```

### Hasil Output Program

Input: `bil1 = 10`, `bil2 = 4`

```
Masukkan Bilangan Pertama : 10
Masukkan Bilangan Kedua   : 4
--- Hasil Operasi Bilangan ---
Penjumlahan : 14.0
Pengurangan : 6.0
Perkalian   : 40.0
Pembagian   : 2.5
```

Program berhasil meminta input dari user, menghitung, dan menampilkan hasil operasi dengan benar.

---

## C. Struktur Direktori Akhir Project

```
pertemuan-4/
├── .vscode/
│   ├── settings.json
│   ├── tasks.json
│   ├── launch.json
│   ├── extensions.json
│   └── run.ps1
├── src/
│   ├── App.java
│   ├── OperasiBilangan.java
│   ├── BangunDatar/
│   │   ├── BangunDatarMain.java
│   │   ├── Lingkaran.java
│   │   ├── Persegi.java
│   │   └── PersegiPanjang.java
│   ├── OperasiBilangan/
│   │   ├── MyProject.java
│   │   └── OperasiBilangan.java
│   ├── belajarjava/
│   ├── dasar/
│   ├── enkapsulasi/
│   └── kasir/
├── bin/                # hasil kompilasi (.class)
└── notes/
```

---

## D. Kesimpulan

1. **Class** adalah template yang berisi **atribut** (data) dan **method** (perilaku), contohnya class `Persegi` dengan atribut `sisi` dan method `hitungLuas()`.
2. **Atribut** adalah variabel milik class, contohnya `panjang`, `lebar`, `jariJari`, `bil1`, `bil2`.
3. **Method** yang memakai `return` mengembalikan nilai, misalnya `hitungKeliling()`, sedangkan yang memakai `void` hanya menjalankan aksi.
4. **Objek** dibuat dari class menggunakan kata kunci `new`, lalu atribut & method-nya dipanggil melalui objek tersebut.
5. Satu sumber data (class) dapat digunakan berkali-kali dengan membuat banyak objek, seperti objek `persegiA` dan `persegiB`.
6. Dengan pendekatan OOP, kode menjadi terstruktur, mudah dibaca, dan mudah dipakai ulang.