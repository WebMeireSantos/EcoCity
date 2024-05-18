
import java.util.Scanner;

public class Helper {
    public static void LimparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void MensagemContinuar() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Dê enter para continuar");

        ler.nextLine();

        Helper.LimparTela();
    }
}
