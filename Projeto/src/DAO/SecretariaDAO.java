package DAO;
import Model.Secretaria;
import Util.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SecretariaDAO {

    // 1. CREATE (Inserir)
    public void inserir(Secretaria secretaria) {
        String sqlFuncionario = "INSERT INTO funcionario (nome, cargo, cpf, salario) VALUES (?, ?, ?, ?)";
        String sqlSecretaria = "INSERT INTO secretaria (codigo) VALUES (?)";

        Connection conn = null;

        try {
            conn = ConnectionFactory.getConnection();
            // Desliga o autocommit para garantir que as duas tabelas sejam inseridas juntas (Transação)
            conn.setAutoCommit(false);

            int idGerado = 0;

            // Passo A: Inserir na tabela Funcionario e pedir a chave gerada
            try (PreparedStatement stmtFunc = conn.prepareStatement(sqlFuncionario, Statement.RETURN_GENERATED_KEYS)) {
                stmtFunc.setString(1, secretaria.getNome());
                stmtFunc.setString(2, "Secretária"); // Cargo fixo para este DAO
                stmtFunc.setInt(4, secretaria.getCpf());
                stmtFunc.setDouble(5, secretaria.getSalario());

                stmtFunc.executeUpdate();

                // Pega o ID (código) que o banco gerou
                try (ResultSet rs = stmtFunc.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGerado = rs.getInt(1);
                        secretaria.setCodigo(idGerado); // Atualiza o objeto Java com o novo ID
                    }
                }
            }

            // Passo B: Inserir na tabela Secretaria usando o ID gerado
            try (PreparedStatement stmtSec = conn.prepareStatement(sqlSecretaria)) {
                stmtSec.setInt(1, idGerado);
                stmtSec.executeUpdate();
            }

            // Confirma a transação se tudo deu certo
            conn.commit();
            System.out.println("Secretária cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar secretária: " + e.getMessage());
            // Se deu erro, desfaz qualquer inserção pela metade
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
        } finally {
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    // 2. READ (Listar todas as secretárias)
    public List<Secretaria> listar() {
        List<Secretaria> lista = new ArrayList<>();
        // O JOIN garante que só vamos trazer os funcionários que também estão na tabela secretaria
        String sql = "SELECT f.codigo, f.nome, f.cpf, f.salario " +
                "FROM funcionario f " +
                "INNER JOIN secretaria s ON f.codigo = s.codigo";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Instancia a secretária com os dados vindos do banco
                Secretaria sec = new Secretaria(
                        rs.getString("nome"),
                        rs.getString("cargo"),
                        rs.getInt("cpf"),
                        rs.getDouble("salario")
                );
                sec.setCodigo(rs.getInt("codigo"));
                lista.add(sec);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar secretárias: " + e.getMessage());
        }
        return lista;
    }

    // 3. UPDATE (Atualizar)
    public void atualizar(Secretaria secretaria) {
        // A atualização ocorre apenas na tabela mãe, pois a tabela filha só tem o ID
        String sql = "UPDATE funcionario SET nome = ?, cpf = ?, salario = ? WHERE codigo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, secretaria.getNome());
            stmt.setInt(2, secretaria.getCpf());
            stmt.setDouble(3, secretaria.getSalario());
            stmt.setInt(4, secretaria.getCodigo());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Dados da secretária atualizados com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar secretária: " + e.getMessage());
        }
    }

    // 4. DELETE (Excluir)
    public void excluir(int codigo) {
        // Deletamos da tabela mãe. O 'ON DELETE CASCADE' do SQL apaga automaticamente da tabela filha.
        String sql = "DELETE FROM funcionario WHERE codigo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Secretária excluída com sucesso!");
            } else {
                System.out.println("Nenhuma secretária encontrada com este código.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir secretária: " + e.getMessage());
        }
    }
}
