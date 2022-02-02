package src;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.ano = ano;
        setMes(mes);
        setDia(dia);
    }


    /**
     * Seta um valor para mês. Caso seja um valor inválido, chama uma exceção
     * e seta o valor de mes para 1.
     * @param mes {@code int}
     */
    public void setMes(int mes) {
        if (mes <= 0 || mes > 12) {
            this.mes = 1;
            throw new IllegalArgumentException("Mes deve estar entre 1 e 12");
        }

        this.mes = mes;
    }



    /**
     * Devolve o valor de mes
     * @return {@code int}
     */
    public int getMes() {
        return this.mes;
    }


    /**
     * Seta um valor para dia. Se não for um ano bissexto e o valor de {@code dia}
     * for maior ou igual a 29, {@code dia} fica valendo 1
     * @param dia {@code int}
     */
    public void setDia(int dia) {
        if (dia == 29 && getMes() == 2) {
            // Verifica se ano é bissexto para setar o valor de dia para 29
            if ((getAno()%4 == 0) || (getAno()%100 == 0 && getAno()%400 != 0)) {
                this.dia = 1;
                throw new IllegalArgumentException("Ano ano e bissexto");
            }
        }

        this.dia = dia;
    }


    /**
     * Devolve o valor de dia
     * @return {@code int}
     */
    public int getDia() {
        return this.dia;
    }


    /**
     * Devolve o valor de ano
     * @return {@code int}
     */
    public int getAno() {
        return this.ano;
    }

    /**
     * Seta um valor para ano
     * @param ano {@code int}
     */
    public void setAno(int ano) {
        this.ano = ano;
    }


    
    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", getDia(), getMes(), getAno());
    }
}
