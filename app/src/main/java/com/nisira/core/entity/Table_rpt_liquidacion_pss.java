package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "TABLE_RPT_LIQUIDACION_PSS")
@XStreamAlias("TABLE_RPT_LIQUIDACION_PSS")

public class Table_rpt_liquidacion_pss implements Serializable {
	@Columna
	@SerializedName("campo1") 
	@XStreamAlias("CAMPO1") 
	private String campo1 = "" ;
	@Columna
	@SerializedName("campo2") 
	@XStreamAlias("CAMPO2") 
	private String campo2 = "" ;
	@Columna
	@SerializedName("campo3") 
	@XStreamAlias("CAMPO3") 
	private String campo3 = "" ;
	@Columna
	@SerializedName("campo4") 
	@XStreamAlias("CAMPO4") 
	private String campo4 = "" ;
	@Columna
	@SerializedName("campo5") 
	@XStreamAlias("CAMPO5") 
	private String campo5 = "" ;
	@Columna
	@SerializedName("campo6") 
	@XStreamAlias("CAMPO6") 
	private String campo6 = "" ;
	@Columna
	@SerializedName("campo7") 
	@XStreamAlias("CAMPO7") 
	private String campo7 = "" ;
	@Columna
	@SerializedName("campo8") 
	@XStreamAlias("CAMPO8") 
	private String campo8 = "" ;
	@Columna
	@SerializedName("campo9") 
	@XStreamAlias("CAMPO9") 
	private String campo9 = "" ;
	@Columna
	@SerializedName("campo10") 
	@XStreamAlias("CAMPO10") 
	private String campo10 = "" ;
	@Columna
	@SerializedName("campo11") 
	@XStreamAlias("CAMPO11") 
	private String campo11 = "" ;
	@Columna
	@SerializedName("campo12") 
	@XStreamAlias("CAMPO12") 
	private String campo12 = "" ;
	@Columna
	@SerializedName("campo13") 
	@XStreamAlias("CAMPO13") 
	private String campo13 = "" ;
	@Columna
	@SerializedName("campo14") 
	@XStreamAlias("CAMPO14") 
	private String campo14 = "" ;
	@Columna
	@SerializedName("campo15") 
	@XStreamAlias("CAMPO15") 
	private String campo15 = "" ;



	/* Sets & Gets */
	public void setCampo1(String campo1) {
		this.campo1 = campo1;
	}

	public String getCampo1() {
		return this.campo1;
	}

	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}

	public String getCampo2() {
		return this.campo2;
	}

	public void setCampo3(String campo3) {
		this.campo3 = campo3;
	}

	public String getCampo3() {
		return this.campo3;
	}

	public void setCampo4(String campo4) {
		this.campo4 = campo4;
	}

	public String getCampo4() {
		return this.campo4;
	}

	public void setCampo5(String campo5) {
		this.campo5 = campo5;
	}

	public String getCampo5() {
		return this.campo5;
	}

	public void setCampo6(String campo6) {
		this.campo6 = campo6;
	}

	public String getCampo6() {
		return this.campo6;
	}

	public void setCampo7(String campo7) {
		this.campo7 = campo7;
	}

	public String getCampo7() {
		return this.campo7;
	}

	public void setCampo8(String campo8) {
		this.campo8 = campo8;
	}

	public String getCampo8() {
		return this.campo8;
	}

	public void setCampo9(String campo9) {
		this.campo9 = campo9;
	}

	public String getCampo9() {
		return this.campo9;
	}

	public void setCampo10(String campo10) {
		this.campo10 = campo10;
	}

	public String getCampo10() {
		return this.campo10;
	}

	public void setCampo11(String campo11) {
		this.campo11 = campo11;
	}

	public String getCampo11() {
		return this.campo11;
	}

	public void setCampo12(String campo12) {
		this.campo12 = campo12;
	}

	public String getCampo12() {
		return this.campo12;
	}

	public void setCampo13(String campo13) {
		this.campo13 = campo13;
	}

	public String getCampo13() {
		return this.campo13;
	}

	public void setCampo14(String campo14) {
		this.campo14 = campo14;
	}

	public String getCampo14() {
		return this.campo14;
	}

	public void setCampo15(String campo15) {
		this.campo15 = campo15;
	}

	public String getCampo15() {
		return this.campo15;
	}



	/* Sets & Gets FK*/

}