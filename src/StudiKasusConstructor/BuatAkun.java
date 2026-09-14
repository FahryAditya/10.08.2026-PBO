package StudiKasusConstructor;

/**
 * STUDI KASUS: REGISTRASI AKUN BARU
 * Membandingkan pembuatan objek TANPA vs PAKAI Constructor.
 */

// 1. TANPA CONSTRUCTOR (Risiko data null / kosong)
class AkunTanpaConstructor {
    String email;
    String password;

    public void tampilkanInfo() {
        System.out.println("Email    : " + email);
        System.out.println("Password : " + password);
        if (email == null || password == null) {
            System.out.println("Status   : ❌ AKUN RUSAK (Data belum diisi / null)");
        } else {
            System.out.println("Status   : ✅ Akun Aktif");
        }
    }
}


// 2. PAKAI CONSTRUCTOR (Data wajib diisi saat objek dibuat)
class AkunDenganConstructor {
    String email;
    String password;

    // Constructor berparameter
    public AkunDenganConstructor(String email, String password) {
        this.email = email;  //membedakan parameter dengan variabel lokal
        this.password = password;  //dan membedakan atribu dengan parameter
        System.out.println(" Registrasi Berhasil via Constructor!");
    }

    public void tampilkanInfo() {
        System.out.println("Email    : " + email);
        System.out.println("Password : " + password);
        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            System.out.println("Status   : AKUN INVALID (Email/Password kosong)");
        } else {
            System.out.println("Status   :  Akun Aktif & Valid");
        }
    }
}

