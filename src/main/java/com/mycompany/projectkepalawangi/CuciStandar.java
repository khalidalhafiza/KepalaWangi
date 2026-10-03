package com.mycompany.projectkepalawangi;

public class CuciStandar extends LayananCuci {
    private String jenisHelm;
    private String aromaParfum;
    private final int estimasiJam = 4;

    public CuciStandar(int idTransaksi, String namaPelanggan, String jenisHelm, String aromaParfum) {
        super(idTransaksi, namaPelanggan);
        this.jenisHelm = jenisHelm;
        this.aromaParfum = aromaParfum;
    }

    public String getJenisHelm() {
        return this.jenisHelm;
    }

    public void setJenisHelm(String jenisHelm) {
        this.jenisHelm = jenisHelm;
    }

    public String getAromaParfum() {
        return this.aromaParfum;
    }

    public void setAromaParfum(String aromaParfum) {
        this.aromaParfum = aromaParfum;
    }

    public int getEstimasiJam() {
        return this.estimasiJam;
    }

    @Override
    public void prosesCuci() {
        System.out.println("CUCI STANDAR [" + jenisHelm + "] - Aroma: " + aromaParfum + " (Selesai: " + estimasiJam + " Jam)");
    }
}