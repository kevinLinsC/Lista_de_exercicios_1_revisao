/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_12_kevin;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author kevin
 */
public class PROJETO_12_KEVIN {

    public static void main(String[] args) throws IOException {
        Random aleatorio = new Random();
        int N;
        int V[];
        int vetorAux[];
        int i;
        int X;
        int contador; //Usado para contar quantos numeros serão removidos.
        int index; // Varivel auxiliar, serve para escrever o numero no vetorAux de forma correta.
        
        N = PegaNum("Defina o tamanho do vetor [0 - 50]: ");
        
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

        // Loop para perguntar o numero e deletar do vetor.
        while (true) {
            // Se o vetor (V) for menor ou igual a zero, o codigo informa que não há mais valores.
            if (V.length > 0) {
                Linha();
                X = PegaNum("Digite um numero para deletar do vetor (0 - sair): ");

                if (X == 0) {
                    break;
                }

                // Verifica se o numeros esta presente no vetor, se estiver apaga as posiçoes, se não fala que não esta presente.
                contador = 0;
                if (VerifVetor(V, X)) {
                    for(i = 0; i < V.length; i++) {
                        // Verifica se o numero é o escolhido pelo usuario, se for troca por zero.
                        if (X == V[i]) {
                            V[i] = 0;
                            contador++;
                        }
                    }

                    vetorAux = new int[V.length - contador]; // Definindo o tamanho do vetor auxiliar.

                    // Passa o vetor V para o vetorAux, sem o numero escolhido pelo usuario.
                    index = 0;
                    for(i = 0; i < V.length; i++) {
                        if (V[i] != 0) {
                            vetorAux[index] = V[i];
                            index++;
                        }
                    }

                    V = vetorAux; // Passa o vetorAux para o vetor principal(V).

                    Linha();
                    System.out.println("O novo vetor e: ");
                    System.out.println(Arrays.toString(V));

                }
                else {
                    System.out.println("Nao foi encontrado nenhum valor.");
                }
            }
            else {
                Linha();
                System.out.println("O vetor nao tem mais valores.");
                break;
            }
        }
        
        Linha();
        System.out.println("Obrigado por usar o programa.");
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
                if (num >= 0 && num <= 50) {
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
