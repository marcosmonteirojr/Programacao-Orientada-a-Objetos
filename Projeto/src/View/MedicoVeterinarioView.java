package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MedicoVeterinarioView extends JFrame {

    // Componentes de entrada de dados (Formulário)
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtCargo;
    private JTextField txtSalario;
    private JTextField txtCrmv;
    private JTextField txtEspecialidade;

    // Botões de ação
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnLimpar;

    // Componentes de listagem (Tabela)
    private JTable tabelaVeterinarios;
    private DefaultTableModel modeloTabela;

    public MedicoVeterinarioView() {
        // Configurações básicas da janela principal
        setTitle("Gestão de Médicos Veterinários");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setLocationRelativeTo(null); // Centraliza no ecrã
        setLayout(new BorderLayout(10, 10));

        // 1. Painel Superior: Formulário de Cadastro
        JPanel painelFormulario = new JPanel(new GridLayout(6, 2, 5, 5));
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Veterinário"));

        painelFormulario.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelFormulario.add(txtNome);

        painelFormulario.add(new JLabel("Cargo:"));
        txtCargo = new JTextField();
        painelFormulario.add(txtCargo);

        painelFormulario.add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        painelFormulario.add(txtCpf);

        painelFormulario.add(new JLabel("Salário:"));
        txtSalario = new JTextField();
        painelFormulario.add(txtSalario);

        painelFormulario.add(new JLabel("CRMV:"));
        txtCrmv = new JTextField();
        painelFormulario.add(txtCrmv);

        painelFormulario.add(new JLabel("Especialidade:"));
        txtEspecialidade = new JTextField();
        painelFormulario.add(txtEspecialidade);

        // 2. Painel Central: Botões de Ação
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSalvar = new JButton("Salvar");
        btnExcluir = new JButton("Excluir");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnLimpar);

        // Agrupa o formulário e os botões na parte superior (Norte)
        JPanel painelNorte = new JPanel(new BorderLayout());
        painelNorte.add(painelFormulario, BorderLayout.CENTER);
        painelNorte.add(painelBotoes, BorderLayout.SOUTH);
        add(painelNorte, BorderLayout.NORTH);

        // 3. Painel Inferior: Tabela de Listagem
        String[] colunas = {"Código", "Nome", "CRMV", "Especialidade"};
        modeloTabela = new DefaultTableModel(colunas, 0);
        tabelaVeterinarios = new JTable(modeloTabela);
        JScrollPane scrollTabela = new JScrollPane(tabelaVeterinarios);
        scrollTabela.setBorder(BorderFactory.createTitledBorder("Veterinários Registados"));

        add(scrollTabela, BorderLayout.CENTER);

        // Adiciona comportamentos visuais básicos (Limpar campos)
        configurarEventosBasicos();
    }

    // Método para limpar o formulário (Lógica puramente visual)
    private void configurarEventosBasicos() {
        btnLimpar.addActionListener(e -> {
            txtNome.setText("");
            txtCpf.setText("");
            txtCargo.setText("");
            txtSalario.setText("");
            txtCrmv.setText("");
            txtEspecialidade.setText("");
            txtNome.requestFocus(); // Devolve o cursor para o primeiro campo
        });
    }

    // Métodos Getters para que o Controller possa ler os dados digitados
    public String getNome() { return txtNome.getText(); }
    public String getCpf() { return txtCpf.getText(); }
    public String getCargo() { return txtCargo.getText(); }
    public String getSalario() { return txtSalario.getText(); }
    public String getCrmv() { return txtCrmv.getText(); }
    public String getEspecialidade() { return txtEspecialidade.getText(); }

    // Getters para os botões e tabela (usados pelo Controller para adicionar EventListeners reais)
    public JButton getBtnSalvar() { return btnSalvar; }
    public JButton getBtnExcluir() { return btnExcluir; }
    public DefaultTableModel getModeloTabela() { return modeloTabela; }
    public JTable getTabelaVeterinarios() { return tabelaVeterinarios; }

    // Método principal apenas para testar o visual da janela
    public static void main(String[] args) {
        // Garante que a interface gráfica corre na Thread correta do Swing
        SwingUtilities.invokeLater(() -> {
            new MedicoVeterinarioView().setVisible(true);
        });
    }
}
