import java.util.Random;
import java.util.Scanner;

public class Fase2 extends Fase {
    private Random gerador = new Random();
    private String[][] ataques;
    private String[] categorias;

    public Fase2() {
        super();
        ataques = new String[][] {
                { "carros velozes", "utilização de energias renováveis" },
                { "maquiagens", "não testado em animais" },
                { "como a festa tá bombando", "a importância da reciclagem" },
                { "troca de eletrônicos", "a importância da reciclagem" },
                { "banho ao se preparar pra festa", "uso consciente da água" },
                { "descarte do lixo da festa", "a importância da reciclagem" },
                { "política", "a importância políticas ambientais" },
                { "reunião do bairro", "a importância políticas ambientais" },
                { "limpar a casa", "uso consciente da água" },
                { "higienizar o pet", "uso consciente da água" },
                { "compra de produtos de limpeza", "não testado em animais" },
                { "lavar o carro", "uso consciente da água" },
                { "valor da gasolina", "utilização de energias renováveis" }
        };

        categorias = new String[] {
                "utilização de energias renováveis",
                "não testado em animais",
                "a importância da reciclagem",
                "uso consciente da água"
        };
    }

    @Override
    public Boolean Jogar(Leo leo) {
        Scanner ler = new Scanner(System.in);
        Vilao vilao = new Vilao();

        IntroducaoFase(ler);

        while (leo.GetVida() > 0 && vilao.GetVida() > 0) {

            int ataque = ObterAtaque();

            ExibirOpcoes();

            if (ValidarEscolha(ataque)) {

                vilao.DiminuirVida(10);
                System.out.println("Muito bem, você argumentou corretamente\n");
            } else {
                leo.DiminuirVida(10);
                System.out.println("Que pena, resposta errada");
                System.out.println(
                        String.format("O descarte correto para %s era %s\n", ataques[ataque][0], ataques[ataque][1]));
            }

            System.out.println("Leo: " + leo.GetVida() + " de XP");
            System.out.println("Maus hábitos ambientais: " + vilao.GetVida() + " de XP");

            System.out.println("\n--------------");
        }

        if (leo.GetVida() > 0) {
            System.out.println("Leo conseguiu conscientizar pessoas ao redor e adquiriu a 'Força do Bem' !");
            return true;
        }

        System.out.println(
                "Leo infelizmente não conseguiu conscientizar as pessoas ao redor!\n");
        System.out.println("Tentar novamente (1- Sim / 2 - Não)?");

        int escolha = Integer.parseInt(ler.nextLine());

        if (escolha == 2) {
            System.exit(0);
        }

        Helper.LimparTela();

        return false;
    }

    private void IntroducaoFase(Scanner ler) {
        System.out.println(
                "Leo é convidado para uma festa na rua da floresta, onde um deck próximo ao lago é o ponto de encontro para comemorações jovens.");
        System.out.println(
                "Enquanto observa o local, Leo percebe a falta de lixeiras próximas, o que leva os copos de bebidas a serem espalhados pelo mato.");
        System.out
                .println("Ele decide então fazer alguma coisa e conscientizar os presentes sobre problemas ambientais");
    }

    private int ObterAtaque() {
        // Gera um numero aleatorio entre 1 e o tamanho da lista de lixos
        int ataque = gerador.nextInt(ataques.length);

        System.out.println(String.format("\nO assunto da conversa agora é %s.", ataques[ataque][0]));

        return ataque;
    }

    // Exibe as escolhas disponiveis
    private void ExibirOpcoes() {
        System.out.println("\nEscolha o que o Leo pode argumentar pra conscientizar seus amigos");

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
            System.out.println("O valor informado inválido");
            escolha = Integer.parseInt(ler.nextLine());
            ler.close();
        }

        String categoriaEscolhida = categorias[escolha - 1];
        String categoriaLixoAtacada = ataques[escolhaVilao][1];

        if (categoriaEscolhida == categoriaLixoAtacada) {
            return true;
        }

        return false;
    }
}
