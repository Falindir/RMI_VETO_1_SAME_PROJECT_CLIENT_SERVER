package src.tp1.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFollowUpFile extends Remote{
	
	public String getObservation()throws RemoteException;
	
	public void setObservation(String observation)throws RemoteException;
}
