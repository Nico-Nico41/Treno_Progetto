/**
 * @version 1 
 * @version 2
 * @version 3 online
 */

import java.util.Arrays;
import java.util.*;
//modificato online
public class Treno {
	//modificato online 2
	private Vagone listaVagoni[];
	private int numVagPresenti, numVagMax;
	private String nomeTreno;

	public Treno(String nomeTreno, int numVagMax) {
		// TODO Auto-generated constructor stub
		
		this.listaVagoni = new Vagone[numVagMax];
		this.numVagPresenti = 0;
		this.nomeTreno = nomeTreno;
		this.numVagMax = numVagMax;
		
	}

	public int getNumVagPresenti() {
		return numVagPresenti;
	}

	public void setNumVagPresenti(int numVagPresenti) {
		this.numVagPresenti = numVagPresenti;
	}

	public String getNomeTreno() {
		return nomeTreno;
	}
	
	//AGGIUNTA VAGONE PASSANDO L'OGGETTO
	public boolean addVagone(Vagone vag) {
		
		listaVagoni[numVagPresenti] = vag;
		this.numVagPresenti++;
		
		if (numVagPresenti > numVagMax)
			return false;
		else
			return true;
	}
	
	//AGGIUNTA VAGONE INSERENDO I PARAMTERI
	public boolean addVagone(int numPostiOccupati, int numPostiMax, String matricola, int tipoClasse) {
		listaVagoni[numVagPresenti] = new Vagone(numPostiOccupati, numPostiMax, matricola, tipoClasse);
		this.numVagPresenti++;
		
		if (numVagPresenti > numVagMax)
			return false;
		else
			return true;
	}
	
	//ELIMINA VAGONE
	public boolean eliminaVagone(String matricola) {
		for (int i=0; i<numVagPresenti; i++) {
			if (listaVagoni[i].getMatricola().compareToIgnoreCase(matricola) == 0) {
				for (int j=i; j<numVagPresenti; j++) 
					listaVagoni[j] = listaVagoni[j+1];
				
				numVagPresenti--;
				return true;
			}
		}
		return false;
	}
	
	//VISUALIZZA PASSEGGERI TOTALI
	public int passeggeriTotali() {
		int totale = 0;
		for (int i=0; i<numVagPresenti; i++) {
			totale += listaVagoni[i].getNumPostiOccupati();
		}
		return totale;
	}
	
	//CERCA VAGONI CHE HANNO POSTI ANCORA DISPONIBILI
	public Vagone[] cercaVagonidDisp() {
		Vagone[] vDisp = new Vagone[numVagPresenti];
		int cont = 0;
		
		for (int i=0; i<numVagPresenti; i++) {
			if (listaVagoni[i].getNumPostiOccupati() < listaVagoni[i].getNumPostiMax()) {
				vDisp[cont] = listaVagoni[i];
				cont++;
			}
		}
		return vDisp;
	}
	
	//CERCA VAGONE PER MATRICOLA
	public Vagone cercaVagone(String matricola) {
		Vagone vagone = null;
		
		for (int i=0; i<numVagPresenti; i++) {
			if (listaVagoni[i].getMatricola().equals(matricola)) {
				vagone = listaVagoni[i];
				break;
			}
		}
		return vagone;
	}

	@Override
	public String toString() {
		return "Treno [listaVagoni=" + Arrays.toString(listaVagoni) + ", numVagPresenti=" + numVagPresenti
				+ ", nomeTreno=" + nomeTreno + "]";
	}
	
	public static void main(String[] args) {
		
		Vagone v1 = new Vagone (50, 100, "0000", 1);
		Vagone v2 = new Vagone (20, 20, "1111", 2);
		Treno t1 = new Treno ("Bari-Milano", 15);
		
		//AGGIUNTA VAGONE/I
		t1.addVagone(v1);
		t1.addVagone(v2);
		t1.addVagone(15, 20, "2222", 2);
		System.out.println(t1);
		
		//ELIMINAZIONE VAGONE/I
		System.out.println("Elimina un vagone: ");
		t1.eliminaVagone("2222");
		System.out.println(t1);
		
		//CERCA VAGONI CHE HANNO POSTI ANCORA DISPONIBILI
		System.out.println("Visualizza tutti i vagoni con POSTI DISPONIBILI: ");
		Vagone[] vDisp = t1.cercaVagonidDisp();
		for (int i=0; i<vDisp.length; i++) {
			if (vDisp[i] != null)
				System.out.println(vDisp[i].toString());
			else
				break;
		}
		
		//CERCA VAGONE PER MATRICOLA
		System.out.println("Ricerca vagone per MATRICOLA: ");
		System.out.println(t1.cercaVagone("0000"));
		
	}
	

}
