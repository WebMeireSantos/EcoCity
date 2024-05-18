public class EcoCity {

    public static void main(String[] args) throws Exception {
        Helper.LimparTela();

        System.out.println(
                "Bem-Vindo à Eco-City,conhecida por sua convivência harmoniosa com a natureza, mas sinais preocupantes começaram a surgir.");

        System.out.println("Leo, é um jovem ativista ambiental que vive na metrópole de Eco-city.");

        Leo leo = new Leo();

        Fase fase = new Fase1(); 
        while (!fase.Jogar(leo)) {
            leo.SetVida(100); // restaura vida do Leo / personagem
        }

        fase = new Fase2();
        while (!fase.Jogar(leo)) {
            leo.SetVida(100); // restaura vida do Leo / personagem
        }

        fase = new Fase3();
        while (!fase.Jogar(leo)) {
            leo.SetVida(100);// restaura vida do Leo / personagem
        }

        System.out.println(
                "Graças aos esforços de Leo e dos moradores, Eco-City é uma cidade limpa e");
        System.out.println(
                "com cidadões conscientes. O ar da cidade é saudável e a vida verde é ambundante!");        
    }
}
