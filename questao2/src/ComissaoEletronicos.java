public class ComissaoEletronicos implements iRegraComissao {

    private static double percentual = 0.12;
    private static double minimo = 50.00;

    @Override
    public double calcular(double valorVenda) {
        return Math.max(valorVenda * percentual, minimo);
    }

    @Override
    public String nome() {
        return "Eletronicos 12% min R$ 50";
    }
}
