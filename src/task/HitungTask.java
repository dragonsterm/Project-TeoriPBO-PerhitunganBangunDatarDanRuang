/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package task;

import geometri.Geometri;
import geometri.BangunRuang;
import geometri.Persegi;
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
        double luas, keliling, volume, kelilingMurni, totalRusukAtauKeliling;
        int waktuProses;
        try {
            waktuProses = random.nextInt(4000) + 1000;

            Thread.sleep(waktuProses);

            luas = bangun.hitungLuas();
            totalRusukAtauKeliling = bangun.hitungKeliling();

            StringBuilder hasil = new StringBuilder();

            hasil.append(namaBenda).append(" => ");

            if (bangun instanceof BangunRuang) {
                volume = ((BangunRuang) bangun).hitungVolume();
                Persegi p = (Persegi) bangun;
                kelilingMurni = p.hitungKeliling(p.getSisi());

                hasil.append(formatHasil(luas, kelilingMurni, totalRusukAtauKeliling, volume));
            } else {
                hasil.append(formatHasil(luas, totalRusukAtauKeliling));
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
    
    private String formatHasil(double luas, double kelilingAlas, double totalRusuk, double volume) {
        return String.format("Luas Permukaan: %.2f cm, Keliling Alas: %.2f cm, Total Panjang Rusuk: %.2f cm, Volume: %.2f cm",
                luas, kelilingAlas , totalRusuk, volume);
    }
}
