package com.example.jesus95.petvet.models;

/**
 * Created by jesus95 on 02/06/17.
 */

public class PreguntasMultiplesOk {

    public String mQuestions[] = {  //7 preguntas
            "Selecciona que comida le debemos dar a nuestro perro para que tenga una alimentación balanceada\n",
            "¿Que debemos de tomar en cuenta al elegir la comida para nuestro perro?",
            "Cuanta comida le debemos de dar nuestro perro?"
    };

    public String mChoices[][] = {
            //2da opcion
            {"Croquetas", "Comida de lata", "leche", "Pollo cocido", "Carnasas", "Carne"},
            {"Sabor", "Ingredientes", "Edad", "Precio", "Comida Especializada", "Color"},
            {"La suficiente para llenarse","La que nos indica el veterinario","Un taza","La que indica la bolsa de la comida"}
    };

    public String mCorrectChoices[] = {
            "Croquetas",
            "Comida de lata"
    };

    public String mCorrectChoices1[] = {
            "Ingredientes",
            "Edad",
            "Comida Especializada"
    };

    public String mCorrectChoices2[] = {
            "La que nos indica el veterinario",
            "La que indica la bolsa de la comida",
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

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getChoice5(int a) {
        String choice = mChoices[a][4];
        return choice;
    }

    public String getChoice6(int a) {
        String choice = mChoices[a][5];
        return choice;
    }




    public String getCorrectAnswer1(int a){
        String answer1 = mCorrectChoices[0];
        return answer1;

    }

    public String getCorrectAnswer2(int a){
        String answer2 = mCorrectChoices[1];
        return answer2;
    }

    //------------------------->

    public String getCorrectAnswer3(int a){
        String answer1 = mCorrectChoices1[0];
        return answer1;

    }

    public String getCorrectAnswer4(int a){
        String answer2 = mCorrectChoices1[1];
        return answer2;
    }

    public String getCorrectAnswer5(int a){
        String answer3 = mCorrectChoices1[2];
        return answer3;
    }

    //---------------------------->

    public String getCorrectAnswer6(int a){
        String answer1 = mCorrectChoices2[0];
        return answer1;

    }

    public String getCorrectAnswer7(int a){
        String answer2 = mCorrectChoices2[1];
        return answer2;
    }

}

