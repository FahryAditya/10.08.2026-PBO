package MenghitungDerajat;

    

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan suhu dalam Celsius: ");
        double nilaiSuhu = input.nextDouble();

        Termometer termometer = new Termometer(nilaiSuhu);

        System.out.println("\n=== Hasil Konversi Suhu ===");
        System.out.println("Celsius    : " + termometer.getCelcius() + " °C");
        System.out.println("Fahrenheit : " + termometer.keFahrenheit() + " °F");
        System.out.println("Reamur     : " + termometer.keReamur() + " °R");
        System.out.println("Kelvin     : " + termometer.keKelvin() + " K");

        input.close();
    }
}