package Negocio;

import java.util.*;

public class Cadastro {

    private List<Pessoa> pessoas;

    public Cadastro() {
        pessoas = new ArrayList<Pessoa>();
    }

    public void adicionar(Pessoa p) {
        pessoas.add(p);
    }

    public List<Pessoa> getTodos() {
        return pessoas;
    }

    public List<Pessoa> getHomens() {
        List<Pessoa> tmp = new ArrayList<Pessoa>();
        for (Pessoa p : pessoas) {
            if (p.getSexo() == 'M') {
                tmp.add(p);
            }
        }
        return tmp;
    }

    public List<Pessoa> getMulheres() {
        List<Pessoa> tmp = new ArrayList<Pessoa>();
        for (Pessoa p : pessoas) {
            if (p.getSexo() == 'F') {
                tmp.add(p);
            }
        }
        return tmp;
    }

    @Override
    public String toString() {
        return pessoas.toString();
    }
}
