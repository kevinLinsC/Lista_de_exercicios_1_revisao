/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_08_kevin;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class PROJETO_08_KEVIN {

    public static void main(String[] args) throws IOException {
        int Min;
        int Max;
        int aux;
        int X;
        int contagem = 0;
        int total = 0;
        
        Min = PegaNum("Digite o valor minimo: ");
        Linha();
        
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
            
            // Se 
            if (X == 0) {
                break;
            }
            
            if (X <= Max && X >= Min) {
                contagem++;
                total += X;
            }
            else {
                System.out.println("Valor fora do intervalo [" + Min + ", " + Max + "] ignorado na totalizacao");
            }
            Linha();
        }
        
        System.out.println("O quantidade de numeros fornecidos foi: " + contagem);
        System.out.println("A totalizacao dos numeros e: " + total);
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
