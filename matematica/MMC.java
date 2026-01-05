import java.util.Scanner;

public class MMC {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Quantos números quer para calcular o MMC: ");
        int quantidadeNumeros = in.nextInt();

        int[] listaDosNumeros = new int[quantidadeNumeros];

        int cont = 0;
        while (cont < quantidadeNumeros) {
            System.out.print("Digite o número " + (cont + 1) + ": ");
            listaDosNumeros[cont] = in.nextInt();

            while (listaDosNumeros[cont] <= 0) {
                System.out.print("Valor inválido. Digite um número positivo: ");
                listaDosNumeros[cont] = in.nextInt();
            }

            cont++;
        }

        calcularMMC(listaDosNumeros);
        in.close();
    }

    public static void calcularMMC(int[] numeros) {

        int mmcFinal = 1;
        int fatorPrimoCandidato = 2;
        int controlaLoop = 1;

        while (controlaLoop == 1) {

            int teveDivisao = 0;
            int possuiValorMaiorQueUm = 0;

            int contador = 0;
            while (contador < numeros.length) {
                if (numeros[contador] % fatorPrimoCandidato == 0) {
                    teveDivisao = 1;
                }
                contador++;
            }

            if (teveDivisao == 1) {
                for (int i = 0; i < numeros.length; i++) {
                    System.out.print(numeros[i] + " ");
                }
                System.out.println("| " + fatorPrimoCandidato);

                contador = 0;
                while (contador < numeros.length) {
                    if (numeros[contador] % fatorPrimoCandidato == 0) {
                        numeros[contador] = numeros[contador] / fatorPrimoCandidato;
                    }
                    contador++;
                }

                mmcFinal = mmcFinal * fatorPrimoCandidato;
            } else {
                fatorPrimoCandidato++;
            }

            contador = 0;
            while (contador < numeros.length) {
                if (numeros[contador] > 1) {
                    possuiValorMaiorQueUm = 1;
                }
                contador++;
            }

            if (possuiValorMaiorQueUm == 0) {
                controlaLoop = 0;
            }
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("1 ");
        }
        System.out.println();
        System.out.println("(mmc) " + mmcFinal);
    }
}
