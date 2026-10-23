package DAO;

import Model.MedicoVeterinario;
import Util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoVeterinarioDAO {

    // 1. CREATE (Inserir)
    public void inserir(MedicoVeterinario veterinario) {
        // SQL para a tabela mãe
        String sqlFuncionario = "INSERT INTO funcionario (nome, cargo, cpf, salario) VALUES (?, ?, ?, ?)";
        // SQL para a tabela filha, incluindo os atributos específicos
        String sqlVeterinario = "INSERT INTO medico_veterinario (codigo, crmv, especialidade) VALUES (?, ?, ?)";

        Connection conn = null;

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false); // Inicia a transação

            int idGerado = 0;

            // Passo A: Inserir na tabela Funcionario e pedir a chave gerada
            try (PreparedStatement stmtFunc = conn.prepareStatement(sqlFuncionario, Statement.RETURN_GENERATED_KEYS)) {
                stmtFunc.setString(1, veterinario.getNome());
                stmtFunc.setString(2, "Médico Veterinário");
                stmtFunc.setString(3, veterinario.getCpf());
                stmtFunc.setDouble(4, veterinario.getSalario());

                stmtFunc.executeUpdate();

                // Captura o código gerado pelo banco
                try (ResultSet rs = stmtFunc.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                        veterinario.setCodigo(idGerado);
                    }
                }
            }

            // Passo B: Inserir na tabela medico_veterinario usando o código gerado
            try (PreparedStatement stmtVet = conn.prepareStatement(sqlVeterinario)) {
                stmtVet.setInt(1, idGerado);
                stmtVet.setString(2, veterinario.getCrmv());
                stmtVet.setString(3, veterinario.getEspecialidade());
                stmtVet.executeUpdate();
            }

            conn.commit(); // Confirma a transação
            System.out.println("Médico Veterinário cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar veterinário: " + e.getMessage());
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // 2. READ (Listar todos)
    public List<MedicoVeterinario> listar() {
        List<MedicoVeterinario> lista = new ArrayList<>();
        // INNER JOIN para buscar os dados comuns e específicos ao mesmo tempo
        String sql = "SELECT f.codigo, f.nome, f.cargo, f.cpf, f.salario, v.crmv, v.especialidade " +
                "FROM funcionario f " +
                "INNER JOIN medico_veterinario v ON f.codigo = v.codigo";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MedicoVeterinario vet = new MedicoVeterinario(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getString("cpf"),
                        rs.getDouble("salario"),
                        rs.getString("crmv"),
                        rs.getString("especialidade")
                );

                lista.add(vet);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar veterinários: " + e.getMessage());
        }
        return lista;
    }

    // 3. UPDATE (Atualizar)
    public void atualizar(MedicoVeterinario veterinario) {
        String sqlFuncionario = "UPDATE funcionario SET nome = ?, cpf = ?, salario = ? WHERE codigo = ?";
        String sqlVeterinario = "UPDATE medico_veterinario SET crmv = ?, especialidade = ? WHERE codigo = ?";

        Connection conn = null;

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false); // Inicia a transação para garantir que ambas as tabelas atualizem juntas

            // Atualiza a tabela mãe
            try (PreparedStatement stmtFunc = conn.prepareStatement(sqlFuncionario)) {
                stmtFunc.setString(1, veterinario.getNome());
                stmtFunc.setString(2, veterinario.getCpf());
                stmtFunc.setDouble(3, veterinario.getSalario());
                stmtFunc.setInt(4, veterinario.getCodigo());
                stmtFunc.executeUpdate();
            }

            // Atualiza a tabela filha
            try (PreparedStatement stmtVet = conn.prepareStatement(sqlVeterinario)) {
                stmtVet.setString(1, veterinario.getCrmv());
                stmtVet.setString(2, veterinario.getEspecialidade());
                stmtVet.setInt(3, veterinario.getCodigo());
                stmtVet.executeUpdate();
            }

            conn.commit(); // Confirma a transação
            System.out.println("Dados do veterinário atualizados com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veterinário: " + e.getMessage());
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // 4. DELETE (Excluir)
    public void excluir(int codigo) {
        // Graças ao 'ON DELETE CASCADE' na chave estrangeira do banco, deletar o funcionário apaga o veterinário.
        String sql = "DELETE FROM funcionario WHERE codigo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Médico Veterinário excluído com sucesso!");
            } else {
                System.out.println("Nenhum veterinário encontrado com este código.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir veterinário: " + e.getMessage());
        }
    }
}