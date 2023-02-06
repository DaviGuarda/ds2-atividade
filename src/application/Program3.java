package application;

import entities.Televisao;
import entities.enums.Power;
import exceptions.TvException;

import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Televisao quartoTV = new Televisao("Philips", Power.DESLIGADA,0);
        Televisao salaTV = new Televisao("Philips", Power.DESLIGADA,0);

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

            if (escolherTV == 1 && quartoTV.getPower() == Power.DESLIGADA){
                quartoTV.setPower(Power.valueOf("LIGADA"));
                System.out.println("Televisão "+quartoTV.getPower());
                System.out.println();

            }

            if (escolherTV == 2 && salaTV.getPower() == Power.DESLIGADA){
                salaTV.setPower(Power.valueOf("LIGADA"));
                System.out.println("Televisão "+salaTV.getPower());
                System.out.println();

            }

            if (escolherTV == 1){
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
                        } catch (TvException e) {
                            System.out.println(e.getMessage());
                            System.out.println();
                        }
                    } while (opcaoDeEscolhaAumentarDiminuir != 3);

                    System.out.println();
                    System.out.print("Deseja trocar de canal (1 - sim | 2 - não): ");
                    int opcaoTrocarCanal = entrada.nextInt();
                    if (quartoTV.getPower() == Power.valueOf("LIGADA")) {
                        if (opcaoTrocarCanal == 1) {
                            System.out.print("Digite o canal que deseja alterar: ");
                            int canal = entrada.nextInt();
                            try {
                                quartoTV.pesquisarSeCanalExiste(canal);
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
                        quartoTV.setPower(Power.valueOf("DESLIGADA"));
                        System.out.println("Sua Televisão do quarto está " + quartoTV.getPower());
                        System.out.println();
                    }

                    System.out.println();
                    System.out.println("STATUS ATUALIZADO = " + quartoTV);
            } else if (escolherTV == 2) {
                if (salaTV.getPower() == Power.LIGADA) {
                    System.out.println("Sua Televisão do quarto já está " + salaTV.getPower());
                } else {
                    salaTV.setPower(Power.valueOf("LIGADA"));
                    System.out.println("Televisão " + salaTV.getPower());
                    System.out.println();

                    int opcaoDeEscolhaAumentarDiminuir;
                    do {
                        System.out.print("Deseja aumentar o volume da televisão (1) | diminuir (2) | sair (3): ");
                        opcaoDeEscolhaAumentarDiminuir = entrada.nextInt();
                        try {
                            if (salaTV.getPower() == Power.valueOf("LIGADA")) {
                                if (opcaoDeEscolhaAumentarDiminuir == 1) {
                                    salaTV.aumentarVolume();
                                    System.out.println("Volume aumentado para: " + salaTV.getVolume() + "%");
                                } else if (opcaoDeEscolhaAumentarDiminuir == 2) {
                                    salaTV.diminuirVolume();
                                    System.out.println("Volume diminuido para: " + salaTV.getVolume() + "%");
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
                    if (salaTV.getPower() == Power.valueOf("LIGADA")) {
                        if (opcaoTrocarCanal == 1) {
                            System.out.print("Digite o canal que deseja alterar: ");
                            int canal = entrada.nextInt();
                            try {
                                salaTV.pesquisarSeCanalExiste(canal);
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
                        salaTV.setPower(Power.valueOf("DESLIGADA"));
                        System.out.println("Sua Televisão do quarto está " + salaTV.getPower());
                        System.out.println();
                    } else {
                        System.out.println("Sua televisão ainda está " + salaTV.getPower());
                    }

                    System.out.println();
                    System.out.println("STATUS ATUALIZADO = " + salaTV);
                }
            }

        }while(escolherTV != 3);

        System.out.println();
        System.out.println("STATUS FINAL QUARTO = "+quartoTV);
        System.out.println("STATUS FINAL SALA = "+salaTV);




        entrada.close();
    }
}
