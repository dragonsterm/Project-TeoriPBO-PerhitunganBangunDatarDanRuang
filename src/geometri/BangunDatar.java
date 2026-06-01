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
    private String namaBenda;
    private String hasilAkhir;

    public void setNamaBenda(String namaBenda) {
        this.namaBenda = namaBenda;
    }

    public String getNamaBenda() {
        return this.namaBenda;
    }

    public void setHasilAkhir(String hasilAkhir) {
        this.hasilAkhir = hasilAkhir;
    }

    public String getHasilAkhir() {
        return this.hasilAkhir;
    }

    @Override
    public abstract double hitungLuas();

    @Override
    public abstract double hitungKeliling();
}
