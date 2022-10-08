package headfirstjava.finalproject;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceServer extends Remote{
    public Object[] getServiceList() throws RemoteException;
    public Service getService(Object serviceKey) throws RemoteException;
}
