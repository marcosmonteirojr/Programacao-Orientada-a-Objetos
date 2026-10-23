package Model;

public class Secretaria extends Funcionario {
    private int codigo;

    // O construtor recebe os dados e os envia para a classe mãe gerenciar
    public Secretaria(int codigo, String nome, String cargo, String cpf, double salario) {
        super(codigo, nome, cargo, cpf, salario);
    }

    // Comportamentos (métodos) exclusivos da Secretária
    public void agendarConsulta() {
        System.out.println("A secretária " + getNome() + " está agendando uma consulta.");
    }

    public void receberPagamento() {
        System.out.println("Pagamento recebido no caixa.");
    }
}