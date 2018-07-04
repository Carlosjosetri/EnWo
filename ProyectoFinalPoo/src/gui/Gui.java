/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import thread.jugador;
import thread.circleclicklistener;

/**
 *
 * @author LN710Q
 */
public class Gui extends JFrame {
   
    private JLabel [] labels;
    private JButton inicio;
    private String [] nombres={"canguro","tortuga","dragon","megaman"};

   
     public Gui(){
        super("Carrera de animales");
        initialComponents();
    } 
     
  
    public void initialComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
       
        labels=new JLabel[4];
        inicio=new JButton("Inicio");
        Container container=getContentPane();
        
        
            labels[0]=new JLabel();
            labels[0].setIcon(new ImageIcon(getClass().getResource("enma"+".gif")));
            labels[0].setBounds(10,400, 200, 200);
            container.add(labels[0]);
        
      
            inicio.setBounds(10, 0, 100, 30);
            container.add(inicio);
       
          
     
       

//                      
            
            inicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
//            AnimalThread canguro=new AnimalThread("canguro",510,labels[0].getX(),labels[0].getY(),labels[0]);
//            AnimalThread tortuga=new AnimalThread("tortuga",510,labels[1].getX(),labels[1].getY(),labels[1]);
// 
//             canguro.start();
//            tortuga.start();            
            
            }
        });
             setSize(1000,650);
             jugador dragon =new jugador("dragon",510,labels[0].getX(),labels[0].getY(),labels[0]);
           dragon.start(); 
         this.getContentPane().addMouseListener(new circleclicklistener(dragon));
        
    }
    
}
