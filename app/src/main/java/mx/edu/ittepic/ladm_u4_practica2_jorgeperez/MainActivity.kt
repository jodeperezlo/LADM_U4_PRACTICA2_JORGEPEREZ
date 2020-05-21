package mx.edu.ittepic.ladm_u4_practica2_jorgeperez

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var lienzo : Lienzo
    lateinit var sensorManager : SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        // ACELERÓMETRO
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)
        // PROXIMIDAD
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)

        // MANDAMOS LLAMAR AL LIENZO
        lienzo = Lienzo(this)
        setContentView(lienzo)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) { }

    // CUANDO LOS SENSORES SUFREN ALGÚN CAMBIO
    override fun onSensorChanged(event: SensorEvent) {
        var posX = event.values[0]

        // SI EL ACELERÓMETRO CAMBIA, CAMBIAMOS LA POSICIÓN DE LA VARIABLE posX
        // PARA QUE ASÍ SE MUEVA LA IMAGEN
        if(event.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            lienzo.posX = lienzo.posX + (-posX)
        }

        // SI EL SENSOR DE PROXIMIDAD CAMIBA, PCAMBIAMOS EL VALOR DE LA VARIABLE DÍA
        if(event.sensor.type == Sensor.TYPE_PROXIMITY) {
            lienzo.dia = (event.values[0] >= 5f)
        }

        lienzo.invalidate()
    }
}