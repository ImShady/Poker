/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author Shady
 */
public class board extends javax.swing.JFrame {

    /**
     * Creates new form board
     */
    
    	// for I/O
	private ObjectInputStream sInput;		// to read from the socket
	private ObjectOutputStream sOutput;		// to write on the socket
	private Socket socket = new Socket();

	// if I use a GUI or not
	//private ClientGUI cg;
	
	// the server, the port and the username
	private String server, username;
	private int port;

	/*
	 *  Constructor called by console mode
	 *  server: the server address
	 *  port: the port number
	 *  username: the username
	 */
    
    public board()
    {
        this.getContentPane().setBackground(new Color(34,139,34));
        //int players = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the additional number of players: ", "Players", JOptionPane.QUESTION_MESSAGE));
        initComponents();
        lblPlayer1.setText(welcome.getUser());
        int portNumber = 4444;
        String serverAddress = "localhost";
        String userName = "username: " + welcome.getUser();
                
        // create the Client object
        board client = new board(serverAddress, portNumber, userName);
	// test if we can start the connection to the Server
        // if it failed nothing we can do
        
        if(client.start() == false)
        {
            return;
        }
        
//       if(client.start() == false)
//       {
//           System.out.println("connection fayuled.");
//       }

        // wait for messages from user;
        // loop forever for message from the user
//        while (true) {
//            System.out.print("> ");
//        }
        // done disconnect
       // client.disconnect();             
    }
    
    public board(String server, int port, String username)
    {
        this(server, port, username, 0);   
    }
    
    board(String server, int port, String username, int x) {
        this.server = server;
        this.port = port;
        this.username = username;
        // save if we are in GUI mode or not
    }

    public boolean start() {
        // try to connect to the server
        try {      
            //socket = new Socket(server, port);
            socket.connect(new InetSocketAddress(server, port), 1000);
        } // if it failed not much I can so
        catch (Exception ec) {
            System.out.println("Error connectiong to server:" + ec);
            return false;
        }
        
        String msg = "Connection accepted " + socket.getInetAddress() + ":" + socket.getPort();
        System.out.println(msg);

        /* Creating both Data Stream */
        try {
            sInput = new ObjectInputStream(socket.getInputStream());
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException eIO) {
            System.out.println("Exception creating new Input/output Streams: " + eIO);
            return false;
        }

        // creates the Thread to listen from the server 
        new ListenFromServer().start();
		// Send our username to the server this is the only message that we
        // will send as a String. All other messages will be ChatMessage objects
        try {
            sOutput.writeObject(username);
        } catch (IOException eIO) {
            System.out.println("Exception doing login : " + eIO);
            disconnect();
            return false;
        }
        // success we inform the caller that it worked
        return true;
    }
    
    private void disconnect() {
        try {
            if (sInput != null) {
                sInput.close();
            }
        } catch (Exception e) {
        } // not much else I can do
        try {
            if (sOutput != null) {
                sOutput.close();
            }
        } catch (Exception e) {
        } // not much else I can do
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
        } // not much else I can do
    } 

    /*
     * To send a message to the server
     */
    void sendMessage(ChatMessage msg) {
        try {
            sOutput.writeObject(msg);
        } catch (IOException e) {
            System.out.println("Exception writing to server: " + e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blBoard = new javax.swing.JLabel();
        image1 = new javax.swing.JLabel();
        lblPlayer1 = new javax.swing.JLabel();
        lblPlayer1Chips = new javax.swing.JLabel();
        image2 = new javax.swing.JLabel();
        lblPlayer2Chips = new javax.swing.JLabel();
        lblPlayer2 = new javax.swing.JLabel();
        image3 = new javax.swing.JLabel();
        lblPlayer3 = new javax.swing.JLabel();
        lblPlayer3Chips = new javax.swing.JLabel();
        lblPlayer4 = new javax.swing.JLabel();
        image4 = new javax.swing.JLabel();
        lblPlayerChips4 = new javax.swing.JLabel();
        image5 = new javax.swing.JLabel();
        lblPlayer5 = new javax.swing.JLabel();
        lblPlayer5Chips = new javax.swing.JLabel();
        image6 = new javax.swing.JLabel();
        lblPlayer6 = new javax.swing.JLabel();
        lblPlayer6Chips = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 0));
        setResizable(false);

        blBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/board.png"))); // NOI18N

        image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playerdefault.png"))); // NOI18N

        lblPlayer1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer1.setForeground(java.awt.Color.orange);
        lblPlayer1.setText("Ramy");

        lblPlayer1Chips.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer1Chips.setForeground(java.awt.Color.orange);
        lblPlayer1Chips.setText("Total Chips: ");

        image2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playerdefault.png"))); // NOI18N

        lblPlayer2Chips.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer2Chips.setForeground(java.awt.Color.orange);
        lblPlayer2Chips.setText("Total Chips: ");

        lblPlayer2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer2.setForeground(java.awt.Color.orange);
        lblPlayer2.setText("Empty");

        image3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playerdefault.png"))); // NOI18N

        lblPlayer3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer3.setForeground(java.awt.Color.orange);
        lblPlayer3.setText("Empty");

        lblPlayer3Chips.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer3Chips.setForeground(java.awt.Color.orange);
        lblPlayer3Chips.setText("Total Chips: ");

        lblPlayer4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer4.setForeground(java.awt.Color.orange);
        lblPlayer4.setText("Empty");

        image4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playerdefault.png"))); // NOI18N

        lblPlayerChips4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayerChips4.setForeground(java.awt.Color.orange);
        lblPlayerChips4.setText("Total Chips: ");

        image5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playerdefault.png"))); // NOI18N

        lblPlayer5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer5.setForeground(java.awt.Color.orange);
        lblPlayer5.setText("Empty");

        lblPlayer5Chips.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer5Chips.setForeground(java.awt.Color.orange);
        lblPlayer5Chips.setText("Total Chips: ");

        image6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/playerdefault.png"))); // NOI18N

        lblPlayer6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer6.setForeground(java.awt.Color.orange);
        lblPlayer6.setText("Empty");

        lblPlayer6Chips.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPlayer6Chips.setForeground(java.awt.Color.orange);
        lblPlayer6Chips.setText("Total Chips: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(image5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPlayer5Chips))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPlayer5)
                        .addGap(32, 32, 32)))
                .addGap(213, 213, 213)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(image6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPlayer6Chips))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPlayer6)
                        .addGap(32, 32, 32)))
                .addGap(322, 322, 322))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(image3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPlayer3Chips))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPlayer3)
                                .addGap(32, 32, 32)))
                        .addGap(209, 209, 209)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(image2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPlayer2Chips))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPlayer2)
                                .addGap(32, 32, 32))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(image4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPlayerChips4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPlayer4)
                                .addGap(32, 32, 32)))
                        .addComponent(blBoard)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(image1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblPlayer1Chips))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPlayer1)
                                .addGap(32, 32, 32)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(image5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlayer5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer5Chips))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(image6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlayer6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer6Chips)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(blBoard)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(image1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlayer1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer1Chips)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(image4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlayer4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayerChips4)
                        .addGap(54, 54, 54)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(image3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlayer3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer3Chips))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(image2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPlayer2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPlayer2Chips)))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and System.out.println the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new board().setVisible(true);
            }
        });  
    }
    
    public class ListenFromServer extends Thread {                
        
        public void run() {
            
            while (true) {
                
                try {
                    
                    String msg = (String) sInput.readObject();
                    
                    System.out.println(msg);
                    
                    if(msg.contains("New player: "))
                    {
                        String newUser = msg.substring(12, msg.length() - 1);                       
                        
                        if(!lblPlayer1.getText().equals(newUser) && !lblPlayer2.getText().equals(newUser) && !lblPlayer3.getText().equals(newUser) && !lblPlayer4.getText().equals(newUser) && !lblPlayer5.getText().equals(newUser) & !lblPlayer6.getText().equals(newUser))
                        {                            
                            if(lblPlayer2.getText().equals("Empty"))
                            {
                                lblPlayer2.setText(newUser);
                                System.out.println("New player " + newUser + " has connected!");
                            }
                            else if(lblPlayer3.getText().equals("Empty"))
                            {
                                lblPlayer3.setText(newUser);
                                System.out.println("New Player " + newUser + " has connected!");
                            }
                            else if(lblPlayer4.getText().equals("Empty"))
                            {
                                lblPlayer4.setText(newUser);
                                System.out.println("New Player " + newUser + " has connected!");
                            }
                            else if(lblPlayer5.getText().equals("Empty"))
                            {
                                lblPlayer5.setText(newUser);
                                System.out.println("New Player " + newUser + " has connected!");
                            }
                            else if(lblPlayer6.getText().equals("Empty"))
                            {
                                lblPlayer6.setText(newUser);
                                System.out.println("New Player " + newUser + " has connected!");
                            }
                        }                        
                    }
                    else if (msg.contains("cuser:"))
                    {
                        String cUser = msg.substring(7, msg.length() - 1);

                        if (!lblPlayer1.getText().equals(cUser) && !lblPlayer2.getText().equals(cUser) && !lblPlayer3.getText().equals(cUser) && !lblPlayer4.getText().equals(cUser) && !lblPlayer5.getText().equals(cUser) & !lblPlayer6.getText().equals(cUser)) {

                            if (lblPlayer2.getText().equals("Empty")) {
                                lblPlayer2.setText(cUser);
                                System.out.println("Current player " + cUser + " has connected!");
                            } else if (lblPlayer3.getText().equals("Empty")) {
                                lblPlayer3.setText(cUser);
                                System.out.println("Current Player " + cUser + " has connected!");
                            } else if (lblPlayer4.getText().equals("Empty")) {
                                lblPlayer4.setText(cUser);
                                System.out.println("Current Player " + cUser + " has connected!");
                            } else if (lblPlayer5.getText().equals("Empty")) {
                                lblPlayer5.setText(cUser);
                                System.out.println("Current Player " + cUser + " has connected!");
                            } else if (lblPlayer6.getText().equals("Empty")) {
                                lblPlayer6.setText(cUser);
                                System.out.println("Curretn Player " + cUser + " has connected!");
                            }
                        }
                    }
                    // if console mode print the message and add back the prompt
//                    System.out.println(msg);
//                    System.out.print("> ");

                } catch (IOException e) {

                    System.out.println("Server has closed the connection: " + e);

                    break;
                } // can't happen with a String object but need the catch anyhow
                catch (ClassNotFoundException e2) {
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel blBoard;
    public static javax.swing.JLabel image1;
    public static javax.swing.JLabel image2;
    public static javax.swing.JLabel image3;
    public static javax.swing.JLabel image4;
    public static javax.swing.JLabel image5;
    public static javax.swing.JLabel image6;
    public static javax.swing.JLabel lblPlayer1;
    public static javax.swing.JLabel lblPlayer1Chips;
    public static javax.swing.JLabel lblPlayer2;
    public static javax.swing.JLabel lblPlayer2Chips;
    public static javax.swing.JLabel lblPlayer3;
    public static javax.swing.JLabel lblPlayer3Chips;
    public static javax.swing.JLabel lblPlayer4;
    public static javax.swing.JLabel lblPlayer5;
    public static javax.swing.JLabel lblPlayer5Chips;
    public static javax.swing.JLabel lblPlayer6;
    public static javax.swing.JLabel lblPlayer6Chips;
    public static javax.swing.JLabel lblPlayerChips4;
    // End of variables declaration//GEN-END:variables
}