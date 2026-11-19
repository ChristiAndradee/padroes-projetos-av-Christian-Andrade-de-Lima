import java.util.ArrayList;
import java.util.List;

public class MontadorAmbiente {

    private static int horasPorMes = 730;

    private iFabricaNuvem fabrica;

    public MontadorAmbiente(iFabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public Ambiente provisionar(SolicitacaoAmbiente solicitacao) {

        double custoEstimado = calcularCustoEstimado(solicitacao);
        double orcamento = ConfiguracaoSistema.getInstance().getOrcamentoMaximo();

        if (custoEstimado > orcamento) {
            String motivo = "custo estimado R$ " + String.format("%,.2f", custoEstimado)
                          + " acima do orcamento de R$ " + String.format("%,.2f", orcamento);
            System.out.println("Provisionamento de " + solicitacao.nomeAmbiente + " (" + fabrica.nomeProvedor()
                    + ") RECUSADO: " + motivo);
            Auditoria.getInstance().registrar(solicitacao.nomeAmbiente, fabrica.nomeProvedor(), "RECUSADO - " + motivo);
            return null;
        }

        List<iMaquinaVirtual> maquinas = new ArrayList<iMaquinaVirtual>();
        for (int i = 0; i < solicitacao.quantidadeMaquinas; i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        iArmazenamento armazenamento = fabrica.criarArmazenamento();
        iFila fila = fabrica.criarFila();

        Ambiente ambiente = new Ambiente(solicitacao.nomeAmbiente, maquinas, armazenamento, fila, custoEstimado);

        System.out.println(ambiente.resumo());
        Auditoria.getInstance().registrar(solicitacao.nomeAmbiente, fabrica.nomeProvedor(), "ACEITO");
        return ambiente;
    }

    private double calcularCustoEstimado(SolicitacaoAmbiente solicitacao) {
        return solicitacao.quantidadeMaquinas * fabrica.custoMaquinaPorHora() * horasPorMes
             + solicitacao.gbArmazenamento * fabrica.custoArmazenamentoPorGb()
             + fabrica.custoFilaMensal();
    }
}
