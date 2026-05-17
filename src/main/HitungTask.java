/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import model.Geometri;
import model.BangunRuang;
import java.util.Random;

/**
 *
 * @author mahar
 */
public class HitungTask implements Runnable {
    private Geometri bangun;
    private String namaBenda;
    private Random random = new Random();
    private String hasilAkhir;

    public HitungTask(Geometri bangun, String namaBenda) {
        this.bangun = bangun;
        this.namaBenda = namaBenda;
    }

    @Override
    public void run() {
        try {
            int waktuProses = random.nextInt(4000) + 1000;

            Thread.sleep(waktuProses);

            double luas = bangun.hitungLuas();
            double keliling = bangun.hitungKeliling();

            StringBuilder hasil = new StringBuilder();

            hasil.append(namaBenda).append(" => ");

            if (bangun instanceof BangunRuang) {
                double volume = ((BangunRuang) bangun).hitungVolume();
                hasil.append(String.format("Luas Permukaan: %.2f cm, Total Panjang Rusuk: %.2f cm, Volume: %.2f cm",
                        luas, keliling, volume));
            } else {
                hasil.append(String.format("Luas: %.2f cm, Keliling: %.2f cm",
                        luas, keliling));
            }
            this.hasilAkhir = hasil.toString();

            System.out.println(Thread.currentThread().getName() + " selesai.");

        } catch (InterruptedException ex) {
            System.out.println("Thread " + namaBenda + " terganggu");
        }
    }

    public String getHasilAkhir() {
        return hasilAkhir;
    }

    private String formatHasil(double luas, double keliling) {
        return String.format("Luas: %.2f cm, Keliling: %.2f cm", luas, keliling);
    }
    
    private String formatHasil(double luas, double keliling, double volume) {
        return String.format("Luas Permukaan: %.2f cm, Total Panjang Rusuk: %.2f cm, Volume: %.2f cm", 
                luas, keliling, volume);
    }
}
