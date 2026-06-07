/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import geometri.PrismaBujurSangkar;
import geometri.Persegi;
import geometri.LimasPersegi;
import geometri.BangunDatar;

/**
 *
 * @author mahar
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int jumlahPerhitungan, tasksPerIterasi;
        int pilihanMenu = 0;
        int metodeInput;

        do {
            System.out.println("\n-- Perhitungan Persegi, Limas Persegi, dan Bujur Sangkar --");
            System.out.println("Pilihan Bangun:");
            System.out.println("1. Persegi");
            System.out.println("2. Limas Persegi");
            System.out.println("3. Bujur Sangkar");
            System.out.println("4. Kombinasi (semua)");
            System.out.println("5. exit ");
            System.out.print("Masukkan Pilihan (1-5) = ");

            try {
                pilihanMenu = Integer.parseInt(scanner.nextLine());
                if (pilihanMenu == 5) {
                    System.out.println("Program selesai");
                    break;
                }
                if (pilihanMenu < 1 || pilihanMenu > 5) {
                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
                continue;
            }

            System.out.println("\nPilih Metode Input:");
            System.out.println("1. Random (Banyak iterasi)");
            System.out.println("2. Hardcode Overloading (Hanya Luas, 5 kali per bangun)");
            System.out.print("Masukkan Pilihan (1-2) = ");
            try {
                metodeInput = Integer.parseInt(scanner.nextLine());
                if (metodeInput != 1 && metodeInput != 2) {
                    System.out.println("Pilihan tidak valid. Otomatis menggunakan Random.");
                    metodeInput = 1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Otomatis menggunakan Random.");
                metodeInput = 1;
            }

            if (metodeInput == 1) {
                System.out.print("Berapa kali perhitungan yang ingin dilakukan = ");
                try {
                    jumlahPerhitungan = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid. Menggunakan nilai default (1).");
                    jumlahPerhitungan = 1;
                }
            } else {
                System.out.println("Mode Manual dipilih. Perhitungan dilakukan 1 kali.");
                jumlahPerhitungan = 1;
            }

            System.out.println("\nMemulai perhitungan...\n");

            List<Thread> daftarThread = new ArrayList<>();
            List<BangunDatar> daftarTask = new ArrayList<>();

            for (int i = 1; i <= jumlahPerhitungan; i++) {

                if (metodeInput == 1) {
                    double sisiBangun = random.nextInt(15) + 1;
                    double tinggiBangun = random.nextInt(15) + 1;

                    if (pilihanMenu == 1 || pilihanMenu == 4) {
                        String nama = String.format("Persegi ke-%d (Random) dengan sisi= %.0f cm", i, sisiBangun);
                        Persegi bangun = new Persegi(sisiBangun, nama);
                        Thread thread = new Thread(bangun, "Thread-P" + i);
                        daftarTask.add(bangun);
                        daftarThread.add(thread);
                        thread.start();
                    }

                    if (pilihanMenu == 2 || pilihanMenu == 4) {
                        String nama = String.format("Limas Persegi ke-%d (Random) dengan sisi= %.0f cm dan tinggi= %.0f cm", i, sisiBangun, tinggiBangun);
                        LimasPersegi bangun = new LimasPersegi(sisiBangun, tinggiBangun, nama);
                        Thread thread = new Thread(bangun, "Thread-L" + i);
                        daftarTask.add(bangun);
                        daftarThread.add(thread);
                        thread.start();
                    }

                    if (pilihanMenu == 3 || pilihanMenu == 4) {
                        String nama = String.format("Prisma Bujur Sangkar ke-%d (Random) dengan sisi= %.0f cm dan tinggi= %.0f cm", i, sisiBangun, tinggiBangun);
                        PrismaBujurSangkar bangun = new PrismaBujurSangkar(sisiBangun, tinggiBangun, nama);
                        Thread thread = new Thread(bangun, "Thread-B" + i);
                        daftarTask.add(bangun);
                        daftarThread.add(thread);
                        thread.start();
                    }
                } else {
                    if (pilihanMenu == 1 || pilihanMenu == 4) {
                        Persegi p = new Persegi();
                        Thread tp1 = new Thread(() -> System.out.printf("Thread-P1 => Luas Persegi: %.2f%n", p.hitungLuas(5)));
                        Thread tp2 = new Thread(() -> System.out.printf("Thread-P2 => Luas Persegi: %.2f%n", p.hitungLuas(8)));
                        Thread tp3 = new Thread(() -> System.out.printf("Thread-P3 => Luas Persegi: %.2f%n", p.hitungLuas(9)));
                        Thread tp4 = new Thread(() -> System.out.printf("Thread-P4 => Luas Persegi: %.2f%n", p.hitungLuas(12)));
                        Thread tp5 = new Thread(() -> System.out.printf("Thread-P5 => Luas Persegi: %.2f%n", p.hitungLuas(15)));

                        tp1.start(); tp2.start(); tp3.start(); tp4.start(); tp5.start();
                        daftarThread.addAll(List.of(tp1, tp2, tp3, tp4, tp5));
                    }

                    if (pilihanMenu == 2 || pilihanMenu == 4) {
                        LimasPersegi l = new LimasPersegi();
                        Thread tl1 = new Thread(() -> System.out.printf("Thread-L1 => Luas Limas Persegi: %.2f%n", l.hitungLuas(5, 10)));
                        Thread tl2 = new Thread(() -> System.out.printf("Thread-L2 => Luas Limas Persegi: %.2f%n", l.hitungLuas(8, 12)));
                        Thread tl3 = new Thread(() -> System.out.printf("Thread-L3 => Luas Limas Persegi: %.2f%n", l.hitungLuas(9, 15)));
                        Thread tl4 = new Thread(() -> System.out.printf("Thread-L4 => Luas Limas Persegi: %.2f%n", l.hitungLuas(12, 10)));
                        Thread tl5 = new Thread(() -> System.out.printf("Thread-L5 => Luas Limas Persegi: %.2f%n", l.hitungLuas(15, 20)));

                        tl1.start(); tl2.start(); tl3.start(); tl4.start(); tl5.start();
                        daftarThread.addAll(List.of(tl1, tl2, tl3, tl4, tl5));
                    }

                    if (pilihanMenu == 3 || pilihanMenu == 4) {
                        PrismaBujurSangkar b = new PrismaBujurSangkar();
                        Thread tb1 = new Thread(() -> System.out.printf("Thread-B1 => Luas Prisma: %.2f%n", b.hitungLuas(5, 10)));
                        Thread tb2 = new Thread(() -> System.out.printf("Thread-B2 => Luas Prisma: %.2f%n", b.hitungLuas(8, 12)));
                        Thread tb3 = new Thread(() -> System.out.printf("Thread-B3 => Luas Prisma: %.2f%n", b.hitungLuas(9, 15)));
                        Thread tb4 = new Thread(() -> System.out.printf("Thread-B4 => Luas Prisma: %.2f%n", b.hitungLuas(12, 10)));
                        Thread tb5 = new Thread(() -> System.out.printf("Thread-B5 => Luas Prisma: %.2f%n", b.hitungLuas(15, 20)));

                        tb1.start(); tb2.start(); tb3.start(); tb4.start(); tb5.start();
                        daftarThread.addAll(List.of(tb1, tb2, tb3, tb4, tb5));
                    }
                }
            }

            for (Thread t : daftarThread) {
                try {
                    t.join();
                } catch (InterruptedException ex) {
                    System.out.println("Terjadi kesalahan saat menunggu thread");
                }
            }

            System.out.println("\nSemua Thread selesai perhitungan");
            System.out.println("--Hasil Perhitungan--");

            tasksPerIterasi = (pilihanMenu == 4) ? 3 : 1;

            for (int i = 0; i < daftarTask.size(); i++) {
                System.out.println(daftarTask.get(i).hasilAkhir);

                if ((i + 1) % tasksPerIterasi == 0 && i < daftarTask.size() - 1) {
                    System.out.println();
                }
            }
        } while (pilihanMenu != 5);

        scanner.close();
    }
}
