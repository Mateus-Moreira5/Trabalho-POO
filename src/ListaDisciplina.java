import java.util.LinkedHashSet;
import java.util.Set;

public class ListaDisciplina {
    private Set<Disciplina> listaDisciplinas;

    public ListaDisciplina(){
        this.listaDisciplinas = new LinkedHashSet<>();
    }
    public void adicionarDisciplina(Disciplina dcp){
        listaDisciplinas.add(dcp);
    }
    public boolean verificarDisciplina(String codigo){
        for (Disciplina disciplina : listaDisciplinas) {
            if(disciplina.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    public void removerDisciplina(String codigo){
        for (Disciplina disciplina : listaDisciplinas) {
            if(disciplina.getCodigo().equals(codigo)){
                listaDisciplinas.remove(disciplina);
                System.out.println("Disciplina removida com sucesso!");
                return;
            }
        }
        System.out.println("Disciplina não encontrada!");
    }
    public Set<Disciplina> obterTodasDisciplinas(){
        return listaDisciplinas;
    }
    public int getTamanho(){
        return listaDisciplinas.size();
    }
}
