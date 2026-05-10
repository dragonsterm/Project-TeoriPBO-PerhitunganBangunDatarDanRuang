/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.Geometri;
import model.Bangun3D;
import model.Persegi;
import model.LimasPersegi;

/**
 *
 * @author mahar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan sisi Persegi: ");
        double sisiPersegi = input.nextDouble();
        Persegi persegi = new Persegi(sisiPersegi);

        System.out.print("Masukkan sisi alas Limas: ");
        double sisiLimas = input.nextDouble();
        System.out.print("Masukkan tinggi Limas: ");
        double tinggiLimas = input.nextDouble();
        LimasPersegi limas = new LimasPersegi(sisiLimas, tinggiLimas);


        Geometri[] daftarBangun = { persegi, limas };

        for (Geometri bangun : daftarBangun) {
            String nama = bangun.getClass().getSimpleName();
            System.out.println("Bangun: " + nama);
            System.out.printf("Luas     : %.2f%n", bangun.hitungLuas());
            System.out.printf("Keliling : %.2f%n", bangun.hitungKeliling());

            if (bangun instanceof Bangun3D) {
                double volume = ((Bangun3D) bangun).hitungVolume();
                System.out.printf("Volume   : %.2f%n", volume);
            }
        }

        input.close();
    }
    
}
