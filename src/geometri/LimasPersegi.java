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
public class LimasPersegi extends Persegi implements BangunRuang, Runnable {
    public double tinggiLimas;
    public double luasPermukaan;
    public double totalRusuk;
    public double volume;

    public LimasPersegi(double sisiAlas, double tinggiLimas, String namaBangun) {
        super(sisiAlas, namaBangun);
        this.tinggiLimas = tinggiLimas;
    }

    public LimasPersegi() {
        super();
        this.namaBangun = "Limas Persegi";
    }

    @Override
    public double hitungLuas() {
        luasPermukaan = luas + (2 * sisi * Math.sqrt(Math.pow(sisi / 2.0, 2) + Math.pow(tinggiLimas, 2)));
        return luasPermukaan;
    }

    public double hitungLuas(double sisi, double tinggiLimas) {
        double luasAlas = super.hitungLuas(sisi);
        luasPermukaan = luasAlas + (2 * sisi * Math.sqrt(Math.pow(sisi / 2.0, 2) + Math.pow(tinggiLimas, 2)));
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        totalRusuk = keliling + (4 * Math.sqrt((Math.pow(sisi, 2) / 2.0) + Math.pow(tinggiLimas, 2)));
        return totalRusuk;
    }

    @Override
    public double hitungVolume() {
        volume = (1.0/3.0) * luas * tinggiLimas;
        return volume;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            int waktuProses = random.nextInt(4000) + 1000;
            Thread.sleep(waktuProses);

            super.hitungLuas();
            super.hitungKeliling();

            double lp = hitungLuas();
            double tr = hitungKeliling();
            double v = hitungVolume();

            this.hasilAkhir = String.format("%s => Luas Permukaan: %.2f cm, Total Panjang Rusuk: %.2f cm, Volume: %.2f cm",
                    this.namaBangun, lp, tr, v);

            System.out.println(Thread.currentThread().getName() + " selesai.");
        } catch (InterruptedException ex) {
            System.out.println("Thread " + this.namaBangun + " terganggu");
        }
    }
}
