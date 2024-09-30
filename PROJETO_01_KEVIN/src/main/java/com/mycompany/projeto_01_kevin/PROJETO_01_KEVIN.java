/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_01_kevin;

import java.io.DataInputStream;
import java.io.IOException;



/**
 *
 * @author k.andrade
 */
public class PROJETO_01_KEVIN {

    public static void main(String[] args) throws IOException {
        
        int numUm;
        int numDois;
        int soma;
        
        numUm = PegaNum("Digite o primeiro numero: ");
        Linha();
        
        numDois = PegaNum("Digite o segundo numero: ");
        Linha();
        
        soma = numUm + numDois;
        
        System.out.println("Soma de " + numUm + " com " + numDois + " = " + soma);
    }
    
    // Trata o erro de input.
    public static int PegaNum(String texto) throws IOException {
        DataInputStream dado;
        String s;
        int num;
        
        // Usuario não sai enquanto não digitar um numero inteiro.
        while (true) {
            System.out.print(texto);
            dado = new DataInputStream(System.in);
            s = dado.readLine();
            try {
                num = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Digite um numero inteiro.");
            }
        }
        
        return num;
    }
    
    public static void Linha() {
        System.out.println("-------------------------------------");
    }
}
