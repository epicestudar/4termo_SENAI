package br.com.epicestudar;

public class Roupa extends Produto implements Transportavel{
    private double volume;

    public Roupa(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    @Override
    public double calcularFrete() {
       double valorFrete = calcularPeso() * 5;
       return valorFrete;
    }

    @Override
    public double calcularPeso() {
        double peso = volume * 10;
        return peso;
    }

}
