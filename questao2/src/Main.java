public class Main {

    public static void main(String[] args) {

        Participante Haboski = new Participante("Haboski");
        Participante Valinn = new Participante("Valinn");
        Participante Enache = new Participante("Enache");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        Lote quadro = new Lote("A Noite Estrelada", "Arte", 10000.00, 15000.00, new ComissaoArte());
        Lote notebook = new Lote("Alienware Área 51 16 Ultra", "Eletronicos", 3_000.00, 8_000.00, new ComissaoEletronicos());

        System.out.println("Acompanhamentos:");
        quadro.acompanhar(Haboski);
        quadro.acompanhar(Valinn);
        quadro.acompanhar(Enache);
        quadro.acompanhar(painel);
        quadro.acompanhar(auditor);
        notebook.acompanhar(Valinn);
        notebook.acompanhar(Enache);
        notebook.acompanhar(painel);
        notebook.acompanhar(auditor);

        System.out.println("\n=== Lances: " + quadro.getNome() + " ===");
        Haboski.darLance(quadro, 10_500.00);
        Valinn.darLance(quadro, 10_800.00);
        Valinn.darLance(quadro, 12_000.00);

        System.out.println();
        quadro.deixarDeAcompanhar(Enache);
        Haboski.darLance(quadro, 16_000.00);

        System.out.println("\n=== Lances: " + notebook.getNome() + " ===");
        Enache.darLance(notebook, 3_200.00);
        Valinn.darLance(notebook, 3_300.00);
        Valinn.darLance(notebook, 4_000.00);

        System.out.println();
        quadro.setRegraComissao(new ComissaoEletronicos());

        System.out.println("\n=== Encerramentos ===");
        quadro.encerrar();
        notebook.encerrar();
        Enache.darLance(notebook, 9_000.00);

        System.out.println();
        quadro.imprimirAcertoVendedor();
        notebook.imprimirAcertoVendedor();

        System.out.println("\n=== Fatura do comprador ===");
        iFatura fatura = new FaturaComprador(quadro.getNome(), quadro.getLanceAtual());

        System.out.println("Antes dos servicos adicionais:");
        imprimirFatura(fatura);

        fatura = new SeguroTransporte(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EntregaExpressa(fatura);

        System.out.println("\nCom os servicos adicionais:");
        imprimirFatura(fatura);

        System.out.println();
        auditor.imprimirRegistros();
    }

    private static void imprimirFatura(iFatura fatura) {
        System.out.println(fatura.descricao());
        System.out.println("  TOTAL A PAGAR: R$ " + String.format("%,.2f", fatura.total()));
    }
}
