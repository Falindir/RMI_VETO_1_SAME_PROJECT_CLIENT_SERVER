package src.tp1;

import src.tp1.interfaces.IAnimal;
import src.tp1.interfaces.IVeterinaryOffice;
import src.tp1.object.Animal;
import src.tp1.object.Specie;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


@SuppressWarnings("deprecation")
public class Client {
	
	private Client() {
		
	}
	
	public static void main(String[] args) {
		String host = (args.length < 1) ? null : args[0];
		try {
			// TODO METTRE LE BON CHEMIN
			System.setProperty("java.security.policy", "/home/jimmy/workspace/NTIERS/VETO/Animal.policy");
			
			System.setSecurityManager(new RMISecurityManager());
						
			Registry registry = LocateRegistry.getRegistry(host);
			
			IVeterinaryOffice cabinet = (IVeterinaryOffice) registry.lookup("cabinet");
			
			System.out.println("Cabinet renu : " + cabinet.getName());
			
			System.out.println("Recherche de Sonic");
			
			System.out.println(cabinet.searchAnimal("Sonic").information());
			
			IAnimal chat = new Animal("Cat", "Falindir", "chat noir", new Specie("Chat", 14));
			
			cabinet.addAnimal(chat);
			
			System.out.println("Observation : " +  cabinet.searchAnimal("Sonic").getFollowUpFile().getObservation());
			
			cabinet.searchAnimal("Sonic").setContentsFollowUpFIle("Un méchant chient");
			
			System.out.println("Observation : " + cabinet.searchAnimal("Sonic").getFollowUpFile().getObservation());
			
			for(IAnimal animal : cabinet.listAnimal()) {
				System.out.println(animal.information());
				System.out.println(animal.information());
				System.out.println(animal.getName());
				System.out.println(animal.getFollowUpFile().getObservation());
				System.out.println("Info espèce animal : " + animal.getSpecie().getName());
			}
			
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
