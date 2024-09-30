/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projeto_14_kevin;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author kevin
 */
public class PROJETO_14_KEVIN {

    public static void main(String[] args) throws IOException {
        DataInputStream dado;
        String nome;
        float salario;
        float salarioReajustado;
        float somaSalario = 0;
        float somaReajuste = 0;
        float diferenca;
        
        while (true) {
            // Pega o nome do funcionario.
            System.out.print("Digite o nome do funcionario (FIM - sair): ");
            dado = new DataInputStream(System.in);
            nome = dado.readLine();
            Linha();
            
            if (nome.equals("FIM")){
                break;
            }

            // Pega o salario do funcionario.
            salario = PegaSalario("Digite o salario do funcionario: ");
            Linha();

            // Salario reajustado.
            salarioReajustado = Reajuste(salario);
            System.out.println(nome + " ganhava R$" + salario + ".");
            System.out.println("O salario reajustado e: R$" + salarioReajustado);
            
            somaSalario += salario;
            somaReajuste += salarioReajustado;
            Linha();
        }
        
        diferenca = somaReajuste - somaSalario;
        
        System.out.println("A Soma dos salarios atuais e: R$" + somaSalario);
        System.out.println("A soma dos salario reajustados e: R$" + somaReajuste);
        System.out.println("A diferenca entre eles: R$" + diferenca);
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
                    System.out.println("ERRO! Digite um salario valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO! Digite um numero inteiro.");
            }
        }
        
        return num;
    }
    
    // Faz o calculo de reajuste salarial.
    public static float Reajuste(float salario) {
        if (salario <= 150) {
            salario = (float) (salario + (salario * 0.25));
        }
        else if (salario > 150 && salario <= 300) {
            salario = (float) (salario + (salario * 0.20));
        }
        else if (salario > 300 && salario <= 600) {
            salario = (float) (salario + (salario * 0.15));
        }
        else {
            salario = (float) (salario + (salario * 0.10));
        }
        
        return salario;
    }
    
    public static void Linha() {
        System.out.println("-------------------------------------");
    }
}
