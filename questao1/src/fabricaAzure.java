public class fabricaAzure implements iFabricaNuvem {

    @Override
    public String nomeProvedor() {
        return "Azure";
    }

    @Override
    public iMaquinaVirtual criarMaquinaVirtual() {
        return new MaquinaVirtualAzure();
    }

    @Override
    public iArmazenamento criarArmazenamento() {
        return new ArmazenamentoAzure();
    }

    @Override
    public iFila criarFila() {
        return new FilaAzure();
    }

    @Override
    public double custoMaquinaPorHora() {
        return MaquinaVirtualAzure.custoPorHora;
    }

    @Override
    public double custoArmazenamentoPorGb() {
        return ArmazenamentoAzure.custoPorGb;
    }

    @Override
    public double custoFilaMensal() {
        return FilaAzure.custoFixoMensal;
    }
}
