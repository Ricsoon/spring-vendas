package com.hvendas.sistemavendas.exception;

public class Erro {

	private String msgUser;
	private String msgDev;

	public Erro(String msgUser, String msgDev) {
		this.msgUser = msgUser;
		this.msgDev = msgDev;
	}

	public String getMsgUser() {
		return msgUser;
	}

	public String getMsgDev() {
		return msgDev;
	}

}
