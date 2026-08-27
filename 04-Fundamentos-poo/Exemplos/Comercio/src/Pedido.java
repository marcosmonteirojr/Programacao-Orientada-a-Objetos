import java.util.ArrayList;
import java.util.List;

class Pedido {
    private int idPedido;

    // COMPOSIÇÃO ROBUSTA: A NotaFiscal é criada exclusivamente dentro do construtor do Pedido
    private NotaFiscal notaFiscal;

    // AGREGAÇÃO: Lista de produtos criados de forma independente fora do pedido
    private List<Produto> itensPedido;

    public Pedido(int idPedido, String numeroNota, double valorBase) {
        this.idPedido = idPedido;
        this.itensPedido = new ArrayList<>();

        // A composição acontece aqui: A Nota Fiscal nasce acoplada ao Pedido
        this.notaFiscal = new NotaFiscal(numeroNota, valorBase);
    }

    public void adicionarProduto(Produto produto) {
        this.itensPedido.add(produto);
    }

    public void concluirPedido(Cliente cliente) {
        System.out.println("Processando Pedido #" + idPedido + " para o cliente: " + cliente.getNome());
        System.out.println("Itens comprados:");

        double total = 0;
        for (Produto p : itensPedido) {
            System.out.println(" - " + p.getNomeProduto() + " (R$ " + p.getPreco() + ")");
            total += p.getPreco();
        }

        System.out.println("Valor Total: R$ " + total);

        // Acionando a nota fiscal gerada por composição
        notaFiscal.emitirNota();
        System.out.println("--------------------------------------------------\n");
    }
}