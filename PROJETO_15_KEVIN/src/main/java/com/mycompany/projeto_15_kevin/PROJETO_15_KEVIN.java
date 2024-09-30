/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_15_kevin;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class PROJETO_15_KEVIN {

    public static void main(String[] args) throws IOException {
        int anoAtual;
        int anoNasc;
        int idade;
        
        anoNasc = PegaAno("Digite seu ano de nascimento: ");
        anoAtual = PegaAno("Digite o ano atual: ");
        
        idade = anoAtual - anoNasc;
        
        Linha();
        
        System.out.println("Sua idade no ano atual e: " + idade);
    }
    
    // Trata o erro de input.
    public static int PegaAno(String texto) throws IOException {
        DataInputStream dado;
        String s;
        int num;
        
        // Usuario não sai enquanto não digitar um ano valido.
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
                    System.out.println("ERRO! Digite um ano valido.");
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
