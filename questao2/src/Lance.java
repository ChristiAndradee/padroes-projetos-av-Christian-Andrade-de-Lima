import java.time.LocalDateTime;

public class Lance {

    public iInteressado autor;
    public double valor;
    public LocalDateTime dataHora;

    public Lance(iInteressado autor, double valor) {
        this.autor = autor;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
    }
}
