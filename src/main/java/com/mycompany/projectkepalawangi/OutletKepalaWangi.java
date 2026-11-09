package com.mycompany.projectkepalawangi;

import java.util.ArrayList;
import java.util.HashMap;

public class OutletKepalaWangi {
    private String namaOutlet;
    private RuangTunggu ruangTungguUtama;
    private ArrayList<LayananCuci> daftarTransaksi;
    private HashMap<String, Pelanggan> dataPelanggan;

    public OutletKepalaWangi(String namaOutlet) {
        this.namaOutlet = namaOutlet;
        this.ruangTungguUtama = new RuangTunggu("Ruang Tunggu VIP", 25);
        this.daftarTransaksi = new ArrayList<>();
        this.dataPelanggan = new HashMap<>();
    }

    public void bukaOutlet() {
        System.out.println("\n*** Menginisialisasi sistem " + this.namaOutlet + " ***");
        ruangTungguUtama.bukaRuangan();
    }
        
    public void tambahTransaksi(LayananCuci layanan) {
        daftarTransaksi.add(layanan);
        System.out.println("Sukses! Transaksi ditambahkan. (Total Transaksi: " + daftarTransaksi.size() + ")");
    }

    public void tambahPelanggan(Pelanggan p) {
        dataPelanggan.put(p.getIdPelanggan(), p);
        System.out.println("Berhasil menambahkan pelanggan!");
    }

    public void lihatSemuaTransaksi() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada data transaksi yang tersimpan.");
            return;
        }
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarTransaksi.get(i).tampilkanInformasi();
            System.out.print(" -> Detail: ");
            daftarTransaksi.get(i).prosesCuci();

            if (daftarTransaksi.get(i) instanceof CetakNota) {
                ((CetakNota) daftarTransaksi.get(i)).cetakNotaTransaksi();
            }
            if (daftarTransaksi.get(i) instanceof BisaGaransi) {
                ((BisaGaransi) daftarTransaksi.get(i)).berikanGaransi();
            }
            System.out.println("----------------------------------------");
        }
        System.out.println("Total Transaksi: " + daftarTransaksi.size());
    }

    public void cariTransaksi(String nama) throws DataTidakDitemukanException {
        System.out.println("Mencari transaksi untuk: " + nama);
        boolean ditemukan = false;
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            if (daftarTransaksi.get(i).getNamaPelanggan().equalsIgnoreCase(nama)) {
                daftarTransaksi.get(i).tampilkanInformasi();
                System.out.print(" -> Detail: ");
                daftarTransaksi.get(i).prosesCuci();

                if (daftarTransaksi.get(i) instanceof CetakNota) {
                    ((CetakNota) daftarTransaksi.get(i)).cetakNotaTransaksi();
                }
                if (daftarTransaksi.get(i) instanceof BisaGaransi) {
                    ((BisaGaransi) daftarTransaksi.get(i)).berikanGaransi();
                }
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new DataTidakDitemukanException("Gagal: Transaksi dengan nama '" + nama + "' tidak ditemukan dalam sistem!");
        }
    }

    public void cariPelanggan(String id) {
        if (dataPelanggan.containsKey(id)) {
            System.out.println("Ditemukan! Nama Pelanggan: " + dataPelanggan.get(id).getNama());
        } else {
            System.out.println("Pelanggan dengan ID tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaPelanggan() {
        System.out.println("Total Pelanggan Terdaftar: " + dataPelanggan.size());
        for (Pelanggan p : dataPelanggan.values()) {
            System.out.println("- ID: " + p.getIdPelanggan() + " | Nama: " + p.getNama());
        }
    }

    public Pelanggan getPelanggan(String id) {
        return dataPelanggan.get(id);
    }

    public LayananCuci getTransaksiInt(int index) {
        return daftarTransaksi.get(index);
    }

    int getJumlahTransaksi() {
        return daftarTransaksi.size();
    }
}