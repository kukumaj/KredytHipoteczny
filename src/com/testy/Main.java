package com.testy;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MIES_W_ROKU = 12;
        final byte PROCENT = 100;

        Scanner wczyt_dane = new Scanner(System.in);

        System.out.print("Kwota_Kredytu: ");
        int kw_kredytu = wczyt_dane.nextInt();

        System.out.print("Oprocentowanie_Roczne: ");
        float opr_rocz = wczyt_dane.nextFloat();
        float opr_mies = opr_rocz / PROCENT / MIES_W_ROKU;

        System.out.print("Okres(w latach): ");
        byte lata = wczyt_dane.nextByte();
        int ilosc_splat = lata * MIES_W_ROKU;

        double hipoteka = kw_kredytu
                * (opr_mies * Math.pow(1 + opr_mies, ilosc_splat))
                / (Math.pow(1 + opr_mies, ilosc_splat) - 1);

        String hipotekaformatowanie = NumberFormat.getCurrencyInstance().format(hipoteka);
        System.out.println("Kredyt jeszcze do splacenia: " + hipotekaformatowanie);
    }
}