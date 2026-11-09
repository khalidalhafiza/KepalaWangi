package com.mycompany.projectkepalawangi;

public class RuangTunggu {
    private String namaRuangan;
    private int kapasitasKursi;

    public RuangTunggu(String namaRuangan, int kapasitasKursi) {
        this.namaRuangan = namaRuangan;
        this.kapasitasKursi = kapasitasKursi;
    }

    public void bukaRuangan() {
        System.out.println("- " + namaRuangan + " dibuka. Kapasitas: " + kapasitasKursi + " kursi.");
    }
}