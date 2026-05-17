package geometri;

public class PrismaBujurSangkar extends BangunRuang{
    private double sisiAlas;
    private double tinggiPrisma;

    public PrismaBujurSangkar(double sisiAlas, double tinggiPrisma) {
        this.sisiAlas = sisiAlas;
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getSisiAlas() {
        return sisiAlas;
    }

    public void setSisiAlas(double sisiAlas) {
        this.sisiAlas = sisiAlas;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungLuas() {
        double luasAlas = sisiAlas * sisiAlas;
        double luasDinding = sisiAlas * tinggiPrisma;
        double luasPermukaan = (2 * luasAlas) + (4 * luasDinding);
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        double totalRusukAlasTutup = 8 * sisiAlas;
        double totalRusukTegak = 4 * tinggiPrisma;
        double keliling = totalRusukAlasTutup + totalRusukTegak;
        return keliling;
    }

    @Override
    public double hitungVolume() {
        double volume = (sisiAlas * sisiAlas) * tinggiPrisma;
        return volume;
    }
}
