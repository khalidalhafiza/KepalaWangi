package com.mycompany.projectkepalawangi;

public class CuciPremium extends LayananCuci {
    private String jenisCoating;
    private int jumlahLayer;

    public CuciPremium(int idTransaksi, String namaPelanggan, String jenisCoating, int jumlahLayer) {
        super(idTransaksi, namaPelanggan);
        this.jenisCoating = jenisCoating;
        this.jumlahLayer = jumlahLayer;
    }

    @Override
    public void prosesCuci() {
        System.out.println("[Cuci Premium] Deep cleaning, pengeringan steril, & coating " + jenisCoating + " (" + jumlahLayer + " layer).");
    }
}