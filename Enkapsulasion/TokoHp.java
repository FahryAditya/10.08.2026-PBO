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