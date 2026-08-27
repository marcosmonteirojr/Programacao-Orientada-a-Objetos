public class Principal {
    public static void main(String[] args) {
        // 1. Demonstração de Herança: Criando um Cliente que herda de Usuario
        Cliente cliente = new Cliente("Mariana Silva", "mariana@email.com", "(41) 98888-7777");

        // 2. Demonstração de Agregação: Produtos criados de forma avulsa no catálogo
        Produto p1 = new Produto("Teclado Mecânico RGB", 320.00);
        Produto p2 = new Produto("Mouse Sem Fio ergonômico", 150.00);

        // 3. Demonstração de Composição e Associação combinadas:
        // Ao instanciar o Pedido, sua NotaFiscal interna é construída automaticamente junto (Composição).
        Pedido pedido = new Pedido(5042, "NF-2026/08-BR", 470.00);
        pedido.adicionarProduto(p1);
        pedido.adicionarProduto(p2);

        // 4. Demonstração de Associação: O pedido é concluído associando-se ao cliente
        pedido.concluirPedido(cliente);

        // Se o objeto 'pedido' for coletado pela memória, a 'notaFiscal' associada a ele
        // deixa de existir imediatamente, enquanto os 'produtos' (p1 e p2) continuam existindo no sistema.
    }
}