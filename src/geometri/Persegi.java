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


    public Persegi(double sisi) {
        this.sisi = sisi;
        this.setNamaBenda("Persegi Default");
    }

    public Persegi(double sisi, String namaBenda) {
        this.sisi = sisi;
        this.setNamaBenda(namaBenda);
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

            String hasil = String.format("%s => Luas: %.2f cm, Keliling: %.2f cm", getNamaBenda(), l, k);
            setHasilAkhir(hasil);

            System.out.println(Thread.currentThread().getName() + " selesai.");
        } catch (InterruptedException ex) {
            System.out.println("Thread " + getNamaBenda() + " terganggu");
        }
    }
}
