
import java.util.Random;
import java.util.Scanner;

public class Fase1 extends Fase {

    private Random gerador = new Random();

    final String[][] lixos;

    final String[] categorias;

    public Fase1() {
        super();
        lixos = new String[][] {
                { "caixinha de leite", "papel" },
                { "garrafa pet", "plástico" },
                { "latinha", "alumínio" },
                { "casca de banana", "orgânico" },
                { "canudo de plástico", "plástico" },
                { "cascas de frutas", "orgânico" },
                { "livros", "papel" },
                { "garrafa", "vidro" },
                { "caixa de sapato", "papel" },
                { "panela de alumínio", "alumínio" },
                { "pote de sorvete", "plástico" },
                { "pilha", "bateria" }
        };

        categorias = new String[] {
                "papel", "plástico", "alumínio", "orgânico", "vidro", "bateria"
        };
    }

    @Override
    public Boolean AcaoFase(Leo leo) {
        Scanner ler = new Scanner(System.in);

        Vilao vilao = new Vilao();

        IntroducaoFase(ler);

        // loop de jogo
        while (leo.GetVida() > 0 && vilao.GetVida() > 0) {

            int ataque = ObterAtaque();

            ExibirOpcoes();

            if (ValidaEscolha(ataque, ler)) {
                vilao.DiminuirVida(10);
                System.out.println("Muito bem, você descartou corretamente\n");
            } else {
                leo.DiminuirVida(10);
                System.out.println("Que pena, resposta errada");
                System.out.println(
                        String.format("O descarte correto para %s era %s\n", lixos[ataque][0], lixos[ataque][1]));
            }

            System.out.println("Leo: " + leo.GetVida() + " de XP");
            System.out.println("Capitão lixo: " + vilao.GetVida() + " de XP");

            System.out.println("\n--------------");
        }

        Helper.LimparTela();

        if (leo.GetVida() > 0) {
            System.out.println("Leo derrotou o Capitão Lixo e adquiriu 'Resistência ao Odor' !");
            return true;
        }

        System.out.println(
                "Leo infelizmente não conseguiu derrotar o Capitão Lixo e desmaiou com o cheiro terrível que o cercava!\n");
        System.out.println("Tentar novamente (1- Sim / 2 - Não)?");

        int escolha = Helper.ValidarInteiro(ler);

        if (escolha == 2) {
            System.exit(0);
        }

        Helper.LimparTela();

        return false;

    }

    private void IntroducaoFase(Scanner ler) {

        // Helper.MensagemContinuar(ler);
        System.out.println("Dê enter para continuar");

        ler.nextLine();

        Helper.LimparTela();

        System.out.println("Fase 1 - Capitão Lixo");
        System.out.println(
                """
                        \nEm uma manhã ensolarada, Leo decide explorar as ruas da cidade em busca de novos indícios sobre o aumento da poluição que vem observando.
                        Rapidamente, um odor desagradável invade suas narinas, quando se depara com uma cena desoladora: um monte de lixo se acumula, formando o início de um verdadeiro lixão a céu aberto.
                        Este é o território do Capitão Lixo, conhecido pelas crianças do bairro por recolher o lixo e acumula-los a frente da sua própria casa.""");

        System.out.println("\nAo ser atacado com o lixo do Capitão Lixo, defina o descarte correto");

        // Helper.MensagemContinuar(ler);
        System.out.println("Dê enter para continuar");

        ler.nextLine();

        Helper.LimparTela();
    }

    // Exibe as escolhas disponiveis
    private void ExibirOpcoes() {
        System.out.println("\nEscolha onde deve ser o descarte correto");

        for (int i = 0; i < categorias.length; i++) {
            System.out.println(String.format("%s - %s", i + 1, categorias[i]));
        }
    }

    // Checa se a escolha do descarte equivale a categoria do lixo atacado
    private boolean ValidaEscolha(int lixo, Scanner ler) {

        int escolha = Helper.ValidarInteiro(ler);

        while (escolha < 0 || escolha > categorias.length) {
            System.out.println("O valor informado inválido");
            escolha = ler.nextInt();
        }

        Helper.LimparTela();

        String categoriaEscolhida = categorias[escolha - 1];
        String categoriaLixoAtacada = lixos[lixo][1];

        if (categoriaEscolhida == categoriaLixoAtacada) {
            return true;
        }

        return false;
    }

    // Retorna o nome do lixo baseado no numero da lista
    private int ObterAtaque() {
        // Gera um numero aleatorio entre 1 e o tamanho da lista de lixos
        int ataque = gerador.nextInt(lixos.length);

        System.out.println(String.format("O Capitão Lixo atacou com %s.", lixos[ataque][0]));

        return ataque;
    }
}
