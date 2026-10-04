package com.mycompany.projectkepalawangi;

public class CuciStandar extends LayananCuci {
    private String jenisHelm;
    private String aromaParfum;

    public CuciStandar(int idTransaksi, String namaPelanggan, String jenisHelm, String aromaParfum) {
        super(idTransaksi, namaPelanggan);
        this.jenisHelm = jenisHelm;
        this.aromaParfum = aromaParfum;
    }
    
    @Override
    public void prosesCuci() {
        System.out.println("[Cuci Standar] Pembersihan umum & aroma " + aromaParfum + " untuk helm " + jenisHelm + ".");
    }
}