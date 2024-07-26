package com.example;

//import das bibliotecas junit
import org.junit.Before;
import org.junit.Test;

import br.com.epicestudar.Calculadora;

import static org.junit.Assert.assertEquals;


public class CalculadoraTeste {
    Calculadora calc;


    @Before
    public void setUp() {
        calc = new Calculadora();
    }
   
    @Test
    public void testSoma() {
        assertEquals(7, calc.soma(3, 4));
    }
   
    @Test
    public void testSubtracao() {
        assertEquals(1, calc.subtracao(3, 2));
    }
   
    @Test
    public void testMultiplicacao() {
        assertEquals(12, calc.multiplicacao(3, 4));
    }
   
    @Test
    public void testeDivisao() {
        assertEquals(3.3, calc.divisao(10, 3), 0.1);
    }
   
    @Test(expected = IllegalArgumentException.class)
    public void testDivisaoPorZero() {
        calc.divisao(3, 0);
    }

    @Test
    public void testeRaiz() {
        assertEquals(2, calc.raiz(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeRaizNegativa() {
        calc.raiz(-4);
    }

    @Test
    public void testePotencia() {
        assertEquals(8, calc.potencia(2, 3));
    }
}
