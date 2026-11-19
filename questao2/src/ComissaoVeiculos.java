public class ComissaoVeiculos implements iRegraComissao {

    private static double percentual = 0.08;
    private static double limite = 5_000.00;

    @Override
    public double calcular(double valorVenda) {
        return Math.min(valorVenda * percentual, limite);
    }

    @Override
    public String nome() {
        return "Veiculos 8% ate R$ 5.000";
    }
}
