package src.tp1.object;

import src.tp1.interfaces.IAnimal;
import src.tp1.interfaces.IVeterinaryOffice;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;



public class VeterinaryOffice extends UnicastRemoteObject implements IVeterinaryOffice {
	
	private static final long serialVersionUID = 1L;
	
	public String name;
	public List<IAnimal> listAnimal;
	
	public VeterinaryOffice(String name) throws RemoteException {
		this.name = name;
		this.listAnimal = new ArrayList<IAnimal>();
	}
	
	@Override
	public void addAnimal(IAnimal a) throws RemoteException {

			boolean contain = false;
			
			for(IAnimal animal : listAnimal) {
				if(animal.getName().equals(a.getName()))
					contain = true;
			}
			
			if(!contain)
				listAnimal.add(a);
	}

	@Override
	public IAnimal searchAnimal(String name) throws RemoteException {
		for(IAnimal animal: listAnimal) {
			if(animal.getName().equals(name))
				return animal;
		}
		
		return null;
	}

	@Override
	public String getName() throws RemoteException {
		return this.name;
	}

	@Override
	public List<IAnimal> listAnimal() throws RemoteException {
		return listAnimal;		
	}




	
	
	

}