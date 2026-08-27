class Cliente extends Usuario {
    private String telefone;

    public Cliente(String nome, String email, String telefone) {
        super(nome, email); // Reaproveita o construtor da superclasse
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }
}