package com.nisira.view.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.nisira.core.dao.DordenliquidaciongastoDao;
import com.nisira.core.dao.OrdenliquidaciongastoDao;
import com.nisira.core.dao.UsuarioDao;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Usuario;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Adapter_edt_OrdenLiquidacionGasto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;


public class edt_OrdenLiquidacionGasto_Fragment extends FragmentNisira {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Ordenliquidaciongasto ordenliquidaciongasto;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String OPCION = "param1";
    private static final String ANTERIOR = "param2";
    private TextInputEditText txt_documento;
    private TextInputEditText txt_cliente;
    private TextInputEditText txt_importe;
    private TextView fecha,txt_estado;
    private RecyclerView recyclerView;
    private Adapter_edt_OrdenLiquidacionGasto adapter;
    private RecyclerView.LayoutManager lManager;
    private OrdenliquidaciongastoDao dao2;
    private FloatingActionButton fabnuevo,fab_modificar,fab_eliminar;
    List<Dordenliquidaciongasto> List_dordenliquidaciongastos;
    DordenliquidaciongastoDao dordenliquidaciongastoDao ;
    View view;

    public edt_OrdenLiquidacionGasto_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment edt_OrdenServicio_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static edt_OrdenLiquidacionGasto_Fragment newInstance(String param1, String param2) {
        edt_OrdenLiquidacionGasto_Fragment fragment = new edt_OrdenLiquidacionGasto_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            ordenliquidaciongasto = (Ordenliquidaciongasto) getArguments().getSerializable("OrdenLiquidacionGasto");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_edt__ordenliquidaciongasto, container, false);
        txt_documento = (TextInputEditText)view.findViewById(R.id.txt_documento);
        txt_cliente = (TextInputEditText)view.findViewById(R.id.txt_cliente);
        fecha = (TextView)view.findViewById(R.id.txt_fecha);
        txt_estado = (TextView)view.findViewById(R.id.txt_estado);
        txt_importe = (TextInputEditText)view.findViewById(R.id.txt_importe);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_os);
        fabnuevo = (FloatingActionButton)view.findViewById(R.id.fabnuevo);
        fab_modificar  =(FloatingActionButton)view.findViewById(R.id.fab_modificar);
        fab_eliminar = (FloatingActionButton)view.findViewById(R.id.fab_eliminar);
        LlenarCampos();
        Listeners();
        return view;
    }

    public void LlenarCampos() {
        TextView view = (TextView) getActivity().findViewById(R.id.campo_titulo2);
        view.setText(getString(R.string.edt_OrdenLiquidacionGasto));
        dordenliquidaciongastoDao = new DordenliquidaciongastoDao();
        txt_documento.setText(ordenliquidaciongasto.getIddocumento() + " - " +
                ordenliquidaciongasto.getSerie() + " - " +
                ordenliquidaciongasto.getNumero());
        txt_cliente.setText(ordenliquidaciongasto.getRazonsocial());
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sm.format(ordenliquidaciongasto.getFechacreacion());
        fecha.setText(strDate);
        String estado = ordenliquidaciongasto.getIdestado();
        txt_importe.setText(ordenliquidaciongasto.getImporte()+"");
        if(estado.equals("PE")){
            txt_estado.setText("Pendiente");
        }

        recyclerView.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lManager);
        DordenliquidaciongastoDao dao = new DordenliquidaciongastoDao();
        try {
            List_dordenliquidaciongastos = dao.listarxOrdenLG(ordenliquidaciongasto);
            adapter = new Adapter_edt_OrdenLiquidacionGasto("",List_dordenliquidaciongastos,getFragmentManager(),ordenliquidaciongasto);
            recyclerView.setAdapter(adapter);
            dao2  = new OrdenliquidaciongastoDao();
            BigDecimal importe = BigDecimal.valueOf(0.0);
            for(int i=0;i<List_dordenliquidaciongastos.size();i++){
                importe=importe.add(BigDecimal.valueOf(List_dordenliquidaciongastos.get(i).getImporte()));
                //importe=importe.add(BigDecimal.valueOf(List_dordenliquidaciongastos.get(i).getAfecto()));
            }
            ordenliquidaciongasto.setImporte(importe.doubleValue());
            dao2.mezclarLocal(ordenliquidaciongasto);
            txt_importe.setText(ordenliquidaciongasto.getImporte()+"");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Listeners(){
        fabnuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = mnt_DOrdenLiquidacionGasto_Fragment.newInstance(OPCION, "lst_OrdenServicio_Fragment");
                Bundle bundle = fragment.getArguments();
                bundle.putSerializable("OrdenLiquidacionGasto",ordenliquidaciongasto);
                bundle.putSerializable("tipo_entrada","NUEVO");
                fragment.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        fab_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(List_dordenliquidaciongastos.size()==0){
                    Snackbar.make(getView(), "No hay datos", Snackbar.LENGTH_SHORT).show();
                }
                for (int i = 0; i < List_dordenliquidaciongastos.size(); i++) {
                    if (List_dordenliquidaciongastos.get(i).isSeleccion()) {
                        Fragment fragment = mnt_DOrdenLiquidacionGasto_Fragment.newInstance(OPCION, "edt_OrdenLiquidacionGasto_Fragment");
                        Bundle bundle = fragment.getArguments();
                        bundle.putSerializable("DOrdenLiquidacionGasto", List_dordenliquidaciongastos.get(i));
                        bundle.putSerializable("OrdenLiquidacionGasto", ordenliquidaciongasto);
                        bundle.putSerializable("tipo_entrada", "ACTUALIZAR");
                        fragment.setArguments(bundle);
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.main_content, fragment, "NewFragmentTag");
                        ft.addToBackStack(null);
                        ft.commit();
                    }
                }
            }
        });
        fab_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(List_dordenliquidaciongastos.size()==0){
                        Snackbar.make(getView(), "No hay datos", Snackbar.LENGTH_SHORT).show();
                    }else{
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setMessage("Desea Eliminar el registro?")
                            .setCancelable(false)
                            .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    try {
                                        for (int i = 0; i < List_dordenliquidaciongastos.size(); i++) {
                                            if (List_dordenliquidaciongastos.get(i).isSeleccion()) {
                                                dordenliquidaciongastoDao.borrar(List_dordenliquidaciongastos.get(i));
                                                List_dordenliquidaciongastos.remove(i);
                                                adapter.notifyDataSetChanged();
                                            }
                                        }
                                        LlenarCampos();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    Snackbar.make(getView(), "Detalles Eliminados", Snackbar.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //NADA PASA
                                }
                            });
                    alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = alertDialogBuilder.create();
                    alert.show();
                }

                } catch (Exception e){
                    e.printStackTrace();

                }
            }
        });

    }
    @Override
    public void onResume()
    {
        super.onResume();
            // The fragment restored from backstack, do some work here!
        LlenarCampos();

    }


}
