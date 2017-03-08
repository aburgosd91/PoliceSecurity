package com.nisira.core.entity;

import com.nisira.annotation.ClavePrimaria;
import com.nisira.annotation.Columna;
import com.nisira.annotation.Tabla;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

import java.util.ArrayList;

@Tabla(nombre = "CONFIGSMTP")
@XStreamAlias("CONFIGSMTP")

public class Configsmtp implements Serializable {
	@ClavePrimaria
	@Columna
	@SerializedName("id") 
	@XStreamAlias("ID") 
	private String id = "" ;
	@Columna
	@SerializedName("mail_smtp_host") 
	@XStreamAlias("MAIL_SMTP_HOST") 
	private String mail_smtp_host = "" ;
	@Columna
	@SerializedName("mail_smtp_starttls_enable") 
	@XStreamAlias("MAIL_SMTP_STARTTLS_ENABLE") 
	private String mail_smtp_starttls_enable = "" ;
	@Columna
	@SerializedName("mail_smtp_port") 
	@XStreamAlias("MAIL_SMTP_PORT") 
	private String mail_smtp_port = "" ;
	@Columna
	@SerializedName("mail_smtp_mail_sender") 
	@XStreamAlias("MAIL_SMTP_MAIL_SENDER") 
	private String mail_smtp_mail_sender = "" ;
	@Columna
	@SerializedName("mail_smtp_user") 
	@XStreamAlias("MAIL_SMTP_USER") 
	private String mail_smtp_user = "" ;
	@Columna
	@SerializedName("mail_smtp_auth") 
	@XStreamAlias("MAIL_SMTP_AUTH") 
	private String mail_smtp_auth = "" ;
	@Columna
	@SerializedName("mail_smtp_password") 
	@XStreamAlias("MAIL_SMTP_PASSWORD") 
	private String mail_smtp_password = "" ;
	@Columna
	@SerializedName("asunto") 
	@XStreamAlias("ASUNTO") 
	private String asunto = "" ;
	@Columna
	@SerializedName("mensaje") 
	@XStreamAlias("MENSAJE") 
	private String mensaje = "" ;



	/* Sets & Gets */
	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setMail_smtp_host(String mail_smtp_host) {
		this.mail_smtp_host = mail_smtp_host;
	}

	public String getMail_smtp_host() {
		return this.mail_smtp_host;
	}

	public void setMail_smtp_starttls_enable(String mail_smtp_starttls_enable) {
		this.mail_smtp_starttls_enable = mail_smtp_starttls_enable;
	}

	public String getMail_smtp_starttls_enable() {
		return this.mail_smtp_starttls_enable;
	}

	public void setMail_smtp_port(String mail_smtp_port) {
		this.mail_smtp_port = mail_smtp_port;
	}

	public String getMail_smtp_port() {
		return this.mail_smtp_port;
	}

	public void setMail_smtp_mail_sender(String mail_smtp_mail_sender) {
		this.mail_smtp_mail_sender = mail_smtp_mail_sender;
	}

	public String getMail_smtp_mail_sender() {
		return this.mail_smtp_mail_sender;
	}

	public void setMail_smtp_user(String mail_smtp_user) {
		this.mail_smtp_user = mail_smtp_user;
	}

	public String getMail_smtp_user() {
		return this.mail_smtp_user;
	}

	public void setMail_smtp_auth(String mail_smtp_auth) {
		this.mail_smtp_auth = mail_smtp_auth;
	}

	public String getMail_smtp_auth() {
		return this.mail_smtp_auth;
	}

	public void setMail_smtp_password(String mail_smtp_password) {
		this.mail_smtp_password = mail_smtp_password;
	}

	public String getMail_smtp_password() {
		return this.mail_smtp_password;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return this.mensaje;
	}



	/* Sets & Gets FK*/

}