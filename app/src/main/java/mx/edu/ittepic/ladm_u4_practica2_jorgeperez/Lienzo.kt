package mx.edu.ittepic.ladm_u4_practica2_jorgeperez

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo(p: MainActivity) : View(p) {
    // VARIABLES QUE SE NECESITAN
    var posX = 300f // LA POSICIÓN RESPECTO A X
    var dia = true // VARIABLE PARA SABER SI ES DE DÍA

    override fun onDraw(c : Canvas) {
        // VARIABLE PARA PINTAR
        var p = Paint()

        if(dia) {
            // DIBUJAR EL CIELO AZUL DE DÍA
            c.drawColor(Color.rgb(0,162,232))

            // DIBUJAR EL SOL
            p.color = Color.YELLOW
            c.drawCircle(150f, 150f, 100f, p)

            // DIBUJAR LA NUBE
            p.color = Color.rgb(255,255,255)
            p.style = Paint.Style.FILL
            c.drawCircle(450f, 150f, 50f, p)
            c.drawCircle(500f, 152f, 50f, p)
            c.drawCircle(550f, 150f, 50f, p)
            c.drawCircle(600f, 148f, 50f, p)
            c.drawCircle(650f, 148f, 50f, p)
        } else {
            // DIBUJAR EL CIELO AZUL DE NOCHE
            c.drawColor(Color.rgb(3,21,143))

            // DIBUJAR LA LUNA
            p.color = Color.WHITE
            c.drawCircle(150f, 150f, 100f, p)

            // DIBUJAR LAS ESTRELLAS
            p.color = Color.WHITE
            p.style = Paint.Style.FILL
            c.drawCircle(80f, 342f, 8f, p)
            c.drawCircle(100f, 442f, 8f, p)
            c.drawCircle(150f, 542f, 8f, p)
            c.drawCircle(260f, 312f, 8f, p)
            c.drawCircle(300f, 442f, 8f, p)
            c.drawCircle(320f, 242f, 8f, p)
            c.drawCircle(375f, 342f, 8f, p)
            c.drawCircle(475f, 142f, 8f, p)
            c.drawCircle(575f, 442f, 8f, p)
            c.drawCircle(675f, 262f, 8f, p)
            c.drawCircle(775f, 542f, 8f, p)
            c.drawCircle(875f, 152f, 8f, p)
            c.drawCircle(875f, 442f, 8f, p)
            c.drawCircle(975f, 288f, 8f, p)
            c.drawCircle(975f, 512f, 8f, p)
        }

        // DIBUJAR EL PASTO
        p.color = Color.rgb(17, 194, 7)
        c.drawRect(0f,900f,1080f, 2040f, p)

        // DIBUJAR EL ÁRBOL
        // DIBUJAR EL TRONCO
        p.color = Color.rgb(128, 64, 0)
        c.drawRect(90f, 1110f, 200f, 1310f,p)
        // DIBUJAR LAS HOJAS
        p.color = Color.rgb(0,64,0)
        c.drawCircle(140f,1050f,100f,p)
        c.drawCircle(140f,920f,100f,p)

        // DIBUJAR AL PRÍNCIPE DE LOS SAYAJINES: VEGETA
        c.drawBitmap(BitmapFactory.decodeResource(resources, R.drawable.vegeta), posX, 500f, p)
    }
}