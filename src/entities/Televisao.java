package entities;

import entities.enums.Power;
import exceptions.TvException;

public class Televisao extends Eletronicos{

    private int[] canais = {1,3,5,7,11};

    private int canalAtual = 1;

    public Televisao(){
    }
    public Televisao(String marca) {
        super(marca);
    }

    public int[] getCanais() {
        return canais;
    }

    public void setCanais(int[] canais) {
        this.canais = canais;
    }

    public int getCanalAtual() {
        return canalAtual;
    }

    public void setCanalAtual(int canalAtual) {
        this.canalAtual = canalAtual;
    }

    public void mudarCanal(int canalEscolhido){
        int inicio = 0;
        int meio = 0;
        int fim = canais.length - 1;

        while(inicio <= fim) {
            meio = (fim + inicio) / 2;

            if(canais[meio] == canalEscolhido) {
                System.out.println("Trocando de Canal");
                setCanalAtual(canalEscolhido);
                break;
            }

            if(canais[meio] < canalEscolhido) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if(inicio > fim) {
            throw new TvException("Esse canal não existe.");
        }
    }

    @Override
    public String toString(){
        return "Marca: "
                +getMarca()
                +", Power: "
                +getPower()
                +", Volume: "
                +getVolume()
                +", Canal: "
                +getCanalAtual()
                +".";

    }

}
