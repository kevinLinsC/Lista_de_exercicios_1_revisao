/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_05_kevin;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author k.andrade
 */
public class PROJETO_05_KEVIN {

    public static void main(String[] args) throws IOException {
        DataInputStream dado;
        String nomeLutador;
        String categoria;
        String caminho = "C:\\Users\\kevin\\Desktop\\lutador ";
        float peso;
        
        System.out.print("Digite o nome do lutador: ");
        dado = new DataInputStream(System.in);
        nomeLutador = dado.readLine();
        
        Linha();
        
        peso = PegaNum("Digite o peso do lutador: ");
        
        categoria = Categoria(peso);
        
        // Escreve em um .txt.
        FileWriter arquivo = new FileWriter(caminho + nomeLutador);
        PrintWriter gravar = new PrintWriter(arquivo);
        
        gravar.printf("Nome fornecido: " + nomeLutador);
        gravar.printf("\nPeso fornecido: " + peso);
        gravar.printf("\nO lutador " + nomeLutador + " pesa " + peso + "kg e se enquadra na categoria " + categoria + ".");
        gravar.close();
    }
    
    // Verifica a categoria do lutador e retorna sua categoria.
    public static String Categoria(float peso) {
        String categoria;
        if (peso < 65) {
            categoria = "Pena";
        }
        else if (peso >= 65 && peso < 72) {
            categoria = "Leve";
        }
        else if (peso >= 72 && peso < 79) {
            categoria = "Ligeiro";
        }
        else if (peso >= 79 && peso < 86) {
            categoria = "Meio medio";
        }
        else if (peso >= 86 && peso < 93) {
            categoria = "Medio";
        }
        else if (peso >= 93 && peso < 100) {
            categoria = "Meio pesado";
        }
        else {
            categoria = "Pesado";
        }
        
        return categoria;
    }
    
    // Trata o erro de input.
    public static float PegaNum(String texto) throws IOException {
        DataInputStream dado;
        String s;
        float num;
        
        // Usuario não sai enquanto não digitar um numero.
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
                    System.out.println("ERRO! Digite um numero positivo ou maior que zero.");
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
