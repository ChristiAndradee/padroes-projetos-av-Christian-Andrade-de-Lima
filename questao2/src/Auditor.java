import java.util.ArrayList;
import java.util.List;

public class Auditor implements iInteressado {

    private List<String> registros = new ArrayList<String>();

    @Override
    public void atualizar(Lote lote, Lance lance) {
        registros.add(lance.dataHora + " | " + lote.getNome() + " | "
                + lance.autor.nome() + " | R$ " + String.format("%,.2f", lance.valor));
    }

    @Override
    public String nome() {
        return "Auditor";
    }

    public void imprimirRegistros() {
        System.out.println("Registros do auditor (" + registros.size() + " lances aceitos):");
        for (String registro : registros) {
            System.out.println("  " + registro);
        }
    }
}
