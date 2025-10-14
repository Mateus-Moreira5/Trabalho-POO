import java.util.Objects;

public class Nota {
    private int idEstudante;
    private String codigoDisciplina;
    private double valor;
    
    public Nota(int idEstudante, String codigoDisciplina, double valor) {
        this.idEstudante = idEstudante;
        this.codigoDisciplina = codigoDisciplina;
        this.valor = valor;
    }
    
    public int getIdEstudante() {
        return idEstudante;
    }
    
    public void setIdEstudante(int idEstudante) {
        this.idEstudante = idEstudante;
    }
    
    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }
    
    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    @Override
    public String toString() {
        return "Estudante ID: " + idEstudante + 
               " | Disciplina: " + codigoDisciplina + 
               " | Nota: " + valor;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idEstudante, codigoDisciplina);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Nota other = (Nota) obj;
        
        if (idEstudante != other.idEstudante) return false;
        
        if (codigoDisciplina == null) {
            return other.codigoDisciplina == null;
        } else {
            return codigoDisciplina.equals(other.codigoDisciplina);
        }
    }
}