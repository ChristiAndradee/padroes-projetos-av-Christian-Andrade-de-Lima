public class fabricaAws implements iFabricaNuvem {

    @Override
    public String nomeProvedor() {
        return "Aws";
    }

    @Override
    public iMaquinaVirtual criarMaquinaVirtual() {
        return new MaquinaVirtualAws();
    }

    @Override
    public iArmazenamento criarArmazenamento() {
        return new ArmazenamentoAws();
    }

    @Override
    public iFila criarFila() {
        return new FilaAws();
    }

    @Override
    public double custoMaquinaPorHora() {
        return MaquinaVirtualAws.custoPorHora;
    }

    @Override
    public double custoArmazenamentoPorGb() {
        return ArmazenamentoAws.custoPorGb;
    }

    @Override
    public double custoFilaMensal() {
        return FilaAws.custoFixoMensal;
    }
}
