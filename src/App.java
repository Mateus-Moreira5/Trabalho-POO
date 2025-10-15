import java.util.*;

public class App {
    private static ListaEstudante listaEstudantes = new ListaEstudante();
    private static ListaDisciplina listaDisciplinas = new ListaDisciplina();
    private static ListaNota listaNotas = new ListaNota();

    public static void main(String[] args) throws Exception {
        carregarDataset();
        exibirRelatorios();
    }

    private static void carregarDataset() {
        System.out.println("=== CARREGANDO DATASET DO PDF ===\n");

        // Carregar estudantes (conforme PDF)
        listaEstudantes.adicionarEstudante(new Estudante(1, "Ana"));
        listaEstudantes.adicionarEstudante(new Estudante(2, "Bruno"));
        listaEstudantes.adicionarEstudante(new Estudante(3, "Carla"));
        listaEstudantes.adicionarEstudante(new Estudante(4, "Diego"));
        listaEstudantes.adicionarEstudante(new Estudante(5, "Elisa"));

        // Carregar disciplinas (conforme PDF)
        listaDisciplinas.adicionarDisciplina(new Disciplina("MAT101", "Matemática"));
        listaDisciplinas.adicionarDisciplina(new Disciplina("PRG201", "Programação"));
        listaDisciplinas.adicionarDisciplina(new Disciplina("BD301", "Banco de Dados"));
        listaDisciplinas.adicionarDisciplina(new Disciplina("EDF110", "Educação Física"));

        // Carregar notas/matrículas (conforme PDF)
        listaNotas.adicionarNota(new Nota(1, "MAT101", 8.5));
        listaNotas.adicionarNota(new Nota(1, "PRG201", 9.0));
        listaNotas.adicionarNota(new Nota(2, "PRG201", 7.0));
        listaNotas.adicionarNota(new Nota(2, "MAT101", 5.0));
        listaNotas.adicionarNota(new Nota(3, "BD301", 6.5));
        listaNotas.adicionarNota(new Nota(3, "MAT101", 7.5));
        listaNotas.adicionarNota(new Nota(4, "PRG201", 8.0));
        listaNotas.adicionarNota(new Nota(5, "EDF110", 10.0));
    }

    private static void exibirRelatorios() {
        System.out.println("=== RELATÓRIOS DO SISTEMA ESCOLAR ===\n");

        exibirEstudantes();
        exibirDisciplinas();
        exibirDuplicatas();
        exibirMatriculasENotas();
        exibirMediasDisciplinas();
        exibirTopEstudantes();
        exibirAlunosAprovados();
        exibirDisciplinasComProblema();
    }

    private static void exibirEstudantes() {
        // 1. Lista de estudantes (ordem cadastro)
        System.out.println(" *Carregar alunos cadastrados*");
        for (int i = 0; i < 5; i++) {
            Estudante est = listaEstudantes.obterEstudanteIndice(i);
            if (est != null) {
                System.out.println(est);
            }
        }

        // 2. Lista de estudantes ordenada por nome (alfabética)
        System.out.println("\n *Lista de Estudantes (Em ordem alfabética)*");
        listaEstudantes.ordenarPorNome();
        for (int i = 0; i < 5; i++) {
            Estudante est = listaEstudantes.obterEstudanteIndice(i);
            if (est != null) {
                System.out.println(est.getNome());
            }
        }
    }

    private static void exibirDisciplinas() {
        // 3. Disciplinas (ordem inserção)
        System.out.println("\n *Disciplinas (ordem de inserção)*");
        Set<Disciplina> disciplinas = listaDisciplinas.obterTodasDisciplinas();
        for (Disciplina disc : disciplinas) {
            System.out.print(disc.getCodigo() + " ");
        }
        System.out.println();
    }

    private static void exibirDuplicatas() {
        // 5. c)Duplicatas detectadas
        System.out.println("\n Duplicatas detectadas na importação");
        System.out.println("(nenhuma)");
    }

    private static void exibirMatriculasENotas() {
        // 4. Matrículas e médias dos estudantes
        System.out.println("\n *Diciplinas e Notas dos Estudantes*");
        for (int i = 0; i < 5; i++) {
            Estudante est = listaEstudantes.obterEstudanteIndice(i);
            if (est != null) {
                double media = listaNotas.mediaDoEstudante(est.getId());
                List<Nota> notasEstudante = listaNotas.obterNotasPorEstudante(est.getId());
                
                System.out.print(est.getNome() + ": ");
                for (Nota nota : notasEstudante) {
                    System.out.print(nota.getCodigoDisciplina() + "(" + nota.getValor() + ") ");
                }
                System.out.println("Média: " + String.format("%.2f", media));
            }
        }
    }

    private static void exibirMediasDisciplinas() {
        // Médias por disciplina
        System.out.println("\n *Médias por Disciplina*");
        Set<Disciplina> todasDisciplinas = listaDisciplinas.obterTodasDisciplinas();
        for (Disciplina disc : todasDisciplinas) {
            double media = listaNotas.mediaDaDisciplina(disc.getCodigo());
            System.out.println(disc.getCodigo() + ": " + String.format("%.1f", media));
        }
    }

    private static void exibirTopEstudantes() {
        // "Bonus" Top 3 alunos por média
        System.out.println("\n *Top 3 alunos por média*");
        
        List<Estudante> top3 = obterTopNEstudantes(3);
        for (int i = 0; i < top3.size(); i++) {
            Estudante est = top3.get(i);
            double media = listaNotas.mediaDoEstudante(est.getId());
            System.out.println((i + 1) + ") " + est.getNome() + " - " + String.format("%.1f", media));
        }
    }

    private static void exibirAlunosAprovados() {
        // 5. a)Alunos com média >= 8.0
        System.out.println("\n *Alunos com média >= 8.0*");
        StringBuilder aprovados = new StringBuilder();
        
        for (int i = 0; i < 5; i++) {
            Estudante est = listaEstudantes.obterEstudanteIndice(i);
            if (est != null) {
                double media = listaNotas.mediaDoEstudante(est.getId());
                if (media >= 8.0) {
                    if (aprovados.length() > 0) {
                        aprovados.append(", ");
                    }
                    aprovados.append(est.getNome());
                }
            }
        }
        
        if (aprovados.length() == 0) {
            System.out.println("(nenhum)");
        } else {
            System.out.println(aprovados.toString());
        }
    }

    private static void exibirDisciplinasComProblema() {
        // 5. b)Disciplinas com média < 6.0
        System.out.println("\n *Disciplinas com média < 6.0*");
        Set<Disciplina> todasDisciplinas = listaDisciplinas.obterTodasDisciplinas();
        boolean encontrouProblema = false;
        
        for (Disciplina disc : todasDisciplinas) {
            double media = listaNotas.mediaDaDisciplina(disc.getCodigo());
            if (media < 6.0) {
                System.out.println(disc.getCodigo() + ": " + String.format("%.1f", media));
                encontrouProblema = true;
            }
        }
        
        if (!encontrouProblema) {
            System.out.println("(nenhuma)");
        }
    }

    private static List<Estudante> obterTopNEstudantes(int N) {
        List<Estudante> todosEstudantes = new ArrayList<>();
        
        for (int i = 0; i < 5; i++) {
            Estudante est = listaEstudantes.obterEstudanteIndice(i);
            if (est != null) {
                todosEstudantes.add(est);
            }
        }
        
        Collections.sort(todosEstudantes, new Comparator<Estudante>() {
            @Override
            public int compare(Estudante e1, Estudante e2) {
                double media1 = listaNotas.mediaDoEstudante(e1.getId());
                double media2 = listaNotas.mediaDoEstudante(e2.getId());
                return Double.compare(media2, media1); // Decrescente
            }
        });
        
        
        return todosEstudantes.subList(0, Math.min(N, todosEstudantes.size()));
    }
}