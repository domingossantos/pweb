package br.com.domsantos.common;

import java.util.Collection;


public class TagBiblioteca {

	public static boolean contem(Collection col, Object o){
		return col.contains(o);		 
	}
	
	public static String maskMatricula(String matricula){
		return matricula.substring(0,7)+"-"+matricula.substring(7,10);
	}
	
	public static String maskCPFCNPJ(String cpfcnpj){
		String resp = "";
		cpfcnpj = cpfcnpj.trim();
		if(cpfcnpj.length() == 11){
			resp = cpfcnpj.substring(0,3)+"."+cpfcnpj.substring(3,6)+"."+cpfcnpj.substring(6,9)+"-"+cpfcnpj.substring(9,11);
		}else{
			if(cpfcnpj.length() == 14){
				resp = cpfcnpj.substring(0,2)+"."+cpfcnpj.substring(2,5)+"."+cpfcnpj.substring(5,8)+"/"+cpfcnpj.substring(8,12)+"-"+cpfcnpj.substring(12,14);
			}
		}
		return resp;
	}
}
