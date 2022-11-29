package com.deneb.asteroides;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import java.util.ArrayList;
import java.util.List;

public class VistaJuego extends View {
    private List<Grafico> asteroides;
    private int numAsteroides = 5;
    private int numFragmentos = 3;

    private Grafico nave;
    private int giroNave;
    private double aceleracionNave;
    private static final int MAX_VELOCIDAD_NAVE = 20;
    private static final int PASO_GIRO_NAVE = 5;
    private static final float PASO_ACELERACION_NAVE = 0.5f;

    public VistaJuego(Context context, AttributeSet attrs){
        super(context, attrs);
        Drawable drawableNave, drawableAsteroide, drawableMisil;
        drawableAsteroide = AppCompatResources.getDrawable
                (context, R.drawable.asteroide1);
        asteroides = new ArrayList<Grafico>();
        for (int i = 0; i < numAsteroides; i++){
            Grafico asteroide = new Grafico(this, drawableAsteroide);
            asteroide.setIncY(Math.random() * 4 - 2);
            asteroide.setIncX(Math.random() * 4 - 2);
            asteroide.setAngulo((int) (Math.random() * 360));
            asteroide.setRotacion((int) (Math.random() * 8 - 4));
            asteroides.add(asteroide);
        }
        drawableNave = AppCompatResources.getDrawable(context, R.drawable.nave);
        nave = new Grafico(this, drawableNave);
    }

    @Override
    protected void onSizeChanged(int ancho, int alto, int ancho_anter, int alto_anter){
        super.onSizeChanged(ancho, alto, ancho_anter, alto_anter);

        for(Grafico asteroide: asteroides){
            do {
                asteroide.setCenX((int) (Math.random() * ancho));
                asteroide.setCenY((int) (Math.random() * alto));
            }while(asteroide.distancia(nave) < (int) ((ancho + alto) / 5));
        }
        nave.setCenX(ancho/2);
        nave.setCenY(alto/2);

    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        for(Grafico asteroide: asteroides){
            asteroide.dibujaGrafico(canvas);
        }
        nave.dibujaGrafico(canvas);
    }
}
