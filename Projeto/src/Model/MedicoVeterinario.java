package Model;

public class MedicoVeterinario extends Funcionario {
    private String crmv;
    private String especialidade;

    public MedicoVeterinario(int codigo, String nome, String cargo, String cpf, double salario, String crmv, String especialidade) {
        super(codigo, nome, cargo, cpf, salario);
        this.crmv = crmv;
        this.especialidade = especialidade;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
