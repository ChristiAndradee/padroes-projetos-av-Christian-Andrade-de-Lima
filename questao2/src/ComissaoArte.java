public class ComissaoArte implements iRegraComissao {

    private static double percentual = 0.20;

    @Override
    public double calcular(double valorVenda) {
        return valorVenda * percentual;
    }

    @Override
    public String nome() {
        return "Arte 20%";
    }
}
