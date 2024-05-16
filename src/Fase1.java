import java.util.Scanner;
import java.util.Random;

public class Fase1 {

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

    public void Acaofase1() {

        Scanner ler = new Scanner(System.in);
        Random gerador = new Random();

        System.out.println("\n\nFase 1 - Capitão Lixo, digite algo pra continuar");

        if (!ler.nextLine().equals("")) {
            System.out.println(
                    """
                             \nEm uma manhã ensolarada, Leo decide explorar as ruas da cidade em busca de novos indícios sobre o aumento da poluição que vem observando.
                            Rapidamente, um odor desagradável invade suas narinas, quando se depara com uma cena desoladora:
                            um monte de lixo se acumula, formando o início de um verdadeiro lixão a céu aberto.
                            Este é o território do Capitão Lixo, conhecido pelas crianças do bairro por recolher o lixo
                            e acumula-los a frente da sua própria casa. """);

            System.out.println("\nAo ser atacado com o lixo do Capitão Lixo, defina o descarte correto");

            for (int i = 0; i < lixos.length; i++) {
                System.out.println(String.format("O Capitão Lixo atacou com %s.", lixos[i][0]));
                System.out.println("\nEscolha onde deve ser o descarte correto");

                for (int j = 0; j < reciclaveis.length; j++) {
                    System.out.println(String.format("%s - %s", j + 1, reciclaveis[j]));
                }
                String resposta = ler.nextLine();

                if (reciclaveis[Integer.parseInt(resposta) - 1] == lixos[i][1]) {
                    System.out.println("\nMuito bem, você descartou corretamente\n\n");
                } else {
                    System.out.println("\nQue pena, resposta errada\n\n");
                }
            }
        }
        ler.close();
    }
}
