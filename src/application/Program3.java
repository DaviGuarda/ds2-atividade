package application;

import entities.Televisao;
import entities.enums.Power;
import exceptions.TvException;

import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Televisao quartoTV = new Televisao("Philips");
        Televisao salaTV = new Televisao("LG");

        int escolherTV;
        do {
            if (quartoTV.getPower() == Power.DESLIGADA && salaTV.getPower() == Power.DESLIGADA){
                System.out.print("Deseja ligar a televisão do quarto (1) | sala (2) | sair (3): ");
                escolherTV = entrada.nextInt();
            } else if (quartoTV.getPower() == Power.LIGADA && salaTV.getPower() == Power.LIGADA) {
                System.out.print("Deseja usar a televisão do quarto (1) | sala (2) | sair (3): ");
                escolherTV = entrada.nextInt();
            } else if ((quartoTV.getPower() == Power.DESLIGADA && salaTV.getPower() == Power.LIGADA)){
                System.out.print("Deseja ligar a televisão do quarto (1) | usar televisão da sala (2) | sair (3): ");
                escolherTV = entrada.nextInt();
            }else {
                System.out.print("Deseja ligar a televisão da sala (2) | usar televisão do quarto (1) | sair (3): ");
                escolherTV = entrada.nextInt();
            }

            if (escolherTV == 1){
                mostrarFuncionalidades(entrada, quartoTV);
            }
            if (escolherTV == 2) {
                mostrarFuncionalidades(entrada, salaTV);
            }

        }while(escolherTV != 3);

        System.out.println();
        System.out.println("STATUS FINAL QUARTO = "+quartoTV);
        System.out.println("STATUS FINAL SALA = "+salaTV);




        entrada.close();
    }

    private static void mostrarFuncionalidades(Scanner entrada, Televisao televisao) {
        if (televisao.getPower() == Power.LIGADA) {
            System.out.println("Sua Televisão do quarto já está " + televisao.getPower());
        } else {
            televisao.setPower(Power.valueOf("LIGADA"));
            System.out.println("Televisão " + televisao.getPower());
            System.out.println();
        }
        int opcaoDeEscolhaAumentarDiminuir;
        do {
            System.out.print("Deseja aumentar o volume da televisão (1) | diminuir (2) | sair (3): ");
            opcaoDeEscolhaAumentarDiminuir = entrada.nextInt();
            try {
                if (televisao.getPower() == Power.valueOf("LIGADA")) {
                    if (opcaoDeEscolhaAumentarDiminuir == 1) {
                        televisao.aumentarVolume();
                        System.out.println("Volume aumentado para: " + televisao.getVolume() + "%");
                    } else if (opcaoDeEscolhaAumentarDiminuir == 2) {
                        televisao.diminuirVolume();
                        System.out.println("Volume diminuido para: " + televisao.getVolume() + "%");
                    }
                }
            } catch (TvException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        } while (opcaoDeEscolhaAumentarDiminuir != 3);

        System.out.println();
        System.out.print("Deseja trocar de canal (1 - sim | 2 - não): ");
        int opcaoTrocarCanal = entrada.nextInt();
        if (televisao.getPower() == Power.valueOf("LIGADA")) {
            if (opcaoTrocarCanal == 1) {
                System.out.print("Digite o canal que deseja alterar: ");
                int canal = entrada.nextInt();
                try {
                    televisao.mudarCanal(canal);
                    System.out.println();
                } catch (TvException e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                }
            }
        }

        System.out.println("Deseja desligar a televisão (1) | não (2)");
        int opcaoDesligarLigar = entrada.nextInt();
        if (opcaoDesligarLigar == 1) {
            televisao.setPower(Power.valueOf("DESLIGADA"));
            System.out.println("Sua Televisão do quarto está " + televisao.getPower());
            System.out.println();
        }
        System.out.println();
        System.out.println("STATUS ATUALIZADO = " + televisao);
    }
}