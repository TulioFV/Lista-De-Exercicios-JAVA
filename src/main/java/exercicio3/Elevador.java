package exercicio3;
/*
3. Crie uma classe denominada Elevador para armazenar as informações de um elevador
dentro de um prédio. A classe deve armazenar o andar atual (térreo = 0), total de andares
no prédio (desconsiderando o térreo), capacidade do elevador e quantas pessoas estão
presentes nele. A classe deve também disponibilizar os seguintes métodos:

Inicializa : que deve receber como parâmetros a capacidade do elevador e o total de
andares no prédio (os elevadores sempre começam no térreo e vazio);

Entra : para acrescentar uma pessoa no elevador (só deve acrescentar se ainda houver
espaço);
Sai : para remover uma pessoa do elevador (só deve remover se houver alguém
dentro dele);
Sobe : para subir um andar (não deve subir se já estiver no último andar);
Desce : para descer um andar (não deve descer se já estiver no térreo);
Encapsular todos os atributos da classe (criar os métodos set e get).
 */

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Elevador {


    private int terreo,totalAndares,totalPessoasNoElevador,
            quantidadeDePessoas,andar,andaratual,totalPredios = 0;
    private  int capacidadeElevador = 8;
    private String predio,resultado = null;

    Scanner ler = new Scanner(System.in);
    List<Elevador> predios = new ArrayList<>();


    public void criaPredios(){

        System.out.println("Quantos predios sao?");
        totalPredios = ler.nextInt();
        totalPredios -= 1;

           for (int i = 0; i <= totalPredios; i++) {

               int v = i;

               String str = String.valueOf(v);

               Elevador el = new Elevador();
               numeroDeAndares();
               el.setTotalAndares(totalAndares);
               el.setAndar(terreo);
               el.setQuantidadeDePessoas(0);
               el.setTotalPessoasNoElevador(0);
               el.setCapacidadeElevador(capacidadeElevador);
               el.setTotalPredios(totalPredios);
               el.setPredio("predio" + str);

               predios.add(el);
           }

            System.out.println("O total de predios e: " + (totalPredios +1) + "\n");
    }

    public String escolhePredio(){


        System.out.println("A lista de predios e:");
        predios.forEach(el-> System.out.println(el.getPredio()));

        System.out.println("Escolha o predio?");
        String index = ler.next();

        for (Elevador p: predios) {
            if(p.getPredio().equals(index)) {
                System.out.println("Predio selecionado e: " + p.getPredio());

                resultado = index;
            }
        }
        return resultado;
    }

    public void entra(){
        escolhePredio();
        pessoasEntrandoOuSaindoDoElevador();

        for (Elevador p: predios) {
            if(p.getPredio().equals(resultado)) {
                System.out.println("Predio selecionado e: " + p.getPredio());

                totalPessoasNoElevador = p.getTotalPessoasNoElevador();


                if((totalPessoasNoElevador <= capacidadeElevador)){
                    totalPessoasNoElevador += quantidadeDePessoas;
                    if(totalPessoasNoElevador <= capacidadeElevador){
                        System.out.println("Entrada de psessoas com sucesso.");
                        totalDePessoasNoElevador();
                        p.setTotalPessoasNoElevador(totalPessoasNoElevador);
                    } else{
                        totalPessoasNoElevador -= quantidadeDePessoas;
                        System.out.println("Entrada de psessoas sem sucesso.");
                        mostraQuantidadeDePessoasNoElevador();
                        entra();
                    }
                }else{
                    System.out.println("Não é possivel adicionar esse numero de pessoas, favor verificar a quantidade.");
                    mostraQuantidadeDePessoasNoElevador();
                    entra();
                }

            }
        }


    }

    public void saiDoElevador() {
        escolhePredio();
        pessoasEntrandoOuSaindoDoElevador();

        for (Elevador p : predios) {
            if (p.getPredio().equals(resultado)) {
                System.out.println("Predio selecionado e: " + p.getPredio());

                totalPessoasNoElevador = p.getTotalPessoasNoElevador();


                if ((totalPessoasNoElevador > 0) && (totalPessoasNoElevador >= quantidadeDePessoas)) {

                    if((totalPessoasNoElevador -= quantidadeDePessoas) > 0) {
                        System.out.println("Saida de psessoas com sucesso.");
                        totalDePessoasNoElevador();
                        p.setTotalPessoasNoElevador(totalPessoasNoElevador);
                    }else{
                        totalPessoasNoElevador += quantidadeDePessoas;
                        System.out.println("Saida de psessoas sem sucesso.");
                        totalDePessoasNoElevador();
                        saiDoElevador();
                    }
                }else{
                    System.out.println("Não é possivel remover esse numero de pessoas, elevador com menos pessoas que o selecionado.");
                    mostraQuantidadeDePessoasNoElevador();
                    saiDoElevador();

                }
            }
        }
    }

    public int qualAndar(){
        System.out.println("Numero do andar desejado?");
        andar = ler.nextInt();

        return andar;
    }

    public void sobeDesce(){

        escolhePredio();

        for (Elevador p : predios) {
            if (p.getPredio().equals(resultado)) {
                qualAndar();

                int andaratual = p.getAndar();
                totalAndares = p.getTotalAndares();

                if(andaratual != andar) {
                    if ((andar <= totalAndares) && (andar >= terreo)) {

                        p.setAndar(andar);
                        System.out.println("O novo andar e " + andar);
                        if(andar == totalAndares){
                            System.out.println("Voce esta no ultimo andar.");
                        }
                    } else {
                        System.out.println("Andar nao existe.");
                        sobeDesce();
                    }
                }else{
                    System.out.println("Voce ja esta nesse andar, favor escolher outro.");
                    sobeDesce();
                }
            }
        }
    }


    public void mostraQuantidadeDePessoasNoElevador(){
        System.out.println("A capacidade de pessoas no elevador e "
                + capacidadeElevador + " pessoas.Ha "
                + (capacidadeElevador - totalPessoasNoElevador) + " vagas no elevador.");
    }

    public void totalDePessoasNoElevador(){
        System.out.println("O total de pessoas nesse elevador e "
                + totalPessoasNoElevador + " pessoas.");
    }

    public int pessoasEntrandoOuSaindoDoElevador(){
        System.out.println("Quantas pessoas serao inseridas/removidas?");
        quantidadeDePessoas = ler.nextInt();

        return quantidadeDePessoas;
    }


    public int numeroDeAndares(){
        System.out.println("Quantos andares tem o predio?");
        totalAndares = ler.nextInt();

        return totalAndares;
    }





    public int getTerreo() {
        return terreo;
    }

    public void setTerreo(int terreo) {
        this.terreo = terreo;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }

    public int getTotalPessoasNoElevador() {
        return totalPessoasNoElevador;
    }

    public void setTotalPessoasNoElevador(int totalPessoasNoElevador) {
        this.totalPessoasNoElevador = totalPessoasNoElevador;
    }

    public int getCapacidadeElevador() {
        return capacidadeElevador;
    }

    public void setCapacidadeElevador(int capacidadeElevador) {
        this.capacidadeElevador = capacidadeElevador;
    }

    public int getQuantidadeDePessoas() {
        return quantidadeDePessoas;
    }

    public void setQuantidadeDePessoas(int quantidadeDePessoas) {
        this.quantidadeDePessoas = quantidadeDePessoas;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getAndaratual() {
        return andaratual;
    }

    public void setAndaratual(int andaratual) {
        this.andaratual = andaratual;
    }

    public int getTotalPredios() {
        return totalPredios;
    }

    public void setTotalPredios(int totalPredios) {
        this.totalPredios = totalPredios;
    }

    public void setPredios(List<Elevador> predios) {
        this.predios = predios;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }
}
