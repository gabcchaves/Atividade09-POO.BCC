package model.conta;

import java.time.LocalDateTime;

// Itens do extrato
public class ItemExtrato {
    private LocalDateTime data;
    private double saldoAnterior;
    private double valor;
    private String historico;
    private char tipo;
    private double saldoPosterior;

    public ItemExtrato(double saldoAnterior, String historico, double valor, char tipo, double saldoPosterior) {
        this.data = java.time.LocalDateTime.now();
        this.saldoAnterior = saldoAnterior;
        this.historico = historico;
        this.valor = valor;
        this.tipo = tipo;
        this.saldoPosterior = saldoPosterior;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
    public LocalDateTime getData() {
        return this.data;
    }
    
    public double getSaldoAnterior() {
        return this.saldoAnterior;      
    }

    public double getValor(){
        return this.valor;
    }

    public String getHistorico(){
      return this.historico;
    }

    public char getTipo() {
    return this.tipo;
    }

    public void setTipo(char tipo) {
      this.tipo = tipo;
    }
  
    //Retorna saldo posterior
    public double getSaldoPosterior() {
      return this.saldoPosterior;
    }
  
    public void setSaldoPosterior(double saldoPosterior) {
      this.saldoPosterior = saldoPosterior;
    }
   
    public void setValor(double valor) {
      this.valor = valor;
    }

    public void setHistorico(String historico) {
      this.historico = historico;
    }
  
}
