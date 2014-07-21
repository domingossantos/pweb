package br.com.domsantos.common;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class PaginacaoUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

	public static final int TAMTABELA = 10;
	public static final int LIMITEPAGSVIEW = 3;
	public static final String FIRST = "first";
	public static final String LAST = "last";
	
	public static int numeroDaPagina(String pagina, List<Integer> listaPaginas){
		int pag;
		if (pagina == null) {
			pag = 1;
		} else {
			if (pagina.equals("0") || pagina.equals(FIRST)) {
				pag = 1;
			} else {
				if (pagina.equals(LAST)) {
					pag = listaPaginas.get(listaPaginas.size()-1);
				} else {
					pag = Integer.parseInt(pagina);
				}
			}
		}
		return pag;
	}
	public static int reginicial(int pag) {
		return (pag - 1) * TAMTABELA;
	}
	
	public static ArrayList<Integer> listaPaginas(Long count) {
		ArrayList<Integer> listapags = new ArrayList<Integer>();
		try {
			int cont = Integer.parseInt(count.toString());
			int numpags = (int) Math.ceil((double) (cont / (double) (TAMTABELA)));
			
			for (int i = 0; i < numpags; i++) {
				listapags.add(i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return listapags;
	}
	
	public static List<String> listaPaginasView(List<Integer> lista, int paginaSelecionada){
		
		
		int indexitemselec = 0;
		for (Integer i : lista) {
			if(i == paginaSelecionada){
				indexitemselec = lista.indexOf(i);
				break;
			}
		}
		
		ArrayList<String> listapags = new ArrayList<String>();
		
		int limitemin = indexitemselec - LIMITEPAGSVIEW;
		int limitemax = indexitemselec + LIMITEPAGSVIEW;
		int indexlastpag = lista.size()-1;
		
		listapags.add(FIRST);
		if(limitemin >= 0){
			listapags.add("...");
			while(limitemin < indexitemselec){
				listapags.add(""+lista.get(limitemin));
				limitemin++;
			}
		}else{
			while(limitemin < indexitemselec){
				if(limitemin >= 0){
					listapags.add(""+lista.get(limitemin));
				}
				limitemin++;
			}
		}
		
		listapags.add(""+lista.get(indexitemselec));
		
		if(limitemax <= indexlastpag){
			int aux = indexitemselec +1;
			while(aux <= limitemax){
				listapags.add(""+lista.get(aux));
				aux++;
			}
			listapags.add("...");
		}
		else{
			int aux = indexitemselec +1;
			while(aux <= indexlastpag){
				if(aux <= limitemax){
					listapags.add(""+lista.get(aux));
				}
				aux++;
			}
			
		}
		listapags.add(LAST);
		
		return listapags;
	}
	
	
}
