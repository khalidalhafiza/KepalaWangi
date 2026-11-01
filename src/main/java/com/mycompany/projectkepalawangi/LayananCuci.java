package com.mycompany.projectkepalawangi;

public abstract class LayananCuci {  
    private int idTransaksi;
    private String namaPelanggan;


    public LayananCuci(int idTransaksi, String namaPelanggan) throws Exception {
        if (idTransaksi < 0) {
            throw new Exception("ID Transaksi tidak valid (tidak boleh negatif)!");
        }
        if (namaPelanggan == null || namaPelanggan.trim().isEmpty()) {
            throw new Exception("Nama pelanggan tidak boleh kosong!");
        }
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