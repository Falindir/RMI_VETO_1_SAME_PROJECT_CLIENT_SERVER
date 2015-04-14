package src.tp1;

import src.tp1.interfaces.ISpecie;
import src.tp1.object.Animal;
import src.tp1.object.Specie;
import src.tp1.object.VeterinaryOffice;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



@SuppressWarnings("deprecation")
public class Serveur {
	
	public Serveur() {
		
	}
	
	public static void main(String args[]) {
		try {
			// TODO METTRE LE BON CHEMIN
			System.setProperty("java.security.policy", "/home/jimmy/workspace/NTIERS/VETO/Animal.policy");
			
			System.setSecurityManager(new RMISecurityManager());

			ISpecie r = new Specie("Chien" , 25);
			
			Animal chien = new Animal("Sonic","Falindir", "Epagneul", r);
			
			VeterinaryOffice cabinet = new VeterinaryOffice("Le doux chenil");
			
			cabinet.addAnimal(chien);
			
			Registry registry = LocateRegistry.createRegistry(1099);
			//Registry registry = LocateRegistry.getRegistry();
			
			if (registry==null){
				System.err.println("RmiRegistry not found");
			}else{
				registry.bind("cabinet", cabinet);
				
				System.err.println("Server of Falindir is ready");
			}
			
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
