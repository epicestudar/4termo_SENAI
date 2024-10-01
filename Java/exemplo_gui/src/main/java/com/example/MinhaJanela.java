package com.example;

import javax.swing.*;
import java.awt.event.*;

public class MinhaJanela extends JFrame {
    public MinhaJanela() {
        super("Exemplo Swing");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        this.add(panel);

        JButton button = new JButton();
        panel.add(button);

        String[] colunas = { "Nome", "Idade", "Cidade" };
        Object[][] dados = {
                { "Ana", 25, "São Paulo" },
                { "Pedro", 30, "Rio de Janeiro" }
        };
        JTable table = new JTable(dados, colunas);
        panel.add(new JScrollPane(table));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão foi clicado!");
            }
        });
        this.setVisible(true);
    }
}
