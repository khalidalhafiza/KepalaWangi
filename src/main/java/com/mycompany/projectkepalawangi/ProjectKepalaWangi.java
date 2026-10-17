package com.mycompany.projectkepalawangi;

import java.util.Scanner;

public class ProjectKepalaWangi {
    public static void eksekusiSimulasiProses(LayananCuci layanan) {
        layanan.prosesCuci(); 
    }

    public static void cariDataTransaksi(String namaPelanggan, LayananCuci[] daftarTransaksi, int jumlahTransaksi) {
        System.out.println("Mencari transaksi dengan Nama Pelanggan (Teks): " + namaPelanggan);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahTransaksi; i++) {
            if (daftarTransaksi[i].getNamaPelanggan().equalsIgnoreCase(namaPelanggan)) {
                daftarTransaksi[i].tampilkanInformasi();
                System.out.print(" -> Detail: ");
                eksekusiSimulasiProses(daftarTransaksi[i]); 
                
                if (daftarTransaksi[i] instanceof CetakNota) {
                    ((CetakNota) daftarTransaksi[i]).cetakNotaTransaksi();
                }
                if (daftarTransaksi[i] instanceof BisaGaransi) {
                    ((BisaGaransi) daftarTransaksi[i]).berikanGaransi();
                }
                
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Data transaksi tidak ditemukan.");
    }

    public static void cariDataTransaksi(int idTransaksi, LayananCuci[] daftarTransaksi, int jumlahTransaksi) {
        System.out.println("Mencari transaksi dengan ID Transaksi (Angka): " + idTransaksi);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahTransaksi; i++) {
            if (daftarTransaksi[i].getIdTransaksi() == idTransaksi) {
                daftarTransaksi[i].tampilkanInformasi();
                System.out.print(" -> Detail: ");
                eksekusiSimulasiProses(daftarTransaksi[i]); 
                
                if (daftarTransaksi[i] instanceof CetakNota) {
                    ((CetakNota) daftarTransaksi[i]).cetakNotaTransaksi();
                }
                if (daftarTransaksi[i] instanceof BisaGaransi) {
                    ((BisaGaransi) daftarTransaksi[i]).berikanGaransi();
                }
                
                System.out.println();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Data transaksi tidak ditemukan.");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LayananCuci[] daftarTransaksi = new LayananCuci[100];
            int jumlahTransaksi = 0;

            daftarTransaksi[0] = new CuciStandar(101, "Budi", "Full Face", "Vanilla");
            daftarTransaksi[1] = new CuciPremium(102, "Siti", "Ceramic", 2);
            daftarTransaksi[2] = new CuciExpress(103, "Joko", 15, true);
            jumlahTransaksi = 3; 

            boolean isRunning = true;

            System.out.println("=============================================");
            System.out.println(" SISTEM MANAJEMEN CUCI HELM KEPALA WANGI ");
            System.out.println("=============================================");

            while (isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Transaksi Baru");
                System.out.println("2. Lihat Daftar Transaksi & Detail");
                System.out.println("3. Cari Transaksi (Fitur Overloading)");
                System.out.println("4. Cetak Nota & Detail Berdasarkan Nomor Antrean");
                System.out.println("5. Keluar");
                System.out.print("Pilih Menu: 1-5: ");
                
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        if (jumlahTransaksi < daftarTransaksi.length) {
                            System.out.println("\n-- Pilih Jenis Layanan --");
                            System.out.println("1. Cuci Standar");
                            System.out.println("2. Cuci Premium");
                            System.out.println("3. Cuci Express");
                            System.out.print("Pilihan (1/2/3): ");
                            int jenis = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Masukkan ID Transaksi: ");
                            int idBaru = scanner.nextInt();
                            scanner.nextLine();
                            
                            System.out.print("Masukkan Nama Pelanggan: ");
                            String namaBaru = scanner.nextLine();

                            switch (jenis) {
                                case 1 -> {
                                    System.out.print("Jenis Helm (Full Face/Half Face): ");
                                    String helm = scanner.nextLine();
                                    System.out.print("Aroma Parfum (Vanilla / Kopi/ Lemon / dll): ");
                                    String parfum = scanner.nextLine();
                                    daftarTransaksi[jumlahTransaksi] = new CuciStandar(idBaru, namaBaru, helm, parfum);
                                }
                                case 2 -> {
                                    System.out.print("Jenis Coating (Ceramic/Nano/Kaca/dll): ");
                                    String coating = scanner.nextLine();
                                    System.out.print("Jumlah Layer Coating (Angka): ");
                                    int layer = scanner.nextInt();
                                    scanner.nextLine();
                                    daftarTransaksi[jumlahTransaksi] = new CuciPremium(idBaru, namaBaru, coating, layer);
                                }
                                case 3 -> {
                                    System.out.print("Prioritas VIP (true/false): ");
                                    boolean vip = scanner.nextBoolean();
                                    scanner.nextLine();
                                    int menit = vip ? 15 : 30;
                                    daftarTransaksi[jumlahTransaksi] = new CuciExpress(idBaru, namaBaru, menit, vip);
                                }
                                default -> {
                                    System.out.println("Pilihan jenis tidak valid.");
                                    continue;
                                }
                            }
                            jumlahTransaksi++;
                            System.out.println("Sukses! Transaksi berhasil ditambahkan.");
                            System.out.print("Tekan Enter untuk melanjutkan...");
                            scanner.nextLine();
                        } else {
                            System.out.println("Maaf, kapasitas antrean sudah penuh.");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n-- Daftar Transaksi & Detail --");
                        if (jumlahTransaksi == 0) {
                            System.out.println("Belum ada data.");
                        } else {
                            for (int i = 0; i < jumlahTransaksi; i++) {
                                System.out.print((i + 1) + ". ");
                                daftarTransaksi[i].tampilkanInformasi();
                                System.out.print(" -> Detail: ");
                                eksekusiSimulasiProses(daftarTransaksi[i]); 
                                
                                if (daftarTransaksi[i] instanceof CetakNota) {
                                    ((CetakNota) daftarTransaksi[i]).cetakNotaTransaksi();
                                }
                                if (daftarTransaksi[i] instanceof BisaGaransi) {
                                    ((BisaGaransi) daftarTransaksi[i]).berikanGaransi();
                                }
                                System.out.println("----------------------------------------");
                            }
                            System.out.println("Total Transaksi: " + jumlahTransaksi);
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Transaksi --");
                        System.out.println("1. Cari berdasarkan Nama Pelanggan (String)");
                        System.out.println("2. Cari berdasarkan ID Transaksi (Integer)");
                        System.out.print("Pilih (1/2): ");
                        int modeCari = scanner.nextInt();
                        scanner.nextLine();

                        if (modeCari == 1) {
                            System.out.print("Masukkan Nama Pelanggan: ");
                            String kataKunci = scanner.nextLine();
                            cariDataTransaksi(kataKunci, daftarTransaksi, jumlahTransaksi);
                        } else if (modeCari == 2) {
                            System.out.print("Masukkan ID Transaksi: ");
                            int angkaKunci = scanner.nextInt();
                            scanner.nextLine();
                            cariDataTransaksi(angkaKunci, daftarTransaksi, jumlahTransaksi);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        System.out.println("\n-- Cetak Nota Berdasarkan Nomor Antrean --");
                        if (jumlahTransaksi == 0) {
                            System.out.println("Belum ada data transaksi.");
                        } else {
                            System.out.print("Masukkan nomor urut antrean (1 - " + jumlahTransaksi + "): ");
                            int nomorUrut = scanner.nextInt();
                            scanner.nextLine();
                            
                            int index = nomorUrut - 1;
                            if (index >= 0 && index < jumlahTransaksi) {
                                System.out.println("\n--- Hasil Cetak untuk Antrean ke-" + nomorUrut + " ---");
                                daftarTransaksi[index].tampilkanInformasi();
                                System.out.print(" -> Detail: ");
                                eksekusiSimulasiProses(daftarTransaksi[index]); 

                                if (daftarTransaksi[index] instanceof CetakNota) {
                                    ((CetakNota) daftarTransaksi[index]).cetakNotaTransaksi();
                                }
                                if (daftarTransaksi[index] instanceof BisaGaransi) {
                                    ((BisaGaransi) daftarTransaksi[index]).berikanGaransi();
                                }
                            } else {
                                System.out.println("Nomor antrean tidak valid!");
                            }
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 5 -> {
                        System.out.println("Terima kasih telah menggunakan sistem Kepala Wangi!");
                        isRunning = false;
                    }
                    default -> {
                        System.out.println("Pilihan menu tidak valid.");
                    }
                }
            }
        }
    }
}