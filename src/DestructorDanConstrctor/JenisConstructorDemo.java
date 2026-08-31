package DestructorDanConstrctor;

/**
 * DEMO BERBAGAI JENIS CONSTRUCTOR DALAM JAVA
 * 
 * File ini memuat contoh dan penjelasan lengkap dari:
 * 1. Default Constructor (Implisit & Eksplisit)
 * 2. Parameterized Constructor
 * 3. Copy Constructor
 * 4. Private Constructor (Singleton & Utility Class)
 * 5. Named / Factory Constructor (Static Factory Method di Java)
 */

// ============================================================================
// 1. DEFAULT CONSTRUCTOR (IMPLISIT & EKSPLISIT)
// ============================================================================

/**
 * Contoh Default Constructor Implisit:
 * Pengembang tidak menuliskan constructor sama sekali.
 * Compiler Java otomatis menyediakan constructor tanpa parameter dengan nilai default.
 */
class ProdukImplisit {
    String nama; // Nilai default: null
    double harga; // Nilai default: 0.0
}

/**
 * Contoh Default Constructor Eksplisit:
 * Pengembang menuliskan constructor tanpa parameter secara manual
 * untuk memberikan nilai awal default tertentu.
 */
class ProdukEksplisit {
    String nama;
    double harga;

    // Default Constructor Eksplisit
    public ProdukEksplisit() {
        this.nama = "Produk Tanpa Nama";
        this.harga = 0.0;
    }
}

// ============================================================================
// 2. PARAMETERIZED CONSTRUCTOR (CONSTRUCTOR BERPARAMETER)
// ============================================================================

/**
 * Parameterized Constructor:
 * Menerima satu atau lebih parameter untuk mengisi properti objek secara dinamis.
 */
class Mobil {
    String merk;
    String warna;
    int tahun;

    // Parameterized Constructor
    public Mobil(String merk, String warna, int tahun) {
        this.merk = merk;
        this.warna = warna;
        this.tahun = tahun;
    }

    // ============================================================================
    // 3. COPY CONSTRUCTOR
    // ============================================================================
    /**
     * Copy Constructor:
     * Menerima parameter berupa objek lain dari kelas yang sama (Mobil)
     * untuk menduplikat/menyalin seluruh data objek tersebut ke objek baru.
     */
    public Mobil(Mobil mobilLain) {
        this.merk = mobilLain.merk;
        this.warna = mobilLain.warna;
        this.tahun = mobilLain.tahun;
    }

    public void tampilkanInfo() {
        System.out.println("Mobil: " + merk + " | Warna: " + warna + " | Tahun: " + tahun);
    }
}

// ============================================================================
// 4. PRIVATE CONSTRUCTOR (SINGLETON & UTILITY CLASS)
// ============================================================================

/**
 * Contoh 4a: Private Constructor pada Singleton Pattern
 * Mencegah instansiasi langsung dari luar kelas menggunakan 'new'.
 * Hanya memperbolehkan satu objek (single instance) yang diakses lewat method statis.
 */
class DatabaseConnection {
    private static DatabaseConnection instance;

    // Private Constructor
    private DatabaseConnection() {
        System.out.println("-> Koneksi Database berhasil diinisialisasi (Private Constructor).");
    }

    // Method statis untuk mendapatkan satu-satunya instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}

/**
 * Contoh 4b: Private Constructor pada Utility Class
 * Digunakan jika kelas hanya berisi method-method statis (seperti MathUtils).
 */
class MathUtils {
    // Private Constructor mencegah kelas diinstansiasi
    private MathUtils() {
        throw new UnsupportedOperationException("Utility class tidak boleh diinstansiasi!");
    }

    public static int tambah(int a, int b) {
        return a + b;
    }
}

// ============================================================================
// 5. NAMED / FACTORY CONSTRUCTOR (STATIC FACTORY METHOD DI JAVA)
// ============================================================================

/**
 * Di Java, Named / Factory Constructor diimplementasikan menggunakan
 * "Static Factory Method". Method statis ini memberikan nama yang deskriptif
 * untuk skenario pembuatan objek yang berbeda-beda.
 */
class Pengguna {
    String nama;
    String melet; // Role/Peran: "GUEST", "MEMBER", "ADMIN"

    // Constructor biasa (Private/Package-private agar pembuatan dialihkan ke Static Factory)
    private Pengguna(String nama, String role) {
        this.nama = nama;
        this.melet = role;
    }

    // Named / Factory Method 1: Membuat Pengguna Tamu (Guest)
    public static Pengguna buatUserGuest() {
        return new Pengguna("Guest User", "GUEST");
    }

    // Named / Factory Method 2: Membuat Pengguna Admin
    public static Pengguna buatUserAdmin(String nama) {
        return new Pengguna(nama, "ADMIN");
    }

    // Named / Factory Method 3: Membuat Pengguna dari Parameter Lengkap
    public static Pengguna buatUserMember(String nama) {
        return new Pengguna(nama, "MEMBER");
    }

    public void tampilkanProfil() {
        System.out.println("User: " + nama + " | Role: " + melet);
    }
}

// ============================================================================
// MAIN CLASS UNTUK MENJALANKAN UJI COBA
// ============================================================================
public class JenisConstructorDemo {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("       DEMO JENIS-JENIS CONSTRUCTOR JAVA         ");
        System.out.println("=================================================\n");

        // 1. Default Constructor Implisit & Eksplisit
        System.out.println("--- 1. Default Constructor ---");
        ProdukImplisit p1 = new ProdukImplisit(); // Default implisit bawaan Java
        System.out.println("Implisit  -> Nama: " + p1.nama + ", Harga: " + p1.harga);

        ProdukEksplisit p2 = new ProdukEksplisit(); // Default eksplisit buatan sendiri
        System.out.println("Eksplisit -> Nama: " + p2.nama + ", Harga: " + p2.harga);

        // 2. Parameterized Constructor
        System.out.println("\n--- 2. Parameterized Constructor ---");
        Mobil mobil1 = new Mobil("Toyota Avanza", "Hitam", 2022);
        System.out.print("Mobil 1 (Asli)    : ");
        mobil1.tampilkanInfo();

        // 3. Copy Constructor
        System.out.println("\n--- 3. Copy Constructor ---");
        Mobil mobil2 = new Mobil(mobil1); // Menyalin data dari mobil1
        System.out.print("Mobil 2 (Salinan) : ");
        mobil2.tampilkanInfo();

        // 4. Private Constructor (Singleton)
        System.out.println("\n--- 4. Private Constructor (Singleton Pattern) ---");
        // DatabaseConnection db = new DatabaseConnection(); // ERROR: Private constructor!
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("Apakah db1 dan db2 merujuk pada objek yang sama? " + (db1 == db2));

        // 5. Named / Factory Constructor (Static Factory Method)
        System.out.println("\n--- 5. Named / Factory Constructor ---");
        Pengguna guest = Pengguna.buatUserGuest();
        Pengguna admin = Pengguna.buatUserAdmin("Budi");
        Pengguna member = Pengguna.buatUserMember("Siti");

        guest.tampilkanProfil();
        admin.tampilkanProfil();
        member.tampilkanProfil();

        System.out.println("\n=================================================");
    }
}
