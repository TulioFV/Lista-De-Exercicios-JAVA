package exercicio4;

public class Televisao {

    private int canal = 1,volume = 1;

    public void mostra(){

        System.out.println("O volume atual e: " + getVolume() +".\n"
                + "O canal atual e: " + getCanal()+".");

    }

    public int setCanal(int canal) {

        if(canal == 1){
            this.canal +=1;
            mostra();
        }else if(canal == 2){
            this.canal -=1;
            mostra();
        }else{
            this.canal = canal;
            mostra();
        }
        return this.canal = canal;
    }

    public int setVolume(int volume) {
        if(volume == 3){
            this.volume +=1;

            mostra();
        }else if(volume == 4){
            this.volume -=1;

            mostra();
        }

        return this.volume = volume;
    }

    public int getCanal() {
        return canal;
    }

    public int getVolume() {
        return volume;
    }

}
