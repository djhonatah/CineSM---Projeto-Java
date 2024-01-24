package br.com.uepb.moviesm.calculator;

import br.com.uepb.moviesm.models.Title;

public class TimeCalculator {
    private int totalTime = 0;

    public int getTotalTime() {
        return this.totalTime;
    }


    public void inclui(Title title){
        System.out.println("Adicionando duração em minutos de " + title);
        this.totalTime += title.getDurationInMinutes();
    }

}
