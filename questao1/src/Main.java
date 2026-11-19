public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread provisionamentoAws = new Thread(() -> {
            new MontadorAmbiente(new fabricaAws()).provisionar(new SolicitacaoAmbiente("loja-producao", 2, 100));
        });

        Thread provisionamentoAzure = new Thread(() -> {
            new MontadorAmbiente(new fabricaAzure()).provisionar(new SolicitacaoAmbiente("erp-homologacao", 2, 200));
        });

        provisionamentoAws.start();
        provisionamentoAzure.start();

        provisionamentoAws.join();
        provisionamentoAzure.join();

        new MontadorAmbiente(new fabricaAws()).provisionar(new SolicitacaoAmbiente("site-institucional", 1, 50));

        new MontadorAmbiente(new fabricaAzure()).provisionar(new SolicitacaoAmbiente("data-lake", 5, 1000));

        System.out.println();
        Auditoria.getInstance().imprimirHistorico();
    }
}
