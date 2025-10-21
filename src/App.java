import java.io.*;
import java.util.*;

public class App {
    private static ListaEstudante listaEstudantes = new ListaEstudante();
    private static ListaDisciplina listaDisciplinas = new ListaDisciplina();
    private static ListaNota listaNotas = new ListaNota();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(" SISTEMA DE GESTÃO ESCOLAR - POO ");
        System.out.println("======================================");
        
        // Carregar dados de exemplo para demonstrar as coleções
        carregarDadosExemplo();
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerInteiro("Digite sua opção: ");
            processarOpcao(opcao);
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private static void carregarDadosExemplo() {
        // Adicionar estudantes exemplo
        listaEstudantes.adicionarEstudante(new Estudante(1, "Mateus Moreira"));
        listaEstudantes.adicionarEstudante(new Estudante(2, "Ian Brito"));
        listaEstudantes.adicionarEstudante(new Estudante(3, "Caio Vitor"));
        
        // Adicionar disciplinas exemplo
        listaDisciplinas.adicionarDisciplina(new Disciplina("MAT101", "Matemática Discreta"));
        listaDisciplinas.adicionarDisciplina(new Disciplina("POO202", "Programação Orientada a Objetos"));
        listaDisciplinas.adicionarDisciplina(new Disciplina("QUI303", "Química Geral"));
        
        // Adicionar notas exemplo
        listaNotas.adicionarNota(new Nota(1, "MAT101", 8.5));
        listaNotas.adicionarNota(new Nota(1, "POO202", 7.0));
        listaNotas.adicionarNota(new Nota(2, "MAT101", 6.5));
        listaNotas.adicionarNota(new Nota(2, "QUI303", 9.0));
        listaNotas.adicionarNota(new Nota(3, "POO202", 8.0));
        listaNotas.adicionarNota(new Nota(3, "QUI303", 7.5));
        
        System.out.println(" Dados de exemplo carregados para demonstração!");
    }
    
    private static void exibirMenu() {
        System.out.println("\n MENU PRINCIPAL");
        System.out.println("1.  Gerenciar Estudantes");
        System.out.println("2.  Gerenciar Disciplinas");
        System.out.println("3.  Gerenciar Notas");
        System.out.println("4.  Estatísticas e Relatórios");
        System.out.println("5.  Gerar Relatório Completo (output.txt)");
        System.out.println("0.  Sair");
        System.out.println("--------------------------------------");
    }
    
    private static void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                menuEstudantes();
                break;
            case 2:
                menuDisciplinas();
                break;
            case 3:
                menuNotas();
                break;
            case 4:
                exibirEstatisticas();
                break;
            case 5:
                gerarRelatorioCompleto();
                break;
            case 0:
                System.out.println(" Saindo do sistema... Até logo!");
                break;
            default:
                System.out.println(" Opção inválida! Tente novamente.");
        }
    }
    
    private static void menuEstudantes() {
        System.out.println("\n GERENCIAR ESTUDANTES");
        System.out.println("1. Adicionar Estudante");
        System.out.println("2. Remover Estudante");
        System.out.println("3. Listar Estudantes");
        System.out.println("4. Buscar Estudante por Nome");
        System.out.println("5. Ordenar Estudantes por Nome");
        System.out.println("0. Voltar");
        
        int opcao = lerInteiro("Escolha: ");
        switch (opcao) {
            case 1:
                adicionarEstudante();
                break;
            case 2:
                removerEstudante();
                break;
            case 3:
                listarEstudantes();
                break;
            case 4:
                buscarEstudantePorNome();
                break;
            case 5:
                ordenarEstudantes();
                break;
            case 0:
                return;
            default:
                System.out.println(" Opção inválida!");
        }
    }
    
    private static void menuDisciplinas() {
        System.out.println("\n GERENCIAR DISCIPLINAS");
        System.out.println("1. Adicionar Disciplina");
        System.out.println("2. Remover Disciplina");
        System.out.println("3. Listar Disciplinas");
        System.out.println("4. Verificar se Disciplina Existe");
        System.out.println("0. Voltar");
        
        int opcao = lerInteiro("Escolha: ");
        switch (opcao) {
            case 1:
                adicionarDisciplina();
                break;
            case 2:
                removerDisciplina();
                break;
            case 3:
                listarDisciplinas();
                break;
            case 4:
                verificarDisciplina();
                break;
            case 0:
                return;
            default:
                System.out.println(" Opção inválida!");
        }
    }
    
    private static void menuNotas() {
        System.out.println("\n GERENCIAR NOTAS");
        System.out.println("1. Adicionar Nota");
        System.out.println("2. Remover Nota");
        System.out.println("3. Listar Todas as Notas");
        System.out.println("4. Consultar Notas do Estudante");
        System.out.println("5. Consultar Nota Específica");
        System.out.println("6. Calcular Média do Estudante");
        System.out.println("7. Calcular Média da Disciplina");
        System.out.println("0. Voltar");
        
        int opcao = lerInteiro("Escolha: ");
        switch (opcao) {
            case 1:
                adicionarNota();
                break;
            case 2:
                removerNota();
                break;
            case 3:
                listarTodasNotas();
                break;
            case 4:
                consultarNotasEstudante();
                break;
            case 5:
                consultarNotaEspecifica();
                break;
            case 6:
                calcularMediaEstudante();
                break;
            case 7:
                calcularMediaDisciplina();
                break;
            case 0:
                return;
            default:
                System.out.println(" Opção inválida!");
        }
    }
    
    // Métodos para Estudantes
    private static void adicionarEstudante() {
        int id = lerInteiro("ID do estudante: ");
        String nome = lerString("Nome do estudante: ");
        listaEstudantes.adicionarEstudante(new Estudante(id, nome));
        System.out.println(" Estudante adicionado com sucesso!");
    }
    
    private static void removerEstudante() {
        int id = lerInteiro("ID do estudante a remover: ");
        listaEstudantes.removerEstudantePorID(id);
    }
    
    private static void listarEstudantes() {
        System.out.println("\n LISTA DE ESTUDANTES (" + listaEstudantes.getTamanho() + "):");
        for (int i = 0; i < listaEstudantes.getTamanho(); i++) {
            Estudante est = listaEstudantes.obterEstudanteIndice(i);
            System.out.println((i + 1) + ". " + est);
        }
    }
    
    private static void buscarEstudantePorNome() {
        String nome = lerString("Digite o nome para buscar: ");
        List<Estudante> resultado = listaEstudantes.buscarEstudanteNome(nome);
        System.out.println("\n RESULTADO DA BUSCA (" + resultado.size() + " encontrados):");
        for (Estudante est : resultado) {
            System.out.println("• " + est);
        }
    }
    
    private static void ordenarEstudantes() {
        listaEstudantes.ordenarPorNome();
        System.out.println(" Estudantes ordenados por nome!");
        listarEstudantes();
    }
    
    // Métodos para Disciplinas
    private static void adicionarDisciplina() {
        String codigo = lerString("Código da disciplina: ");
        String nome = lerString("Nome da disciplina: ");
        listaDisciplinas.adicionarDisciplina(new Disciplina(codigo, nome));
        System.out.println(" Disciplina adicionada com sucesso!");
    }
    
    private static void removerDisciplina() {
        String codigo = lerString("Código da disciplina a remover: ");
        listaDisciplinas.removerDisciplina(codigo);
    }
    
    private static void listarDisciplinas() {
        System.out.println("\n LISTA DE DISCIPLINAS (" + listaDisciplinas.getTamanho() + "):");
        Set<Disciplina> disciplinas = listaDisciplinas.obterTodasDisciplinas();
        int i = 1;
        for (Disciplina disc : disciplinas) {
            System.out.println(i + ". " + disc);
            i++;
        }
    }
    
    private static void verificarDisciplina() {
        String codigo = lerString("Código da disciplina a verificar: ");
        boolean existe = listaDisciplinas.verificarDisciplina(codigo);
        System.out.println(" A disciplina com código '" + codigo + "' " + 
                          (existe ? "EXISTE" : "NÃO EXISTE") + " no sistema.");
    }
    
    // Métodos para Notas
    private static void adicionarNota() {
        int idEstudante = lerInteiro("ID do estudante: ");
        String codigoDisciplina = lerString("Código da disciplina: ");
        double valor = lerNota("Nota (use ponto ou vírgula): ");
        
        // Verificar se estudante existe
        boolean estudanteExiste = false;
        for (int i = 0; i < listaEstudantes.getTamanho(); i++) {
            if (listaEstudantes.obterEstudanteIndice(i).getId() == idEstudante) {
                estudanteExiste = true;
                break;
            }
        }
        
        if (!estudanteExiste) {
            System.out.println(" Estudante não encontrado!");
            return;
        }
        
        if (!listaDisciplinas.verificarDisciplina(codigoDisciplina)) {
            System.out.println(" Disciplina não encontrada!");
            return;
        }
        
        listaNotas.adicionarNota(new Nota(idEstudante, codigoDisciplina, valor));
    }
    
    private static void removerNota() {
        int idEstudante = lerInteiro("ID do estudante: ");
        String codigoDisciplina = lerString("Código da disciplina: ");
        listaNotas.removerNota(idEstudante, codigoDisciplina);
    }
    
    private static void listarTodasNotas() {
        System.out.println("\n TODAS AS NOTAS (" + listaNotas.obterTodasNotas().size() + "):");
        List<Nota> notas = listaNotas.obterTodasNotas();
        for (Nota nota : notas) {
            System.out.println("• Estudante " + nota.getIdEstudante() + 
                             " - " + nota.getCodigoDisciplina() + 
                             ": " + formatarNota(nota.getValor()));
        }
    }
    
    private static void consultarNotasEstudante() {
        int idEstudante = lerInteiro("ID do estudante: ");
        List<Nota> notas = listaNotas.obterNotasPorEstudante(idEstudante);
        System.out.println("\n NOTAS DO ESTUDANTE " + idEstudante + " (" + notas.size() + " notas):");
        for (Nota nota : notas) {
            System.out.println("• " + nota.getCodigoDisciplina() + ": " + formatarNota(nota.getValor()));
        }
    }
    
    private static void consultarNotaEspecifica() {
        int idEstudante = lerInteiro("ID do estudante: ");
        String codigoDisciplina = lerString("Código da disciplina: ");
        Nota nota = listaNotas.obterNotaEspecifica(idEstudante, codigoDisciplina);
        if (nota != null) {
            System.out.println(" Nota encontrada: " + formatarNota(nota.getValor()));
        } else {
            System.out.println(" Nota não encontrada!");
        }
    }
    
    private static void calcularMediaEstudante() {
        int idEstudante = lerInteiro("ID do estudante: ");
        double media = listaNotas.mediaDoEstudante(idEstudante);
        System.out.println(" Média do estudante " + idEstudante + ": " + formatarNota(media));
    }
    
    private static void calcularMediaDisciplina() {
        String codigoDisciplina = lerString("Código da disciplina: ");
        double media = listaNotas.mediaDaDisciplina(codigoDisciplina);
        System.out.println(" Média da disciplina " + codigoDisciplina + ": " + formatarNota(media));
    }
    
    private static void exibirEstatisticas() {
        System.out.println("\n ESTATÍSTICAS DO SISTEMA");
        System.out.println("==========================");
        System.out.println(" Total de Estudantes: " + listaEstudantes.getTamanho());
        System.out.println(" Total de Disciplinas: " + listaDisciplinas.getTamanho());
        System.out.println(" Total de Notas: " + listaNotas.obterTodasNotas().size());
        
        // Médias gerais
        System.out.println("\n MÉDIAS GERAIS:");
        for (int i = 0; i < listaEstudantes.getTamanho(); i++) {
            Estudante est = listaEstudantes.obterEstudanteIndice(i);
            double media = listaNotas.mediaDoEstudante(est.getId());
            System.out.println("• " + est.getNome() + ": " + formatarNota(media));
        }
        
        System.out.println("\n MÉDIAS POR DISCIPLINA:");
        Set<Disciplina> disciplinas = listaDisciplinas.obterTodasDisciplinas();
        for (Disciplina disc : disciplinas) {
            double media = listaNotas.mediaDaDisciplina(disc.getCodigo());
            System.out.println("• " + disc.getCodigo() + " - " + disc.getNome() + ": " + formatarNota(media));
        }
    }
    
    // Método para gerar relatório completo no arquivo output.txt
    private static void gerarRelatorioCompleto() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output.txt"))) {
            writer.println(" RELATÓRIO COMPLETO - SISTEMA DE GESTÃO ESCOLAR");
            writer.println("==================================================");
            writer.println("Data: " + new Date());
            writer.println();
            
            // Seção de Estudantes
            writer.println(" ESTUDANTES CADASTRADOS (" + listaEstudantes.getTamanho() + "):");
            writer.println("--------------------------------------------------");
            for (int i = 0; i < listaEstudantes.getTamanho(); i++) {
                Estudante est = listaEstudantes.obterEstudanteIndice(i);
                writer.println((i + 1) + ". " + est);
                
                // Notas do estudante
                List<Nota> notasEstudante = listaNotas.obterNotasPorEstudante(est.getId());
                if (!notasEstudante.isEmpty()) {
                    writer.println(" Notas:");
                    for (Nota nota : notasEstudante) {
                        writer.println("   • " + nota.getCodigoDisciplina() + ": " + formatarNota(nota.getValor()));
                    }
                    double media = listaNotas.mediaDoEstudante(est.getId());
                    writer.println(" Média Geral: " + formatarNota(media));
                } else {
                    writer.println(" Nenhuma nota registrada");
                }
                writer.println();
            }
            
            // Seção de Disciplinas
            writer.println(" DISCIPLINAS CADASTRADAS (" + listaDisciplinas.getTamanho() + "):");
            writer.println("--------------------------------------------------");
            Set<Disciplina> disciplinas = listaDisciplinas.obterTodasDisciplinas();
            int i = 1;
            for (Disciplina disc : disciplinas) {
                writer.println(i + ". " + disc);
                double media = listaNotas.mediaDaDisciplina(disc.getCodigo());
                writer.println("    Média da disciplina: " + formatarNota(media));
                writer.println();
                i++;
            }
            
            // Seção de Estatísticas Gerais
            writer.println(" ESTATÍSTICAS GERAIS");
            writer.println("--------------------------------------------------");
            writer.println("• Total de estudantes: " + listaEstudantes.getTamanho());
            writer.println("• Total de disciplinas: " + listaDisciplinas.getTamanho());
            writer.println("• Total de notas registradas: " + listaNotas.obterTodasNotas().size());
            

            System.out.println(" Relatório gerado com sucesso em 'output.txt'!");
            System.out.println(" Arquivo contém:");
            System.out.println("   • " + listaEstudantes.getTamanho() + " estudantes");
            System.out.println("   • " + listaDisciplinas.getTamanho() + " disciplinas");
            System.out.println("   • " + listaNotas.obterTodasNotas().size() + " notas");
            System.out.println("   • Estatísticas completas do sistema");
            
        } catch (IOException e) {
            System.out.println(" Erro ao gerar relatório: " + e.getMessage());
        }
    }
    
    private static double lerNota(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String input = scanner.nextLine().trim();
                
                // Substitui vírgula por ponto
                input = input.replace(",", ".");
                
                double valor = Double.parseDouble(input);
                
                // Valida se a nota está entre 0 e 10
                if (valor < 0 || valor > 10) {
                    System.out.println(" A nota deve estar entre 0 e 10!");
                    continue;
                }
                
                return valor;
                
            } catch (NumberFormatException e) {
                System.out.println(" Por favor, digite um número válido! Exemplos: 7.5 ou 7,5");
            }
        }
    }
    
    private static String formatarNota(double nota) {
        // Formata com 1 casa decimal e substitui ponto por vírgula
        return String.format("%.1f", nota).replace(".", ",");
    }
    
    // Métodos auxiliares para leitura de entrada
    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }
    
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println(" Por favor, digite um número inteiro válido!");
            }
        }
    }
}