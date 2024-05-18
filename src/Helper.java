import java.util.Scanner;

public class Helper {
    public static void LimparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void MensagemContinuar(Scanner ler) {
        System.out.println("Dê enter para continuar");

        ler.nextLine();

        Helper.LimparTela();
    }

    public static Integer ValidarInteiro(Scanner ler) {
        while (!ler.hasNextInt()) {
            System.out.println("O valor informado inválido");
            ler.nextLine();
        }
        return ler.nextInt();
    }
}
