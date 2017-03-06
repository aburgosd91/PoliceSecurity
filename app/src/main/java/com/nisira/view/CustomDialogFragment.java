package com.nisira.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import android.support.v4.view.ViewGroupCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.nisira.gcalderon.policesecurity.R;

/**
 * Created by gcalderon on 06/03/2017.
 */

public class CustomDialogFragment extends android.support.v4.app.DialogFragment {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        LayoutInflater inflater = getActivity().getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = inflater.inflate(R.layout.dialog_custompopup, null);
        builder
                .setView(view)
                .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        Bundle mArgs = getArguments();
        TextView titulo = (TextView) view.findViewById(R.id.txttitulo1);
        titulo.setText(mArgs.getString("titulo"));
        TextView mensaje = (TextView) view.findViewById(R.id.txtmessage);
        mensaje.setText(mArgs.getString("mensaje"));
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
