package org.example;

import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.example.factories.ProductoFactory;
import org.example.models.Producto;

import java.util.Random;
import java.util.Scanner;

public class FacturaMain {
    static Random rdn = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Producto[] productos = new Producto[rdn.nextInt(5,15)];
        ProductoFactory.getInstance().createProductosRandom(productos);

        String usuario = inputString("Introduce tu nombre de usuario: ");

        System.out.println("Bienvenido " + usuario);

        //Coroutine

    }

    private static String inputString(String message) {
        System.out.println(message);
        String response;
        do {
            response = sc.nextLine();
            if (response.isEmpty())
                System.out.println("Error: Introduce algún texto.");
        }while (response.isEmpty());
        return response;
    }
}