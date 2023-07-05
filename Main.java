package albero_mario;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws NodoGiaPresenteException {
		
		Albero_m_ario albero1 = new Albero_m_ario(2);
		
		Nodo_m_ario<String> a = albero1.aggiungiRadice("a");
		
		Nodo_m_ario<String> b = albero1.aggiungiNodo(a, "b", 1);
		
		Nodo_m_ario<String> c = albero1.aggiungiNodo(a, "c", 2);
		
		Nodo_m_ario<String> d = albero1.aggiungiNodo(b, "d", 2);
		
		Nodo_m_ario<String> g = albero1.aggiungiNodo(d, "g", 1);
		
		Nodo_m_ario<String> h = albero1.aggiungiNodo(d, "h", 2);
		
		Nodo_m_ario<String> e = albero1.aggiungiNodo(c, "e", 1);
		
		Nodo_m_ario<String> f = albero1.aggiungiNodo(c, "f", 2);
		
		Nodo_m_ario<String> i = albero1.aggiungiNodo(f, "i", 1);
		
		System.out.println("Altezza: " + albero1.getAltezza());
		
		System.out.println("Foglie: " + albero1.getFoglie());
		
		System.out.println("Nodi interni: " + albero1.getNodiInterni());
		
		//System.out.println("Nodi interni di a: " + albero1.getFigliNodiInterni(a));  //errore
		
		//System.out.println("Info figli di a: " + albero1.getInfoFigliNodiInterni(i)); //errore

		//System.out.println(albero1.getNodi());
		
		
		//for(Nodo_m_ario<String> nodo : albero1.visitaInAmpiezza()) {
		//	System.out.println("Nodo " + nodo.getInfo());
		//}
		
		
		for(Nodo_m_ario<String> nodo : albero1.visitaInAmpiezza()) {
			System.out.println("Nodo " + nodo.getInfo());
		}
	}

}
