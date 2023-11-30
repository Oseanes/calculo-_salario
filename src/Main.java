/*  Faça um programa que receba 5 salários brutos de funcionários, sabendo-se
    que são descontados Imposto de Renda e INSS, calcule e mostre o total do salário
    líquido no referido mês.

        Obs.: Salário Bruto - Descontos = Salário Líquido.

        A saída do programa deve fornecer as seguintes informações:

        Salário bruto.
        Quanto pagou ao INSS.
        Quanto pagou de Imposto de Renda.
        Salário líquido.
*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double salario;
        double impostoRenda;
        double inss;
        double salarioLiquido;

        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Informe o salário:");
                salario = Double.parseDouble(scanner.nextLine());

                impostoRenda = calculaImpostoRenda(salario);
                inss = calculaInss(salario);
                salarioLiquido = salario - (impostoRenda + inss);

                printInf(salario, salarioLiquido, impostoRenda, inss );
            }
        } catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }

    }

    public static double calculaImpostoRenda(double salario) {
        return Math.round(salario * impostoRenda(salario) * 100.00)/100.00;
    }

    public static double calculaInss(double salario) {
        return Math.round( salario * inss(salario)* 100.00)/100.00;
    }

    public static void printInf(double salario, double salarioLiquido, double impostoRenda, double inss) {
        System.out.println(
                "Salário bruto: " + salario + "\n" +
                        "Valor a ser pagou ao INSS: " + inss + "\n" +
                        "Valor a ser pagou de Imposto de Renda:" + impostoRenda + "\n" +
                        "Salário líquido: " + salarioLiquido
        );
    }

    private static double impostoRenda(double salario) {

        if (salario >= 4664.68) {
            return 0.275;
        } else if (salario > 3751.06) {
            return 0.225;
        } else if (salario > 2826.66) {
            return 0.15;
        } else if (salario > 1903.98) {
            return 0.075;
        } else {
            return 0.0;
        }
    }

    private static double inss(double salario) {

        if (salario > 7087.22) {
            return 0.0;
        } else if (salario > 3641.03) {
            return 0.14;
        } else if (salario > 2427.35) {
            return 0.12;
        } else if (salario > 1212.00) {
            return 0.09;
        } else {
            return 0.075;
        }
    }
}














