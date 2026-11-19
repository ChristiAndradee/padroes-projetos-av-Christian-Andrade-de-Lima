public class ConfiguracaoSistema {

    private static ConfiguracaoSistema instancia = new ConfiguracaoSistema();

    private String regiaoPadrao;
    private double orcamentoMaximo;

    private ConfiguracaoSistema() {
        this.regiaoPadrao = "brasil-sul";
        this.orcamentoMaximo = 200.00;

        System.out.println("[Config] carregada: regiao=" + regiaoPadrao
                + ", orcamento=R$ " + String.format("%,.2f", orcamentoMaximo) + " (esta mensagem aparece uma unica vez)");
    }

    public static ConfiguracaoSistema getInstance() {
        return instancia;
    }

    public String getRegiaoPadrao() {
        return regiaoPadrao;
    }

    public double getOrcamentoMaximo() {
        return orcamentoMaximo;
    }
}
