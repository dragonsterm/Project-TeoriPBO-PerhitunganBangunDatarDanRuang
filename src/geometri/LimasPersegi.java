/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri;

/**
 *
 * @author mahar
 */
public class LimasPersegi extends BangunRuang {
    private Persegi alas;
    private double tinggiLimas;

    public LimasPersegi(double sisiAlas, double tinggiLimas) {
        this.alas = new Persegi(sisiAlas);
        this.tinggiLimas = tinggiLimas;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    public void setTinggiLimas(double tinggiLimas) {
        this.tinggiLimas = tinggiLimas;
    }

    @Override
    public double hitungLuas() {
        double luasAlas = alas.hitungLuas();
        double tinggiSegitiga = Math.sqrt(Math.pow(alas.getSisi() / 2.0, 2) + Math.pow(tinggiLimas, 2));
        double luasSelimut = 4 * (0.5 * alas.getSisi() * tinggiSegitiga);
        double luasPermukaan = luasAlas + luasSelimut;
        return luasPermukaan;
    }

    @Override
    public double hitungKeliling() {
        double kelilingAlas = 4 * alas.getSisi();
        double setengahDiagonal = (alas.getSisi() * Math.sqrt(2)) / 2.0;
        double panjangRusukTegak = Math.sqrt(Math.pow(setengahDiagonal, 2) + Math.pow(tinggiLimas, 2));
        double keliling = kelilingAlas + (4 * panjangRusukTegak);
        return keliling;
    }

    @Override
    public double hitungVolume() {
        double volume = (1.0/3.0) * Math.pow(alas.getSisi(), 2) * tinggiLimas;
        return volume;
    }
}
