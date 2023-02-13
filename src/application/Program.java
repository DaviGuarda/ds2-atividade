package application;

import entities.Televisao;
import entities.enums.Power;
import exceptions.TvException;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Televisao quartoTV = new Televisao("Philips");

        System.out.println("STATUS = "+quartoTV);
        System.out.println();

        System.out.print("Deseja ligar a televisão do Quarto (1 - sim / 2 - não): ");
        int op = entrada.nextInt();
        if (op == 1){
            quartoTV.setPower(Power.valueOf("LIGADA"));
            System.out.println("Sua Televisão está "+quartoTV.getPower());
            System.out.println();

            int opcaoDeEscolhaAumentarDiminuir;
            do {
                System.out.print("Deseja aumentar o volume da televisão (1) | diminuir (2) | sair (3): ");
                opcaoDeEscolhaAumentarDiminuir = entrada.nextInt();
                try {
                    if (quartoTV.getPower() == Power.valueOf("LIGADA")) {
                        if (opcaoDeEscolhaAumentarDiminuir == 1) {
                            quartoTV.aumentarVolume();
                            System.out.println("Volume aumentado para: " + quartoTV.getVolume() + "%");
                        } else if (opcaoDeEscolhaAumentarDiminuir == 2) {
                            quartoTV.diminuirVolume();
                            System.out.println("Volume diminuido para: " + quartoTV.getVolume() + "%");
                        }
                    }
                }catch (TvException e){
                    System.out.println(e.getMessage());
                    System.out.println();
                }
            }while (opcaoDeEscolhaAumentarDiminuir != 3);

            System.out.println();
            System.out.print("Deseja trocar de canal (1 - sim | 2 - não): ");
            int opcaoTrocarCanal = entrada.nextInt();
            if (quartoTV.getPower() == Power.valueOf("LIGADA")){
                if(opcaoTrocarCanal == 1){
                    System.out.print("Digite o canal que deseja alterar: ");
                    int canal = entrada.nextInt();
                    try{
                        quartoTV.mudarCanal(canal);
                        System.out.println();
                    }catch (TvException e){
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                }
            }

            System.out.println("STATUS ATUALIZADO = "+quartoTV);
        }else {
            System.out.println();
            System.out.println("Sua televisão do quarto continua desligada.");
        }

        entrada.close();
    }
}
