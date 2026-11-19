public class MaquinaVirtualAzure implements iMaquinaVirtual {

    public static double custoPorHora = 0.12;

    private static int proximoNumero = 1;

    private String id;

    public MaquinaVirtualAzure() {
        this.id = "vm-" + proximoNumero;
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
