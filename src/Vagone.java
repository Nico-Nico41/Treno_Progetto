
public class Vagone {
	
	private int numPostiOccupati, numPostiMax, tipoClasse;
	private String matricola;

	public Vagone(int numPostiOccupati, int numPostiMax, String matricola, int tipoClasse) {
		// TODO Auto-generated constructor stub
		
		this.numPostiOccupati = numPostiOccupati;
		this.numPostiMax = numPostiMax;
		this.matricola = matricola;
		this.tipoClasse = tipoClasse;
		
	}
	
	public int getNumPostiMax() {
		return numPostiMax;
	}

	public void setNumPostiMax(int numPostiMax) {
		this.numPostiMax = numPostiMax;
	}

	public int getTipoClasse() {
		return tipoClasse;
	}

	public void setTipoClasse(int tipoClasse) {
		this.tipoClasse = tipoClasse;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public int getNumPostiOccupati() {
		return numPostiOccupati;
	}
	
	public void setNumPostiOccupati(int numPostiOccupati) {
		this.numPostiOccupati = numPostiOccupati;
	}
	
	
	@Override
	public String toString() {
		return "Vagone [numPostiOccupati=" + numPostiOccupati + ", numPostiMax=" + numPostiMax + ", tipoClasse="
				+ tipoClasse + ", matricola=" + matricola + "]";
	}

	public static void main(String[] args) {
		
		Vagone v1 = new Vagone(100, 20, "Fiat", 1);
		
		System.out.println(v1.toString());
	}

}
