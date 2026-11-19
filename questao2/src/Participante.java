public class Participante implements iInteressado {

    private String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public void darLance(Lote lote, double valor) {
        lote.receberLance(this, valor);
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.println("    [" + nome + "] novo lance no lote " + lote.getNome()
                + ": R$ " + String.format("%,.2f", lance.valor));
    }

    @Override
    public String nome() {
        return nome;
    }
}
