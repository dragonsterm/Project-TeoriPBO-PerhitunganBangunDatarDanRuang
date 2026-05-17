package geometri;

public class PrismaBujurSangkar extends Persegi {
    private double tinggiPrisma;

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

    @Override
    public double hitungLuas() {
        double luasAlas = super.hitungLuas();
        double luasDinding = sisi * tinggiPrisma;
        double luasPermukaan = (2 * luasAlas) + (4 * luasDinding);
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        double totalRusukAlasTutup = 2 * super.hitungKeliling();
        double totalRusukTegak = 4 * tinggiPrisma;
        double keliling = totalRusukAlasTutup + totalRusukTegak;
        return keliling;
    }

    @Override
    public double hitungVolume() {
        double volume = super.hitungLuas() * tinggiPrisma;
        return volume;
    }
}
