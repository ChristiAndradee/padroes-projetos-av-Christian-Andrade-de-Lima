import java.util.ArrayList;
import java.util.List;

public class Lote {

    private static double percentualMinimo = 5;

    private String nome;
    private String categoria;
    private double precoInicial;
    private double precoReserva;
    private double lanceAtual;

    private List<Lance> lances = new ArrayList<Lance>();
    private Lance ultimoLance;
    private List<iInteressado> interessados = new ArrayList<iInteressado>();
    private iRegraComissao regraComissao;

    private boolean aberto = true;
    private boolean vendido = false;
    private double comissaoCobrada;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, iRegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    public void acompanhar(iInteressado interessado) {
        interessados.add(interessado);
        System.out.println("  + " + interessado.nome() + " passou a acompanhar " + nome);
    }

    public void deixarDeAcompanhar(iInteressado interessado) {
        interessados.remove(interessado);
        System.out.println("  - " + interessado.nome() + " deixou de acompanhar " + nome);
    }

    private void notificarInteressados(Lance lance) {
        for (iInteressado interessado : interessados) {
            if (interessado != lance.autor) {
                interessado.atualizar(this, lance);
            }
        }
    }

    public void receberLance(iInteressado autor, double valor) {
        double lanceMinimo = lanceAtual + lanceAtual * percentualMinimo / 100;

        if (!aberto) {
            System.out.println("Lance de " + autor.nome() + " RECUSADO: o lote " + nome + " ja foi encerrado.");
        } else if (valor < lanceMinimo) {
            System.out.println("Lance de " + autor.nome() + " de R$ " + String.format("%,.2f", valor)
                    + " RECUSADO: precisa ser pelo menos 5% maior que R$ " + String.format("%,.2f", lanceAtual)
                    + " (minimo R$ " + String.format("%,.2f", lanceMinimo) + ").");
        } else {
            ultimoLance = new Lance(autor, valor);
            lances.add(ultimoLance);
            lanceAtual = valor;
            System.out.println("Lance de " + autor.nome() + " de R$ " + String.format("%,.2f", valor) + " ACEITO no lote " + nome + ".");

            notificarInteressados(ultimoLance);
        }
    }

    public void setRegraComissao(iRegraComissao regraComissao) {
        System.out.println("Campanha: lote " + nome + " (" + categoria + ") passa a usar a regra "
                + regraComissao.nome() + " no lugar de " + this.regraComissao.nome() + ".");
        this.regraComissao = regraComissao;
    }

    public void encerrar() {
        aberto = false;

        if (ultimoLance != null && lanceAtual >= precoReserva) {
            vendido = true;
            comissaoCobrada = regraComissao.calcular(lanceAtual);
            System.out.println("Lote " + nome + " ENCERRADO: vendido para " + ultimoLance.autor.nome()
                    + " por R$ " + String.format("%,.2f", lanceAtual) + ".");
        } else {
            System.out.println("Lote " + nome + " ENCERRADO: NAO VENDIDO (maior lance R$ " + String.format("%,.2f", lanceAtual)
                    + ", reserva R$ " + String.format("%,.2f", precoReserva) + ").");
        }
    }

    public void imprimirAcertoVendedor() {
        System.out.println("Acerto do vendedor - " + nome + " (" + categoria + ")");

        if (vendido) {
            System.out.println("  Valor de venda : R$ " + String.format("%,.2f", lanceAtual));
            System.out.println("  Comissao       : R$ " + String.format("%,.2f", comissaoCobrada) + " (" + regraComissao.nome() + ")");
            System.out.println("  Valor liquido  : R$ " + String.format("%,.2f", lanceAtual - comissaoCobrada));
        } else {
            System.out.println("  Lote nao vendido: nada a repassar.");
        }
    }

    public String getNome() {
        return nome;
    }

    public double getLanceAtual() {
        return lanceAtual;
    }

    public int getQuantidadeLances() {
        return lances.size();
    }
}
