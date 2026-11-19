public class CertificadoAutenticidade extends ServicoAdicional {

    private static double custo = 300.00;

    public CertificadoAutenticidade(iFatura fatura) {
        super(fatura);
    }

    @Override
    public String nomeServico() {
        return "Certificado de autenticidade";
    }

    @Override
    public double custoServico() {
        return custo;
    }
}
