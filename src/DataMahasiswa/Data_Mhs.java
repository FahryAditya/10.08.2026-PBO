package DataMahasiswa;

public class Data_Mhs {
    public String nama, nim, jurusan;

    public Data_Mhs(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public void tampilkanData() {
        System.out.println("Nama Mahasiswa     : " + nama);
        System.out.println("NIM Mahasiswa      : " + nim);
        System.out.println("Jurusan Mahasiswa  : " + jurusan);
    }
}
