public class SeguroTransporte extends ServicoAdicional {

    private static double percentual = 0.015;

    public SeguroTransporte(iFatura fatura) {
        super(fatura);
    }

    @Override
    public String nomeServico() {
        return "Seguro de transporte (1,5%)";
    }

    @Override
    public double custoServico() {
        return valorVenda() * percentual;
    }
}
