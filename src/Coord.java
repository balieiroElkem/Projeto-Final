package src;

import interfaces.Gerencia;

public class Coord implements Gerencia {
    private Aluno[] alunos;
    private int controle = 0;

    public Coord() {
        alunos = new Aluno[1];
        controle++;
    }
    

    @Override
    public boolean novoAluno(Aluno novoAluno) {
        alunos[controle-1] = novoAluno;
        controle++;
        Aluno[] novosAlunos = new Aluno[controle];

        for (int i = 0; i < controle-1; ++i) {
            novosAlunos[i] = alunos[i];
        }
        
        alunos = novosAlunos;

        return false;
    }

 
    @Override
    public boolean modificaAluno(String inf, int op, int dado) {
        int index = pesquisa(inf);
        boolean retorno = false;
        
        if (index != -1) {
            switch (op) {
                case 1:
                    alunos[index].setSerie(dado);
                    retorno = true;
                    break;
                case 2:
                    alunos[index].setIdade(dado);
                    retorno = true;
                    break;
            }                
        }
        

        return retorno;
    }

    @Override
    public boolean deleteAluno(String inf) {
        int index = pesquisa(inf);

        if (index != -1) {
            System.out.println("Deletando......");
            controle--;
            Aluno[] novosAlunos = new Aluno[controle];
            for (int i = 0, j = 0; i < controle; ++i) {
                if (i != index) {
                    novosAlunos[j] = alunos[i];
                    j++;
                }
            }
            alunos = novosAlunos;
            System.out.println("Deletado!");
            
            return true;
        }
        
        return false;
    }

    @Override
    public void print() {
        for (int i = 0; i < controle-1; i++) {
            System.out.println(alunos[i].toString() + "\n");
        }
    }


    @Override
    public int pesquisa(String inf) {
        int index = -1;
        
        for (int i = 0; i < controle-1; ++i) {
            if (alunos[i].getNomeCompleto().equalsIgnoreCase(inf)) {
                index = i;
                break;
            }

            if (alunos[i].getCpf().equals(inf)) {
                index = i;
                break;
            }
        }
        
        return index;
    }


    @Override
    public Aluno getAluno(int index) {
        Aluno al = null;

        if (index >= 0 && index <= controle-1) {
            al = alunos[index];
        }
        
        return al;
    }


}
