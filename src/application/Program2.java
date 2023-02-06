package application;

import entities.Televisao;
import entities.enums.Power;
import exceptions.TvException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        List<Televisao> televisoes = new ArrayList<>();
        int opcaoTV;
        do{
            System.out.print("Deseja adicionar uma televisão (1 - sim | 2 não): ");
            opcaoTV = entrada.nextInt();
            System.out.println();
            if (opcaoTV == 1){
                System.out.print("Digite a marca da televisão: ");
                entrada.nextLine();
                String marcaTV = entrada.nextLine();
                Televisao televisao = new Televisao(marcaTV, Power.DESLIGADA, 0);
                televisoes.add(televisao);

                System.out.println("STATUS = "+televisao);
                System.out.println();

                System.out.print("Deseja ligar a televisão (1 - sim / 2 - não): ");
                int op = entrada.nextInt();
                if (op == 1){
                    televisao.setPower(Power.valueOf("LIGADA"));
                    System.out.println("Sua Televisão está "+televisao.getPower());
                    System.out.println();

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
                        }catch (TvException e){
                            System.out.println(e.getMessage());
                            System.out.println();
                        }
                    }while (opcaoDeEscolhaAumentarDiminuir != 3);

                    System.out.println();
                    System.out.print("Deseja trocar de canal (1 - sim | 2 - não): ");
                    int opcaoTrocarCanal = entrada.nextInt();
                    if (televisao.getPower() == Power.valueOf("LIGADA")){
                        if(opcaoTrocarCanal == 1){
                            System.out.print("Digite o canal que deseja alterar: ");
                            int canal = entrada.nextInt();
                            try{
                                televisao.pesquisarSeCanalExiste(canal);
                                System.out.println();
                            }catch (TvException e){
                                System.out.println(e.getMessage());
                                System.out.println();
                            }
                        }
                    }

                    System.out.println("STATUS ATUALIZADO = "+televisao);
                    System.out.println();
                }else {
                    System.out.println();
                    System.out.println("Sua televisão permanecerá desligada.");
                    System.out.println();
                }
            }
        }while(opcaoTV != 2);

        for(Televisao televisaoImp : televisoes){
            System.out.println("LISTA DAS TV'S / STATUS = "+televisaoImp);
        }

        entrada.close();
    }
}
