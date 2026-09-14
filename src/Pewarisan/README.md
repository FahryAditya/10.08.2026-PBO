# 🏢 PAKET PEWARISAN - AKTIVITAS 3: STUDI KASUS PROYEK MINI (EVALUASI AKHIR 5 JP)

Sistem Manajemen Karyawan Software House berbasis Pemrograman Berorientasi Objek (Inheritance).

---

## 📜 DAFTAR BERKAS PROYEK
- 📜 **[Karyawan.java](file:///e:/Mimin%20Adresteia/pertemuan-4/src/Pewarisan/Karyawan.java)** → Parent Class (Superclass) dengan atribut `nama`, `idKaryawan`, `gajiPokok`, dan method `tampilkanData()`.
- 📜 **[Programmer.java](file:///e:/Mimin%20Adresteia/pertemuan-4/src/Pewarisan/Programmer.java)** → Subclass 1 (`extends Karyawan`) dengan atribut tambahan `bahasaPemrograman` dan `@Override tampilkanData()`.
- 📜 **[ProjectManager.java](file:///e:/Mimin%20Adresteia/pertemuan-4/src/Pewarisan/ProjectManager.java)** → Subclass 2 (`extends Karyawan`) dengan atribut tambahan `jumlahTim` dan `@Override tampilkanData()`.
- 📜 **[MainPerusahaan.java](file:///e:/Mimin%20Adresteia/pertemuan-4/src/Pewarisan/MainPerusahaan.java)** → Main Class tempat pengujian instansiasi objek `Programmer` dan `ProjectManager`.
- 📘 **[README.md Utama](file:///e:/Mimin%20Adresteia/pertemuan-4/README.md)** → Laporan Evaluasi Akhir 5 JP Lengkap & Terperinci.

---

## 🖥️ PERINTAH KOMPILASI & RUNNING
```bash
javac -d bin src/Pewarisan/Karyawan.java src/Pewarisan/Programmer.java src/Pewarisan/ProjectManager.java src/Pewarisan/MainPerusahaan.java
java -cp bin Pewarisan.MainPerusahaan
```
