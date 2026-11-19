public class EntregaExpressa extends ServicoAdicional {

    private static double custo = 450.00;

    public EntregaExpressa(iFatura fatura) {
        super(fatura);
    }

    @Override
    public String nomeServico() {
        return "Entrega expressa";
    }

    @Override
    public double custoServico() {
        return custo;
    }
}
