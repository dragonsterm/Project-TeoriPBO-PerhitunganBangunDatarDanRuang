/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geometri;

/**
 *
 * @author mahar
 */
public abstract class BangunDatar implements Geometri {
    public String namaBangun;
    public String hasilAkhir;

    @Override
    public abstract double hitungLuas();

    @Override
    public abstract double hitungKeliling();
}
