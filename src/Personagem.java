public class Personagem {
    private String nome;
    private double vida = 100;
    private double forca;
    private double resistencia;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVida() {
        return vida;
    }

    // Define um valor absoluto para a vida do personagem
    public void setVida(Double vida) {
        this.vida = vida;
    }

    // Incrementa ou decrementa a vida do personagem
    public void mudaVida(Double qtd) {
        this.vida = this.vida + qtd;
    }

    public Double getForca() {
        return forca;
    }

    public void setForca(Double forca) {
        this.forca = forca;
    }

    public Double getResistencia() {
        return resistencia;
    }

    public void setResistencia(Double resistencia) {
        this.resistencia = resistencia;
    }

}
