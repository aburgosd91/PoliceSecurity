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

public class ContactosclieprovDao extends BaseDao<Contactosclieprov> {
	public ContactosclieprovDao() {
		super(Contactosclieprov.class);
	}
	public ContactosclieprovDao(boolean usaCnBase) throws Exception {
		super(Contactosclieprov.class, usaCnBase);
	}

	public Boolean insert(Contactosclieprov contactosclieprov) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",contactosclieprov.getIdempresa()); 
			initialValues.put("IDCLIEPROV",contactosclieprov.getIdclieprov()); 
			initialValues.put("ITEM",contactosclieprov.getItem()); 
			initialValues.put("NOMBRE",contactosclieprov.getNombre()); 
			initialValues.put("DIRECCION",contactosclieprov.getDireccion()); 
			initialValues.put("TELEFONO1",contactosclieprov.getTelefono1()); 
			initialValues.put("TELEFONO2",contactosclieprov.getTelefono2()); 
			initialValues.put("TELEFONO3",contactosclieprov.getTelefono3()); 
			initialValues.put("EMAIL",contactosclieprov.getEmail()); 
			initialValues.put("PREDETERMINADO",contactosclieprov.getPredeterminado()); 
			initialValues.put("ESTADO",contactosclieprov.getEstado()); 
			initialValues.put("SINCRONIZA",contactosclieprov.getSincroniza()); 
			initialValues.put("FECHACREACION",dateFormat.format(contactosclieprov.getFechacreacion() ) ); 
			initialValues.put("IDCARGO",contactosclieprov.getIdcargo()); 
			initialValues.put("DNI",contactosclieprov.getDni()); 
			initialValues.put("APELLIDOPATERNO",contactosclieprov.getApellidopaterno()); 
			initialValues.put("APELLIDOMATERNO",contactosclieprov.getApellidomaterno()); 
			initialValues.put("SEXO",contactosclieprov.getSexo()); 
			initialValues.put("FECHA_NACIMIENTO",dateFormat.format(contactosclieprov.getFecha_nacimiento() ) ); 
			initialValues.put("DIRECCION_NUMERO",contactosclieprov.getDireccion_numero()); 
			initialValues.put("IDUBIGEO",contactosclieprov.getIdubigeo()); 
			initialValues.put("IDESTADOCIVIL",contactosclieprov.getIdestadocivil()); 
			initialValues.put("TELEFONO4",contactosclieprov.getTelefono4()); 
			initialValues.put("TELEFONO5",contactosclieprov.getTelefono5()); 
			initialValues.put("HORAPREF",contactosclieprov.getHorapref()); 
			initialValues.put("MODOCONTACTO",contactosclieprov.getModocontacto()); 
			initialValues.put("CARGO",contactosclieprov.getCargo()); 
			initialValues.put("ESPROPIETARIO",contactosclieprov.getEspropietario()); 
			initialValues.put("HORAPREFH",contactosclieprov.getHoraprefh()); 
			resultado = mDb.insert("CONTACTOSCLIEPROV",null,initialValues)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public Boolean update(Contactosclieprov contactosclieprov,String where) {
		Boolean resultado = false;
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues initialValues = new ContentValues();
			initialValues.put("IDEMPRESA",contactosclieprov.getIdempresa()) ; 
			initialValues.put("IDCLIEPROV",contactosclieprov.getIdclieprov()) ; 
			initialValues.put("ITEM",contactosclieprov.getItem()) ; 
			initialValues.put("NOMBRE",contactosclieprov.getNombre()) ; 
			initialValues.put("DIRECCION",contactosclieprov.getDireccion()) ; 
			initialValues.put("TELEFONO1",contactosclieprov.getTelefono1()) ; 
			initialValues.put("TELEFONO2",contactosclieprov.getTelefono2()) ; 
			initialValues.put("TELEFONO3",contactosclieprov.getTelefono3()) ; 
			initialValues.put("EMAIL",contactosclieprov.getEmail()) ; 
			initialValues.put("PREDETERMINADO",contactosclieprov.getPredeterminado()) ; 
			initialValues.put("ESTADO",contactosclieprov.getEstado()) ; 
			initialValues.put("SINCRONIZA",contactosclieprov.getSincroniza()) ; 
			initialValues.put("FECHACREACION",dateFormat.format(contactosclieprov.getFechacreacion() ) ) ; 
			initialValues.put("IDCARGO",contactosclieprov.getIdcargo()) ; 
			initialValues.put("DNI",contactosclieprov.getDni()) ; 
			initialValues.put("APELLIDOPATERNO",contactosclieprov.getApellidopaterno()) ; 
			initialValues.put("APELLIDOMATERNO",contactosclieprov.getApellidomaterno()) ; 
			initialValues.put("SEXO",contactosclieprov.getSexo()) ; 
			initialValues.put("FECHA_NACIMIENTO",dateFormat.format(contactosclieprov.getFecha_nacimiento() ) ) ; 
			initialValues.put("DIRECCION_NUMERO",contactosclieprov.getDireccion_numero()) ; 
			initialValues.put("IDUBIGEO",contactosclieprov.getIdubigeo()) ; 
			initialValues.put("IDESTADOCIVIL",contactosclieprov.getIdestadocivil()) ; 
			initialValues.put("TELEFONO4",contactosclieprov.getTelefono4()) ; 
			initialValues.put("TELEFONO5",contactosclieprov.getTelefono5()) ; 
			initialValues.put("HORAPREF",contactosclieprov.getHorapref()) ; 
			initialValues.put("MODOCONTACTO",contactosclieprov.getModocontacto()) ; 
			initialValues.put("CARGO",contactosclieprov.getCargo()) ; 
			initialValues.put("ESPROPIETARIO",contactosclieprov.getEspropietario()) ; 
			initialValues.put("HORAPREFH",contactosclieprov.getHoraprefh()) ; 
			resultado = mDb.update("CONTACTOSCLIEPROV",initialValues,where,null)>0; 
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
			resultado = mDb.delete("CONTACTOSCLIEPROV",where,null)>0; 
		} catch (Exception e) {
		}finally {
			mDb.close();
		} 
		return resultado; 
	} 

	public ArrayList<Contactosclieprov> listar(String where,String order,Integer limit) {
		if(limit == null){
			limit =0;
		}
		ArrayList<Contactosclieprov> lista  = new ArrayList<Contactosclieprov>();
		SQLiteDatabase mDb  = SQLiteDatabase.openDatabase(DataBaseClass.PATH_DATABASE,null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
		try{
			Cursor cur =  mDb.query("CONTACTOSCLIEPROV",
					new String[] {
							 "IDEMPRESA" ,
							 "IDCLIEPROV" ,
							 "ITEM" ,
							 "NOMBRE" ,
							 "DIRECCION" ,
							 "TELEFONO1" ,
							 "TELEFONO2" ,
							 "TELEFONO3" ,
							 "EMAIL" ,
							 "PREDETERMINADO" ,
							 "ESTADO" ,
							 "SINCRONIZA" ,
							 "FECHACREACION" ,
							 "IDCARGO" ,
							 "DNI" ,
							 "APELLIDOPATERNO" ,
							 "APELLIDOMATERNO" ,
							 "SEXO" ,
							 "FECHA_NACIMIENTO" ,
							 "DIRECCION_NUMERO" ,
							 "IDUBIGEO" ,
							 "IDESTADOCIVIL" ,
							 "TELEFONO4" ,
							 "TELEFONO5" ,
							 "HORAPREF" ,
							 "MODOCONTACTO" ,
							 "CARGO" ,
							 "ESPROPIETARIO" ,
							 "HORAPREFH" 
					},
			where, null, null, null, order);
			if (cur!=null){
				cur.moveToFirst();
				int i=0;
				while (cur.isAfterLast() == false) {
					int j=0;
					Contactosclieprov contactosclieprov = new Contactosclieprov() ;
					contactosclieprov.setIdempresa(cur.getString(j++));
					contactosclieprov.setIdclieprov(cur.getString(j++));
					contactosclieprov.setItem(cur.getString(j++));
					contactosclieprov.setNombre(cur.getString(j++));
					contactosclieprov.setDireccion(cur.getString(j++));
					contactosclieprov.setTelefono1(cur.getString(j++));
					contactosclieprov.setTelefono2(cur.getString(j++));
					contactosclieprov.setTelefono3(cur.getString(j++));
					contactosclieprov.setEmail(cur.getString(j++));
					contactosclieprov.setPredeterminado(cur.getDouble(j++));
					contactosclieprov.setEstado(cur.getDouble(j++));
					contactosclieprov.setSincroniza(cur.getString(j++));
					contactosclieprov.setFechacreacion(dateFormat.parse(cur.getString(j++)) );
					contactosclieprov.setIdcargo(cur.getString(j++));
					contactosclieprov.setDni(cur.getString(j++));
					contactosclieprov.setApellidopaterno(cur.getString(j++));
					contactosclieprov.setApellidomaterno(cur.getString(j++));
					contactosclieprov.setSexo(cur.getString(j++));
					contactosclieprov.setFecha_nacimiento(dateFormat.parse(cur.getString(j++)) );
					contactosclieprov.setDireccion_numero(cur.getDouble(j++));
					contactosclieprov.setIdubigeo(cur.getString(j++));
					contactosclieprov.setIdestadocivil(cur.getString(j++));
					contactosclieprov.setTelefono4(cur.getString(j++));
					contactosclieprov.setTelefono5(cur.getString(j++));
					contactosclieprov.setHorapref(cur.getString(j++));
					contactosclieprov.setModocontacto(cur.getString(j++));
					contactosclieprov.setCargo(cur.getString(j++));
					contactosclieprov.setEspropietario(cur.getDouble(j++));
					contactosclieprov.setHoraprefh(cur.getString(j++));

					lista.add(contactosclieprov); 
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