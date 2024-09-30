/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_11_kevin;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author kevin
 */
public class PROJETO_11_KEVIN {

    public static void main(String[] args) throws IOException {
        Random aleatorio = new Random();
        int N;
        int V[];
        int i;
        int X;
        
        N = PegaNum("Defina o tamanho do vetor [0 - 50]: ", true);
        
        V = new int[N]; // Definindo o tamanho do vetor V.
        
        // Gera os numeros aleatorios.
        for (i = 0; i < V.length; i++) {
            V[i] = aleatorio.nextInt(1, 51);
            if (V[i] == 0) {
                i--;
            }
        }
        
        // Escreve os numeros para o usuario.
        Linha();
        System.out.println("Os numeros gerados sao: ");
        System.out.println(Arrays.toString(V));

        // Loop para perguntar o numero e mostrar se esta presente no vetor.
        while (true) {
            Linha();
            X = PegaNum("Digite um numero para saber se ele esta presente no vetor (0 - sair):  ", false);
            
            if (X == 0) {
                break;
            }
            
            // Verifica se o numeros esta presente no vetor, se estiver mostra as posiçoes, se não fala que naõ esta presente.
            if (VerifVetor(V, X)) {
                System.out.println("O valor esta nas posicoes: ");
                for (i = 0; i < V.length; i++) {
                    if (X == V[i]) {
                        System.out.print((i + 1) + "a  ");
                    }
                }
                System.out.println();
            }
            else {
                System.out.println("Nao foi encontrado nenhum valor.");
            }
        }
    }
    
    // Trata o erro de input.
    public static int PegaNum(String texto, boolean verif) throws IOException {
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
                if (verif == true && num >= 0 && num <= 50) {
                    break;
                }
                else if (verif == false) {
                    break;
                }
                else {
                    System.out.println("ERRO! Digite um numero valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Digite um numero inteiro.");
            }
        }
        
        return num;
    }
    
    // Verifica se o numero esta no vetor V.
    public static boolean VerifVetor(int[] V, int num) {
        int i;
        boolean existe = false;
        for (i = 0; i < V.length; i++) {
            if (V[i] == num) {
                existe = true;
            }
        }
        
        return existe;
    } 
    
    public static void Linha() {
        System.out.println("-------------------------------------");
    }
}
