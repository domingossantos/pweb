package br.com.domsantos.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FuncoesUteis {

	public static String limpaCaracter(String campo) {
		campo = campo.replace(".", "");
		campo = campo.replace("-", "");
		campo = campo.replace("/", "");
		campo = campo.replace("(", "");
		campo = campo.replace(")", "");
		campo = campo.replace(" ", "");
		return campo;
	}

	public static String cifraString(String campo) {
		MessageDigest MD;
		String senhaCifrada = "";
		try {
			MD = MessageDigest.getInstance("MD5");
			MD.update(campo.getBytes(), 0, campo.length());

			senhaCifrada = new BigInteger(1, MD.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return senhaCifrada;
	}

	public static Date converteStringToDataDDMMYYYY(String data) {
		Date dataFormatada = null;
		if (data != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"dd/MM/yyyy");
			try {
				dataFormatada = simpleDateFormat.parse(data);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dataFormatada = null;
			}
		}
		return dataFormatada;
	}

	public static String converteDataToStringDDMMYYYY(Date data) {
		String dataFormatada = null;
		if (data != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"dd/MM/yyyy");
			dataFormatada = simpleDateFormat.format(data);
		}
		return dataFormatada;
	}

	public static String recuperaAnoString(Date data) {
		String dataFormatada = null;
		if (data != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
			dataFormatada = simpleDateFormat.format(data);
		}
		return dataFormatada;
	}

	public static String converteDataToStringExtenso(Date data) {
		String dataFormatada = null;
		if (data != null) {
			Locale locale = new Locale("pt", "BR");
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"EEEEEE ',' dd ' de 'MMMM ' de ' yyyy", locale);
			dataFormatada = simpleDateFormat.format(data);
		}
		return dataFormatada;
	}

	public static Calendar getDataCorrentePt_BR() {
		Locale locale = new Locale("pt", "BR");
		return Calendar.getInstance(locale);
	}

}
