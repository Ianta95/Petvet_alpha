package com.example.jesus95.petvet.models;

/**
 * Created by jesus95 on 02/06/17.
 */

public class Tips {

    public String mTips[] = {
            "Remojar las croquetas con leche o agua tibia, ayudara a pasar mejor el alimento",
            "Leche en polvo para cachorro le da todo lo necesario para que tu cachorro siga creciendo saludable",
            "3 es lo recomendable, Necesitan mas alimento para nutrirse en esa etapa",
            "2 veces es lo recomendado! Una en la mañana, y otra en la noche",
            "Tortillas no es suficienta para nutrir adecuadamente a nuestro cachorro",
            "Lo recomendable es hacerlo 50/50 y esperar unos dias a que se acostumbre al nuevo sabor de las croquetas",
            "Todos necesitamos relajarnos al comer, ¿no?. Lo recomendable es en un lugar tranquilo"
    };

    public String getTip(int a){
        String tip = mTips[a];
        return tip;
    }

    public String mTipsadulto[] = {
            "Remojar las croquetas con leche o agua tibia, ayudara a pasar mejor el alimento",
            "Leche en polvo para cachorro le da todo lo necesario para que tu cachorro siga creciendo saludable",
            "3 es lo recomendable, Necesitan mas alimento para nutrirse en esa etapa",
            "2 veces es lo recomendado! Una en la mañana, y otra en la noche",
            "Tortillas no es suficienta para nutrir adecuadamente a nuestro cachorro",
            "Lo recomendable es hacerlo 50/50 y esperar unos dias a que se acostumbre al nuevo sabor de las croquetas",
            "Todos necesitamos relajarnos al comer, ¿no?. Lo recomendable es en un lugar tranquilo"
    };

    public String getTipadulto(int a){
        String tip = mTips[a];
        return tip;
    }
}
