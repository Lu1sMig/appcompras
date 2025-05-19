package org.yanapaytech.principal;

import org.yanapaytech.modelo.Compra;
import org.yanapaytech.modelo.TarjetaDeCredito;
import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escribe el limite de la tarjeta; ");
        double limite = lectura.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir = 1;
        while(salir!= 0){
            System.out.println("Escriba la descripción de la compra:");
            String descripcion = lectura.next();

            System.out.println("Escriba el valor de la compra:");
            double valor = Double.valueOf(lectura.next());

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            if(compraRealizada){
                System.out.println("Compra realizada!");
                System.out.println("Escribe 0 para salir o 1 para continuar");
                salir = lectura.nextInt();
            }else {
                System.out.println("Saldo insuficiente!");
                salir = 0;
            }
        }
        System.out.println("*****************************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(tarjeta.getListaDeCompras());
        for (Compra compra : tarjeta.getListaDeCompras()){
            System.out.println(compra.getDescripcion()+" - "+compra.getValor());
        }
        System.out.println("\n****************************");
        System.out.println("\nSaldo de la tarjeta"+tarjeta.getSaldo());
    }
}