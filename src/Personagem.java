public class Personagem {
    private int vida = 100;

    public int getVida() {
        return vida;
    }

    // Define um valor absoluto para a vida do personagem
    public void setVida(int vida) {
        this.vida = vida;
    }

    // Incrementa ou decrementa a vida do personagem
    public void diminuiVida(int qtd) {
        this.vida = this.vida - qtd;
    }
}
