/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_16_kevin;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class PROJETO_16_KEVIN {

    public static void main(String[] args) throws IOException {
        int funcionarios;
        float[] salario;
        float somaTotalSalario = 0;
        float media;
        int funcionariosAcimaMedia = 0;
        
        funcionarios = PegaNum("Digite a quantidade de funcionarios: ");
        Linha();
        
        salario = new float[funcionarios]; // Cria o vetor funcionario com a quantidade de funcionarios.
        
        // Pega o salario dos funcionarios.
        for (int i = 0; i < salario.length; i++) {
            salario[i] = PegaSalario("Digite o salario do " + (i + 1) + " funcionario: ");
            somaTotalSalario += salario[i];
        }
        
        media = somaTotalSalario / salario.length; // Media do salario de todos os funcionarios.
        
        for (int i = 0; i < salario.length; i++) {
            if (salario[i] > media) {
                funcionariosAcimaMedia++;
            }
        }
        
        Linha();
        System.out.println("A media salarial da empresa e: R$" + media);
        Linha();
        System.out.println("A quantidade de funcionarios com o salario acima da media e: " + funcionariosAcimaMedia);
    }
    
    // Trata o erro de input.
    public static int PegaNum(String texto) throws IOException {
        DataInputStream dado;
        String s;
        int num;
        
        // Usuario não sai enquanto não digitar um numero de funcionarios valido.
        while (true) {
            System.out.print(texto);
            dado = new DataInputStream(System.in);
            s = dado.readLine();
            try {
                num = Integer.parseInt(s);
                if (num > 0) {
                    break;
                }
                else {
                    System.out.println("ERRO! Digite um numero de funcionarios valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Digite um numero inteiro.");
            }
        }
        
        return num;
    }
    
    // Trata o erro de input.
    public static float PegaSalario(String texto) throws IOException {
        DataInputStream dado;
        String s;
        float num;
        
        // Usuario não sai enquanto não digitar um salario valido.
        while (true) {
            System.out.print(texto);
            dado = new DataInputStream(System.in);
            s = dado.readLine();
            try {
                num = Float.parseFloat(s);
                if (num > 0) {
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
    
    public static void Linha() {
        System.out.println("-------------------------------------");
    }
}
