package br.com.epicestudar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Eletronico extends Produto implements Transportavel{
    private double volume;

    public Eletronico(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    @Override
    public double calcularPeso() {
        double peso = volume * 150;
        return peso;
    }

    @Override
    public double calcularFrete() {
        double valorFrete = calcularPeso() * 1;
        return valorFrete;
    }
}
