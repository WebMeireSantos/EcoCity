public class EcoCity {
    public static void limpaTela() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static void main(String[] args) throws Exception {
        limpaTela();
        
        System.out.println("Bem-Vindo à Eco-City,conhecida por sua convivência harmoniosa com a natureza, mas sinais preocupantes começaram a surgir.");

        System.out.println("Leo, é um jovem ativista ambiental que vive na metrópole de Eco-city.");

        Personagem leo = new Personagem();
        Fase1 fase1 = new Fase1();
        fase1.Acaofase1(leo);

    }

    

}
