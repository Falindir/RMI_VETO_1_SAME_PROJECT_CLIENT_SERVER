package src.tp1.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnimal extends Remote {
	
	public String information() throws RemoteException;

	public IFollowUpFile getFollowUpFile()throws RemoteException;
	
	public void setFollowUpFile(IFollowUpFile file)throws RemoteException;
	
	public void setContentsFollowUpFIle(String contents) throws RemoteException;

	public ISpecie getSpecie() throws RemoteException;
	
	public String getName() throws RemoteException;
	
}