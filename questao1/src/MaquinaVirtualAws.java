public class MaquinaVirtualAws implements iMaquinaVirtual {

    public static double custoPorHora = 0.10;

    private static int proximoNumero = 1;

    private String id;

    public MaquinaVirtualAws() {
        this.id = "i-" + proximoNumero;
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
