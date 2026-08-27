class NotaFiscal {
    private String numeroNota;
    private double valorImpostos;

    // A nota fiscal é restrita e gerada a partir do contexto do pedido
    public NotaFiscal(String numeroNota, double valorTotal) {
        this.numeroNota = numeroNota;
        this.valorImpostos = valorTotal * 0.12; // 12% de tributação
    }

    public void emitirNota() {
        System.out.println("   [Nota Fiscal Nº: " + numeroNota + " | Tributos Calculados: R$ " + valorImpostos + "]");
    }
}