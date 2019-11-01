package aerolinea;

import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalController;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalModel;
import aerolinea.presentacion.ventanaprincipal.VentanaPrincipalView;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    
  CardLayout windows;
  Container container;

  
  
    public Main()
  {
      VentanaPrincipalModel model = new VentanaPrincipalModel();
     VentanaPrincipalView view;  view   = new VentanaPrincipalView();
      VentanaPrincipalController controller = new VentanaPrincipalController(model,view);
      view.setVisible(true);
  }
    public static void main(String[] args) 
    {
       
        try
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
    {
      System.err.println("error: invalid look and feel.");
    }
    
    java.awt.EventQueue.invokeLater(VentanaPrincipalView::new);
    
    }
    
    
}
