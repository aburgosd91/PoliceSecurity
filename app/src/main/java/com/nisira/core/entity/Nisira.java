package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "NISIRA")
@XStreamAlias("NISIRA")

public class Nisira implements Serializable {
	@Columna
	@SerializedName("a") 
	@XStreamAlias("A") 
	private String a = "" ;
	@Columna
	@SerializedName("b") 
	@XStreamAlias("B") 
	private String b = "" ;
	@Columna
	@SerializedName("c") 
	@XStreamAlias("C") 
	private String c = "" ;
	@Columna
	@SerializedName("d") 
	@XStreamAlias("D") 
	private String d = "" ;
	@Columna
	@SerializedName("e") 
	@XStreamAlias("E") 
	private String e = "" ;
	@Columna
	@SerializedName("f") 
	@XStreamAlias("F") 
	private String f = "" ;
	@Columna
	@SerializedName("g") 
	@XStreamAlias("G") 
	private String g = "" ;
	@Columna
	@SerializedName("h") 
	@XStreamAlias("H") 
	private String h = "" ;
	@Columna
	@SerializedName("i") 
	@XStreamAlias("I") 
	private String i = "" ;
	@Columna
	@SerializedName("j") 
	@XStreamAlias("J") 
	private String j = "" ;
	@Columna
	@SerializedName("k") 
	@XStreamAlias("K") 
	private String k = "" ;
	@Columna
	@SerializedName("l") 
	@XStreamAlias("L") 
	private String l = "" ;
	@Columna
	@SerializedName("m") 
	@XStreamAlias("M") 
	private String m = "" ;
	@Columna
	@SerializedName("n") 
	@XStreamAlias("N") 
	private String n = "" ;
	@Columna
	@SerializedName("o") 
	@XStreamAlias("O") 
	private String o = "" ;
	@Columna
	@SerializedName("p") 
	@XStreamAlias("P") 
	private String p = "" ;
	@Columna
	@SerializedName("q") 
	@XStreamAlias("Q") 
	private String q = "" ;
	@Columna
	@SerializedName("r") 
	@XStreamAlias("R") 
	private String r = "" ;
	@Columna
	@SerializedName("s") 
	@XStreamAlias("S") 
	private String s = "" ;
	@Columna
	@SerializedName("t") 
	@XStreamAlias("T") 
	private String t = "" ;
	@Columna
	@SerializedName("u") 
	@XStreamAlias("U") 
	private String u = "" ;
	@Columna
	@SerializedName("v") 
	@XStreamAlias("V") 
	private String v = "" ;
	@Columna
	@SerializedName("w") 
	@XStreamAlias("W") 
	private String w = "" ;
	@Columna
	@SerializedName("x") 
	@XStreamAlias("X") 
	private String x = "" ;
	@Columna
	@SerializedName("y") 
	@XStreamAlias("Y") 
	private String y = "" ;
	@Columna
	@SerializedName("z") 
	@XStreamAlias("Z") 
	private String z = "" ;
	@Columna
	@SerializedName("aa") 
	@XStreamAlias("AA") 
	private String aa = "" ;
	@Columna
	@SerializedName("ab") 
	@XStreamAlias("AB") 
	private String ab = "" ;



	/* Sets & Gets */
	public void setA(String a) {
		this.a = a;
	}

	public String getA() {
		return this.a;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getB() {
		return this.b;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getC() {
		return this.c;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getD() {
		return this.d;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getE() {
		return this.e;
	}

	public void setF(String f) {
		this.f = f;
	}

	public String getF() {
		return this.f;
	}

	public void setG(String g) {
		this.g = g;
	}

	public String getG() {
		return this.g;
	}

	public void setH(String h) {
		this.h = h;
	}

	public String getH() {
		return this.h;
	}

	public void setI(String i) {
		this.i = i;
	}

	public String getI() {
		return this.i;
	}

	public void setJ(String j) {
		this.j = j;
	}

	public String getJ() {
		return this.j;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getK() {
		return this.k;
	}

	public void setL(String l) {
		this.l = l;
	}

	public String getL() {
		return this.l;
	}

	public void setM(String m) {
		this.m = m;
	}

	public String getM() {
		return this.m;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getN() {
		return this.n;
	}

	public void setO(String o) {
		this.o = o;
	}

	public String getO() {
		return this.o;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getP() {
		return this.p;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public String getQ() {
		return this.q;
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getR() {
		return this.r;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getS() {
		return this.s;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getT() {
		return this.t;
	}

	public void setU(String u) {
		this.u = u;
	}

	public String getU() {
		return this.u;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getV() {
		return this.v;
	}

	public void setW(String w) {
		this.w = w;
	}

	public String getW() {
		return this.w;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getX() {
		return this.x;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getY() {
		return this.y;
	}

	public void setZ(String z) {
		this.z = z;
	}

	public String getZ() {
		return this.z;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public String getAa() {
		return this.aa;
	}

	public void setAb(String ab) {
		this.ab = ab;
	}

	public String getAb() {
		return this.ab;
	}



	/* Sets & Gets FK*/

}