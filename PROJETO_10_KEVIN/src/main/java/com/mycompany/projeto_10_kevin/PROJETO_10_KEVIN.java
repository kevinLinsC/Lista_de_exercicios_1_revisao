/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_10_kevin;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author kevin
 */
public class PROJETO_10_KEVIN {

    public static void main(String[] args) throws IOException {
        int i;
        int N;
        float[] A;
        float[] NEG;
        int contNeg = 0;
        float[] POS;
        int contPos = 0;
        
        N = PegaNumInt("Defina o tamanho do vetor [0 - 50]: ");
        
        A = new float[N]; // Cria um vetor A com o tamanho indicado pelo usuario.
        
        Linha();
        
        // Preenche o vetor.
        for (i = 0; i < A.length; i++) {
            A[i] = PegaNumFloat("Digite o " + (i + 1) + " numero real: ");
            if (A[i] >= 0) {
                contPos++;
            }
            else {
                contNeg++;
            }
        }
        
        Linha();
        
        NEG = new float[contNeg]; // Cria um vetor NEG com a quantidade de numeros negativos.
        POS = new float[contPos]; // Cria um vetor POS com a quantidade de numeros positivos.
        
        // Separa os valores positivos e negativos, e coloca em cada vetor respectivo.
        for (i = A.length - 1; i >= 0; i--) {
            if (A[i] >= 0) {
                POS[contPos - 1] = A[i]; // Preenche o vetor de trás para frente.
                contPos--;
            }
            else {
                NEG[contNeg - 1] = A[i]; // Preenche o vetor de trás para frente.
                contNeg--;
            }
        }
        
        System.out.println("A quantidade de valores negativos inseridos foi: " + NEG.length);
        System.out.println("Os numeros negativos inseridos foram: " + Arrays.toString(NEG));
        Linha();
        
        System.out.println("A quantidade de valores positivos inseridos foi: " + POS.length);
        System.out.println("Os numeros positivos inseridos foram: " + Arrays.toString(POS));
        Linha();
    }
    
    // Trata o erro de input.
    public static int PegaNumInt(String texto) throws IOException {
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
    
    // Trata o erro de input.
    public static float PegaNumFloat(String texto) throws IOException {
        DataInputStream dado;
        String s;
        float num;
        
        // Usuario não sai enquanto não digitar um numero real.
        while (true) {
            System.out.print(texto);
            dado = new DataInputStream(System.in);
            s = dado.readLine();
            try {
                num = Float.parseFloat(s);
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
