public class FilaAzure implements iFila {

    public static double custoFixoMensal = 0.50;

    private static int proximoNumero = 1;

    private String id;

    public FilaAzure() {
        this.id = "sb-" + proximoNumero;
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
