package src.tp1.object;

import src.tp1.interfaces.IFollowUpFile;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class FollowUpFile extends UnicastRemoteObject implements IFollowUpFile {

	private static final long serialVersionUID = 1L;
	
	private String observation;
	
	public FollowUpFile()throws RemoteException{
		this.observation = "aucune";
	}
	
	@Override
	public String getObservation()throws RemoteException{
		return observation;
	}
	
	@Override
	public void setObservation(String observation)throws RemoteException{
		this.observation = observation;
	}
}