package com.mycompany.projectkepalawangi;

public abstract class LayananCuci {  
    private int idTransaksi;
    private String namaPelanggan;


    public LayananCuci(int idTransaksi, String namaPelanggan) {
        this.idTransaksi = idTransaksi;
        this.namaPelanggan = namaPelanggan;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public abstract void prosesCuci();

    public void tampilkanInformasi() {
        System.out.printf("| %-5d | %-15s |", idTransaksi, namaPelanggan);
    }
}