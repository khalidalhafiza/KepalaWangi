package com.mycompany.projectkepalawangi;

import java.io.Serializable;

public abstract class LayananCuci implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idTransaksi;
    private String namaPelanggan;

    public LayananCuci(int idTransaksi, String namaPelanggan) {
        this.idTransaksi = idTransaksi;
        this.namaPelanggan = namaPelanggan;
    }

    public abstract void prosesCuci();

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void tampilkanInformasi() {
        System.out.print("ID: " + idTransaksi + " | Pelanggan: " + namaPelanggan);
    }
}