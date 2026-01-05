import java.util.Scanner;

public class BhaskaraMetodoBabilonico {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Digite o valor de A: ");
        double a = in.nextDouble();

        while (a == 0) {
            System.out.println("O valor de A não pode ser 0.");
            System.out.print("Digite outro valor para A: ");
            a = in.nextDouble();
        }

        System.out.print("Digite o valor de B: ");
        double b = in.nextDouble();

        System.out.print("Digite o valor de C: ");
        double c = in.nextDouble();

        double delta = b * b - (4 * a * c);

        if (delta < 0) {
            System.out.println("As raízes da equação são números complexos.");
            in.close();
            return;
        }

        if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("A equação possui apenas uma raiz real: " + x);
            in.close();
            return;
        }

        // Método Babilônico para calcular sqrt(delta)
        double chute = delta / 2.0;
        double limite = 0.00001;
        double proximo;

        do {
            proximo = (chute + delta / chute) / 2.0;
            chute = proximo;
        } while (Math.abs(chute * chute - delta) > limite);

        double raiz1 = (-b - chute) / (2 * a);
        double raiz2 = (-b + chute) / (2 * a);

        System.out.println("Primeira raiz: " + raiz1);
        System.out.println("Segunda raiz: " + raiz2);

        in.close();
    }
}
