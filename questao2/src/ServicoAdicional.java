public abstract class ServicoAdicional implements iFatura {

    private iFatura fatura;

    public ServicoAdicional(iFatura fatura) {
        this.fatura = fatura;
    }

    public abstract String nomeServico();

    public abstract double custoServico();

    @Override
    public String descricao() {
        return fatura.descricao() + "\n"
             + "  + " + nomeServico() + ": R$ " + String.format("%,.2f", custoServico());
    }

    @Override
    public double total() {
        return fatura.total() + custoServico();
    }

    @Override
    public double valorVenda() {
        return fatura.valorVenda();
    }
}
