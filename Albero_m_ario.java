package albero_mario;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Albero_m_ario {
	
	private int m;
	private List<Nodo_m_ario<String>> nodi;
	private Nodo_m_ario<String> radice;
	//private int numeroFoglie = 0;
	
	//costruttore
	public Albero_m_ario(int m) {
		this.m = m;
		nodi = new ArrayList<Nodo_m_ario<String>>();
	}
	
	//aggiungo la radice 
	public Nodo_m_ario<String> aggiungiRadice(String info){
		if (radice!=null){
			return null;
		}
		
        radice = new Nodo_m_ario<String>(info);
        //radice.setLivello(0);
        //nodi.add(radice);
        return radice; 
	}
	
	
	//aggiungi una nuova radice, padre della vecchia radice
		public Nodo_m_ario<String> aggiungiAltraRadice(Nodo_m_ario<String> nuovaRadice, int i) {
			
			if(radice == null) {
				return null;
			}
			//for(Nodo_m_ario<String> nodo : nodi) {
				//nodo.aumentaLivello();
			//}
			radice.setPadre(nuovaRadice);
			nuovaRadice.setFiglio(radice, i);
			radice = nuovaRadice;
			//nodi.add(nuovaRadice);		
			return radice;
		}
	
	
	//aggiungo un nuovo nodo
	public Nodo_m_ario<String> aggiungiNodo(Nodo_m_ario<String> U, String info, int i) throws NodoGiaPresenteException {
		if(i > m || i < 1) {
			throw new IllegalArgumentException();
		}
		
		if (U.getFiglio(i) == null) {
			Nodo_m_ario<String> nodo = new Nodo_m_ario<String>(info);
			nodo.setPadre(U);
			U.setFiglio(nodo, i);
			//nodo.setLivello(nodo.getPadre().getLivello() + 1);
			//nodi.add(nodo);
			return nodo;
		} else {
			throw new NodoGiaPresenteException();
		}	
	}
	
	
	
	//ritorna il numero di nodi interni dell'albero
	public int getNodiInterni() {
		
		return getFigliNodiInterni(radice);
	}
	
	
	//ritorna il numero di figli di un nodo v come nodi interni
	public int getFigliNodiInterni(Nodo_m_ario<String> v) {
			
		List<Nodo_m_ario<String>> nodiInterni = new ArrayList<Nodo_m_ario<String>>();
		visitaNodiInterniRicorsiva(v, nodiInterni);
				
		return nodiInterni.size();
	}
	
	
	//ritorna le informazioni dei figli di un nodo, come nodi interni
	public List<String> getInfoFigliNodiInterni(Nodo_m_ario<String> v) {
		
		List<String> infoNodiInterni = new ArrayList<String>();
		List<Nodo_m_ario<String>> nodiInterni = new ArrayList<Nodo_m_ario<String>>();
		visitaNodiInterniRicorsiva(v, nodiInterni);
		
		for(Nodo_m_ario<String> nodo : nodiInterni) {
			infoNodiInterni.add(nodo.getInfo());
		}
		return infoNodiInterni;
	}
 	
	
	private void visitaNodiInterniRicorsiva (Nodo_m_ario<String> v, List<Nodo_m_ario<String>> nodiVisitati) {
		if(v == null || v.getFigli().isEmpty()) {
			return;
		}
		
		nodiVisitati.add(v);
		for(int i = 1; i <= m; i++) {
			visitaNodiInterniRicorsiva(v.getFiglio(i), nodiVisitati);
		}
	}
	
	
	//ritorna il contenuto di un nodo interno
	public String getInfo(Nodo_m_ario<String> v) {
		return v.getInfo();
	}
	
	
	//cambia le info di un nodo intenro
	public void setInfoNodoInterno(Nodo_m_ario<String> v, String i) {
		
		if(v.isNodoInterno()) {
			v.setInfo(i);
		}
	}
	
	
	//ritorna la radice
	public Nodo_m_ario<String> getRadice() { 
		return radice;
	}
	
	
	//ritorna il padre di un nodo
	public Nodo_m_ario<String> getPadre(Nodo_m_ario<String> v) {
		return v.getPadre();
	}
	
	
	//ritorna il numero di foglie dell'albero
	/*public int getFoglie() {
		for(Nodo_m_ario<String> nodo : nodi) {
			if(nodo.getFigli().isEmpty()) {
				numeroFoglie++;
			}
		}
		return numeroFoglie;
	}*/
	
	public int getFoglie() {
		
		return foglieRicorsiva(radice);
	}
	
	
	private int foglieRicorsiva(Nodo_m_ario<String> v) {
		
		if(v == null) {
			return 0;
		}
		
		if(v.getFigli().isEmpty()) {
			return 1;
		} 
		
		int somma = 0;
		for(int i = 1; i <= m; i++) {
			somma += foglieRicorsiva(v.getFiglio(i));
		}
		return somma;
	}
	
	
	
	
	//ritorna il livello di un nodo
	public int getLivello(Nodo_m_ario<String> v) {
		if(v == null) {
			return 0;
		}
		
		return getLivello(v.getPadre()) + 1;
	}
	
	
	//ritorna l'altezza dell'albero
	public int getAltezza() {
		//int max = 0;
		/*for(Nodo_m_ario<String> nodo : nodi) {
			if(nodo.getLivello() > max) {
				max = nodo.getLivello();
			}
		}*/
		return altezzaRicorsiva(radice);
	}
	
	
	private int altezzaRicorsiva(Nodo_m_ario<String> v) {
		if(v == null) {
			return 0;
		}
		
		int max = 0;
		for(int i = 1; i <= m; i++) {
			int altezza = altezzaRicorsiva(v.getFiglio(i));
			if (altezza > max) {
				max = altezza;
			}
		}
		return max + 1;
	}
	
	
	//visita per ampiezza (per livelli)
	
	public List<Nodo_m_ario<String>> visitaInAmpiezza() {
		int i = 0;
		Nodo_m_ario<String> nodo;
		
		List<Nodo_m_ario<String>> nodiVisitati = new LinkedList<Nodo_m_ario<String>>();
		
		nodiVisitati.add(radice);
		while(i < nodiVisitati.size()) {
			nodo = nodiVisitati.get(i);
			for(int j = 1; j <= m; j++) {
				if(nodo.getFiglio(j)!= null)
				nodiVisitati.add(nodo.getFiglio(j));
			}	
			i++;
		}
		return nodiVisitati;	
	}	
	
	
	
	
	//visita in profondità (anticipata)
	
	public List<Nodo_m_ario<String>> visitaInProfondità() {
		
		List<Nodo_m_ario<String>> nodiVisitati = new ArrayList<Nodo_m_ario<String>>();
		visitaRicorsiva(radice, nodiVisitati);
		return nodiVisitati;
	}
 	
	
	private void visitaRicorsiva (Nodo_m_ario<String> v, List<Nodo_m_ario<String>> nodiVisitati) {
		if(v == null) {
			return;
		}
		
		nodiVisitati.add(v);
		for(int i = 1; i <= m; i++) {
			visitaRicorsiva(v.getFiglio(i), nodiVisitati);
		}
	}
	
	
	public String getNodi() {
		String s = "";
		for(Nodo_m_ario<String> nodo : nodi) {
			s += "Nodo " + nodo.getInfo() + "\n";
		}
		return s;
	}
}
