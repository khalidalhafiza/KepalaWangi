package com.mycompany.projectkepalawangi;

public class CuciStandar extends LayananCuci implements CetakNota {
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

    @Override
    public void cetakNotaTransaksi() {
        System.out.println("=== CUCI STANDAR ===");
        System.out.println("ID: " + getIdTransaksi() + " | Pelanggan: " + getNamaPelanggan());
        System.out.println("Helm: " + jenisHelm + " | Parfum: " + aromaParfum);
        System.out.println("================================");
    }
}