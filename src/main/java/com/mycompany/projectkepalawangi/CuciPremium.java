package com.mycompany.projectkepalawangi;

public class CuciPremium extends LayananCuci implements CetakNota, BisaGaransi {
    private String jenisCoating;
    private int jumlahLayer;

    public CuciPremium(int idTransaksi, String namaPelanggan, String jenisCoating, int jumlahLayer) throws Exception {
        super(idTransaksi, namaPelanggan);
        this.jenisCoating = jenisCoating;
        this.jumlahLayer = jumlahLayer;
    }

    @Override
    public void prosesCuci() {
        System.out.println("[Cuci Premium] Deep cleaning, pengeringan steril, & coating " + jenisCoating + " (" + jumlahLayer + " layer).");
    }

    @Override
    public void cetakNotaTransaksi() {
        System.out.println("=== CUCI PREMIUM ===");
        System.out.println("ID: " + getIdTransaksi() + " | Pelanggan: " + getNamaPelanggan());
        System.out.println("Coating: " + jenisCoating + " | Layer: " + jumlahLayer);
        System.out.println("================================");
    }

    @Override
    public void berikanGaransi() {
        System.out.println("-> [Info Garansi] Layanan ini berhak mendapatkan garansi perawatan coating selama 7 hari!");
    }
}