public class ArmazenamentoAws implements iArmazenamento {

    public static double custoPorGb = 0.023;

    private static int proximoNumero = 1;

    private String id;

    public ArmazenamentoAws() {
        this.id = "s3://" + proximoNumero;
        proximoNumero++;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String provedor() {
        return "Aws";
    }
}
