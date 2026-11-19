public interface iFabricaNuvem {

    String nomeProvedor();

    iMaquinaVirtual criarMaquinaVirtual();

    iArmazenamento criarArmazenamento();

    iFila criarFila();

    double custoMaquinaPorHora();

    double custoArmazenamentoPorGb();

    double custoFilaMensal();

}
