public class FilaAws implements iFila {

    public static double custoFixoMensal = 0.40;

    private static int proximoNumero = 1;

    private String id;

    public FilaAws() {
        this.id = "sqs-" + proximoNumero;
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
