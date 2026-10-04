package com.mycompany.projectkepalawangi;

public class CuciExpress extends LayananCuci {
    private int estimasiMenit;
    private boolean prioritasVIP;

    public CuciExpress(int idTransaksi, String namaPelanggan, int estimasiMenit, boolean prioritasVIP) {
        super(idTransaksi, namaPelanggan);
        this.estimasiMenit = estimasiMenit;
        this.prioritasVIP = prioritasVIP;
    }

    @Override
    public void prosesCuci() {
        String jalur = prioritasVIP ? "Jalur VIP Express" : "Jalur Reguler Express";
        System.out.println("[Cuci Express] Pembersihan cepat kilat (" + estimasiMenit + " menit) melalui " + jalur + ".");
    }
}