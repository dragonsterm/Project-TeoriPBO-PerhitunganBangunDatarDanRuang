/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri;

/**
 *
 * @author mahar
 */
public class LimasPersegi extends Persegi {
    private double tinggiLimas;

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

    @Override
    public double hitungLuas() {
        double luasAlas = super.hitungLuas();
        double tinggiSegitiga = Math.sqrt(Math.pow(sisi / 2.0, 2) + Math.pow(tinggiLimas, 2));
        double luasSelimut = 4 * (0.5 * sisi * tinggiSegitiga);
        double luas = luasAlas + luasSelimut;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        double kelilingAlas = super.hitungKeliling();
        double setengahDiagonalAlas = Math.sqrt(2 * Math.pow(sisi / 2.0, 2));
        double panjangRusukMiring = Math.sqrt(Math.pow(setengahDiagonalAlas, 2) + Math.pow(tinggiLimas, 2));
        double totalRusukMiring =  4 *  panjangRusukMiring;
        double keliling = kelilingAlas + totalRusukMiring;
        return keliling;
    }

    @Override
    public double hitungVolume() {
        double volume = (1.0/3.0) * super.hitungLuas() * tinggiLimas;
        return volume;
    }
}
