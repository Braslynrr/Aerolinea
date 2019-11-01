package aerolinea;

import aerolinea.presentacion.Usuario.Login;
import aerolinea.presentacion.Usuario.LoginController;
import aerolinea.presentacion.Usuario.UsuarioModel;
import aerolinea.presentacion.administrador.AdministradorController;
import aerolinea.presentacion.administrador.AdministradorModel;
import aerolinea.presentacion.administrador.AdministradorView;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends JFrame {
    
  CardLayout windows;
  Container container;
  public static aerolinea.presentacion.administrador.AdministradorController Controller_Admin;
  
    public Main(){
        
    windows = new CardLayout();
    container = this.getContentPane();
    container.setLayout(windows);
    this.initComponents();

  }
    public void initComponents()
  {
    this.setTitle("Proyecto_Programacion_3");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.swapWindow("tipoavion");
    
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
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
    
    java.awt.EventQueue.invokeLater(Main::new);
    }
    
    
    public void swapWindow(String window){
    windows.show(container, window);
  }
    public void addWindow(JPanel window, String name){
    container.add(window);
    windows.addLayoutComponent(window, name);
  }
}
