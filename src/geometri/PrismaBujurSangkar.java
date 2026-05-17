package geometri;

public class PrismaBujurSangkar extends BangunRuang{
    private Persegi alas;
    private double tinggiPrisma;

    public PrismaBujurSangkar(double sisiAlas, double tinggiPrisma) {
        this.alas = new Persegi(sisiAlas);
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }

    @Override
    public double hitungLuas() {
        double luasAlas = alas.hitungLuas();
        double luasDinding = alas.getSisi() * tinggiPrisma;
        double luasPermukaan = (2 * luasAlas) + (4 * luasDinding);
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        double totalRusukAlasTutup = 8 * alas.getSisi();
        double totalRusukTegak = 4 * tinggiPrisma;
        double keliling = totalRusukAlasTutup + totalRusukTegak;
        return keliling;
    }

    @Override
    public double hitungVolume() {
        double volume = alas.hitungLuas() * tinggiPrisma;
        return volume;
    }
}
