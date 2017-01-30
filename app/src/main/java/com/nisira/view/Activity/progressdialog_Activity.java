package com.nisira.view.Activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.nisira.gcalderon.policesecurity.R;

/**
 * Created by aburgos on 27/01/2017.
 */

public class progressdialog_Activity extends Activity {

    //variables necesarias
    private ProgressDialog pd = null;
    private Object data = null;

    private TextView texto;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressdialog);

        //asignamos el TextView para mostrar luego los datos procesados
        this.texto = (TextView) findViewById(R.id.texto);

        // Mostrar el ProgressDialog en este Thread
        this.pd = ProgressDialog.show(this, "Procesando", "Espere unos segundos...", true, false);

        // Se comienza la nueva Thread que descargará los datos necesarios
        new DownloadTask().execute("Parametros que necesite el DownloadTask");
    }

    /**
     * Muestra el texto resultado
     * @paramString textoAMostrar
     */
    public void mostrarResultado(String textoAMostrar){
        this.texto.setText(textoAMostrar);
    }

    /**
     * Subclase privada que crea un hilo aparte para realizar
     * las acciones que deseemos.
     */
    private class DownloadTask extends AsyncTask<String, Void, Object> {
        protected String doInBackground(String... args) {
            Log.i("Mi app", "Empezando hilo en segundo plano");

            // Aqui se realizan las operaciones necesarias (como descargar datos internet, por ejmplo)
            // Como ejemplo, simulamos que se trabaja durante unos segundos con un for
            for (int i=1;i<1400000;i++){
            }

            return "Datos ya procesados (resultado)";
        }

        protected void onPostExecute(Object result) {
            // Pasamos el resultado de los datos a la Acitvity principal
            progressdialog_Activity.this.mostrarResultado((String)result);
            if (progressdialog_Activity.this.pd != null) {
                progressdialog_Activity.this.pd.dismiss();
            }
        }
    }
}
