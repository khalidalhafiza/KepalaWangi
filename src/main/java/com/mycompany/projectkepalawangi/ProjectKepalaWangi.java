package com.mycompany.projectkepalawangi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectKepalaWangi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OutletKepalaWangi outletPusat = new OutletKepalaWangi("Kepala Wangi Outlet Utama");
        outletPusat.bukaOutlet();

        try {
            outletPusat.tambahTransaksi(new CuciStandar(101, "Budi", "Full Face", "Vanilla"));
            outletPusat.tambahTransaksi(new CuciPremium(102, "Siti", "Ceramic", 2));
            outletPusat.tambahTransaksi(new CuciExpress(103, "Joko", 15, true));
            
            outletPusat.tambahPelanggan(new Pelanggan("P001", "Budi Santoso"));
            outletPusat.tambahPelanggan(new Pelanggan("P002", "Siti Aminah"));
        } catch (Exception e) {
            System.out.println("Error inisialisasi: " + e.getMessage());
        }

        boolean isRunning = true;

        System.out.println("=============================================");
        System.out.println("      SISTEM MANAJEMEN CUCI HELM KEPALA WANGI ");
        System.out.println("=============================================");

        while (isRunning) {
            try {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Transaksi");
                System.out.println("2. Lihat Daftar Transaksi");
                System.out.println("3. Cari Transaksi (Custom Exception)");
                System.out.println("4. Manajemen Pelanggan (HashMap)");
                System.out.println("5. Cetak Nota Berdasarkan Nomor Antrean");
                System.out.println("6. Simulasi Transaksi (Demo Association)");
                System.out.println("7. Keluar");
                System.out.print("Pilih Menu: 1-7: ");
                
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
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

                try {   
                    if (jenis == 1) {
                        System.out.print("Jenis Helm: ");
                        String helm = scanner.nextLine();
                        System.out.print("Aroma Parfum: ");
                        String parfum = scanner.nextLine();
                        outletPusat.tambahTransaksi(new CuciStandar(idBaru, namaBaru, helm, parfum));
                    } else if (jenis == 2) {
                        System.out.print("Jenis Coating: ");
                        String coating = scanner.nextLine();
                        System.out.print("Jumlah Layer: ");
                        int layer = scanner.nextInt();
                        scanner.nextLine();
                        outletPusat.tambahTransaksi(new CuciPremium(idBaru, namaBaru, coating, layer));
                    } else if (jenis == 3) {
                        System.out.print("Prioritas VIP (true/false): ");
                        boolean vip = scanner.nextBoolean();
                        scanner.nextLine();
                        int menit = vip ? 15 : 30;
                        outletPusat.tambahTransaksi(new CuciExpress(idBaru, namaBaru, menit, vip));
                    }
                    System.out.println("Sukses! Transaksi berhasil ditambahkan.");
                } catch (Exception e) {
                    System.out.println("Gagal menambah transaksi: " + e.getMessage());
                }
            }
                    case 2 -> {
                        System.out.println("\n-- Daftar Transaksi --");
                        outletPusat.lihatSemuaTransaksi();
                    }
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Transaksi --");
                        System.out.print("Masukkan Nama Pelanggan yang dicari: ");
                        String kataKunci = scanner.nextLine();
                        
                        try {
                            outletPusat.cariTransaksi(kataKunci);
                        } catch (DataTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        }
                    }
                    case 4 -> {
                        System.out.println("\n-- Kelola Pelanggan --");
                        System.out.println("1. Tambah Pelanggan");
                        System.out.println("2. Cari Pelanggan via ID");
                        System.out.println("3. Lihat Semua Pelanggan");
                        System.out.print("Pilih: ");
                        int menuP = scanner.nextInt();
                        scanner.nextLine();

                        if (menuP == 1) {
                            System.out.print("Masukkan ID Pelanggan: ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama: ");
                            String nama = scanner.nextLine();
                            outletPusat.tambahPelanggan(new Pelanggan(id, nama));
                        } else if (menuP == 2) {
                            System.out.print("ID Pelanggan yg dicari: ");
                            outletPusat.cariPelanggan(scanner.nextLine());
                        } else if (menuP == 3) {
                            outletPusat.lihatSemuaPelanggan();
                        }
                    }
                    case 5 -> {
                        System.out.println("\n-- Cetak Nota Berdasarkan Nomor Antrean --");
                        if (outletPusat.getJumlahTransaksi() == 0) {
                            System.out.println("Belum ada data transaksi.");
                        } else {
                            outletPusat.lihatSemuaTransaksi();
                            System.out.print("Masukkan nomor urut antrean (1 - " + outletPusat.getJumlahTransaksi() + "): ");
                            int nomorUrut = scanner.nextInt();
                            scanner.nextLine();
                            
                            int index = nomorUrut - 1;
                            if (index >= 0 && index < outletPusat.getJumlahTransaksi()) {
                                System.out.println("\n--- Hasil Cetak untuk Antrean ke-" + nomorUrut + " ---");
                                LayananCuci item = outletPusat.getTransaksiInt(index);
                                item.tampilkanInformasi();
                                System.out.print(" -> Detail: ");
                                item.prosesCuci();

                                if (item instanceof CetakNota) {
                                    ((CetakNota) item).cetakNotaTransaksi();
                                }
                                if (item instanceof BisaGaransi) {
                                    ((BisaGaransi) item).berikanGaransi();
                                }
                            } else {
                                System.out.println("Nomor antrean tidak valid!");
                            }
                        }
                    }
                    case 6 -> {
                        System.out.println("\n-- Simulasi Transaksi (Asosiasi) --");
                        System.out.print("Masukkan ID Pelanggan: ");
                        String inputId = scanner.nextLine();
                        Pelanggan peminjam = outletPusat.getPelanggan(inputId);

                        if (peminjam == null) {
                            System.out.println("Gagal: Pelanggan belum terdaftar!");
                        } else if (outletPusat.getJumlahTransaksi() == 0) {
                            System.out.println("Gagal: Belum ada transaksi yang tersedia.");
                        } else {
                            outletPusat.lihatSemuaTransaksi();
                            System.out.print("Pilih Nomor Transaksi yg ingin diproses: ");
                            int noTrx = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noTrx >= 0 && noTrx < outletPusat.getJumlahTransaksi()) {
                                LayananCuci itemTrx = outletPusat.getTransaksiInt(noTrx);
                                TransaksiCuci.prosesCuciTransaksi(peminjam, itemTrx);
                            } else {
                                System.out.println("Nomor transaksi tidak valid!");
                            }
                        }
                    }
                    case 7 -> {
                        System.out.println("Terima kasih telah menggunakan sistem Kepala Wangi!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan menu tidak valid.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT]: Terjadi kesalahan format! Harap masukkan angka.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}