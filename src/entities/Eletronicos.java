package entities;

import entities.enums.Power;
import exceptions.TvException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public abstract class Eletronicos {
    private String marca;
    private Power power;
    private int volume = 0;


    public Eletronicos(){
    }
    @Contract(pure = true)
    public Eletronicos(String marca, @NotNull Power power, int volume) {
        this.marca = marca;
        this.power = power.DESLIGADA;
        this.volume = volume;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void aumentarVolume(){
        if (getVolume() < 100){
            this.volume++;
        } else {
            throw new TvException("Já está no volume máximo!");
        }
    }
    public void diminuirVolume(){
        if (getVolume() > 0){
            this.volume--;
        }else {
            throw new TvException("Já está no volume minimo!");
        }
    }
}
