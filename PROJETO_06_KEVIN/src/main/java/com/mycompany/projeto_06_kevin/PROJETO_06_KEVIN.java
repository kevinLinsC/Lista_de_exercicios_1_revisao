/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_06_kevin;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class PROJETO_06_KEVIN {

    public static void main(String[] args) throws IOException {
        int num;
        
        // Loop perguntando para o usuario digitar um numero.
        while (true) {
            num = PegaNum("Digite um numero (0 - Para o programa): ");
            
            // Se o numero for igual a zero, sai do loop.
            if (num == 0) {
                break;
            }
            else {
                if (num > 0) {
                    System.out.println("Numero e positivo.");
                }
                else {
                    System.out.println("Numero e negativo");
                }
            }
            
            Linha();
        }
        
        Linha(); 
        System.out.println("Fim do programa.");
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
