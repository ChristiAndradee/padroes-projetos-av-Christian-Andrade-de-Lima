public class ArmazenamentoAzure implements iArmazenamento {

    public static double custoPorGb = 0.02;

    private static int proximoNumero = 1;

    private String id;

    public ArmazenamentoAzure() {
        this.id = "blob://" + proximoNumero;
        proximoNumero++;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String provedor() {
        return "Azure";
    }
}
