package interfaces;

import src.Aluno;


public interface Gerencia {
    /**
     * Cadastra um novo aluno
     * @param novoAluno {@code Aluno}
     * @return {@code true} se ocorreu tudo certo e {@code false} se algo deu errado..
     */
    public boolean novoAluno(Aluno novoAluno);


    /**
     * Faz uma pesquisa linear nos dados em busca de um cpf ou nome completo.
     * Se encontrado, ele altera.
     * @param inf {@code String} a ser pesquisada
     * @param op {@code int} opção de modificação
     * @param dado {@code int} dado substituto
     * @return {@code true} se ocorreu tudo bem, {@code false} se não ocorreu tudo bem.
     */
    public boolean modificaAluno(String inf, int op, int dado);



    /**
     * Deleta um registro de aluno
     * @param inf {@code false}
     * @return {@code true} se ocorreu tudo bem e {@code false} se algo deu errado.
     */
    public boolean deleteAluno(String inf);



    /**
     * Informa todos os dados de todos os alunos cadastrados
     */
    public void print();



    /**
     * Pesquisa por um nome completo ou cpf de um aluno e retorna o index.
     * @param inf {@code String}
     * @return {@code int} index da aluno, caso achado ou {@code -1} caso não achado
     */
    public int pesquisa(String inf);




    /**
     * Retorna o Aluno do index desejado.
     * Caso o index seja invalido, retorna {@code null}.
     * @param index {@code int}
     * @return {@code Aluno}
     */
    public Aluno getAluno(int index);
}
