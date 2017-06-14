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

public class DocumentosDao extends BaseDao<Documentos> {
	public DocumentosDao() {
		super(Documentos.class);
	}
	public DocumentosDao(boolean usaCnBase) throws Exception {
		super(Documentos.class, usaCnBase);
	}
	public void mezclarLocal(Documentos obj)throws Exception{
		List<Documentos> lst= listar("LTRIM(RTRIM(t0.IDEMPRESA)) =? AND LTRIM(RTRIM(t0.IDDOCUMENTO))=?",obj.getIdempresa().trim(),obj.getIddocumento().trim());
		if(lst.isEmpty())
			insertar(obj);
		else
			actualizar(obj);
	}
	public List<Documentos> listar_comprobantes()throws  Exception{
		List<Documentos> lst = listar("LTRIM(RTRIM(t0.CODIGO_SUNAT))!= ? ","");
		if(lst.isEmpty())
			return null;
		else
			return lst;
	}
	public List<Documentos> listar_xID(String ID)throws  Exception{
		List<Documentos> lst = listar("LTRIM(RTRIM(t0.IDDOCUMENTO))!= ? ",ID);
		if(lst.isEmpty())
			return null;
		else
			return lst;
	}
	public Boolean insert(Documentos documentos) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",documentos.getIdempresa()); 
			initialValues.put("IDDOCUMENTO",documentos.getIddocumento()); 
			initialValues.put("DESCRIPCION",documentos.getDescripcion()); 
			initialValues.put("CODIGO_SUNAT",documentos.getCodigo_sunat()); 
			initialValues.put("ES_HONORARIOS",documentos.getEs_honorarios()); 
			initialValues.put("ES_IMPORTACION",documentos.getEs_importacion()); 
			initialValues.put("INCLUIR_CRONOGRAMA",documentos.getIncluir_cronograma()); 
			initialValues.put("PIDE_REFERENCIA",documentos.getPide_referencia()); 
			initialValues.put("REGISTRAR_EN",documentos.getRegistrar_en()); 
			initialValues.put("ESTADO",documentos.getEstado()); 
			initialValues.put("SINCRONIZA",documentos.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(documentos.getFechacreacion() ) ); 
			initialValues.put("FACTOR",documentos.getFactor()); 
			initialValues.put("INCLUIR_IGV",documentos.getIncluir_igv()); 
			initialValues.put("MOSTRAR_EN",documentos.getMostrar_en()); 
			initialValues.put("RETENER_IGV",documentos.getRetener_igv()); 
			initialValues.put("ES_4TA5TA",documentos.getEs_4ta5ta()); 
			initialValues.put("NUM_GRANDE",documentos.getNum_grande()); 
			initialValues.put("ES_RRHH",documentos.getEs_rrhh()); 
			initialValues.put("RETENER_ODOC",documentos.getRetener_odoc()); 
			initialValues.put("SOLO_IMPUESTO",documentos.getSolo_impuesto()); 
			initialValues.put("SIN_IGV",documentos.getSin_igv()); 
			initialValues.put("PIDE_DOCCOMPRA",documentos.getPide_doccompra()); 
			initialValues.put("IDREGISTRO_SUNAT",documentos.getIdregistro_sunat()); 
			initialValues.put("PARA_DECLARACION",documentos.getPara_declaracion()); 
			initialValues.put("ES_LEASING",documentos.getEs_leasing()); 
			initialValues.put("ES_NODOMICILIADO",documentos.getEs_nodomiciliado()); 
			initialValues.put("ES_NOEMITIDO",documentos.getEs_noemitido()); 
			initialValues.put("ES_ELECTRONICO",documentos.getEs_electronico()); 
			initialValues.put("INICIAL_DOCELECTRONICO",documentos.getInicial_docelectronico()); 
			initialValues.put("INCLUIR_DOCAN_COMPRA_LE",documentos.getIncluir_docan_compra_le()); 
			initialValues.put("IDTIPOTITULO_SUNAT",documentos.getIdtipotitulo_sunat()); 
			initialValues.put("ES_DIETA",documentos.getEs_dieta()); 
			initialValues.put("PARA_PPAGO",documentos.getPara_ppago()); 
			initialValues.put("NO_CTACTEASIENTO",documentos.getNo_ctacteasiento()); 
			resultado = mDb.insert("DOCUMENTOS",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Documentos documentos,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",documentos.getIdempresa()) ; 
			initialValues.put("IDDOCUMENTO",documentos.getIddocumento()) ; 
			initialValues.put("DESCRIPCION",documentos.getDescripcion()) ; 
			initialValues.put("CODIGO_SUNAT",documentos.getCodigo_sunat()) ; 
			initialValues.put("ES_HONORARIOS",documentos.getEs_honorarios()) ; 
			initialValues.put("ES_IMPORTACION",documentos.getEs_importacion()) ; 
			initialValues.put("INCLUIR_CRONOGRAMA",documentos.getIncluir_cronograma()) ; 
			initialValues.put("PIDE_REFERENCIA",documentos.getPide_referencia()) ; 
			initialValues.put("REGISTRAR_EN",documentos.getRegistrar_en()) ; 
			initialValues.put("ESTADO",documentos.getEstado()) ; 
			initialValues.put("SINCRONIZA",documentos.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(documentos.getFechacreacion() ) ) ; 
			initialValues.put("FACTOR",documentos.getFactor()) ; 
			initialValues.put("INCLUIR_IGV",documentos.getIncluir_igv()) ; 
			initialValues.put("MOSTRAR_EN",documentos.getMostrar_en()) ; 
			initialValues.put("RETENER_IGV",documentos.getRetener_igv()) ; 
			initialValues.put("ES_4TA5TA",documentos.getEs_4ta5ta()) ; 
			initialValues.put("NUM_GRANDE",documentos.getNum_grande()) ; 
			initialValues.put("ES_RRHH",documentos.getEs_rrhh()) ; 
			initialValues.put("RETENER_ODOC",documentos.getRetener_odoc()) ; 
			initialValues.put("SOLO_IMPUESTO",documentos.getSolo_impuesto()) ; 
			initialValues.put("SIN_IGV",documentos.getSin_igv()) ; 
			initialValues.put("PIDE_DOCCOMPRA",documentos.getPide_doccompra()) ; 
			initialValues.put("IDREGISTRO_SUNAT",documentos.getIdregistro_sunat()) ; 
			initialValues.put("PARA_DECLARACION",documentos.getPara_declaracion()) ; 
			initialValues.put("ES_LEASING",documentos.getEs_leasing()) ; 
			initialValues.put("ES_NODOMICILIADO",documentos.getEs_nodomiciliado()) ; 
			initialValues.put("ES_NOEMITIDO",documentos.getEs_noemitido()) ; 
			initialValues.put("ES_ELECTRONICO",documentos.getEs_electronico()) ; 
			initialValues.put("INICIAL_DOCELECTRONICO",documentos.getInicial_docelectronico()) ; 
			initialValues.put("INCLUIR_DOCAN_COMPRA_LE",documentos.getIncluir_docan_compra_le()) ; 
			initialValues.put("IDTIPOTITULO_SUNAT",documentos.getIdtipotitulo_sunat()) ; 
			initialValues.put("ES_DIETA",documentos.getEs_dieta()) ; 
			initialValues.put("PARA_PPAGO",documentos.getPara_ppago()) ; 
			initialValues.put("NO_CTACTEASIENTO",documentos.getNo_ctacteasiento()) ; 
			resultado = mDb.update("DOCUMENTOS",initialValues,where,null)>0; 
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
			resultado = mDb.delete("DOCUMENTOS",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Documentos> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Documentos> lista  = new ArrayList<Documentos>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("DOCUMENTOS",
					new String[] {
							 "IDEMPRESA" ,
							 "IDDOCUMENTO" ,
							 "DESCRIPCION" ,
							 "CODIGO_SUNAT" ,
							 "ES_HONORARIOS" ,
							 "ES_IMPORTACION" ,
							 "INCLUIR_CRONOGRAMA" ,
							 "PIDE_REFERENCIA" ,
							 "REGISTRAR_EN" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "FACTOR" ,
							 "INCLUIR_IGV" ,
							 "MOSTRAR_EN" ,
							 "RETENER_IGV" ,
							 "ES_4TA5TA" ,
							 "NUM_GRANDE" ,
							 "ES_RRHH" ,
							 "RETENER_ODOC" ,
							 "SOLO_IMPUESTO" ,
							 "SIN_IGV" ,
							 "PIDE_DOCCOMPRA" ,
							 "IDREGISTRO_SUNAT" ,
							 "PARA_DECLARACION" ,
							 "ES_LEASING" ,
							 "ES_NODOMICILIADO" ,
							 "ES_NOEMITIDO" ,
							 "ES_ELECTRONICO" ,
							 "INICIAL_DOCELECTRONICO" ,
							 "INCLUIR_DOCAN_COMPRA_LE" ,
							 "IDTIPOTITULO_SUNAT" ,
							 "ES_DIETA" ,
							 "PARA_PPAGO" ,
							 "NO_CTACTEASIENTO" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Documentos documentos = new Documentos() ;
					documentos.setIdempresa(cur.getString(j++));
					documentos.setIddocumento(cur.getString(j++));
					documentos.setDescripcion(cur.getString(j++));
					documentos.setCodigo_sunat(cur.getString(j++));
					documentos.setEs_honorarios(cur.getDouble(j++));
					documentos.setEs_importacion(cur.getDouble(j++));
					documentos.setIncluir_cronograma(cur.getDouble(j++));
					documentos.setPide_referencia(cur.getDouble(j++));
					documentos.setRegistrar_en(cur.getString(j++));
					documentos.setEstado(cur.getDouble(j++));
					documentos.setSincroniza(cur.getString(j++));
					documentos.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					documentos.setFactor(cur.getDouble(j++));
					documentos.setIncluir_igv(cur.getDouble(j++));
					documentos.setMostrar_en(cur.getString(j++));
					documentos.setRetener_igv(cur.getDouble(j++));
					documentos.setEs_4ta5ta(cur.getDouble(j++));
					documentos.setNum_grande(cur.getDouble(j++));
					documentos.setEs_rrhh(cur.getDouble(j++));
					documentos.setRetener_odoc(cur.getDouble(j++));
					documentos.setSolo_impuesto(cur.getDouble(j++));
					documentos.setSin_igv(cur.getDouble(j++));
					documentos.setPide_doccompra(cur.getDouble(j++));
					documentos.setIdregistro_sunat(cur.getString(j++));
					documentos.setPara_declaracion(cur.getDouble(j++));
					documentos.setEs_leasing(cur.getDouble(j++));
					documentos.setEs_nodomiciliado(cur.getDouble(j++));
					documentos.setEs_noemitido(cur.getDouble(j++));
					documentos.setEs_electronico(cur.getDouble(j++));
					documentos.setInicial_docelectronico(cur.getString(j++));
					documentos.setIncluir_docan_compra_le(cur.getDouble(j++));
					documentos.setIdtipotitulo_sunat(cur.getString(j++));
					documentos.setEs_dieta(cur.getDouble(j++));
					documentos.setPara_ppago(cur.getDouble(j++));
					documentos.setNo_ctacteasiento(cur.getDouble(j++));

					lista.add(documentos); 
					i++; 
					if(i == limit){ 
						break; 
					} 
					cur.moveToNext(); 
				} 
				cur.close(); 
			} 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return lista; 
	} 
}