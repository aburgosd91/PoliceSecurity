package com.nisira.core.dao;

import com.nisira.core.Consulta;
import com.nisira.core.EntityTuple;
import com.nisira.core.database.SqlLiteConsulta;
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
	public List<Ordenserviciocliente> listOrdenServicioxCliente(Usuario user)throws Exception{
		List<Ordenserviciocliente> lst= listar("t0.IDOPERARIO = ?",user.getIdclieprov());
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
	public List<Ordenserviciocliente> listOrdenServicioxClienteFiltro(String filtro, Usuario user)throws Exception{

        String where = "t1.IDCLIEPROV like '%'||?||'%' AND t1.RAZON_SOCIAL like '%'||?||'%' ";
        SqlLiteConsulta c = getInstancia();
        c.join("inner", Clieprov.class, "t1", "t0.IDCLIEPROV = t1.IDCLIEPROV");
        c.where(where, user.getIdclieprov(), filtro);
        List<Ordenserviciocliente> ordenservicioclienteList=(List<Ordenserviciocliente>) EntityTuple.getListForAlias(c.execSelect(), "t0");
        ClieprovDao clientedao = new ClieprovDao();
        Clieprov cliente = null;
        int i=0;
        for(Ordenserviciocliente obj : ordenservicioclienteList){
            cliente=clientedao.getClientexempresa_codigo(obj.getIdempresa(),obj.getIdclieprov());
            if(cliente!=null){
                obj.setCliente(cliente.getRazon_social()
                );
                obj.setRuc(cliente.getRuc());
                ordenservicioclienteList.set(i,obj);
            }
            i++;
        }
		return ordenservicioclienteList;
	}
}