package src.tp1.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISpecie extends Remote{
	
	public String getName() throws RemoteException;
	
	public int getLifeTime() throws RemoteException;
	
	public String getInformation() throws RemoteException;
}