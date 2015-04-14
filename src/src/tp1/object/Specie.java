package src.tp1.object;

import src.tp1.interfaces.ISpecie;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



public class Specie implements Serializable, ISpecie {

	public String name;
	public int lifeTime;
	
	public Specie(String name, int lifeTime)throws RemoteException {
		this.name = name;
		this.lifeTime = lifeTime;
	}
	

	public String getName() throws RemoteException {
		return name;
	}


	public int getLifeTime() throws RemoteException {
		return lifeTime;
	}


	public String getInformation() throws RemoteException {
		return "Aucune information sur cette espèce";
	}
}
