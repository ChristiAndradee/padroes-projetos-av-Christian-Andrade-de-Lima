public class EmbalagemEspecial extends ServicoAdicional {

    private static double custo = 180.00;

    public EmbalagemEspecial(iFatura fatura) {
        super(fatura);
    }

    @Override
    public String nomeServico() {
        return "Embalagem especial";
    }

    @Override
    public double custoServico() {
        return custo;
    }
}
