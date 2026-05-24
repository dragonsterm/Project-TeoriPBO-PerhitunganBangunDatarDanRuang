/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri;

/**
 *
 * @author mahar
 */
public class Persegi extends BangunDatar {
    protected double sisi;
    protected double luas;
    protected double keliling;


    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    public double getLuas() {
        return luas;
    }

    public double getKeliling() {
        return keliling;
    }

    @Override
    public double hitungLuas() {
        luas = sisi * sisi;
        return luas;
    }

    @Override
    public double hitungKeliling() {
        keliling = 4 * sisi;
        return keliling;
    }

    public double hitungKeliling(double sisiAlas) {
        keliling = 4 * sisiAlas;
        return keliling;
    }
}
