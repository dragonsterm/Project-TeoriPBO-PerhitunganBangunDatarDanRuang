/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import model.PrismaBujurSangkar;
import model.Geometri;
import model.Persegi;
import model.LimasPersegi;

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
        int jumlahPerhitungan;
        int pilihanMenu = 0;
        int tasksPerIteration;

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
                    System.out.println("Pilihan tidakk valid. Silahkan coba lagi.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Pilihan tidakk valid. Silahkan coba lagi.");
                continue;
            }

            System.out.print("Berapa kali perhitugan yang ingin dilakukan = ");
            try {
                jumlahPerhitungan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Menggunakan nilai default (1).");
                jumlahPerhitungan = 1;
            }

            System.out.println("\nMemulai " + jumlahPerhitungan + " iterasi perhitungan\n");

            List<Thread> daftarThread = new ArrayList<>();
            List<HitungTask> daftarTask = new ArrayList<>();

            for (int i = 1; i <= jumlahPerhitungan; i++) {
                double sisiBangun = random.nextInt(15) + 1;
                double tinggiBangun = random.nextInt(15) + 1;

                if (pilihanMenu == 1 || pilihanMenu == 4) {
                    Geometri bangun = new Persegi(sisiBangun);
                    String nama = String.format("Persegi ke-%d dengan sisi= %.0f cm", i, sisiBangun);
                    HitungTask task = new HitungTask(bangun, nama);
                    Thread thread = new Thread(task, "Thread-P" + i);

                    daftarTask.add(task);
                    daftarThread.add(thread);
                    thread.start();

                }

                if (pilihanMenu == 2 || pilihanMenu == 4) {
                    Geometri bangun = new LimasPersegi(sisiBangun, tinggiBangun);
                    String nama = String.format("Limas Persegi ke-%d dengan sisi= %.0f cm dan tinggi= %.0f cm", i, sisiBangun, tinggiBangun);
                    HitungTask task = new HitungTask(bangun, nama);
                    Thread thread = new Thread(task, "Thread-L" + i);

                    daftarTask.add(task);
                    daftarThread.add(thread);
                    thread.start();

                }

                if (pilihanMenu == 3 || pilihanMenu == 4) {
                    Geometri bangun = new PrismaBujurSangkar(sisiBangun, tinggiBangun);
                    String nama = String.format("Prisma Bujur Sangkar ke-%d dengan sisi= %.0f cm dan tinggi= %.0f cm", i, sisiBangun, tinggiBangun);
                    HitungTask task = new HitungTask(bangun, nama);
                    Thread thread = new Thread(task, "Thread-B" + i);

                    daftarTask.add(task);
                    daftarThread.add(thread);
                    thread.start();
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

            tasksPerIteration = (pilihanMenu == 4) ? 3 : 1;

            for (int i = 0; i < daftarTask.size(); i++) {
                System.out.println(daftarTask.get(i).getHasilAkhir());

                if ((i + 1) % tasksPerIteration == 0 && i < daftarTask.size() - 1) {
                    System.out.println();
                }
            }
        } while (pilihanMenu != 5);

        scanner.close();
    }

}
