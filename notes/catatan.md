method static adalah method milik class, bukan milik objek

method non static adalah method milik objek dan tidak memiliki kata static

jadi kedua nya di pakai dalam program utama dan di pakai dalam objek

method yang tidaak mengembalikan data disebut void

method yang mengembalikan data disebut return

---

## Perbedaan Method Static dan Non-Static

### Method Static
- Milik **class**, bukan milik objek
- Ditandai dengan kata kunci `static`
- Bisa dipanggil **tanpa membuat objek** dulu
- Dipanggil lewat nama class: `NamaClass.namaMethod()`
- Tidak bisa mengakses variabel/method non-static secara langsung
- Contoh: `Math.sqrt(16)`, `Integer.parseInt("5")`

### Method Non-Static
- Milik **objek** (instance)
- **Tidak** memakai kata kunci `static`
- Harus **membuat objek dulu** sebelum dipanggil
- Dipanggil lewat objek: `namaObjek.namaMethod()`
- Bisa mengakses variabel/method static maupun non-static

### Tabel Ringkasan

| Aspek              | Static                      | Non-Static                    |
|--------------------|-----------------------------|-------------------------------|
| Milik              | Class                       | Objek (instance)              |
| Kata kunci         | pakai `static`              | tanpa `static`                |
| Cara panggil       | `NamaClass.method()`        | `namaObjek.method()`          |
| Perlu buat objek?  | Tidak                       | Ya                            |
| Akses ke non-static| Tidak bisa langsung         | Bisa                          |

### Contoh Kode (Java)

```java
public class Contoh {
    // method static
    static void sapa() {
        System.out.println("Halo dari method static");
    }

    // method non-static
    void kenalan() {
        System.out.println("Halo dari method non-static");
    }

    public static void main(String[] args) {
        // static: langsung panggil tanpa objek
        sapa();

        // non-static: harus buat objek dulu
        Contoh obj = new Contoh();
        obj.kenalan();
    }
}
```

---

## Perbedaan Method yang Mengembalikan dan Tidak Mengembalikan Data

### Method Void (Tidak Mengembalikan Data)
- Ditandai dengan kata kunci `void`
- **Tidak** menghasilkan/mengembalikan nilai apa pun
- Biasanya hanya menjalankan aksi, misalnya menampilkan teks
- Tidak perlu (dan tidak boleh) pakai `return nilai;`
- Dipanggil langsung, tidak bisa disimpan ke variabel

### Method Return (Mengembalikan Data)
- Ditandai dengan **tipe data** hasilnya, misalnya `int`, `double`, `String`, `boolean`
- **Menghasilkan/mengembalikan** sebuah nilai
- Wajib pakai kata kunci `return` di dalamnya
- Nilai hasilnya bisa disimpan ke variabel atau dipakai langsung

### Tabel Ringkasan

| Aspek              | Void (Tidak Mengembalikan) | Return (Mengembalikan)        |
|--------------------|----------------------------|-------------------------------|
| Kata kunci tipe    | `void`                     | `int`, `String`, `double`, dll|
| Pakai `return`?    | Tidak                      | Ya (wajib)                    |
| Menghasilkan nilai?| Tidak                      | Ya                            |
| Bisa disimpan?     | Tidak                      | Bisa ke variabel              |

### Contoh Kode (Java)

```java
public class ContohReturn {
    // method void: tidak mengembalikan data, hanya menampilkan
    static void tampilkanSalam() {
        System.out.println("Selamat datang!");
    }

    // method return: mengembalikan hasil penjumlahan (tipe int)
    static int tambah(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        // void: langsung dipanggil
        tampilkanSalam();

        // return: hasilnya bisa disimpan ke variabel
        int hasil = tambah(5, 3);
        System.out.println("Hasil penjumlahan: " + hasil); // output: 8
    }
}
```