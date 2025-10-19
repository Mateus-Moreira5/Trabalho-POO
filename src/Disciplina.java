import java.util.Objects;

public class Disciplina {
    private String codigo;
    private String nome;
    
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return codigo + " - " + nome;
    }
    public Disciplina(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Disciplina other = (Disciplina) obj;
        return Objects.equals(codigo, other.codigo);
    }
}
