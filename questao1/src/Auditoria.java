import java.time.LocalDateTime;
import java.util.List;
import java.util.Vector;

public class Auditoria {

    private static Auditoria instancia = new Auditoria();

    private List<String> registros = new Vector<String>();

    private Auditoria() {
    }

    public static Auditoria getInstance() {
        return instancia;
    }

    public void registrar(String nomeAmbiente, String provedor, String resultado) {
        registros.add(LocalDateTime.now() + " | " + nomeAmbiente + " | " + provedor + " | " + resultado);
    }

    public void imprimirHistorico() {
        System.out.println("Historico de auditoria (" + registros.size() + " registros):");
        for (int i = 0; i < registros.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + registros.get(i));
        }
    }
}
