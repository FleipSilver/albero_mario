package albero_mario;

import java.util.HashMap;

public class Nodo_m_ario<T> {

	private T info;
	private Nodo_m_ario<T> padre;
	private HashMap<Integer, Nodo_m_ario<T>> figli;
	//private int livello;
	
	public Nodo_m_ario(T info) {
		this.info = info;
		figli = new HashMap<Integer, Nodo_m_ario<T>>();
	}
	
	
	//ritorna i figli di un nodo
	public HashMap<Integer, Nodo_m_ario<T>> getFigli() {
		
		return figli;
	}
	
	public Nodo_m_ario<T> getFiglio(int i) {
		return figli.get(i);
	}
	
	public void setFiglio(Nodo_m_ario<T> v, int i) {
		figli.put(i, v);
	}
	
	
	//ritorna true se il nodo su cui è invocato il metodo è un nodo interno, false altrimenti
	public boolean isNodoInterno() {
		
		if(figli.isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	//ritorna le info del nodo su cui è invocato il metodo
	public T getInfo() {
		
		return info;
	}
	
	
	//cambia il contento di un nodo interno
	public void setInfo(T info) {
		this.info = info;
	}
	
	
	public void setPadre(Nodo_m_ario<T> padre) {
		this.padre = padre;
	}
	
	public Nodo_m_ario<T> getPadre() {
		return padre;
	}
	
	/*
	public void setLivello(int livello) {
		this.livello = livello;
	}
	
	public int getLivello() {
		return livello;
	}
	
	public void aumentaLivello() {
		this.livello += 1;
	}*/
}
