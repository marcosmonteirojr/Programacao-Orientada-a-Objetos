package Model;

public class Secretaria extends Empregado {
private int codigo;
    // O construtor recebe os dados e os envia para a classe mãe gerenciar
    public Secretaria(String nome,String cargo, int cpf, double salario) {
        super(nome, cargo, cpf, salario);
    }

    // Comportamentos (métodos) exclusivos da Secretária
    public void agendarConsulta() {
        System.out.println("A secretária " + getNome() + " está agendando uma consulta.");
    }

    public void receberPagamento() {
        System.out.println("Pagamento recebido no caixa.");
    }
}