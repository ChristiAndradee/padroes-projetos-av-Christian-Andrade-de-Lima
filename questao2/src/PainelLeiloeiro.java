public class PainelLeiloeiro implements iInteressado {

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.println("    [Painel] " + lote.getNome() + " | maior lance R$ " + String.format("%,.2f", lote.getLanceAtual())
                + " | " + lote.getQuantidadeLances() + " lance(s) recebido(s)");
    }

    @Override
    public String nome() {
        return "Painel do leiloeiro";
    }
}
