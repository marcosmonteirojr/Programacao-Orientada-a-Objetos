package Model;

public abstract class Empregado {
    protected int codigo;
    protected String nome;
    protected String cargo;
    protected int cpf;
    protected double salario;

    public Empregado(String nome, String cargo, int cpf, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
        this.salario = salario;
    }
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
