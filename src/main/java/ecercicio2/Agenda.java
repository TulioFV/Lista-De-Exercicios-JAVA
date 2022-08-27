package ecercicio2;
/*
2. Crie uma classe Agenda que pode armazenar 10 pessoas e que seja capaz de realizar as
seguintes operações:
void armazenaPessoa(String nome, int idade, float altura);
void removePessoa(String nome);
int buscaPessoa(String nome); // informa em que posição da agenda está a pessoa
void imprimeAgenda(); // imprime os dados de todas as pessoas da agenda
void imprimePessoa(int index); // imprime os dados da pessoa que está na posição “i” da
agenda.

*/

import exercicio1.Pessoas;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Agenda {

    private int pergunta;

    List<Pessoas> pes = new ArrayList<Pessoas>();
    Scanner ler = new Scanner(System.in);

   public void armazenaPessoa() throws ParseException {


        System.out.println("Quantas pessoas serao inseridas?");
        pergunta = ler.nextInt();
        pergunta-=1;


            for (int i = 0; i <= pergunta; i++) {
                Pessoas p = new Pessoas();
                p.getNome();
                p.getIdade();
                p.getDataConv();
                p.getAltura();
                pes.add(p);
        }
    }

    public void removePessoas(){

        System.out.println("Informe o nome a ser removido: ");
        String nome = ler.next();


        if (pes.removeIf(p -> p.getNome().equals(nome))) {
            MostraDadosPessoas();
        }else{
            System.out.println("Lista vazia");
        }
   }

    public void MostraDadosPessoas(){
        pes.forEach(p -> System.out.println("A lista e composta por:" + "\n" + "Nome: " + p.getNome() + " Idade: " + " Nascimento: " + p.getDataConv() + " Altura:  " + p.getAltura()));
    }

    public void MostraDadosPorIndice(){

        System.out.println("Informe o indice que deseja consultar: ");
        int indice = ler.nextInt();

        System.out.println("Nome:  " + pes.get(indice).getNome() + " Idade:  " + pes.get(indice).getIdade()+ " Altura: " + pes.get(indice).getAltura() +" Aniversário: " + pes.get(indice).getDataConv());


    }

}
