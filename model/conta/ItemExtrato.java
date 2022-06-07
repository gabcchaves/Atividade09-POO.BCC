import java.time.LocalDate;

// Itens do extrato
public class ItemExtrato {
    private LocalDate data;
    private double saldoAnterior;
    
    public ItemExtrato(double saldoAnterior) {
        this.saldoAnterior = novoSaldoAnterior;
    }
    
    // Definir data do item
    public void setData(LocalDate data) {
        this.data = data;
    }
    
    // Retornar data do item
    public LocalDate getData() {
        return this.data;
    }
    
    // Retornar saldo anterior
    public double getSaldoAnterior() {
        return this.saldoAnterior;
    }
}
