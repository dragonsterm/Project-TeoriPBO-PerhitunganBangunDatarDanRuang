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

    public Persegi(double sisi, String namaBangun) {
        this.sisi = sisi;
        this.namaBangun = namaBangun;
    }

    public Persegi(String sisiStr) {
        try {
            double parsedSisi = Double.parseDouble(sisiStr);
            if (parsedSisi <= 0) throw new NumberFormatException();
            this.sisi = parsedSisi;
        } catch (NumberFormatException e) {
            System.out.println("[Error] Input sisi Persegi tidak valid, menggunakan nilai default 1.0\n");
            this.sisi = 1.0;
        }
    }

    @Override
    public double hitungLuas() {
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
