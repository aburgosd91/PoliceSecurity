package com.nisira.view.Activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.nisira.core.dao.DordenliquidaciongastoDao;
import com.nisira.core.dao.OrdenliquidaciongastoDao;
import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.entity.Dordenliquidaciongasto;
import com.nisira.core.entity.Ordenliquidaciongasto;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.gcalderon.policesecurity.R;
import com.nisira.view.Adapter.Adapter_edt_OrdenLiquidacionGasto;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.StringJoiner;


public class edt_OrdenLiquidacionGasto_Fragment extends FragmentNisira {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Ordenliquidaciongasto ordenliquidaciongasto;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextInputEditText txt_documento;
    private TextInputEditText txt_cliente;
    private TextView fecha,txt_estado;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
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
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_os);
        LlenarCampos();
        Listeners();
        return view;
    }

    public void LlenarCampos() {
        TextView view = (TextView) getActivity().findViewById(R.id.campo_titulo);
        view.setText(getString(R.string.edt_OrdenLiquidacionGasto));

        txt_documento.setText(ordenliquidaciongasto.getIddocumento() + " - " +
                ordenliquidaciongasto.getSerie() + " - " +
                ordenliquidaciongasto.getNumero());
        txt_cliente.setText(ordenliquidaciongasto.getRazonsocial());
        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sm.format(ordenliquidaciongasto.getFecha());
        fecha.setText(strDate);
        String estado = ordenliquidaciongasto.getIdestado();
        if(estado.equals("PE")){
            txt_estado.setText("Pendiente");
        }

        recyclerView.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lManager);
        DordenliquidaciongastoDao dao = new DordenliquidaciongastoDao();
        try {
            List<Dordenliquidaciongasto> dordenliquidaciongastos = dao.ListarxOrdenLiq(ordenliquidaciongasto);
            Adapter_edt_OrdenLiquidacionGasto adapter = new Adapter_edt_OrdenLiquidacionGasto("",dordenliquidaciongastos);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Listeners(){

    }


}
