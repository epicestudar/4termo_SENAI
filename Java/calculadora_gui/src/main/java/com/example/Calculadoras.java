package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadoras extends JFrame{
    private JTextField displaySimples;
    private JTextField displayCientifico;
    private double valor1, valor2, resultado;
    private String operador;

    public Calculadoras() {
        super("Calculadora com Abas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Aba da Calculadora Simples
        JPanel calculadoraSimples = new JPanel(new BorderLayout());
        displaySimples = new JTextField();
        displaySimples.setEditable(false);
        calculadoraSimples.add(displaySimples, BorderLayout.NORTH);

        JPanel botoesSimples = new JPanel(new GridLayout(4, 4));
        String[] botoesSimplesLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String label : botoesSimplesLabels) {
            JButton button = new JButton(label);
            botoesSimples.add(button);
            button.addActionListener(new SimplesAction());
        }

        calculadoraSimples.add(botoesSimples, BorderLayout.CENTER);
        tabbedPane.addTab("Calculadora Simples", calculadoraSimples);

        // Aba da Calculadora Científica
        JPanel calculadoraCientifica = new JPanel(new BorderLayout());
        displayCientifico = new JTextField();
        displayCientifico.setEditable(false);
        calculadoraCientifica.add(displayCientifico, BorderLayout.NORTH);

        JPanel botoesCientificos = new JPanel(new GridLayout(3, 3));
        String[] botoesCientificosLabels = {"x²", "√x", "log", "C"};

        for (String label : botoesCientificosLabels) {
            JButton button = new JButton(label);
            botoesCientificos.add(button);
            button.addActionListener(new CientificoAction());
        }

        calculadoraCientifica.add(botoesCientificos, BorderLayout.CENTER);
        tabbedPane.addTab("Calculadora Científica", calculadoraCientifica);

        // Adiciona o JTabbedPane ao JFrame
        add(tabbedPane);

    }

    private class SimplesAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           String comando = e.getActionCommand();

           if (comando.equals("C")) {
            displaySimples.setText("");
            valor1 = valor2 = resultado = 0;
            operador = "";
           } else if(comando.equals("=")) {
            valor2 = Double.parseDouble(displaySimples.getText());

                switch (operador) {
                    case "+":
                        resultado = valor1 + valor2;
                        break;
                    case "-":
                        resultado = valor1 - valor2;
                        break;
                    case "*":
                        resultado = valor1 * valor2;
                        break;
                    case "/":
                        resultado = valor1 / valor2;
                        break;
           }
           displaySimples.setText(String.valueOf(resultado));
        } else if ("+-*/".contains(comando)) {
            valor1 = Double.parseDouble(displaySimples.getText());
            operador = comando;
            displaySimples.setText("");
        } else {
            displaySimples.setText(displaySimples.getText() + comando);
        }
        
    }
}

// Ação para a Calculadora Científica
private class CientificoAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        try {
            double valor = Double.parseDouble(displayCientifico.getText());

            switch (comando) {
                case "x²":
                    resultado = Math.pow(valor, 2);
                    break;
                case "√x":
                    resultado = Math.sqrt(valor);
                    break;
                case "log":
                    resultado = Math.log(valor);
                    break;
                case "C":
                    displayCientifico.setText("");
                    return;
            }

            displayCientifico.setText(String.valueOf(resultado));
        } catch (NumberFormatException ex) {
            displayCientifico.setText("Erro");
        }
    }
}
}
