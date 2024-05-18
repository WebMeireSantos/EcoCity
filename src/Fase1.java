
import java.util.Random;
import java.util.Scanner;

public class Fase1 extends Fase {

    private Random gerador = new Random();

    final String[][] ataques;

    final String[] categorias;

    public Fase1() {
        super();
        ataques = new String[][] {
                { "caixinha de leite", "papel" },
                { "garrafa pet", "plástico" },
                { "latinha", "alumínio" },
                { "casca de banana", "orgânico" },
                { "canudo de plástico", "plástico" },
                { "restos de alimentos", "orgânico" },
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
    public Boolean Jogar(Leo leo) {

        Vilao vilao = new Vilao(100);

        IntroducaoFase();

        // loop de jogo
        while (leo.GetVida() > 0 && vilao.GetVida() > 0) {

            int ataque = ObterAtaque();

            ExibirOpcoes();

            if (ValidarEscolha(ataque)) {
                Helper.LimparTela();
                vilao.DiminuirVida(10);
                System.out.println("Muito bem, você descartou corretamente\n");
            } else {
                Helper.LimparTela();
                leo.DiminuirVida(10);
                System.out.println("Que pena, resposta errada");
                System.out.println(
                        String.format("O descarte correto para %s era %s\n", ataques[ataque][0], ataques[ataque][1]));
            }

            System.out.println("Leo: " + leo.GetVida() + " de XP");
            System.out.println("Capitão lixo: " + vilao.GetVida() + " de XP");

            System.out.println("\n--------------");
        }

        Helper.LimparTela();

        if (leo.GetVida() > 0) {
            System.out.println("\nLeo derrotou o Capitão Lixo e adquiriu 'Resistência ao Odor' !\n");
            Helper.MensagemContinuar();
            return true;
        }

        System.out.println(
                "Leo infelizmente não conseguiu derrotar o Capitão Lixo e desmaiou com o cheiro terrível que o cercava!\n");
        System.out.println("Tentar novamente (1- Sim / 2 - Não)?");

        Scanner ler = new Scanner(System.in);
        int escolha = Integer.parseInt(ler.nextLine());
        ler.close();

        if (escolha == 2) {
            System.exit(0);
        }

        Helper.LimparTela();

        return false;

    }

    private void IntroducaoFase() {

        Helper.MensagemContinuar();

        System.out.println("Fase 1 - Luta conta a sujeira nas ruas");
        System.out.println(
                "\nEm uma manhã ensolarada, Leo decide explorar as ruas da cidade em busca de novos indícios sobre o aumento da poluição que vem observando.");
        System.out.println(
                "Rapidamente, um odor desagradável invade suas narinas, quando se depara com uma cena desoladora: um monte de lixo se acumula, formando o início de um verdadeiro lixão a céu aberto.");
        System.out.println(
                "Este é o território do Capitão Lixo, conhecido pelas crianças do bairro por recolher o lixo e acumula-los a frente da sua própria casa.");

        System.out.println("\nAo ser atacado com o lixo do Capitão Lixo, defina o descarte correto");

        Helper.MensagemContinuar();

    }

    // Exibe as escolhas disponiveis
    private void ExibirOpcoes() {
        System.out.println("\nEscolha onde deve ser o descarte correto");

        for (int i = 0; i < categorias.length; i++) {
            System.out.println(String.format("%s - %s", i + 1, categorias[i]));
        }
    }

    // Checa se a escolha do descarte equivale a categoria do lixo atacado
    private boolean ValidarEscolha(int escolhaVilao) {

        Scanner ler = new Scanner(System.in);
        int escolha = Integer.parseInt(ler.nextLine());

        while (escolha < 0 || escolha > categorias.length) {
            ler = new Scanner(System.in);
            System.out.println("O valor informado é inválido");
            escolha = Integer.parseInt(ler.nextLine());
            ler.close();
        }

        String categoriaEscolhida = categorias[escolha - 1];
        String categoriaLixoAtacada = ataques[escolhaVilao][1];

        if (categoriaEscolhida.equals(categoriaLixoAtacada)) {
            return true;
        }

        return false;
    }

    // Retorna o nome do lixo baseado no numero da lista
    private int ObterAtaque() {
        // Gera um numero aleatorio entre 1 e o tamanho da lista de lixos
        int ataque = gerador.nextInt(ataques.length);

        System.out.println(String.format("\nO Capitão Lixo atacou com %s.", ataques[ataque][0]));

        return ataque;
    }
}
