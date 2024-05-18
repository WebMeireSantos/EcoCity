import java.util.Random;
import java.util.Scanner;

public class Fase3 extends Fase {

    private Random gerador = new Random();

    @Override
    public Boolean Jogar(Leo leo) {

        IntroducaoFase();

        System.out.println(
                "Ao chegar ao esconderijo, Leo tem que tomar uma decisão entrar pela porta principal ou procurar uma entrada lateral");
        System.out.println("(1- porta principal / 2- entrada lateral)");

        int temVilao = gerador.nextInt(3);
        if (temVilao == 1) {
            System.out.println("Um guarda de repente apareceu, Leo terá que lutar");
            Vilao vilao = new Vilao(10);
            Batalha(leo, vilao);
        }

        return true;
    }

    private void IntroducaoFase() {

        Helper.MensagemContinuar();

        System.out.println("Fase 3 - Doutor Névoa Negra");
        System.out.println(
                "\nA cidade acorda em uma manhã mais escura do que o normal, e uma densa fumaça emerge do último andar de um prédio residencial.");
        System.out.println(
                "O responsável por essa névoa tóxica é o sinistro Dr. Névoa Negra, um cientista louco que desenvolveu uma máquina capaz de liberar poluentes no ar, intensificando a poluição e colocando em risco a saúde dos cidadãos.");
        System.out.println(
                "Determinado a deter essa ameaça, Leo tenta confrontar o cientista maluco.");

        Helper.MensagemContinuar();

    }

    private void Batalha(Leo leo, Vilao vilao) {
        System.out.println("(1- Pedra / 2- Papel / 3- Tesoura)");
        Scanner ler = new Scanner(System.in);
        gerador.nextInt(1, 3);
        int escolha = integer.parseInt(ler.nextLine());
    }
}
