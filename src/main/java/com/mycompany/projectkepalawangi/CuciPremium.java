package com.mycompany.projectkepalawangi;

public class CuciPremium extends LayananCuci {
    private String jenisCoating;
    private int jumlahLayer;
    private final int garansiHari = 7;
    private final int estimasiJam = 1;

    public CuciPremium(int idTransaksi, String namaPelanggan, String jenisCoating, int jumlahLayer) {
        super(idTransaksi, namaPelanggan);
        this.jenisCoating = jenisCoating;
        setJumlahLayer(jumlahLayer);
    }

    public String getJenisCoating() {
        return this.jenisCoating;
    }

    public void setJenisCoating(String jenisCoating) {
        this.jenisCoating = jenisCoating;
    }

    public int getJumlahLayer() {
        return this.jumlahLayer;
    }

    public void setJumlahLayer(int jumlahLayer) {
        if (jumlahLayer >= 1 && jumlahLayer <= 3) {
            this.jumlahLayer = jumlahLayer;
        } else {
            System.out.println("Jumlah layer coating harus 1-3, otomatis disetel ke 1 layer.");
            this.jumlahLayer = 1;
        }
    }

    public int getGaransiHari() {
        return this.garansiHari;
    }

    public int getEstimasiJam() {
        return this.estimasiJam;
    }

    // Method Overriding
    @Override
    public void prosesCuci() {
        System.out.println("CUCI PREMIUM [" + jenisCoating + " " + jumlahLayer + " Layer] - Garansi Toko: " + garansiHari + " Hari (Selesai Express: " + estimasiJam + " Jam)");
    }
}