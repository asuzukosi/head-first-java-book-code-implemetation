package headfirstjava.finalproject;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.event.*;
import java.rmi.Naming;

public class UnivrsalBrowserClient {
    JPanel mainPanel;
    JFrame mainFrame;
    JComboBox<Object> serviceList;
    ServiceServer server;

    public static void main(String[] args) {
        UnivrsalBrowserClient client = new UnivrsalBrowserClient();
        client.buildGUI();
    }

    public void buildGUI() {
        setUpNetwork();
        mainFrame = new JFrame("RMI Universal Browser");
        mainPanel = new JPanel();
        mainFrame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        Object[] services = getServiceList();
        serviceList = new JComboBox<Object>(services);
        mainFrame.getContentPane().add(BorderLayout.NORTH, serviceList);
        serviceList.addActionListener(new MyListListener());

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setVisible(true);

    }

    public Object[] getServiceList(){
        Object[] services = null;
        try {
            services = server.getServiceList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return services;
    }

    public void loadService(Service service) {
        try {
            mainPanel.removeAll();
            mainPanel.add(service.getGuiPanel());
            mainPanel.validate();
            mainPanel.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUpNetwork() {
        try {
            server = (ServiceServer)Naming.lookup("rmi://127.0.0.1/ServiceServer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * MyListListener
     */
    public class MyListListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent arg0) {            
            String serviceName = (String)serviceList.getSelectedItem();
            try {
                Service service = server.getService(serviceName);
                loadService(service);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        
    }
    
}
