import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaEstudante {
    private List<Estudante> listaEstudantes;

    public ListaEstudante() {
        this.listaEstudantes = new ArrayList<>();
    }
    public void adicionarEstudante(Estudante est){
        listaEstudantes.add(est);
    }
    public void removerEstudantePorID(int id){
        for (Estudante estudante : listaEstudantes) {
            if(estudante.getId() == id){
                listaEstudantes.remove(estudante);
                System.out.println("Estudante removido!");
                return;
            }
        }
        System.out.println("Estudante não encontrado!");
    }
    public Estudante obterEstudanteIndice(int indice){
        if(indice >= 0 && indice < listaEstudantes.size()){
            return listaEstudantes.get(indice);
        }
        return null;
    }
    public List<Estudante> buscarEstudanteNome(String nome){
        List<Estudante> resultado = new ArrayList<>();
        for(Estudante estudante : listaEstudantes){
            if(estudante.getNome().toLowerCase().contains(nome.toLowerCase())){
                resultado.add(estudante);
            }
        }
        return resultado;
    }
    public void ordenarPorNome(){
        Collections.sort(listaEstudantes, new Comparator<Estudante>() {
            @Override
            public int compare(Estudante o1, Estudante o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }
    public int getTamanho(){
        return listaEstudantes.size();
    }
}
