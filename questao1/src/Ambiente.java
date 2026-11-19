import java.util.List;
public class Ambiente {

    private String nome;
    private String provedor;
    private String regiao;
    private List<iMaquinaVirtual> maquinas;
    private iArmazenamento armazenamento;
    private iFila fila;
    private double custoMensalEstimado;

    public Ambiente(String nome, List<iMaquinaVirtual> maquinas, iArmazenamento armazenamento, iFila fila,
                    double custoMensalEstimado) {

        String provedorDoAmbiente = fila.provedor();
        if (!armazenamento.provedor().equals(provedorDoAmbiente)) {
            throw new IllegalArgumentException("Armazenamento de outro provedor no ambiente " + nome);
        }
        for (iMaquinaVirtual maquina : maquinas) {
            if (!maquina.provedor().equals(provedorDoAmbiente)) {
                throw new IllegalArgumentException("Maquina de outro provedor no ambiente " + nome);
            }
        }

        this.nome = nome;
        this.provedor = provedorDoAmbiente;
        this.regiao = ConfiguracaoSistema.getInstance().getRegiaoPadrao();
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensalEstimado = custoMensalEstimado;
    }

    public String resumo() {
        String idsMaquinas = "";
        for (iMaquinaVirtual maquina : maquinas) {
            if (!idsMaquinas.isEmpty()) {
                idsMaquinas = idsMaquinas + ", ";
            }
            idsMaquinas = idsMaquinas + maquina.getId();
        }

        return "------------------------------------------------\n"
             + "Ambiente      : " + nome + "\n"
             + "Provedor      : " + provedor + "\n"
             + "Regiao        : " + regiao + "\n"
             + "Maquinas      : " + idsMaquinas + "\n"
             + "Armazenamento : " + armazenamento.getId() + "\n"
             + "Fila          : " + fila.getId() + "\n"
             + "Custo mensal  : R$ " + String.format("%,.2f", custoMensalEstimado) + "\n"
             + "------------------------------------------------";
    }
}
