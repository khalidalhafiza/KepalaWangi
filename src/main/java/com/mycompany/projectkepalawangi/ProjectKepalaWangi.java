package com.mycompany.projectkepalawangi;

import java.util.Scanner;

public class ProjectKepalaWangi {
    static LayananCuci[] daftarTransaksi = new LayananCuci[10];
    static int jumlahTransaksi = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("======================================");
        System.out.println("  Sistem Layanan Pencucian Helm");
        System.out.println("          KEPALA WANGI");
        System.out.println("======================================");

        while (isRunning) {
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Transaksi Cuci Baru");
            System.out.println("2. Tampilkan Seluruh Transaksi");
            System.out.println("3. Cari Transaksi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlahTransaksi < daftarTransaksi.length) {
                        System.out.println("Pilih Tipe Layanan:");
                        System.out.println("1. Cuci Standar (Estimasi 4 Jam)");
                        System.out.println("2. Cuci Premium (Express 1 Jam / Buka Ditunggu)");
                        System.out.print("Pilihan: ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan ID Transaksi (Angka): ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Pelanggan: ");
                        String nama = scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Jenis Helm (Full Face / Half Face): ");
                            String helm = scanner.nextLine();
                            System.out.print("Pilih Aroma Parfum (Vanilla / Fresh Mint / Lavender): ");
                            String parfum = scanner.nextLine();

                            daftarTransaksi[jumlahTransaksi] = new CuciStandar(id, nama, helm, parfum);
                            jumlahTransaksi++;
                            System.out.println("Transaksi Cuci Standar berhasil ditambahkan!");

                        } else if (jenis == 2) {
                            System.out.print("Masukkan Jenis Coating (Nano Ceramic / Anti-Bakteri): ");
                            String coating = scanner.nextLine();
                            System.out.print("Masukkan Jumlah Layer Coating (1-3 Layer): ");
                            int layer = scanner.nextInt();
                            scanner.nextLine();

                            daftarTransaksi[jumlahTransaksi] = new CuciPremium(id, nama, coating, layer);
                            jumlahTransaksi++;
                            System.out.println("Transaksi Cuci Premium berhasil ditambahkan!");

                        

                        } else {
                            System.out.println("Jenis layanan tidak valid.");
                        }
                    } else {
                        System.out.println("Mohon maaf, kuota antrian pencucian penuh!");
                    }
                    break;

                case 2:
                    if (jumlahTransaksi == 0) {
                        System.out.println("Belum ada transaksi pencucian yang dicatat.");
                    } else {
                        System.out.println("\n--- Daftar Seluruh Transaksi Cuci Helm ---");
                        for (int i = 0; i < jumlahTransaksi; i++) {
                            System.out.printf("%d. [ID: %d] Atas Nama: %s%n", (i + 1), daftarTransaksi[i].getIdTransaksi(), daftarTransaksi[i].getNamaPelanggan());
                            System.out.print("   Detail: ");
                            daftarTransaksi[i].prosesCuci();
                        }
                        System.out.println("\nTotal transaksi sukses dibuat: " + LayananCuci.totalTransaksiBerhasilDibuat);
                    }
                    break;

                case 3:
                    System.out.println("Metode Pencarian:");
                    System.out.println("1. Berdasarkan ID Transaksi (Angka)");
                    System.out.println("2. Berdasarkan Nama Pelanggan (Teks)");
                    System.out.print("Pilih: ");
                    int metodeCari = scanner.nextInt();
                    scanner.nextLine();

                    if (metodeCari == 1) {
                        System.out.print("Masukkan ID Transaksi: ");
                        int cariId = scanner.nextInt();
                        scanner.nextLine();
                        cariDataTransaksi(cariId);
                    } else if (metodeCari == 2) {
                        System.out.print("Masukkan Nama Pelanggan: ");
                        String cariNama = scanner.nextLine();
                        cariDataTransaksi(cariNama);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                    break;

                case 4:
                    isRunning = false;
                    System.out.println("Sistem pencucian helm ditutup. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi!");
                    break;
            }
        }
        scanner.close();
    }

    public static void cariDataTransaksi(int idTransaksi) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahTransaksi; i++) {
            if (daftarTransaksi[i].getIdTransaksi() == idTransaksi) {
                System.out.println("\n[DITEMUKAN] Transaksi atas nama: " + daftarTransaksi[i].getNamaPelanggan());
                daftarTransaksi[i].prosesCuci();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Transaksi dengan ID " + idTransaksi + " tidak ditemukan.");
        }
    }

    public static void cariDataTransaksi(String namaPelanggan) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahTransaksi; i++) {
            if (daftarTransaksi[i].getNamaPelanggan().equalsIgnoreCase(namaPelanggan)) {
                System.out.println("\n[DITEMUKAN] Transaksi ID: " + daftarTransaksi[i].getIdTransaksi());
                daftarTransaksi[i].prosesCuci();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Transaksi atas nama '" + namaPelanggan + "' tidak ditemukan.");
        }
    }
}