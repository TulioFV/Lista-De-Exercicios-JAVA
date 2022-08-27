package exercicio4;

import java.util.Scanner;

public class ControleRemoto {



    public ControleRemoto(){
        Televisao tel = new Televisao();
        Scanner ler = new Scanner(System.in);

        String resultado = null;

        System.out.println("Canal: Seleciona 1"+"\n"+"Volume: Seleciona 2"+"\n"
                +"Colocar o numero do canal: Seleciona 3");
        int seleciona = ler.nextInt();

        if(seleciona != 3) {
            System.out.println("Volume/Canal:" + "\n" + "Aumentar: + " + "\n" + "Diminuir: - ");
            resultado = ler.next();
        }
        if((seleciona == 1) && (resultado.equals("+"))){
            tel.setCanal(1);
        }else if((seleciona == 1) && (resultado.equals("-"))){
            tel.setCanal(2);
        }
        if((seleciona == 2) && (resultado.equals("+"))){
            tel.setVolume(3);
        }else if((seleciona == 2) && (resultado.equals("-"))){
            tel.setVolume(4);
        }else if(seleciona == 3){
            System.out.println("Qual o canal?");
            int canalAlt = ler.nextInt();
            tel.setCanal(canalAlt);
        }
    }
}
