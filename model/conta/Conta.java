package model.conta;

import model.cliente.Cliente;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public abstract class Conta {

    private DecimalFormat df = new DecimalFormat("0.00");
    
    private static int prox_num = 1;
    
    private String numero;
    private Cliente titular;
    private double saldo;
    private List<ArrayList<String>> extrato = new ArrayList<ArrayList<String>>();
  
    public Conta(Cliente titular) {
        this.titular =  titular;
        this.numero = String.valueOf(Conta.prox_num);
        this.saldo = 0;
        
        // Incrementar o número para próxima conta
        prox_num++;
    }
    
    public void depositar(double valor) {
        this.saldo = this.saldo + valor;

        // Registro da operação no extrato
        this.setExtrato(LocalDate.now(), "Depósito", valor, "C");
    }
    
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= this.getDisponivelParaSaque()) {
            this.saldo -= valor;

            // Registro da operação no extrato
            this.setExtrato(LocalDate.now(), "Saque", valor, "D");
        } else {
            throw new SaldoInsuficienteException(this);
        }
    }
    
    public void transferir(Conta destino, double valor) throws SaldoInsuficienteException {
        this.sacar(valor);
        destino.depositar(valor);

        // Registro da operação nos extratos de ambas as contas
        this.setExtrato(LocalDate.now(), "Transferido para a conta #" + destino.getNumero(), valor, "D");
        destino.setExtrato(LocalDate.now(), "Recebido da conta #" + this.getNumero(), valor, "C");
    }
    
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public Cliente getTitular() {
        return this.titular;
    }
    
    public String getNumero() {
        return this.numero;
    }
    
    public double getSaldo() {
        return this.saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getDisponivelParaSaque() {
        return this.saldo;
    }
  
    public abstract String getTipo();

    public List<ArrayList<String>> getExtrato() {
		return this.extrato;
    }

    public void setExtrato(LocalDate data, String descricao, double valor, String tipoDeTransacao) {
    // Cria um campo do extrato
    ArrayList<String> campo = new ArrayList<String>();

		campo.add(data.format(DateTimeFormatter.ofPattern("dd/MM/yy"))); // Data formatada
		campo.add(descricao);
		campo.add(df.format(valor));
		campo.add(tipoDeTransacao);

		// Registra o campo no extrato
		this.extrato.add(campo);
    }
    
    public String toString() {
        return "Número...: " + this.getNumero() +
               "\nTitular..: " + this.getTitular() +
               "\nSaldo....: " + this.getSaldo();
    }
}
