package geometri;

import java.util.Random;

public class PrismaBujurSangkar extends Persegi implements BangunRuang, Runnable {
    public double tinggiPrisma;
    public double luasPermukaan;
    public double totalRusuk;
    public double volume;

    public PrismaBujurSangkar(double sisiAlas, double tinggiPrisma, String namaBangun) {
        super(sisiAlas, namaBangun);
        this.tinggiPrisma = tinggiPrisma;
    }

    public PrismaBujurSangkar() {
        super();
        this.namaBangun = "Prisma Bujur Sangkar";
    }

    @Override
    public double hitungLuas() {
        luasPermukaan = (2 * luas) + (4 * sisi * tinggiPrisma);
        return luasPermukaan;
    }

    public double hitungLuas(double sisi, double tinggiPrisma) {
        double luasAlas = super.hitungLuas(sisi);
        luasPermukaan = (2 * luasAlas) + (4 * sisi * tinggiPrisma);
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        totalRusuk = (2 * super.hitungKeliling()) + (4 * tinggiPrisma);
        return totalRusuk;
    }

    @Override
    public double hitungVolume() {
        volume = luas * tinggiPrisma;
        return volume;
    }

    @Override
    public void run() {
        Random random = new Random();
        double lp, tr, v;
        int waktuProses;
        try {
            waktuProses = random.nextInt(4000) + 1000;
            Thread.sleep(waktuProses);

            super.hitungLuas();

            lp = hitungLuas();
            tr = hitungKeliling();
            v = hitungVolume();

            this.hasilAkhir = String.format("%s => Luas Permukaan: %.2f cm, Total Panjang Rusuk: %.2f cm, Volume: %.2f cm",
                    this.namaBangun, lp, tr, v);

            System.out.println(Thread.currentThread().getName() + " selesai.");
        } catch (InterruptedException ex) {
            System.out.println("Thread " + this.namaBangun + " terganggu");
        }
    }
}
