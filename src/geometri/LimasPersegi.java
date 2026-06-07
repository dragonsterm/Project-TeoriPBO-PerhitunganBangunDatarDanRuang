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
    public double luasAlas;
    public double tinggiSegitiga;
    public double luasSelimut;

    public double totalRusuk;
    public double kelilingAlas;
    public double setengahDiagonal;
    public double panjangRusukTegak;

    public double volume;

    public LimasPersegi() {
        super();
        this.namaBangun = "Limas Persegi";
    }

    public LimasPersegi(double sisiAlas, double tinggiLimas, String namaBangun) {
        super(sisiAlas, namaBangun);
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double hitungLuas() {
        luasAlas = super.hitungLuas();
        tinggiSegitiga = Math.sqrt(Math.pow(sisi / 2.0, 2) + Math.pow(tinggiLimas, 2));
        luasSelimut = 4 * (0.5 * sisi * tinggiSegitiga);
        luasPermukaan = luasAlas + luasSelimut;
        return luasPermukaan;
    }

    public double hitungLuas(double sisi, double tinggiLimas) {
        luasAlas = super.hitungLuas(sisi);
        tinggiSegitiga = Math.sqrt(Math.pow(sisi / 2.0, 2) + Math.pow(tinggiLimas, 2));
        luasSelimut = 4 * (0.5 * sisi * tinggiSegitiga);
        luasPermukaan = luasAlas + luasSelimut;
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        kelilingAlas = super.hitungKeliling();
        setengahDiagonal = (sisi * Math.sqrt(2)) / 2.0;
        panjangRusukTegak = Math.sqrt(Math.pow(setengahDiagonal, 2) + Math.pow(tinggiLimas, 2));
        totalRusuk = kelilingAlas + (4 * panjangRusukTegak);
        return totalRusuk;
    }

    @Override
    public double hitungVolume() {
        volume = (1.0/3.0) * luasAlas * tinggiLimas;
        return volume;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            int waktuProses = random.nextInt(4000) + 1000;
            Thread.sleep(waktuProses);

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
