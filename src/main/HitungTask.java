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

    public HitungTask(Geometri bangun, String namaBenda) {
        this.bangun = bangun;
        this.namaBenda = namaBenda;
    }

    @Override
    public void run() {
        try {
            int waktuProses = random.nextInt(2500) + 500;

            Thread.sleep(waktuProses);

            double luas = bangun.hitungLuas();
            double keliling = bangun.hitungKeliling();

            StringBuilder hasil = new StringBuilder();

            hasil.append(Thread.currentThread().getName())
                    .append(" | ").append(namaBenda).append(" selesai => ")
                    .append(String.format("Luas: %.2f, Keliling: %.2f", luas, keliling));

            if (bangun instanceof BangunRuang) {
                double volume = ((BangunRuang) bangun).hitungVolume();
                hasil.append(String.format(", Volume: %.2f", volume));
            }

            System.out.println(hasil.toString());

        } catch (InterruptedException ex) {
            System.out.println("Thread " + namaBenda + " terganggu");
        }
    }
}
