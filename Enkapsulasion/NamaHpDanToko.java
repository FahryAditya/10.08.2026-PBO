package belajarjava;

public class Enkapsulasi {

    // Private (tidak bisa diakses langsung)
    private String merek;
    private String warna;
    private int harga;

    // Setter
    public void setMerek(String merek) {
        this.merek = merek;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    // Getter
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
}

class TokoHp {

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