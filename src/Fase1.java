import java.util.Scanner;
import java.util.Random;

public class Fase1 {

    private boolean ganhou = false;
    private boolean perdeu = false;
    private int vidaInimigo = 100;

    private String[][] lixos = {
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
            { "pote de sorvete", "plástico" }
    };

    private String[] reciclaveis = {
            "papel", "plástico", "alumínio", "orgânico", "vidro", "bateria"
    };

    public static void limpaTela() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    //Exibe as escolhas disponiveis
    private void exibeEscolhas(){
        for (int j = 0; j < reciclaveis.length; j++) {
            System.out.println(String.format("%s - %s", j + 1, reciclaveis[j]));
        }
    }


    //Checa se a escolha do descarte equivale ao lixo atacado
    private boolean escolhaCorreta(int lixo, int escolha){

        String tipo = reciclaveis[escolha - 1];
        String ataque = lixos[lixo - 1][0];

        for(int i = 0; i < lixos.length - 1; i++){
            if (lixos[i][0] == ataque && lixos[i][1] == tipo)
                return true;
        }
        return false;
    }

    //Retorna o nome do lixo baseado no numero da lista
    private String lixo(int num){
        return lixos[num - 1][0];
    }






    public void Acaofase1(Personagem personagem) {

        personagem.setVida(100); //restaura vida do Leo / personagem
        vidaInimigo = 100;            //restaura vida do inimigo
        ganhou = false;
        perdeu = false;

        Scanner ler = new Scanner(System.in);
        Random gerador = new Random();

        System.out.println("\n\nFase 1 - Capitão Lixo, digite algo pra continuar");

        ler.nextLine();

        limpaTela();

        System.out.println("\nEm uma manhã ensolarada, Leo decide explorar as ruas da cidade em busca de novos indícios sobre o aumento da poluição que vem observando. Rapidamente, um odor desagradável invade suas narinas, quando se depara com uma cena desoladora: um monte de lixo se acumula, formando o início de um verdadeiro lixão a céu aberto. Este é o território do Capitão Lixo, conhecido pelas crianças do bairro por recolher o lixo e acumula-los a frente da sua própria casa.");

        System.out.println("\nAo ser atacado com o lixo do Capitão Lixo, defina o descarte correto");
        System.out.println("Digite algo para continuar");

        ler.nextLine();
        limpaTela();

        int ataque = 0;

        //loop de jogo
        while(ganhou == false && perdeu == false){

            ataque = gerador.nextInt(lixos.length - 1) + 1; //Gera um numero aleatorio entre 1 e o tamanho da lista de lixos

            System.out.println(String.format("O Capitão Lixo atacou com %s.", lixo(ataque)));
            System.out.println("\nEscolha onde deve ser o descarte correto");

            exibeEscolhas();

            int escolha = Integer.parseInt(ler.nextLine());

            limpaTela();

            if (escolhaCorreta(ataque, escolha)){
                vidaInimigo = vidaInimigo - 10;
                System.out.println("Muito bem, você descartou corretamente\n");
            }

            else {
                personagem.diminuiVida(10);
                System.out.println("Que pena, resposta errada");
                System.out.println("O correto era: " + lixos[ataque - 1][1] + "\n");
            }

            if(vidaInimigo <= 0)
                ganhou = true;

            if(personagem.getVida() <= 0)
                perdeu = true;

            System.out.println("Leo: " + personagem.getVida() + " de XP");
            System.out.println("Capitão lixo: " + vidaInimigo + " de XP");

            System.out.println("\n--------------");
        }

        limpaTela();

        if (ganhou){
            System.out.println("Leo derrotou o Capitão Lixo e adquiriu 'Resistencia ao Odor' !");
            //chama a fase 2 ou returna valor true para a classe principal
        }

        if (perdeu){
            System.out.println("Leo infelizmente não conseguiu derrotar o Capitão Lixo e desmaiou com o cheiro terrível que o cercava!\n");
            System.out.println("Tentar novamente (1- Sim / 2 - Não)?");

            int escolha = Integer.parseInt(ler.nextLine());
            
            if (escolha == 1){
                limpaTela();
                Acaofase1(personagem);  
            }
            else{
                System.exit(0);
            }    
        }

        ler.close();
    }

}
