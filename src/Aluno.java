package src;

public class Aluno extends Pessoa {
    private int serie;
    private Data dtMatricula;
    private int matricula;

    public Aluno(String nomeCompleto, String cpf, int diaNascimento, int mesNascimento, int anoNascimento, 
        int idade, int serie, int diaMatricula, int mesMatricula, int anoMatricula, int matricula) {
     
        super(nomeCompleto, cpf, diaNascimento, mesNascimento, anoNascimento, idade);
        dtMatricula = new Data(diaMatricula, mesMatricula, anoMatricula);
        
        setSerie(serie);
        this.matricula = matricula;
    }




    /**
     * Seta uma serie para o aluno
     * @param serie {@code int}
     */
    public void setSerie(int serie) {
        if (serie < 0) {
            throw new IllegalArgumentException("Serie nao pode ser menor que 0");
        }

        this.serie = serie;
    }



    /**
     * Retorna a serie do aluno
     * @return {@code int}
     */
    public int getSerie() {
        return this.serie;
    }



    /**
     * Retorna a matricula do aluno
     * @return {@code int}
     */
    public int getMatricula() {
        return this.matricula;
    }





    /**
     * Retorna o dia da matricula do aluno
     * @return {@code Data}
     */
    public Data getDtMatricula() {
        return this.dtMatricula;
    }




    @Override
    /**
     * Devolve uma string com o resumo do aluno
     * @return {@code String}
     */
    public String toString() {
        return String.format("%s\nSerie: %d\nMatricula: %d\nData da Matricula: %s", super.toString(), 
            getSerie(), getMatricula(), getDtMatricula().toString());
    }
}
