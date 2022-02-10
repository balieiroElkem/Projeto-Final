import java.util.Scanner;
import interfaces.Gerencia;
import src.Coord;
import src.Aluno;


public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Gerencia diretoria = new Coord();



        System.out.println("|-------------------------------------------------|");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|                  BEM-VINDO(A)                   |");
        System.out.println("|            AO GERENCIADOR DE ALUNOS             |");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|                                                 |");
        System.out.println("|-------------------------------------------------|");
        
        

        int escolha = 0;
        do {
            System.out.println("1 - Inserir Novo Aluno");
            System.out.println("2 - Modificar Aluno");
            System.out.println("3 - Pesquisar Aluno");
            System.out.println("4 - Deletar Aluno");
            System.out.println("5 - Mostrar Alunos Cadastrados");
            System.out.print("0 - Sair\n: ");
            while (scan.hasNextLine()) {
                escolha = scan.nextInt();
                break;
            }
            scan.nextLine(); // limpa o buffer.

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome completo\n: ");
                    String nomeCompleto = scan.nextLine();
                    
                    System.out.print("Digite a data de nascimento(dd mm aaaa)\n: ");
                    int diaNascimento = 0;
                    int mesNascimento = 0;
                    int anoNascimento = 0;
                    
                    while (scan.hasNextLine()) {
                        diaNascimento = scan.nextInt();
                        mesNascimento = scan.nextInt();
                        anoNascimento = scan.nextInt();
                        break;
                    }
                    
                    System.out.print("Digite a idade\n: ");
                    int idade = 0;
                    while (scan.hasNextLine()) {
                        idade = scan.nextInt();
                        break;
                    }
                    
                    System.out.print("Digite a serie\n: ");
                    int serie = 0;
                    while (scan.hasNextLine()) {
                        serie = scan.nextInt();
                        break;
                    }
                    
                    System.out.print("Digite a matricula\n: ");
                    int matricula = 0;
                    while (scan.hasNextLine()) {
                        matricula = scan.nextInt();
                        break;
                    }

                    System.out.print("Digite a data da matricula(dd mm aaaa)\n: ");
                    int diaMatricula = 0;
                    int mesMatricula = 0;
                    int anoMatricula = 0;
                    while (scan.hasNextLine()) {
                        diaMatricula = scan.nextInt();
                        mesMatricula = scan.nextInt();
                        anoMatricula = scan.nextInt();
                        break;
                    }
                    
                    System.out.print("Digite o cpf\n: ");
                    String cpf = scan.next();
                    
                    
                    Aluno novoAluno = new Aluno(nomeCompleto, cpf, diaNascimento, mesNascimento, anoNascimento, 
                    idade, serie, diaMatricula, mesMatricula, anoMatricula, matricula);
                    
                    diretoria.novoAluno(novoAluno);
                    break;
                
            case 2:
                System.out.print("Nome completo ou cpf do aluno\n: ");
                String infModifica = scan.nextLine();
                System.out.print("Digite 1 - SERIE\t2 - IDADE\n: ");
                int op = 0;
                while (scan.hasNextLine()) {
                    op = scan.nextInt();
                    break;
                }
                System.out.print("Por: ");
                int dado = 0;
                while (scan.hasNextLine()) {
                    dado = scan.nextInt();
                    break;
                }

                if (diretoria.modificaAluno(infModifica, op, dado)) {
                    System.out.println("\nModificado com sucesso.\n");
                } else {
                    System.out.println("\nModificação não realizada.\n");
                }

                break;
            
            case 3:
                System.out.print("Nome completo ou cpf do aluno a pesquisar.\n: ");
                String infPesquisar = scan.nextLine();
                int index = diretoria.pesquisa(infPesquisar);
                Aluno al = diretoria.getAluno(index);
                if (al != null) {
                    System.out.println(al.toString() + "\n");
                } else {
                    System.out.println("Nada Encontado.\n");
                }
                break;
            
            case 4:
                System.out.print("Nome completo ou cpf do aluno a deletar.\n: ");
                String infDeletar = scan.nextLine();
                diretoria.deleteAluno(infDeletar);
                break;
            
            case 5:
                diretoria.print();
                break;
            }
            
            
        } while (escolha != 0);


        scan.close();
    }
}
