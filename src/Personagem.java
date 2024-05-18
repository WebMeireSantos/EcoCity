public class Personagem {
    private int vida = 100;

    public int GetVida() {
        return vida;
    }

    // Define um valor absoluto para a vida do personagem
    public void SetVida(int vida) {
        this.vida = vida;
    }

    // Incrementa ou decrementa a vida do personagem
    public void DiminuirVida(int qtd) {
        this.vida = this.vida - qtd;
    }
}
