package it.polimi.ingsw.capecchidelcoco.client;


public class NetworkInterfaceFactory {

	private NetworkInterfaceFactory(){
		
	}
	public static NetworkInterface getInterface(String param){
		if(param.equals("1")) return new  RMIInterface();
		else return null;
	}
}
