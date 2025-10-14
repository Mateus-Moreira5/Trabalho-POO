import java.util.*;

public class ListaNota {
    private List<Nota> listaNotas;

    public ListaNota() {
        this.listaNotas = new ArrayList<>();
    }
    
    public void adicionarNota(Nota nota) {
        listaNotas.add(nota);
        System.out.println("Nota adicionada com sucesso!");
    }
    
    public void removerNota(int idEstudante, String codigoDisciplina) {
        for (Nota nota : listaNotas) {
            if (nota.getIdEstudante() == idEstudante && 
                nota.getCodigoDisciplina().equals(codigoDisciplina)) {
                listaNotas.remove(nota);
                System.out.println("Nota removida com sucesso!");
                return;
            }
        }
        System.out.println("Nota não encontrada!");
    }
    
    public List<Nota> obterTodasNotas() {
        return new ArrayList<>(listaNotas);
    }
    
    public List<Nota> obterNotasPorEstudante(int idEstudante) {
        List<Nota> resultado = new ArrayList<>();
        for (Nota nota : listaNotas) {
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
        
        for (Nota nota : listaNotas) {
            if (nota.getCodigoDisciplina().equals(codigoDisciplina)) {
                soma += nota.getValor();
                count++;
            }
        }
        return count > 0 ? soma / count : 0.0;
    }
}