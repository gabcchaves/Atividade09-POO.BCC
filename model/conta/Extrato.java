package model.conta;

import java.util.*;

public class Extrato {

    private List<ItemExtrato> extrato;
  
    public Extrato() {
      this.extrato = new ArrayList<ItemExtrato>();
    }
    public List<ItemExtrato> getItemExtrato(){
      return new ArrayList<ItemExtrato>(extrato);
    }
    public void addItemExtrato(ItemExtrato ItemExtrato){
      this.extrato.add(ItemExtrato);
    }
}
