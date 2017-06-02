package com.example.jesus95.petvet.models;

/**
 * Created by jesus95 on 02/06/17.
 */

public class PreguntasCachorro {

    public String mQuestions[] = {  //7 preguntas
            "Si nuestro cachorro tiene problemas para poder comer sus croquetas, podemos:",
            "En caso de no tener a la madre y que no tenga más de 6 semanas, le debemos dar de comer al cachorro:",
            "¿Cuántas veces al dìa debe de comer un cachorro de entre 4 y 6 meses?",
            "A partir de los 6 meses, ¿Cuántas veces al día debemos alimentar a nuestro perro?",
            "¿Cual de estos alimentos, no le da a nuestro cachorro una alimentacion balanceada?",
            "Si cambiaremos el alimento de nuestro cachorro, ¿Que es lo mas recomnedable?",
            "¿Dónde debemos darle de comer a nuestro perro?"
    };

    public String mChoices[][] = {
            //2da opcion
            {"Seguir con la leche", "Remojarlas en su plato", "Darle carne"},
            //3ra opcion
            {"Leche deslactosada light","Croquetas para cachorro","Leche en polvo para cachorros"},
            //1ra opcion
            {"3 veces al dia", "2 veces al dia", "1 sola vez"},
            //3ra opcion
            {"1 Sola vez", "5 veces al dia", "2 veces al dia"},
            //1ra opcion
            {"Tortillas","Croquetas","Comida de lata"},
            //2da opcion
            {"Darle 50/50 y tras unos dias, cambio total", "En un solo dia", "Ambas opciones"},
            //1ra opcion
            {"En un lugar tranquilo para que se relaje y coma tranquilo ","En medio de la sala para verlo comer", "En cualquier lugar en el que puedas cuidarlo"}
    };

    public String mCorrectAnswer[] = {
            "Remojarlas en su plato",
            "Leche en polvo para cachorros",
            "3 veces al dia",
            "2 veces al dia",
            "Tortillas",
            "Darle 50/50 y tras unos dias, cambio total",
            "En un lugar tranquilo para que se relaje y coma tranquilo "
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
