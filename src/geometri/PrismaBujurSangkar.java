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
    public double hitungLuas() throws AngkaInvalidException {
        if (this.tinggiPrisma <= 0) {
            throw new AngkaInvalidException("Tinggi Prisma tidak boleh nol atau negatif!");
        }
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
        int waktuProses;
        try {
            waktuProses = random.nextInt(4000) + 1000;
            Thread.sleep(waktuProses);

            super.hitungLuas();

            hitungLuas();
            hitungKeliling();
            hitungVolume();

            this.hasilAkhir = String.format("%s => Luas Permukaan: %.2f cm, Total Panjang Rusuk: %.2f cm, Volume: %.2f cm",
                    this.namaBangun, this.luasPermukaan, this.totalRusuk, this.volume);

            System.out.println(Thread.currentThread().getName() + " selesai.");
        } catch (InterruptedException ex) {
            System.out.println("Thread " + this.namaBangun + " terganggu");
        } catch (AngkaInvalidException ex) {
            System.err.println(Thread.currentThread().getName() + " Error: " + ex.getMessage());
        }
    }
}
