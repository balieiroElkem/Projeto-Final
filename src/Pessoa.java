package src;

public abstract class Pessoa {
    private String nomeCompleto;
    private String cpf;
    private Data dtNascimento;
    private int idade;    

    public Pessoa(String nomeCompleto, String cpf, int diaNascimento, int mesNascimento, int anoNascimento, int idade) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        dtNascimento = new Data(diaNascimento, mesNascimento, anoNascimento);
        setIdade(idade);
    }


    /**
     * Seta a idade de uma pessoa
     * @param idade {@code int}
     */
    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade nao pode ser negativa.");
        }

        this.idade = idade;
    }



    /**
     * Retorna a idade da pessoa
     * @return {@code int}
     */
    public int getIdade() {
        return this.idade;
    }



    /**
     * Retorna o nome completo da pessoa
     * @return {@code String}
     */
    public String getNomeCompleto() {
        return this.nomeCompleto;
    }



    /**
     * Retorna o cpf da pessoa
     * @return {@code String}
     */
    public String getCpf() {
        return this.cpf;
    }



    /**
     * Retorna o primeiro nome da pessoa
     * @return {@code String}
     */
    public String getNome() {
        return getNomeCompleto().split(" ")[0];
    }



    /**
     * Retorna o último sobrenome da pessoa
     * @return {@code String}
     */
    public String getSobrenome() {
        String[] nome = getNomeCompleto().split(" ");

        return nome[nome.length-1];
    }



    /**
     * Retorna a data de nascimento da pessoa
     * @return {@code Data}
     */
    public Data getDtNascimento() {
        return this.dtNascimento;
    }



    
    @Override
    /**
     * Retorna as informações da pessoa
     * @return {@code String}
     */
    public String toString() {
        return String.format("%s %s\nCPF: %s\nData de Nascimento: %s\nIdade: %d\nNome Completo: %s", getNome(), getSobrenome(), 
            getCpf(),  getDtNascimento().toString(), getIdade(), getNomeCompleto());
    }
}
