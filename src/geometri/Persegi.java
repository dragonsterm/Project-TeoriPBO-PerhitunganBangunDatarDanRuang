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

    public Persegi() {
        this.namaBangun = "Persegi";
    }

    @Override
    public double hitungLuas() throws AngkaInvalidException {
        if (this.sisi <= 0) {
            throw new AngkaInvalidException("Sisi persegi tidak boleh nol atau negatif!");
        }
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
        double l, k;
        int waktuProses;
        try {
            waktuProses = random.nextInt(4000) + 1000;
            Thread.sleep(waktuProses);

            l = hitungLuas();
            k = hitungKeliling();

            this.hasilAkhir = String.format("%s => Luas: %.2f cm, Keliling: %.2f cm", this.namaBangun, l, k);

            System.out.println(Thread.currentThread().getName() + " selesai.");
        } catch (InterruptedException ex) {
            System.out.println("Thread " + this.namaBangun + " terganggu");
        } catch (AngkaInvalidException ex) {
            System.err.println(Thread.currentThread().getName() + " Error: " + ex.getMessage());
        }
    }
}
