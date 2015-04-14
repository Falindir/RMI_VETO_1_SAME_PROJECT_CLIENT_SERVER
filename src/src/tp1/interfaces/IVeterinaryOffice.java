package src.tp1.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IVeterinaryOffice extends Remote{
	
	public String getName() throws RemoteException;
	
	public void addAnimal(IAnimal a) throws RemoteException;
	
	public IAnimal searchAnimal(String name)throws RemoteException;
	
	public List<IAnimal> listAnimal() throws RemoteException;

}