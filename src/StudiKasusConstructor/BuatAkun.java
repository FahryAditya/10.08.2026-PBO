package StudiKasusConstructor;

/**
 * STUDI KASUS: REGISTRASI AKUN BARU
 * File ini berisi perbandingan antara pembuatan objek TANPA Constructor
 * vs PAKAI Constructor berparameter untuk memvalidasi data wajib (Email & Password).
 */

// ============================================================================
// 1. KASUS TANPA CONSTRUCTOR
// ============================================================================
/**
 * Class AkunTanpaConstructor
 * Menggunakan default constructor bawaan Java (tanpa parameter).
 * Risikonya: Akun (objek) bisa terbuat duluan di memori, tetapi nilai atributnya
 * belum diisi (masih null), menyebabkan akun bernilai kosong / rusak.
 */
class AkunTanpaConstructor {
    // Atribut akun
    String email;
    String password;

    /**
     * Method untuk menampilkan informasi akun.
     * Akan mendeteksi jika data email/password masih null (belum diisi).
     */
    public void tampilkanInfo() {
        System.out.println("Email    : " + email);
        System.out.println("Password : " + password);

        // Pengecekan apakah data masih bernilai null
        if (email == null || password == null) {
            System.out.println("Status   : ❌ AKUN KOSONG / RUSAK (Terbuat tanpa data lengkap!)");
        } else {
            System.out.println("Status   : ✅ Akun Aktif");
        }
    }
}

// ============================================================================
// 2. KASUS PAKAI CONSTRUCTOR
// ============================================================================
/**
 * Class AkunDenganConstructor
 * Menggunakan Constructor Berparameter.
 * Solusinya: Saat tombol "Daftar" / instansiasi dipanggil (new Akun(...)),
 * sistem WAJIB meminta Email dan Password sekaligus, serta memvalidasi data tersebut.
 */
class AkunDenganConstructor {
    // Atribut akun
    String email;
    String password;
    boolean isValid; // Penanda status keabsahan pembuatan akun

    /**
     * Constructor Parameter: Memaksa pengirim mendefinisikan email & password saat objek dibuat.
     * @param email    Email calon pengguna
     * @param password Password calon pengguna
     */
    public AkunDenganConstructor(String email, String password) {
        // Validasi: Email dan Password tidak boleh null maupun berupa string kosong ("")
        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            System.out.println("❌ Registrasi Gagal! Email dan Password WAJIB diisi sekaligus.");
            this.isValid = false; // Akun dianggap tidak sah / gagal dibuat
        } else {
            // Jika data lengkap dan valid, set data ke atribut objek
            this.email = email;
            this.password = password;
            this.isValid = true; // Akun sah dan aktif
            System.out.println("✅ Registrasi Berhasil! Akun terdaftar secara sah.");
        }
    }

    /**
     * Method untuk menampilkan rincian informasi akun yang telah dibuat.
     */
    public void tampilkanInfo() {
        // Jika registrasi awal gagal, informasi akun tidak akan ditampilkan
        if (!isValid) {
            System.out.println("Status   : ⛔ Akun Tidak Dibuat (Data tidak lengkap)");
            return;
        }
        
        System.out.println("Email    : " + email);
        System.out.println("Password : " + password);
        System.out.println("Status   : ✅ Akun Aktif & Valid");
    }
}

/**
 * Class BuatAkun
 * Sebagai class pembungkus file Java di package StudiKasusConstructor.
 */
public class BuatAkun {
    // Class utama penampung model data registrasi akun
}
