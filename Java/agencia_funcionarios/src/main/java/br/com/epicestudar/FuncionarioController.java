package br.com.epicestudar;

import java.util.*;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<>();
    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void listarFuncionarios() {
        if (funcionarios.size() == 0) {
            System.out.println("Lista Vazia");
        }
        else{
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario.toString());
            }
        }
    }

    public void removerFuncionario(String nome) throws Exception{
        try {
            boolean encontrado = false;
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nome)) {
                funcionarios.remove(funcionario);
                encontrado = true;
            }
        }
        if(!encontrado) {
            throw new Exception("Usuário não encontrado");
        }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public double mediaSalarial() {
        double mediaSal = 0;
        if(funcionarios.isEmpty()) {
            return mediaSal;
        } else{
            for (Funcionario funcionario : funcionarios) {
                mediaSal+= funcionario.getSalario();
            }
            return mediaSal/funcionarios.size();
        }
    }
}
