package exercicio1;
/*
Crie uma classe para representar uma pessoa, com os atributos privados de nome, data de
nascimento e altura. Crie os métodos públicos necessários para sets e gets e também um
método para imprimir todos dados de uma pessoa. Crie um método para calcular a idade
da pessoa.
*/


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Pessoas {

    private String nome,dataAniversario;
    private int idade;
    private float altura;
    private Date dataConv,atual;

    public Pessoas() throws ParseException {

        Scanner ler = new Scanner(System.in);
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Informe seu nome: ");
        nome = ler.nextLine();
        setNome(nome);

        System.out.println("Informe a data do seu nascimento: ");
        dataAniversario = ler.next();
        dataConv = sdf.parse(dataAniversario);
        setDataAniversario(dataAniversario);

        System.out.println("Informe sua idade: ");
        idade = ler.nextInt();
        setIdade(idade);

        System.out.println("Informe sua altura: ");
        altura = ler.nextFloat();
        setAltura(altura);

    }

    public void CalculaIdadePessoas(){
        atual = new Date();
        int c1 = atual.getYear();
        int c2 = dataConv.getYear();
        int calculo = c1 - c2 ;
        System.out.println("\n");
        System.out.println("Sua idade e " + calculo + "\n");

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Date getDataConv() {
        return dataConv;
    }

    public void setDataConv(Date dataConv) {
        this.dataConv = dataConv;
    }
}
