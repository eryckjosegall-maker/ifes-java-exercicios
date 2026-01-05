import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num;
        int numAnterior = 0;
        int numAtual = 1;
        int numProximo = 0;

        System.out.print("Digite um número: ");
        num = in.nextInt();

        // A sequência é gerada até ultrapassar o número digitado
        while (numProximo < num) {
            numProximo = numAnterior + numAtual;
            numAnterior = numAtual;
            numAtual = numProximo;
        }

        if (numProximo == num) {
            System.out.println(num + " faz parte da sequência de Fibonacci.");
        } else {
            System.out.println(num + " não faz parte da sequência de Fibonacci.");
            System.out.println("O maior número da sequência menor que ele é: " + numAnterior);
        }

        in.close();
    }
}
