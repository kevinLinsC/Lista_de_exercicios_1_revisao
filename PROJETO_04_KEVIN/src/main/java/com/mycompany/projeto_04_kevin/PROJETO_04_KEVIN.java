/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_04_kevin;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author k.andrade
 */
public class PROJETO_04_KEVIN {

    public static void main(String[] args) throws IOException {
        float A;
        float B;
        float C;
        String nomeTrian; // Nome do triangulo.
        
        A = pegaNum("Digite o primeiro lado do triangulo: ");
        System.out.println("----------------------------------");
        
        B = pegaNum("Digite o segundo lado do triangulo: ");
        System.out.println("----------------------------------");
        
        C = pegaNum("Digite o terceiro lado do triangulo: ");
        System.out.println("----------------------------------");
        
        if ((A + B > C) && (A + C > B) && (B + C > A)) {
            nomeTrian = verifiTriangulo(A, B, C);
            System.out.println("Os numeros formam um triangulo " + nomeTrian);
        }
        else {
            System.out.println("Os numeros nao formam um triangulo.");
        }
    }
    
    public static String verifiTriangulo(float A, float B, float C) {
        String nomeTrian;
        
        if (A == B && A == C) {
            nomeTrian = "equilatero.";
        }
        else if (A != B && A != C) {
            nomeTrian = "escaleno.";
        }
        else {
            nomeTrian = "isosceles.";
        }
        return nomeTrian;
    }
    
    // Trata o erro de input.
    public static float pegaNum(String texto) throws IOException {
        DataInputStream dado;
        String s;
        float num = 0;
        
        // Usuario não sai enquanto não digitar um numero real.
        while (true) {
            System.out.print(texto);
            dado = new DataInputStream(System.in);
            s = dado.readLine();
            try {
                num = Float.parseFloat(s);
                if (num > 0) {
                    break;
                } else {
                    System.out.println("ERRO! Digite somente numeros reais positivos.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Digite um numero real.");
            }
        }
        
        return num;
    }
}
