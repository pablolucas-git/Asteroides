package com.deneb.asteroides;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class Grafico {
    private Drawable drawable;
    private int cenX, cenY, ancho, alto, radioColision, xAnterior, yAnterior, radioInval;
    private double incX, incY, angulo, rotacion;
    private View view;

    public Grafico(View view, Drawable drawable){
        this.view = view;
        this.drawable = drawable;
        ancho = drawable.getIntrinsicWidth();
        alto = drawable.getIntrinsicHeight();
        radioColision = (alto + ancho) / 4;
        radioInval = (int) Math.hypot(ancho/2, alto/2);
    }

    public void dibujaGrafico(Canvas canvas){
        int x = (int) (cenX - ancho/2);
        int y = (int) (cenY - alto/2);
        drawable.setBounds(x, y, x+ancho, y+alto);
        canvas.save();
        canvas.rotate((float) angulo, cenX, cenY);
        drawable.draw(canvas);
        canvas.restore();
        xAnterior = cenX;
        yAnterior = cenY;
    }

    public void incrementaPos(double factor){
        cenX += incX * factor;
        cenY += incY * factor;
        angulo += rotacion * factor;
        if(cenX<0) cenX = view.getWidth();
        if(cenX>view.getWidth()) cenX = 0;
        if(cenY < 0) cenY=view.getHeight();
        if(cenY > view.getHeight()) cenY = 0;
        view.postInvalidate(cenX-radioInval, cenY-radioInval,
                cenX+radioInval, cenY+radioInval);
        view.postInvalidate(xAnterior-radioInval, yAnterior-radioInval,
                xAnterior+radioInval, yAnterior+radioInval);
    }
    public double distancia(Grafico g){
        return Math.hypot(cenX-g.cenX, cenY-g.cenY);
    }

    public boolean verificaColision(Grafico g){
        return (distancia(g) < (radioColision + g.radioColision));
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public int getCenX() {
        return cenX;
    }

    public void setCenX(int cenX) {
        this.cenX = cenX;
    }

    public int getCenY() {
        return cenY;
    }

    public void setCenY(int cenY) {
        this.cenY = cenY;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getRadioColision() {
        return radioColision;
    }

    public void setRadioColision(int radioColision) {
        this.radioColision = radioColision;
    }

    public int getxAnterior() {
        return xAnterior;
    }

    public void setxAnterior(int xAnterior) {
        this.xAnterior = xAnterior;
    }

    public int getyAnterior() {
        return yAnterior;
    }

    public void setyAnterior(int yAnterior) {
        this.yAnterior = yAnterior;
    }

    public int getRadioInval() {
        return radioInval;
    }

    public void setRadioInval(int radioInval) {
        this.radioInval = radioInval;
    }

    public double getIncX() {
        return incX;
    }

    public void setIncX(double incX) {
        this.incX = incX;
    }

    public double getIncY() {
        return incY;
    }

    public void setIncY(double incY) {
        this.incY = incY;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public double getRotacion() {
        return rotacion;
    }

    public void setRotacion(double rotacion) {
        this.rotacion = rotacion;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
