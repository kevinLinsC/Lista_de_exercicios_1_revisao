/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_07_kevin;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class PROJETO_07_KEVIN {

    public static void main(String[] args) throws IOException {
        int num;
        int maiorNum = Integer.MIN_VALUE;
        int menorNum = Integer.MAX_VALUE;
        int qtdValores = 0;
        float soma = 0;
        float media;
        
        while (true) {
            num = PegaNum("Digite o " + (qtdValores + 1) + " numero (0 ou valor negativo para sair do programa): ");

            if (num <= 0) {
                break;
            }
            else {
                // Verifica o maior e o menor numero.
                if (num > maiorNum) {
                    maiorNum = num;
                }
                if (num < menorNum) {
                    menorNum = num;
                }
                
                qtdValores++; // Quantidade de numeros digitados.
                soma += num; // Soma de todos os numeros.
            }
        }
        
        media = soma / qtdValores; // Media entre soma / Quantidade de numeros digitados.
        
        Linha();
        System.out.println("O maior numero inserido foi: " + maiorNum);
        System.out.println("O menor numero inserido foi: " + menorNum);
        System.out.println("A quantidade de valores inseridos foi: " + qtdValores);
        System.out.println("A soma de todos os valores inseridos foi: " + soma);
        System.out.println("A media de todos os valores inseridos foi: " + media);
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
