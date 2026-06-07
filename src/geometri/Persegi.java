/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri;

import java.util.Random;

/**
 *
 * @author mahar
 */
public class Persegi extends BangunDatar implements Runnable {
    public double sisi;
    public double luas;
    public double keliling;

    public Persegi() {
        this.namaBangun = "Persegi";
    }

    public Persegi(double sisi, String namaBangun) {
        this.sisi = sisi;
        this.namaBangun = namaBangun;
    }

    @Override
    public double hitungLuas() {
        luas = sisi * sisi;
        return luas;
    }

    public double hitungLuas(double sisi) {
        luas = sisi * sisi;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 4 * sisi;
        return keliling;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            int waktuProses = random.nextInt(4000) + 1000;
            Thread.sleep(waktuProses);

            double l = hitungLuas();
            double k = hitungKeliling();

            this.hasilAkhir = String.format("%s => Luas: %.2f cm, Keliling: %.2f cm", this.namaBangun, l, k);

            System.out.println(Thread.currentThread().getName() + " selesai.");
        } catch (InterruptedException ex) {
            System.out.println("Thread " + this.namaBangun + " terganggu");
        }
    }
}
