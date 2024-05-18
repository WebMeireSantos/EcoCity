import java.util.Random;
import java.util.Scanner;

public class Fase3 extends Fase {
    private Random gerador = new Random();
    private String[][] ataquesGuarda;
    private String[] categoriasGuarda;

    public Fase3() {
        super();
        ataquesGuarda = new String[][] {
            {"Papelão", "Azul"},
            {"Revistas", "Azul"},
            {"Caixas de papel", "Azul"},
            {"Folhas de caderno", "Azul"},
            {"Jornais", "Azul"},
            {"Embalagens de papel", "Azul"},
            {"Cartões", "Azul"},
            
            {"Garrafas PET", "Vermelho"},
            {"Embalagens de plástico", "Vermelho"},
            {"Sacolas plásticas", "Vermelho"},
            {"Copos descartáveis", "Vermelho"},
            {"Potes de plástico", "Vermelho"},
            {"Canudos de plástico", "Vermelho"},
            {"Brinquedos de plástico", "Vermelho"},
            
            {"Garrafas de vidro", "Verde"},
            {"Potes de vidro", "Verde"},
            {"Frascos de perfumes de vidro", "Verde"},
            {"Copos de vidro", "Verde"},
            {"Vidros de conserva", "Verde"},
            {"Garrafas de vinho", "Verde"},
            {"Garrafas de suco", "Verde"},
            
            {"Latas de alumínio", "Amarelo"},
            {"Latas de refrigerante", "Amarelo"},
            {"Latas de cerveja", "Amarelo"},
            {"Papel alumínio", "Amarelo"},
            {"Latas de alimentos", "Amarelo"},
            {"Latas de spray", "Amarelo"},
            {"Panelas de metal", "Amarelo"}
        };

        categoriasGuarda = new String[] {
                "Azul", "Vermelho", "Verde", "Amarelo"
        };
    }


    @Override
    public Boolean Jogar(Leo leo) {

        Scanner ler = new Scanner(System.in);

        IntroducaoFase();
        
        System.out.println(
                "Ao chegar no galpão, Leo avista um objeto metálico na caçamba de lixo do lado de fora");
        System.out.println(
                "Ao pegar o objeto, Leo lê o nome 'Aspirador Seletivo 3000' com uma etiqueta escrita em letras garrafais: 'INUTIL'.");
        System.out.println(
                "No aspirador há uma chave seletora para as cores azul, vermelho, verde e amarelo\n");
        System.out.println(
                "Leo adquiriu o 'Aspirador Seletivo 3000'\n");

        Helper.MensagemContinuar();

        int escolha = 0;

        do{
            System.out.println(
                "Ao chegar ao esconderijo, Leo tem que tomar uma decisão entrar pela porta principal ou procurar uma entrada lateral");
            System.out.println("(1- porta principal / 2- entrada lateral)\n");

            escolha = Integer.parseInt(ler.nextLine());
            Helper.LimparTela();

            if (escolha != 2) {
                BatalhaAleatoria(leo);
                System.out.println("Ao entrar no galpão, Leo avista um monte de entulhos, não há passagem visível, portanto Leo decide sair do galpão");
                Helper.MensagemContinuar();
            }
        }while(escolha == 1);

        
        escolha = 0;
        BatalhaAleatoria(leo);

        do{
            System.out.println(
                "Leo entra no galpão abandonado. À sua frente, há dois corredores.");
            System.out.println("(1- corredor da esquerda / 2- corredor da direita)");

            escolha = Integer.parseInt(ler.nextLine());
            Helper.LimparTela();

            if (escolha != 1) {
                BatalhaAleatoria(leo);
                System.out.println("O corredor da direita dá acesso a uma janela, não há nada para fazer além de olhar a vista de fora, por isso Leo retorna de onde veio");
                Helper.MensagemContinuar();
            }
        }while(escolha != 1);

        BatalhaAleatoria(leo);

        do{
            System.out.println(
                "Leo chega no corredor. O caminho é escuro e estreito. À frente, Leo vê uma porta enferrujada e uma escada descendo.");
            System.out.println("(1- abrir a porta / 2- descer as escadas)");

            escolha = Integer.parseInt(ler.nextLine());
            Helper.LimparTela();

            if (escolha != 1) {
                BatalhaAleatoria(leo);
                System.out.println("Ao descer as escadas, Leo chega a um porão com várias invenções esquisitas, mas nada que possa utilizar, portanto Leo decide subir as escadas de volta");
                Helper.MensagemContinuar();
            }
        }while(escolha != 1);

        BatalhaAleatoria(leo);

        boolean chave = false;
        boolean mapa = false;

        System.out.println(
                "Leo abre a porta e encontra um escritório abandonado com um armário, uma mesa velha e uma porta de madeira");

        do{
            if(mapa) 
                System.out.print("(0- pressionar azulejo com marcação / 1- vasculhar armário / 2- vasculhar mesa / 3 - abrir porta)");
            else
                System.out.print("(1- vasculhar armário / 2- vasculhar mesa / 3 - abrir porta)");

            escolha = Integer.parseInt(ler.nextLine());
            Helper.LimparTela();

            if (escolha == 1 && chave) {
                BatalhaAleatoria(leo);
                System.out.println("O armário esta vazio");
            }

            if (escolha == 1 && !chave) {
                BatalhaAleatoria(leo);
                System.out.println("Leo encontra uma chave enferrujada");
                System.out.println("Leo adquiriu 'chave enferrujada'");
                chave = true;
            }

            if (escolha == 2 && mapa){
                BatalhaAleatoria(leo);
                System.out.println("A mesa está vazia");
                mapa = true;
            }

            if (escolha == 2 && !mapa){
                BatalhaAleatoria(leo);
                System.out.println("Leo encontra um mapa do galpão, que indica a localização da sala secreta.");
                System.out.println("Leo adquiriu 'mapa do galpão'");
                mapa = true;
            }

            if (escolha == 3 && !chave){
                BatalhaAleatoria(leo);
                System.out.println("A porta está trancada, parece que Leo irá precisar de uma chave");
            }

            if (escolha == 3 && chave){
                BatalhaAleatoria(leo);
                System.out.println("Leo entra numa sala pequena, na parede há um aviso: 'Esconder um tesouro aqui em versões futuras'");
                System.out.println("Leo não entende nada e resolve voltar");
            }

            if(escolha == 0 && !mapa)
                System.out.println("Leo não deveria fazer isso");

            if(escolha == 0 && mapa)
                System.out.println("Leo abriu uma passagem secreta e avistou um corredor cheio de velas");

            Helper.MensagemContinuar();

        }while(!mapa || escolha != 0);

        System.out.println("Leo e os moradores finalmente encontram o esconderijo do Dr. Névoa Negra!");
        System.out.println("Dr. Nevoa Negra grita: 'Eu cobrirei essa cidade com poluição HA HA HA HA HA'\n");
        System.out.println("Leo deve enfrentar Dr. Nevoa Negra e acabar com seus planos");
        System.out.println("Mas antes de enfrenta-lo, Leo é surpreendido por um dos moradores que chega ofegante.");
        System.out.println("Dona Lúcia entrega a Leo um colar feito de materiais reciclaveis que emana uma energia boa");
        Helper.MensagemContinuar();
        System.out.println("Leo adquiriu 'Dom da Empatia'");
        Helper.MensagemContinuar();

        Vilao nevoa = new Vilao(100);

        System.out.println("Leo: " + leo.GetVida() + " de XP");
        System.out.println("Dr. Névoa Negra: " + nevoa.GetVida() + " de XP");

        return true;
    }

    private void IntroducaoFase() {

        Helper.MensagemContinuar();

        System.out.println("Fase 3 - Confronto com a Poluição do Ar");
        System.out.println(
                "\nA cidade acorda em uma manhã mais escura do que o normal, e uma densa fumaça emerge de um galpão que aparentemente estava abandonado");
        System.out.println(
                "O responsável por essa névoa tóxica é o sinistro Dr. Névoa Negra, um cientista louco que desenvolveu uma máquina capaz de liberar poluentes no ar, intensificando a poluição e colocando em risco a saúde dos cidadãos.");
        System.out.println(
                "Determinado a deter essa ameaça, Leo tenta confrontar o cientista maluco.");
        System.out.println(
                "Mas Leo não está sozinho, e leva junto alguns moradores");

        Helper.MensagemContinuar();

    }

    private void BatalhaAleatoria(Leo leo) {
        Scanner ler = new Scanner(System.in);
        int temVilao = gerador.nextInt(3);

        if (temVilao == 1) {
            Helper.LimparTela();
            System.out.println("Um guarda de repente apareceu, Leo terá que lutar \n");
            Vilao vilao = new Vilao(10);

            while (leo.GetVida() > 0 && vilao.GetVida() > 0) {
                int ataque = ObterAtaqueGuarda();
                ExibirOpcoesGuarda();
    
                if (ValidarEscolhaGuarda(ataque)) {
                    Helper.LimparTela();
                    vilao.DiminuirVida(10);
                    System.out.println("Muito bem, você aspirou o que o guarda atirou\n");
                } else {
                    Helper.LimparTela();
                    leo.DiminuirVida(10);
                    System.out.println("Que pena, Leo aparentemente selecionou a cor errada");
                    System.out.println(
                            String.format("Talvez a cor correta para '%s' seja '%s'\n", ataquesGuarda[ataque][0], ataquesGuarda[ataque][1]));
                }
    
                System.out.println("Leo: " + leo.GetVida() + " de XP");
                System.out.println("Guarda: " + vilao.GetVida() + " de XP");
    
                System.out.println("\n--------------");
            }

            Helper.LimparTela();

            if (leo.GetVida() > 0) {
                System.out.println("Leo derrotou o guarda e passou por ele que estava sem munição!\n");
                Helper.MensagemContinuar();
            } else {
                System.out.println(
                    "Leo infelizmente não conseguiu derrotar o guarda!\n");
                System.out.println("Tentar novamente (1- Sim / 2 - Não)?");
    
                int escolha = Integer.parseInt(ler.nextLine());
    
                if (escolha == 2) {
                    System.exit(0);
                }
    
                Helper.LimparTela();
    
                Jogar(new Leo());
            }
            
        }
    }

    private int ObterAtaqueGuarda() {
        // Gera um numero aleatorio entre 1 e o tamanho da lista de lixos
        int ataque = gerador.nextInt(ataquesGuarda.length);

        System.out.println(String.format("\nLeo vê o guarda carregando uma arma estranha com '%s'.", ataquesGuarda[ataque][0]));

        return ataque;
    }

    // Exibe as escolhas disponiveis
    private void ExibirOpcoesGuarda() {
        System.out.println("Leo deve selecionar uma cor do aspirador:\n");

        for (int i = 0; i < categoriasGuarda.length; i++) {
            System.out.println(String.format("%s - %s", i + 1, categoriasGuarda[i]));
        }
    }

    // Checa se a escolha do descarte equivale a categoria do lixo atacado
    private boolean ValidarEscolhaGuarda(int escolhaVilao) {

        Scanner ler = new Scanner(System.in);
        int escolha = Integer.parseInt(ler.nextLine());

        while (escolha < 0 || escolha > categoriasGuarda.length) {
            ler = new Scanner(System.in);
            System.out.println("O valor informado inválido");
            escolha = Integer.parseInt(ler.nextLine());
            ler.close();
        }

        String categoriaEscolhida = categoriasGuarda[escolha - 1];
        String categoriaLixoAtacada = ataquesGuarda[escolhaVilao][1];

        if (categoriaEscolhida == categoriaLixoAtacada) {
            return true;
        }

        return false;
    }
}
