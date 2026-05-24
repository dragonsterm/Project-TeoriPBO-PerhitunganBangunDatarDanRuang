package geometri;

public class PrismaBujurSangkar extends Persegi implements BangunRuang {
    private double tinggiPrisma;
    private double luasPermukaan;
    private double totalRusuk;
    private double volume;


    public PrismaBujurSangkar(double sisiAlas, double tinggiPrisma) {
        super(sisiAlas);
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    public void setTinggiPrisma(double tinggiPrisma) {
        this.tinggiPrisma = tinggiPrisma;
    }

    public double getLuasPermukaan() {
        return luasPermukaan;
    }

    public double getTotalRusuk() {
        return totalRusuk;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public double hitungLuas() {
        double luasAlas = super.hitungLuas();
        double luasDinding = sisi * tinggiPrisma;
        luasPermukaan = (2 * luasAlas) + (4 * luasDinding);
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        double totalRusukAlasTutup = 2 * super.hitungKeliling();
        double totalRusukTegak = 4 * tinggiPrisma;
        totalRusuk = totalRusukAlasTutup + totalRusukTegak;
        return totalRusuk;
    }

    @Override
    public double hitungVolume() {
        volume = super.hitungLuas() * tinggiPrisma;
        return volume;
    }
}
