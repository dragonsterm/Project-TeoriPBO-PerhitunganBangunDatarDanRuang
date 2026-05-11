/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
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

        System.out.println("--uji coba--");
        System.out.print("Berapa kali perhitungan yang ingin dilakukan = ");

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

            Geometri bangun1 = new Persegi(sisiBangun);
            Geometri bangun2 = new LimasPersegi(sisiBangun, tinggiBangun);

            String namaPersegi = String.format("Persegi ke-%d dengan sisi=%.0f", i, sisiBangun);
            String namaLimas = String.format("Limas Persegi ke-%d dengan sisi=%.0f dan tinggi=%.0f", i, sisiBangun, tinggiBangun);

            HitungTask taskPersegi = new HitungTask(bangun1, namaPersegi);
            HitungTask taskLimas = new HitungTask(bangun2, namaLimas);

            Thread threadPersegi = new Thread(taskPersegi, "Thread-P" + i);
            Thread threadLimas = new Thread(taskLimas, "Thread-L" + i);

            daftarTask.add(taskPersegi);
            daftarThread.add(threadPersegi);

            daftarTask.add(taskLimas);
            daftarThread.add(threadLimas);

            threadPersegi.start();
            threadLimas.start();
        }
        scanner.close();

        for (Thread t : daftarThread) {
            try {
                t.join();
            } catch (InterruptedException ex) {
                System.out.println("Terjadi kesalahan saat menunggu thread");
            }
        }

        System.out.println("\nSemua Thread selesai perhitungan");
        System.out.println("--Hasil Perhitungan--");

        // 3. Fase Mencetak Hasil Detail secara Berurutan
        for (HitungTask task : daftarTask) {
            System.out.println(task.getHasilAkhir());
        }
    }
}
