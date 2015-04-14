package src.tp1.object;

import src.tp1.interfaces.IAnimal;
import src.tp1.interfaces.IFollowUpFile;
import src.tp1.interfaces.ISpecie;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class Animal extends UnicastRemoteObject implements IAnimal {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String master;
	private String race;
	
	private ISpecie species;
	private IFollowUpFile file;
	
	public Animal(String name, String master, String race, ISpecie espece) throws RemoteException {
		this.name = name;
		this.master = master;
		this.race = race;	
		this.species = espece;
		this.file = new FollowUpFile();
	}

	@Override
	public String information(){
		return "Animal [nom=" + name + ", maitre=" + master + ", race=" + race + "]";
	}
	
	@Override
	public IFollowUpFile getFollowUpFile() throws RemoteException{
		return file;
	}
	
	@Override
	public void setFollowUpFile(IFollowUpFile file) throws RemoteException{
		this.file = file;
	}
	
	@Override
	public void setContentsFollowUpFIle(String contents) throws RemoteException{
		file.setObservation(contents);
	}
	
	@Override
	public ISpecie getSpecie() throws RemoteException{
		return species;
	}

	@Override
	public String getName() throws RemoteException {
		return this.name;
	}
}
