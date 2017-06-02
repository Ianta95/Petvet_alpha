package com.example.jesus95.petvet.models;

/**
 * Created by jesus95 on 02/06/17.
 */

public class PreguntasAdulto {

    public String mQuestions[] = {  //7 preguntas
            "¿Al cambiar la comida de nuestro perro debemos hacer de forma?",
            "¿Dónde debemos darle de comer a nuestro perro?",
    };

    public String mChoices[][] = {
            //1ra opcion
            {"paulatina mezclado 50/50 y después de unos días el cambio total", "De una sola vez, al final es comida", "Ambas funcionan"},
            //3ra opcion
            {"en medio de la sala para verlo comer","En cualquier lugar cerca de ti","En un lugar tranquilo donde pueda relajarse y comer tranquilamente"}
    };

    public String mCorrectAnswer[] = {
            "paulatina mezclado 50/50 y después de unos días el cambio total",
            "En un lugar tranquilo donde pueda relajarse y comer tranquilamente",
    };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }


}
