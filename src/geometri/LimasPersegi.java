/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri;

/**
 *
 * @author mahar
 */
public class LimasPersegi extends Persegi implements BangunRuang {
    private double tinggiLimas;
    private double luasPermukaan;
    private double totalRusuk;
    private double volume;

    public LimasPersegi(double sisiAlas, double tinggiLimas) {
        super(sisiAlas);
        this.tinggiLimas = tinggiLimas;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
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
        double tinggiSegitiga = Math.sqrt(Math.pow(sisi / 2.0, 2) + Math.pow(tinggiLimas, 2));
        double luasSelimut = 4 * (0.5 * sisi * tinggiSegitiga);
        luasPermukaan = luasAlas + luasSelimut;
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        double kelilingAlas = super.hitungKeliling();
        double setengahDiagonal = (sisi * Math.sqrt(2)) / 2.0;
        double panjangRusukTegak = Math.sqrt(Math.pow(setengahDiagonal, 2) + Math.pow(tinggiLimas, 2));
        totalRusuk = kelilingAlas + (4 * panjangRusukTegak);
        return totalRusuk;
    }

    @Override
    public double hitungVolume() {
        volume = (1.0/3.0) * super.hitungLuas() * tinggiLimas;
        return volume;
    }
}
