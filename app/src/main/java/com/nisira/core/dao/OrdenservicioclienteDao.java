package com.nisira.core.dao;

import com.nisira.core.entity.*;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import com.nisira.core.database.DataBaseClass;
import android.content.ContentValues;
import android.database.Cursor;
import com.nisira.core.util.ClaveMovil;
import java.util.ArrayList;
import java.util.LinkedList;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdenservicioclienteDao extends BaseDao<Ordenserviciocliente> {
	public OrdenservicioclienteDao() {
		super(Ordenserviciocliente.class);
	}
	public OrdenservicioclienteDao(boolean usaCnBase) throws Exception {
		super(Ordenserviciocliente.class, usaCnBase);
	}
	public void mezclarLocal(Ordenserviciocliente obj)throws Exception{
		if(obj !=null){
			List<Ordenserviciocliente> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDENSERVICIO))=?",obj.getIdempresa().trim(),obj.getIdordenservicio().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
	public List<Ordenserviciocliente> listOrdenServicioxCliente()throws Exception{
		List<Ordenserviciocliente> lst= listar();
		ClieprovDao clientedao = new ClieprovDao();
		Clieprov cliente = null;
		int i=0;
		for(Ordenserviciocliente obj : lst){
			cliente=clientedao.getClientexempresa_codigo(obj.getIdempresa(),obj.getIdclieprov());
			if(cliente!=null){
				obj.setCliente(cliente.getRazon_social()
				);
				obj.setRuc(cliente.getRuc());
				lst.set(i,obj);
			}
			i++;
		}
		return lst;
	}
	public List<Ordenserviciocliente> listOrdenServicioxClienteFiltro(String filtro)throws Exception{
		ClieprovDao clientedao = new ClieprovDao();
		List<Clieprov> clieprovList = clientedao.listar("LTRIM(RTRIM(t0.IDCLIEPROV)) like '%' || ? || '%' OR LTRIM(RTRIM(t0.RAZON_SOCIAL)) like '%' || ? || '%'",filtro,filtro);
		System.out.println("TAMAÑO "+clieprovList.size());
        List<Ordenserviciocliente> lst=null;
		List<Ordenserviciocliente> lstotal=new ArrayList<>();
		if(!clieprovList.isEmpty()){
			for(Clieprov obj : clieprovList){
				lst=listar("LTRIM(RTRIM(t0.IDCLIEPROV)) = ? ",obj.getIdclieprov());
				if(!lst.isEmpty()){
                    int i=0;
                    for(Ordenserviciocliente elem:lst){
                        elem.setCliente(obj.getRazon_social());
                        elem.setRuc(obj.getRuc());
                        lst.set(i,elem);
                        i++;
                    }
					lstotal.addAll(lst);
				}
			}
			return lstotal;
		}
		return lstotal;
	}
}