package headfirstjava.finalproject;
import java.util.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {
    HashMap<String, Service> serviceList;

    protected ServiceServerImpl() throws RemoteException {
        super();
    }

    public void setUpServices(){
        serviceList = new HashMap<String, Service>();
        serviceList.put("Dice Rolling Service", new DiceService());
        serviceList.put("Day of the week service", new DayOfTheWeekService());
        serviceList.put("Visual Music Service", new MiniMusicService());

    }
    @Override
    public String[] getServiceList(){
        return (String[])serviceList.keySet().toArray();
    }

    @Override
    public Service getService(Object serviceKey) {
        return (Service)serviceList.get((String)serviceKey);
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("ServiceServer", new ServiceServerImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Remote services is running");
    }
    
}
