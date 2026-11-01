package com.mycompany.projectkepalawangi;

public class CuciExpress extends LayananCuci implements CetakNota {
    private int estimasiMenit;
    private boolean prioritasVIP;

    public CuciExpress(int idTransaksi, String namaPelanggan, int estimasiMenit, boolean prioritasVIP) throws Exception {
        super(idTransaksi, namaPelanggan);
        this.estimasiMenit = estimasiMenit;
        this.prioritasVIP = prioritasVIP;
    }

    @Override
    public void prosesCuci() {
        String jalur = prioritasVIP ? "Jalur VIP Express" : "Jalur Reguler Express";
        System.out.println("[Cuci Express] Pembersihan cepat kilat (" + estimasiMenit + " menit) melalui " + jalur + ".");
    }

    @Override
    public void cetakNotaTransaksi() {
        String statusVip = prioritasVIP ? "Ya" : "Tidak";
        System.out.println("=== CUCI EXPRESS ===");
        System.out.println("ID: " + getIdTransaksi() + " | Pelanggan: " + getNamaPelanggan());
        System.out.println("Estimasi: " + estimasiMenit + " menit | VIP: " + statusVip);
        System.out.println("================================");
    }
}