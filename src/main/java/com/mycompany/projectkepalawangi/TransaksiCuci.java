package com.mycompany.projectkepalawangi;

import java.io.FileWriter;
import java.io.IOException;

public class TransaksiCuci {
    public static void prosesCuciTransaksi(Pelanggan pelanggan, LayananCuci layanan) {
        System.out.println("\n--- STRUK TRANSAKSI CUCI (ASOSIASI) ---");
        System.out.println("Pelanggan : " + pelanggan.getNama() + " (ID: " + pelanggan.getIdPelanggan() + ")");
        System.out.print("Layanan   : ");
        layanan.tampilkanInformasi();
        System.out.print(" -> Proses: ");
        layanan.prosesCuci();

        if (layanan instanceof CetakNota) {
            ((CetakNota) layanan).cetakNotaTransaksi();
        }
        if (layanan instanceof BisaGaransi) {
            ((BisaGaransi) layanan).berikanGaransi();
        }
        System.out.println("Status    : Transaksi berhasil dicatat di sistem.");
        System.out.println("-------------------------------------------");

        try (FileWriter pipaTulis = new FileWriter("log_transaksi.txt", true)) {
            String log = "Pelanggan: " + pelanggan.getNama() + " | ID: " + pelanggan.getIdPelanggan() + "\n";
            pipaTulis.write(log);
        } catch (IOException e) {
            System.out.println("Peringatan: Gagal menulis log transaksi ke file. " + e.getMessage());
        }
    }
}