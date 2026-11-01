package com.mycompany.projectkepalawangi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectKepalaWangi {

    public static void eksekusiSimulasiProses(LayananCuci layanan) {
        layanan.prosesCuci(); 
    }

    public static void cariDataTransaksi(String namaPelanggan, ArrayList<LayananCuci> daftarTransaksi) throws DataTidakDitemukanException {
        boolean ditemukan = false;
        System.out.println("Mencari transaksi untuk: " + namaPelanggan);
        
        for (int i = 0; i < daftarTransaksi.size(); i++) {
            if (daftarTransaksi.get(i).getNamaPelanggan().equalsIgnoreCase(namaPelanggan)) {
                daftarTransaksi.get(i).tampilkanInformasi();
                System.out.print(" -> Detail: ");
                eksekusiSimulasiProses(daftarTransaksi.get(i)); 
                
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
            throw new DataTidakDitemukanException("Gagal: Transaksi dengan nama '" + namaPelanggan + "' tidak ditemukan dalam sistem!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<LayananCuci> daftarTransaksi = new ArrayList<>();

        HashMap<String, String> dataMember = new HashMap<>();

        try {
            daftarTransaksi.add(new CuciStandar(101, "Budi", "Full Face", "Vanilla"));
            daftarTransaksi.add(new CuciPremium(102, "Siti", "Ceramic", 2));
            daftarTransaksi.add(new CuciExpress(103, "Joko", 15, true));
            
            dataMember.put("1", "Budi Santoso");
            dataMember.put("2", "Siti Aminah");
        } catch (Exception e) {
            System.out.println("Error saat inisialisasi data: " + e.getMessage());
        }

        boolean isRunning = true;

        System.out.println("=============================================");
        System.out.println(" SISTEM MANAJEMEN CUCI HELM KEPALA WANGI ");
        System.out.println("=============================================");

        while (isRunning) {
            try {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Transaksi Baru");
                System.out.println("2. Lihat Daftar Transaksi & Detail (ArrayList)");
                System.out.println("3. Cari Transaksi (Demo Custom Exception)");
                System.out.println("4. Cetak Nota Berdasarkan Nomor Antrean");
                System.out.println("5. Kelola Member (Demo HashMap)");
                System.out.println("6. Keluar");
                System.out.print("Pilih Menu: 1-6: ");
                
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

                        if (jenis == 1) {
                            System.out.print("Jenis Helm (Full Face/Half Face): ");
                            String helm = scanner.nextLine();
                            System.out.print("Aroma Parfum (Vanilla / Kopi/ Lemon): ");
                            String parfum = scanner.nextLine();
                            daftarTransaksi.add(new CuciStandar(idBaru, namaBaru, helm, parfum));
                        } else if (jenis == 2) {
                            System.out.print("Jenis Coating(Ceramic/Nano/Kaca): ");
                            String coating = scanner.nextLine();
                            System.out.print("Jumlah Layer: ");
                            int layer = scanner.nextInt();
                            scanner.nextLine();
                            daftarTransaksi.add(new CuciPremium(idBaru, namaBaru, coating, layer));
                        } else if (jenis == 3) {
                            System.out.print("Prioritas VIP (true/false): ");
                            boolean vip = scanner.nextBoolean();
                            scanner.nextLine();
                            int menit = vip ? 15 : 30;
                            daftarTransaksi.add(new CuciExpress(idBaru, namaBaru, menit, vip));
                        }
                        System.out.println("Sukses! Transaksi ditambahkan. Total data: " + daftarTransaksi.size());
                    }
                    case 2 -> {
                        System.out.println("\n-- Daftar Transaksi & Detail --");
                        if (daftarTransaksi.isEmpty()) {
                            System.out.println("Belum ada data transaksi.");
                        } else {
                            for (int i = 0; i < daftarTransaksi.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarTransaksi.get(i).tampilkanInformasi();
                                System.out.print(" -> Detail: ");
                                eksekusiSimulasiProses(daftarTransaksi.get(i)); 
                                
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
                    }
                    case 3 -> {
                        System.out.println("\n-- Fitur Cari Transaksi (Custom Exception) --");
                        System.out.print("Masukkan Nama Pelanggan yang dicari: ");
                        String kataKunci = scanner.nextLine();
                        
                        try {
                            cariDataTransaksi(kataKunci, daftarTransaksi);
                        } catch (DataTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }
                    }
                    case 4 -> {
                        System.out.println("\n-- Cetak Nota Berdasarkan Nomor Antrean --");
                        if (daftarTransaksi.isEmpty()) {
                            System.out.println("Belum ada data transaksi.");
                        } else {
                            System.out.print("Masukkan nomor urut antrean (1 - " + daftarTransaksi.size() + "): ");
                            int nomorUrut = scanner.nextInt();
                            scanner.nextLine();
                            
                            int index = nomorUrut - 1;
                            if (index >= 0 && index < daftarTransaksi.size()) {
                                System.out.println("\n--- Hasil Cetak untuk Antrean ke-" + nomorUrut + " ---");
                                daftarTransaksi.get(index).tampilkanInformasi();
                                System.out.print(" -> Detail: ");
                                eksekusiSimulasiProses(daftarTransaksi.get(index)); 

                                if (daftarTransaksi.get(index) instanceof CetakNota) {
                                    ((CetakNota) daftarTransaksi.get(index)).cetakNotaTransaksi();
                                }
                                if (daftarTransaksi.get(index) instanceof BisaGaransi) {
                                    ((BisaGaransi) daftarTransaksi.get(index)).berikanGaransi();
                                }
                            } else {
                                System.out.println("Nomor antrean tidak valid!");
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("\n-- Kelola Member (HashMap) --");
                        System.out.println("1. Tambah Member Baru");
                        System.out.println("2. Cari Member via ID");
                        System.out.println("3. Tampilkan Semua Member");
                        System.out.print("Pilih: ");
                        int menuMember = scanner.nextInt();
                        scanner.nextLine();

                        if (menuMember == 1) {
                            System.out.print("Masukkan ID Member (Key): ");
                            String idKey = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (Value): ");
                            String namaVal = scanner.nextLine();
                            dataMember.put(idKey, namaVal);
                            System.out.println("Berhasil menambahkan member baru!");
                        } else if (menuMember == 2) {
                            System.out.print("Masukkan ID Member yang dicari: ");
                            String cariId = scanner.nextLine();
                            if (dataMember.containsKey(cariId)) {
                                System.out.println("Ditemukan! Nama Member: " + dataMember.get(cariId));
                            } else {
                                System.out.println("Member dengan ID tersebut tidak terdaftar.");
                            }
                        } else if (menuMember == 3) {
                            System.out.println("Total Member Terdaftar: " + dataMember.size());
                            for (String keyId : dataMember.keySet()) {
                                System.out.println("- ID: " + keyId + " | Nama: " + dataMember.get(keyId));
                            }
                        }
                    }
                    case 6 -> {
                        System.out.println("Terima kasih telah menggunakan sistem Kepala Wangi!");
                        isRunning = false;
                    }
                    default -> System.out.println("Pilihan menu tidak valid.");
                }

            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT]: Terjadi kesalahan format! Harap masukkan angka yang valid.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[SISTEM ERROR]: " + e.getMessage());
            }
        }
        scanner.close();
    }
}