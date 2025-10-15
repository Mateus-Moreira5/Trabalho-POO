import java.util.*;

public class ListaNota {
    private Map<String, Nota> mapaNotas;


    public ListaNota() {
        this.mapaNotas = new HashMap<>();
    }
    
    public void adicionarNota(Nota nota) {
         String chave = nota.getIdEstudante() + "-" + nota.getCodigoDisciplina();
         mapaNotas.put(chave, nota);
        System.out.println("Nota adicionada com sucesso!");
    }
    
    public void removerNota(int idEstudante, String codigoDisciplina) {
         String chave = idEstudante + "-" + codigoDisciplina;
            if (mapaNotas.remove(chave) != null) {
            System.out.println("Nota removida com sucesso!");
        } else {
            System.out.println("Nota não encontrada!");
            }
    }
    
    public List<Nota> obterTodasNotas() {
        return new ArrayList<>(mapaNotas.values());
    }
    
    public List<Nota> obterNotasPorEstudante(int idEstudante) {
        List<Nota> resultado = new ArrayList<>();
        for (Nota nota : mapaNotas.values()) {
            if (nota.getIdEstudante() == idEstudante) {
                resultado.add(nota);
            }
        }
        return resultado;
    }
    
    public double mediaDoEstudante(int idEstudante) {
        List<Nota> notasEstudante = obterNotasPorEstudante(idEstudante);
        if (notasEstudante.isEmpty()) return 0.0;
        
        double soma = 0;
        for (Nota nota : notasEstudante) {
            soma += nota.getValor();
        }
        return soma / notasEstudante.size();
    }
    
    public double mediaDaDisciplina(String codigoDisciplina) {
        double soma = 0;
        int count = 0;
        
        for (Nota nota : mapaNotas.values()) {
            if (nota.getCodigoDisciplina().equals(codigoDisciplina)) {
                soma += nota.getValor();
                count++;
            }
        }
        return count > 0 ? soma / count : 0.0;
    }

    public Nota obterNotaEspecifica(int idEstudante, String codigoDisciplina) {
        String chave = idEstudante + "-" + codigoDisciplina;
        return mapaNotas.get(chave);
    }
}