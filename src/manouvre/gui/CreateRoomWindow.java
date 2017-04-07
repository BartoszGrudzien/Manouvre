/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manouvre.gui;

import manouvre.game.Player;
import manouvre.network.client.Message;
import manouvre.network.client.SocketClient;
import manouvre.network.server.GameRoom;

/**
 *
 * @author Piotr
 */
public class CreateRoomWindow extends javax.swing.JFrame {

    
    public SocketClient socketClient;
    
     Player player;
    /**
     * Creates new form CreateRoomWindow
     */
     
     int windowMode;
    public CreateRoomWindow() {
        initComponents();
    }
    public final static int AS_HOST = 0;
    public final static int AS_GUEST = 1;
    
    
    
    /**
     * Creates room window - mod
     * @param passSocket
     * @param player
     * @param mode 
     */
     public CreateRoomWindow(SocketClient passSocket, Player player, int mode) {
         
         socketClient = passSocket;
         this.player = player;
         this.windowMode = mode;
         
         initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createRoomPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        roomNameFieldText = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        passwordRoomFieldText = new javax.swing.JPasswordField();
        createChannelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Room Name");

        roomNameFieldText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomNameFieldTextActionPerformed(evt);
            }
        });

        jLabel7.setText("Password (optional)");

        createChannelButton.setText("OK");
        createChannelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createChannelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createRoomPanelLayout = new javax.swing.GroupLayout(createRoomPanel);
        createRoomPanel.setLayout(createRoomPanelLayout);
        createRoomPanelLayout.setHorizontalGroup(
            createRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createRoomPanelLayout.createSequentialGroup()
                .addGap(0, 49, Short.MAX_VALUE)
                .addGroup(createRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(createChannelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(createRoomPanelLayout.createSequentialGroup()
                        .addGroup(createRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createRoomPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createRoomPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(20, 20, 20)))
                        .addGroup(createRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(roomNameFieldText, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(passwordRoomFieldText))))
                .addGap(33, 33, 33))
        );
        createRoomPanelLayout.setVerticalGroup(
            createRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createRoomPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(createRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(roomNameFieldText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(createRoomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(passwordRoomFieldText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(createChannelButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(createRoomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(createRoomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void roomNameFieldTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomNameFieldTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomNameFieldTextActionPerformed

    private void createChannelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createChannelButtonActionPerformed

        /*
        Port nasluchujacy serwera =  Port socketa klienta 
        Port wynegocjowany z serwerem to localPort socketa klienta
        czyli socketClient.socket.Port = server.liteningsocket.port = server.socket.localport
        socketClient.socket.Localport = server.socket.port
                
        */
        GameRoom room = new GameRoom(roomNameFieldText.getText(), passwordRoomFieldText.getText(), socketClient.getSocket().getLocalPort(), player);
        
        Message msg = new Message(Message.CREATE_ROOM, player.getName(), roomNameFieldText.getText() , "SERVER" );
        
        msg.addPlayer(player);
        msg.addGameRoom(room);
        
        socketClient.send(msg);
              
  
        this.setVisible(false);
      
        
        
    }//GEN-LAST:event_createChannelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CreateRoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateRoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateRoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateRoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateRoomWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createChannelButton;
    private javax.swing.JPanel createRoomPanel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField passwordRoomFieldText;
    private javax.swing.JTextField roomNameFieldText;
    // End of variables declaration//GEN-END:variables
}
