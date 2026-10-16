package Model;

public class MedicoVeterinario extends Empregado{
    private String crm;
    private String especialidade;

    public MedicoVeterinario(int codigo, String nome, String cargo, int cpf, double salario, String crm, String especialidade) {
        super(codigo, nome, cargo, cpf, salario);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
