/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_05_kevin;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author k.andrade
 */
public class PROJETO_05_KEVIN {

    public static void main(String[] args) throws IOException {
        DataInputStream dado;
        String s;
        String nomeLutador;
        float peso;
        
        System.out.print("Digite o nome do lutador: ");
        dado = new DataInputStream(System.in);
        nomeLutador = dado.readLine();
        
        System.out.println("-----------------------------");
        
        peso = pegaNum("Digite o peso do lutador: ");
        
    }
    
    public static float pegaNum(String texto) throws IOException {
        DataInputStream dado;
        String s;
        float num;
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
                    System.out.println("ERRO! Digite um numero positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Digite um numero inteiro.");
            }
        }
        
        return num;
    }
}
