package Controller;

import DAO.MedicoVeterinarioDAO;
import View.MedicoVeterinarioView;
import Model.MedicoVeterinario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MedicoVeterinarioController {

    private MedicoVeterinarioView view;
    private MedicoVeterinarioDAO dao;

    // O construtor recebe a View e inicializa o DAO
    public MedicoVeterinarioController(MedicoVeterinarioView view) {
        this.view = view;
        this.dao = new MedicoVeterinarioDAO();

        // 1. Inicializa a tabela com os dados que já existem na base de dados
        carregarTabela();

        // 2. Adiciona os "Ouvintes de Eventos" (Listeners) aos botões da View
        this.view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarVeterinario();
            }
        });

        this.view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirVeterinario();
            }
        });
    }

    // Método para ler os dados da View, criar o objeto e enviar para o DAO
    private void salvarVeterinario() {
        try {
            // Recolhe os dados em texto da interface
            String nome = view.getNome();
            String cpf = view.getCpf();
            String cargo = view.getCargo();
            String crmv = view.getCrmv();
            String especialidade = view.getEspecialidade();

            // Converte o texto do salário para número (pode gerar exceção se o utilizador digitar letras)
            double salario = Double.parseDouble(view.getSalario());

            // Validação simples de campos vazios
            if (nome.isEmpty() || cpf.isEmpty() || crmv.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Preencha os campos obrigatórios (Nome, CPF e CRMV).", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Cria o objeto modelo (o código é 0 provisoriamente, pois a BD vai gerar o AUTO_INCREMENT)
            MedicoVeterinario vet = new MedicoVeterinario(0, nome, cargo, cpf, salario, crmv, especialidade);

            // Chama o DAO para inserir
            dao.inserir(vet);

            // Mostra mensagem de sucesso e atualiza a grelha visual
            JOptionPane.showMessageDialog(view, "Médico Veterinário guardado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            carregarTabela();
            //view.getBtnLimpar().doClick(); // Simula o clique no botão limpar para esvaziar o formulário

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "O campo Salário deve conter apenas números (ex: 2500.50).", "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para descobrir qual linha foi selecionada e mandar excluir na BD
    private void excluirVeterinario() {
        JTable tabela = view.getTabelaVeterinarios();
        int linhaSelecionada = tabela.getSelectedRow();

        // Verifica se o utilizador realmente selecionou alguma linha na grelha
        if (linhaSelecionada >= 0) {
            // Pergunta de confirmação
            int resposta = JOptionPane.showConfirmDialog(view, "Tem a certeza que deseja excluir este veterinário?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                // Apanha o ID (código) que está na coluna 0 da linha selecionada
                int codigo = (int) tabela.getValueAt(linhaSelecionada, 0);

                // Chama o DAO para excluir
                dao.excluir(codigo);

                JOptionPane.showMessageDialog(view, "Excluído com sucesso!");
                carregarTabela(); // Atualiza a tabela para remover a linha visualmente
            }
        } else {
            JOptionPane.showMessageDialog(view, "Selecione um veterinário na tabela para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para ir à Base de Dados buscar a lista e preencher a JTable
    private void carregarTabela() {
        DefaultTableModel modelo = view.getModeloTabela();

        // Limpa todas as linhas atuais da tabela antes de carregar de novo
        modelo.setRowCount(0);

        // Pede ao DAO a lista atualizada
        List<MedicoVeterinario> lista = dao.listar();

        // Percorre a lista e adiciona linha a linha na JTable
        for (MedicoVeterinario vet : lista) {
            modelo.addRow(new Object[]{
                    vet.getCodigo(),
                    vet.getNome(),
                    vet.getCrmv(),
                    vet.getEspecialidade()
            });
        }
    }
}
