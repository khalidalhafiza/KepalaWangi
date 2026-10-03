package com.mycompany.projectkepalawangi;

public class LayananCuci {
    private int idTransaksi;
    private String namaPelanggan;

    public static int totalTransaksiBerhasilDibuat = 0;

    public LayananCuci(int idTransaksi, String namaPelanggan) {
        this.idTransaksi = idTransaksi;
        this.namaPelanggan = namaPelanggan;
        totalTransaksiBerhasilDibuat++;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getIdTransaksi() {
        return this.idTransaksi;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNamaPelanggan() {
        return this.namaPelanggan;
    }

    public void prosesCuci() {
        System.out.println("Memproses layanan pencucian helm...");
    }
}