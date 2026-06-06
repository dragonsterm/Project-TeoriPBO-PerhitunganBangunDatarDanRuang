package geometri;

import java.util.Random;

public class PrismaBujurSangkar extends Persegi implements BangunRuang, Runnable {
    public double tinggiPrisma;

    public double luasPermukaan;
    public double luasAlas;
    public double luasDinding;

    public double totalRusuk;
    public double totalRusukTegak;
    public double totalRusukAlasTutup;

    public double volume;

    public PrismaBujurSangkar(double sisiAlas, double tinggiPrisma, String namaBangun) {
        super(sisiAlas, namaBangun);
        this.tinggiPrisma = tinggiPrisma;
    }

    public PrismaBujurSangkar(String sisiStr, String tinggiStr) {
        super(sisiStr);
        try {
            double parsedTinggi = Double.parseDouble(tinggiStr);
            if (parsedTinggi <= 0) throw new NumberFormatException();
            this.tinggiPrisma = parsedTinggi;
        } catch (NumberFormatException e) {
            System.out.println("[Error] Input tinggi Prisma tidak valid, menggunakan nilai default 1.0\n");
            this.tinggiPrisma = 1.0;
        }
    }

    @Override
    public double hitungLuas() {
        luasAlas = super.hitungLuas();
        luasDinding = sisi * tinggiPrisma;
        luasPermukaan = (2 * luasAlas) + (4 * luasDinding);
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        totalRusukAlasTutup = 2 * super.hitungKeliling();
        totalRusukTegak = 4 * tinggiPrisma;
        totalRusuk = totalRusukAlasTutup + totalRusukTegak;
        return totalRusuk;
    }

    @Override
    public double hitungVolume() {
        volume = super.hitungLuas() * tinggiPrisma;
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
