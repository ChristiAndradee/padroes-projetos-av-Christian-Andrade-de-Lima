public class FaturaComprador implements iFatura {

    private String nomeLote;
    private double valorVenda;

    public FaturaComprador(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String descricao() {
        return "Lote: " + nomeLote + "\n"
             + "  Valor de venda: R$ " + String.format("%,.2f", valorVenda);
    }

    @Override
    public double total() {
        return valorVenda;
    }

    @Override
    public double valorVenda() {
        return valorVenda;
    }
}
