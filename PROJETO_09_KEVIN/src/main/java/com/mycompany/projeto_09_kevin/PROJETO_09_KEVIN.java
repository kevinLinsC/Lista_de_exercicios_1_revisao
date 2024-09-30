/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_09_kevin;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class PROJETO_09_KEVIN {

    public static void main(String[] args) throws IOException {
        /*
        PROBLEMAS:
        Os problemas identificados são alto uso de processamento, o tamanho da array pode ser além do limite
        e o código pode ficar confuso.
        */
        int Min;
        int Max;
        int aux;
        int X;
        int contagem = 0;
        int total = 0;
        int[] vetorAux;
        int[] numeros = new int[1];
        
        Min = PegaNum("Digite o valor minimo: ");
        
        Max = PegaNum("Digite o valor maximo: ");
        Linha();
        
        // Verifica se o valor minimo é maior do que o maximo, se for inverte os valores.
        if (Min > Max) {
            aux = Max;
            Max = Min;
            Min = aux;
        }
        
        while (true) {
            X = PegaNum("Digite um numero inteiro (0 - sair): ");
            
            // Se o valor for zero sai do loop.
            if (X == 0) {
                break;
            }
            
            if (X <= Max && X >= Min) {
                vetorAux = new int[contagem + 1];
                
                for (int i = 0; i < numeros.length; i++) {
                    vetorAux[i] = numeros[i];
                }
                vetorAux[contagem] = X;
                numeros = vetorAux;
                
                contagem++;
                total += X;
            }
            else {
                System.out.println("Valor fora do intervalo [" + Min + ", " + Max + "] ignorado na totalizacao");
            }

            Linha();
        }
        
        Linha();
        
        System.out.print("Os numeros digitados foram: ");
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i < numeros.length - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.println("\nA totalizacao dos numeros e: " + total);
        System.out.println("O quantidade de numeros fornecidos foi: " + contagem);
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
