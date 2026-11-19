public class ComissaoImoveis implements iRegraComissao {

    private static double percentual = 0.03;
    private static double valorFixo = 1_500.00;

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * percentual + valorFixo;
    }

    @Override
    public String nome() {
        return "Imoveis 3% + R$ 1.500";
    }
}
