public class EcoCity {

    public static void main(String[] args) throws Exception {
        Helper.LimparTela();

        System.out.println(
                "Bem-Vindo à Eco-City,conhecida por sua convivência harmoniosa com a natureza, mas sinais preocupantes começaram a surgir.");

        System.out.println("Leo, é um jovem ativista ambiental que vive na metrópole de Eco-city.");

        Leo leo = new Leo();

        Fase1 fase1 = new Fase1();
        while (!fase1.AcaoFase(leo)) {
            leo.SetVida(100); // restaura vida do Leo / personagem
        }

    }

}
