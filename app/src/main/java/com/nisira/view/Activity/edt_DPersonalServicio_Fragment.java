package com.nisira.view.Activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.nisira.core.dao.OrdenservicioclienteDao;
import com.nisira.core.entity.Ordenserviciocliente;
import com.nisira.core.interfaces.FragmentNisira;
import com.nisira.gcalderon.policesecurity.R;

import java.util.List;


public class edt_DPersonalServicio_Fragment extends FragmentNisira {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText txt_documento;
    private EditText txt_cliente;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    public edt_DPersonalServicio_Fragment() {
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
    public static edt_DPersonalServicio_Fragment newInstance(String param1, String param2) {
        edt_DPersonalServicio_Fragment fragment = new edt_DPersonalServicio_Fragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edt__orden_servicio, container, false);
        txt_documento = (EditText)view.findViewById(R.id.txt_documento);
        txt_cliente = (EditText)view.findViewById(R.id.txt_cliente);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_os);

        txt_documento.setText("Orden Servicio Cliente");
        txt_cliente.setText("Olivia Peña Carlos Alberto");

        recyclerView.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lManager);
        OrdenservicioclienteDao  ordenservicioclienteDao = new OrdenservicioclienteDao();
        try {
            //List<Ordenserviciocliente> lstordenserviciocliente = ordenservicioclienteDao.listOrdenServicioxCliente();
            //List_Adapter_OrdenServicio adapter = new List_Adapter_OrdenServicio(lstordenserviciocliente,getFragmentManager());
            //recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
