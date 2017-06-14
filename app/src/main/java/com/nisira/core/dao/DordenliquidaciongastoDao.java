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

public class DordenliquidaciongastoDao extends BaseDao<Dordenliquidaciongasto> {
	public DordenliquidaciongastoDao() {
		super(Dordenliquidaciongasto.class);
	}
	public DordenliquidaciongastoDao(boolean usaCnBase) throws Exception {
		super(Dordenliquidaciongasto.class, usaCnBase);
	}
	public void mezclarLocal(Dordenliquidaciongasto obj)throws Exception{
		if(obj !=null){
			List<Dordenliquidaciongasto> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDEN))=? AND LTRIM(RTRIM(t0.ITEM))=?",obj.getIdempresa().trim(),obj.getIdorden().trim(),obj.getItem().trim());
			if(lst.isEmpty())
				insertar(obj);
			else
				actualizar(obj);
		}
	}
	public List<Dordenliquidaciongasto> listar(Dordenliquidaciongasto obj)throws Exception{
		List<Dordenliquidaciongasto> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDEN))=? ORDER BY LTRIM(RTRIM(t0.ITEM)) ",obj.getIdempresa().trim(),obj.getIdorden().trim());
		return lst;
	}
	public List<Dordenliquidaciongasto> listarxOrdenLG(Ordenliquidaciongasto obj)throws Exception{
		List<Dordenliquidaciongasto> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDEN))=? ORDER BY LTRIM(RTRIM(t0.ITEM)) ",obj.getIdempresa().trim(),obj.getIdorden().trim());
		return lst;
	}

	public  List<Dordenliquidaciongasto> ListarxOrdenLiq(Ordenliquidaciongasto obj)throws Exception{
		if (obj != null){
			List<Dordenliquidaciongasto> lst = listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDORDEN))=? ",obj.getIdempresa().trim(),obj.getIdorden().trim());
			Concepto_cuentaDao dao = new Concepto_cuentaDao();
			int i=0;
			for(Dordenliquidaciongasto item:lst){
				List<Concepto_cuenta> lista = dao.listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDCONCEPTO))=?",item.getIdempresa().trim(),item.getIdconcepto().trim());
				if(!lst.isEmpty()){
					item.setDescripcion_concepto(lista.get(0).getDescripcion());
					lst.set(i,item);
				}
				i++;
			}

			return lst;
		}
		return null;
	}
	public Boolean insert(Dordenliquidaciongasto dordenliquidaciongasto) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dordenliquidaciongasto.getIdempresa()); 
			initialValues.put("IDORDEN",dordenliquidaciongasto.getIdorden()); 
			initialValues.put("ITEM",dordenliquidaciongasto.getItem()); 
			initialValues.put("GLOSA",dordenliquidaciongasto.getGlosa()); 
			initialValues.put("IDCONCEPTO",dordenliquidaciongasto.getIdconcepto()); 
			initialValues.put("IDCUENTA",dordenliquidaciongasto.getIdcuenta()); 
			initialValues.put("IDCCOSTO",dordenliquidaciongasto.getIdccosto()); 
			initialValues.put("IDTIPOMOV",dordenliquidaciongasto.getIdtipomov()); 
			initialValues.put("IDCLIEPROV",dordenliquidaciongasto.getIdclieprov()); 
			initialValues.put("IDDOCUMENTO",dordenliquidaciongasto.getIddocumento()); 
			initialValues.put("SERIE",dordenliquidaciongasto.getSerie()); 
			initialValues.put("NUMERO",dordenliquidaciongasto.getNumero()); 
			initialValues.put("FECHA",dateFormat.format(dordenliquidaciongasto.getFecha() ) ); 
			initialValues.put("IDDESTINO",dordenliquidaciongasto.getIddestino()); 
			initialValues.put("IDMONEDA",dordenliquidaciongasto.getIdmoneda()); 
			initialValues.put("TCMONEDA",dordenliquidaciongasto.getTcmoneda()); 
			initialValues.put("TCAMBIO",dordenliquidaciongasto.getTcambio()); 
			initialValues.put("IDREGIMEN",dordenliquidaciongasto.getIdregimen()); 
			initialValues.put("AFECTO",dordenliquidaciongasto.getAfecto()); 
			initialValues.put("INAFECTO",dordenliquidaciongasto.getInafecto()); 
			initialValues.put("PIMPUESTO",dordenliquidaciongasto.getPimpuesto()); 
			initialValues.put("IMPUESTO",dordenliquidaciongasto.getImpuesto()); 
			initialValues.put("IMPORTE",dordenliquidaciongasto.getImporte()); 
			initialValues.put("OTROS",dordenliquidaciongasto.getOtros()); 
			initialValues.put("IDCONSUMIDOR",dordenliquidaciongasto.getIdconsumidor()); 
			initialValues.put("NUMERO_RCOMPRAS",dordenliquidaciongasto.getNumero_rcompras()); 
			initialValues.put("IDMEDIDA",dordenliquidaciongasto.getIdmedida()); 
			initialValues.put("IDPRODUCTO",dordenliquidaciongasto.getIdproducto()); 
			initialValues.put("ITEMALMACEN",dordenliquidaciongasto.getItemalmacen()); 
			initialValues.put("PRODUCTO",dordenliquidaciongasto.getProducto()); 
			initialValues.put("VENTANA",dordenliquidaciongasto.getVentana()); 
			initialValues.put("CANTIDAD",dordenliquidaciongasto.getCantidad()); 
			initialValues.put("IDSIEMBRA",dordenliquidaciongasto.getIdsiembra()); 
			initialValues.put("IDCAMPANA",dordenliquidaciongasto.getIdcampana()); 
			initialValues.put("IDORDENPRODUCCION",dordenliquidaciongasto.getIdordenproduccion()); 
			initialValues.put("IDLOTEPRODUCCION",dordenliquidaciongasto.getIdloteproduccion()); 
			resultado = mDb.insert("DORDENLIQUIDACIONGASTO",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Dordenliquidaciongasto dordenliquidaciongasto,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",dordenliquidaciongasto.getIdempresa()) ; 
			initialValues.put("IDORDEN",dordenliquidaciongasto.getIdorden()) ; 
			initialValues.put("ITEM",dordenliquidaciongasto.getItem()) ; 
			initialValues.put("GLOSA",dordenliquidaciongasto.getGlosa()) ; 
			initialValues.put("IDCONCEPTO",dordenliquidaciongasto.getIdconcepto()) ; 
			initialValues.put("IDCUENTA",dordenliquidaciongasto.getIdcuenta()) ; 
			initialValues.put("IDCCOSTO",dordenliquidaciongasto.getIdccosto()) ; 
			initialValues.put("IDTIPOMOV",dordenliquidaciongasto.getIdtipomov()) ; 
			initialValues.put("IDCLIEPROV",dordenliquidaciongasto.getIdclieprov()) ; 
			initialValues.put("IDDOCUMENTO",dordenliquidaciongasto.getIddocumento()) ; 
			initialValues.put("SERIE",dordenliquidaciongasto.getSerie()) ; 
			initialValues.put("NUMERO",dordenliquidaciongasto.getNumero()) ; 
			initialValues.put("FECHA",dateFormat.format(dordenliquidaciongasto.getFecha() ) ) ; 
			initialValues.put("IDDESTINO",dordenliquidaciongasto.getIddestino()) ; 
			initialValues.put("IDMONEDA",dordenliquidaciongasto.getIdmoneda()) ; 
			initialValues.put("TCMONEDA",dordenliquidaciongasto.getTcmoneda()) ; 
			initialValues.put("TCAMBIO",dordenliquidaciongasto.getTcambio()) ; 
			initialValues.put("IDREGIMEN",dordenliquidaciongasto.getIdregimen()) ; 
			initialValues.put("AFECTO",dordenliquidaciongasto.getAfecto()) ; 
			initialValues.put("INAFECTO",dordenliquidaciongasto.getInafecto()) ; 
			initialValues.put("PIMPUESTO",dordenliquidaciongasto.getPimpuesto()) ; 
			initialValues.put("IMPUESTO",dordenliquidaciongasto.getImpuesto()) ; 
			initialValues.put("IMPORTE",dordenliquidaciongasto.getImporte()) ; 
			initialValues.put("OTROS",dordenliquidaciongasto.getOtros()) ; 
			initialValues.put("IDCONSUMIDOR",dordenliquidaciongasto.getIdconsumidor()) ; 
			initialValues.put("NUMERO_RCOMPRAS",dordenliquidaciongasto.getNumero_rcompras()) ; 
			initialValues.put("IDMEDIDA",dordenliquidaciongasto.getIdmedida()) ; 
			initialValues.put("IDPRODUCTO",dordenliquidaciongasto.getIdproducto()) ; 
			initialValues.put("ITEMALMACEN",dordenliquidaciongasto.getItemalmacen()) ; 
			initialValues.put("PRODUCTO",dordenliquidaciongasto.getProducto()) ; 
			initialValues.put("VENTANA",dordenliquidaciongasto.getVentana()) ; 
			initialValues.put("CANTIDAD",dordenliquidaciongasto.getCantidad()) ; 
			initialValues.put("IDSIEMBRA",dordenliquidaciongasto.getIdsiembra()) ; 
			initialValues.put("IDCAMPANA",dordenliquidaciongasto.getIdcampana()) ; 
			initialValues.put("IDORDENPRODUCCION",dordenliquidaciongasto.getIdordenproduccion()) ; 
			initialValues.put("IDLOTEPRODUCCION",dordenliquidaciongasto.getIdloteproduccion()) ; 
			resultado = mDb.update("DORDENLIQUIDACIONGASTO",initialValues,where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Boolean delete(String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			resultado = mDb.delete("DORDENLIQUIDACIONGASTO",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	}
}