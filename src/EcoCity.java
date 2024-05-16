public class EcoCity {
    public static void main(String[] args) throws Exception {
        System.out.println("""
                Bem-Vindo à Eco-City,
                conhecida por sua convivência harmoniosa com a natureza,
                mas sinais preocupantes começaram a surgir.""");

        System.out.println("Leo, é um jovem ativista ambiental que vive na metrópole de Eco-city.");

        Personagem personagem1 = new Personagem();
        Fase1 fase1 = new Fase1();
        fase1.Acaofase1();

    }

    public void Batalha(Personagem atacante, Personagem defensor) {
        Double valorAtaque = atacante.getForca() / 5; // define o valor de ataque baseado na forca do atacante
        Double valorDefesa = defensor.getResistencia() / 5; // define o valor de defesa baseado na resistencia do
                                                            // defensor
        Double dano = valorAtaque - (valorAtaque * (valorDefesa / 100)); // diminui o ataque do atacante baseado no
                                                                         // valor de defesa do defensor
S
        defensor.mudaVida(-dano); // decrementa a vida
    }

}
