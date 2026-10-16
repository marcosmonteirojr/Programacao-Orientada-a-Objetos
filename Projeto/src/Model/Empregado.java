package Model;

public abstract class Empregado {
    protected int codigo;
    protected String nome;
    protected String cargo;
    protected int cpf;
    protected double salario;

    public Empregado(int codigo, String nome, String cargo, int cpf, double salario) {
       this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
        this.salario = salario;
    }
}
