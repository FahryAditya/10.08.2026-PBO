# Adresteia Code

Name : Fahry Aditya Setiwan


Proyek belajar pemrograman Java — Kumpulan tugas dan latihan.

## Struktur Proyek

```
adresteia/
├── src/
│   ├── App.java                          # Program utama (Hello World)
│   ├── belajarjava/
│   │   ├── Main.java                     # Main package belajarjava
│   │   └── Innerfunction.java            # Fungsi hitung luas persegi
│   ├── dasar/
│   │   ├── ContohMethod.java             # Method void, return, overloading, rekursif
│   │   ├── ContohNonStatic.java          # OOP: objek Mobil (non-static)
│   │   └── Genap.java                    # Looping: angka genap/ganjil
│   ├── enkapsulasi/
│   │   ├── Enkapsulasi.java              # Encapsulation: getter/setter HP
│   │   └── TokoHp.java                   # Class TokoHp (pendukung)
│   └── kasir/
│       └── AplikasiKasir.java            # Program kasir sederhana
├── notes/
│   └── catatan.md                        # Catatan belajar Java
├── lib/                                  # Dependencies (JAR)
├── bin/                                  # Output compiled
└── html/                                 # File HTML pendukung
```

### Cara paling mudah (VS Code)

1. Buka file `.java` yang mau dijalankan (misal `src/kasir/AplikasiKasir.java`).
2. Klik tombol **Run** (▶) di pojok kanan atas editor.
3. Program langsung dikompilasi & dijalankan otomatis — tidak perlu perintah manual.

> Semua kode dikompilasi ke folder `bin/` lalu dijalankan berdasarkan package-nya.

### Kompilasi semua file sekaligus

```bash
javac -d bin src/**/*.java
```

### Menjalankan program manual

| Program | Perintah |
|---------|----------|
| Hello World | `java -cp bin App` |
| Innerfunction | `java -cp bin belajarjava.Innerfunction` |
| ContohMethod | `java -cp bin dasar.ContohMethod` |
| ContohNonStatic | `java -cp bin dasar.ContohNonStatic` |
| Genap | `java -cp bin dasar.Genap` |
| Enkapsulasi | `java -cp bin enkapsulasi.Enkapsulasi` |
| AplikasiKasir | `java -cp bin kasir.AplikasiKasir` |
| Main | `java -cp bin belajarjava.Main` |

### Alternatif: Code Runner (VS Code)

Jika memakai ekstensi **Code Runner**, tekan `Ctrl+Alt+N` untuk compile & run file yang sedang dibuka (tombol ▶ di pojok kanan atas juga bisa).

## Materi yang Dipelajari

- **Dasar Java**: variabel, tipe data, looping, percabangan
- **Method**: void, return, static, non-static, overloading, rekursif
- **OOP**: class, object, constructor, encapsulation (getter/setter)
- **Package**: struktur package Java
- **Input/Output**: Scanner, print
