/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manouvre.gui;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import manouvre.game.Player;
import manouvre.game.interfaces.CardInterface;
import manouvre.game.interfaces.FrameInterface;
import manouvre.network.client.Message;
import manouvre.network.client.SocketClient;

/**
 *
 * @author Piotr
 */
public class RoomWindow extends javax.swing.JFrame  implements FrameInterface{

    public SocketClient client;
    public int port;
    public String serverAddr, username, password;
    public Thread clientThread;
    public DefaultListModel model;

    int windowMode ;
    
    
    Player hostPlayer;
    Player guestPlayer;
    
    Player currentPlayer;
    
    /**
     * Creates new form RoomWindow
     */
    public RoomWindow() {
        initComponents();
    }
    
       /**
     * Creates new form RoomWindow
     */
    public RoomWindow(SocketClient passSocket, Player player, int mode ) {
        
       this.client = passSocket;
       this.windowMode = mode;
       /*
       Setting player as currentPlayer and host or guest 
       */
       setPlayer(player);
   
       initComponents();
       setEditableButtons();
       setBorders();
       setTitleBar();
      
    }
    
           /*
       Setting player either as host or guest
       */
    public void setPlayer(Player player){
        
        currentPlayer = player;
        if(windowMode == CreateRoomWindow.AS_HOST)
           hostPlayer = player;
        else
           guestPlayer = player;
       
        
    }
    
    public void setBorders(){
    
    if(hostPlayer != null)
        player1Panel.setBorder(javax.swing.BorderFactory.createTitledBorder( hostPlayer.getName() ));
    if(guestPlayer != null)
        player2Panel.setBorder(javax.swing.BorderFactory.createTitledBorder( guestPlayer.getName() ));
    }
    
    private void setTitleBar(){
    
    String modeString;
                
                if(windowMode == CreateRoomWindow.AS_HOST )
                    modeString = " as Host";
                else 
                    modeString = " as Quest";
                      
        this.setTitle(currentPlayer.getName()  + modeString);
    }
    
     private void setEditableButtons(){
     
         switch(windowMode)
         {
             case CreateRoomWindow.AS_HOST :
               AustriaRB2.setEnabled(false);
               BritainRB2.setEnabled(false);
               FranceRB2.setEnabled(false);
               OttomanRB2.setEnabled(false);
               PrussiaRB2.setEnabled(false);
               RussiaRB2.setEnabled(false);
               SpainRB2.setEnabled(false);
               USARB2.setEnabled(false);
             
             break;
             case CreateRoomWindow.AS_GUEST :
               AustriaRB1.setEnabled(false);
               BritainRB1.setEnabled(false);
               FranceRB1.setEnabled(false);
               OttomanRB1.setEnabled(false);
               PrussiaRB1.setEnabled(false);
               RussiaRB1.setEnabled(false);
               SpainRB1.setEnabled(false);
               USARB1.setEnabled(false);
               
              startButton.setEnabled(false);
              break;    
     }}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        player1Group = new javax.swing.ButtonGroup();
        player2Group = new javax.swing.ButtonGroup();
        austriaSel = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainChat = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        messageTextField = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        playersPanel = new javax.swing.JPanel();
        player1Panel = new javax.swing.JPanel();
        FranceRB1 = new javax.swing.JRadioButton();
        USARB1 = new javax.swing.JRadioButton();
        AustriaRB1 = new javax.swing.JRadioButton();
        PrussiaRB1 = new javax.swing.JRadioButton();
        OttomanRB1 = new javax.swing.JRadioButton();
        BritainRB1 = new javax.swing.JRadioButton();
        SpainRB1 = new javax.swing.JRadioButton();
        RussiaRB1 = new javax.swing.JRadioButton();
        player2Panel = new javax.swing.JPanel();
        FranceRB2 = new javax.swing.JRadioButton();
        USARB2 = new javax.swing.JRadioButton();
        AustriaRB2 = new javax.swing.JRadioButton();
        PrussiaRB2 = new javax.swing.JRadioButton();
        OttomanRB2 = new javax.swing.JRadioButton();
        BritainRB2 = new javax.swing.JRadioButton();
        SpainRB2 = new javax.swing.JRadioButton();
        RussiaRB2 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainChat.setEditable(false);
        mainChat.setColumns(20);
        mainChat.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        mainChat.setRows(5);
        jScrollPane1.setViewportView(mainChat);

        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setText("Message : ");

        messageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageTextFieldActionPerformed(evt);
            }
        });

        sendButton.setText("Send Message ");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton)
                    .addComponent(jLabel5)
                    .addComponent(messageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        player1Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("HostPlayer"));

        player1Group.add(FranceRB1);
        FranceRB1.setText("France");
        FranceRB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FranceRB1ActionPerformed(evt);
            }
        });

        player1Group.add(USARB1);
        USARB1.setText("USA");
        USARB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USARB1ActionPerformed(evt);
            }
        });

        player1Group.add(AustriaRB1);
        AustriaRB1.setSelected(true);
        AustriaRB1.setText("Austria");
        AustriaRB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AustriaRB1ActionPerformed(evt);
            }
        });

        player1Group.add(PrussiaRB1);
        PrussiaRB1.setText("Prussia");
        PrussiaRB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrussiaRB1ActionPerformed(evt);
            }
        });

        player1Group.add(OttomanRB1);
        OttomanRB1.setText("Ottoman");
        OttomanRB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OttomanRB1ActionPerformed(evt);
            }
        });

        player1Group.add(BritainRB1);
        BritainRB1.setText("Britain");
        BritainRB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BritainRB1ActionPerformed(evt);
            }
        });

        player1Group.add(SpainRB1);
        SpainRB1.setText("Spain");
        SpainRB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpainRB1ActionPerformed(evt);
            }
        });

        player1Group.add(RussiaRB1);
        RussiaRB1.setText("Russia");
        RussiaRB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RussiaRB1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout player1PanelLayout = new javax.swing.GroupLayout(player1Panel);
        player1Panel.setLayout(player1PanelLayout);
        player1PanelLayout.setHorizontalGroup(
            player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player1PanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BritainRB1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AustriaRB1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OttomanRB1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USARB1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrussiaRB1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FranceRB1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpainRB1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RussiaRB1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player1PanelLayout.setVerticalGroup(
            player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RussiaRB1)
                    .addComponent(FranceRB1)
                    .addComponent(USARB1)
                    .addComponent(AustriaRB1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(player1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BritainRB1)
                    .addComponent(OttomanRB1)
                    .addComponent(PrussiaRB1)
                    .addComponent(SpainRB1))
                .addContainerGap())
        );

        player2Panel.setBorder(javax.swing.BorderFactory.createTitledBorder("QuestPlayer"));

        player2Group.add(FranceRB2);
        FranceRB2.setText("France");
        FranceRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FranceRB2ActionPerformed(evt);
            }
        });

        player2Group.add(USARB2);
        USARB2.setSelected(true);
        USARB2.setText("USA");
        USARB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USARB2ActionPerformed(evt);
            }
        });

        player2Group.add(AustriaRB2);
        AustriaRB2.setText("Austria");
        AustriaRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AustriaRB2ActionPerformed(evt);
            }
        });

        player2Group.add(PrussiaRB2);
        PrussiaRB2.setText("Prussia");
        PrussiaRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrussiaRB2ActionPerformed(evt);
            }
        });

        player2Group.add(OttomanRB2);
        OttomanRB2.setText("Ottoman");
        OttomanRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OttomanRB2ActionPerformed(evt);
            }
        });

        player2Group.add(BritainRB2);
        BritainRB2.setText("Britain");
        BritainRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BritainRB2ActionPerformed(evt);
            }
        });

        player2Group.add(SpainRB2);
        SpainRB2.setText("Spain");
        SpainRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SpainRB2ActionPerformed(evt);
            }
        });

        player2Group.add(RussiaRB2);
        RussiaRB2.setText("Russia");
        RussiaRB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RussiaRB2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout player2PanelLayout = new javax.swing.GroupLayout(player2Panel);
        player2Panel.setLayout(player2PanelLayout);
        player2PanelLayout.setHorizontalGroup(
            player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player2PanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BritainRB2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AustriaRB2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OttomanRB2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(USARB2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrussiaRB2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FranceRB2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpainRB2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RussiaRB2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        player2PanelLayout.setVerticalGroup(
            player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player2PanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RussiaRB2)
                    .addComponent(FranceRB2)
                    .addComponent(USARB2)
                    .addComponent(AustriaRB2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(player2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BritainRB2)
                    .addComponent(OttomanRB2)
                    .addComponent(PrussiaRB2)
                    .addComponent(SpainRB2))
                .addContainerGap())
        );

        javax.swing.GroupLayout playersPanelLayout = new javax.swing.GroupLayout(playersPanel);
        playersPanel.setLayout(playersPanelLayout);
        playersPanelLayout.setHorizontalGroup(
            playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playersPanelLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(player1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(player2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        playersPanelLayout.setVerticalGroup(
            playersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(player1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(player2Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        startButton.setText("Start Game");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(playersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
      
        Message msg = new Message (Message.CHAT_IN_ROOM, currentPlayer.getName(), messageTextField.getText(), "CHAT_IN_ROOM");
        messageTextField.setText("");
        client.send(msg);
        
    }//GEN-LAST:event_sendButtonActionPerformed
        
    private void BritainRB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BritainRB1ActionPerformed
        buttonActionPerformed(evt);
    }//GEN-LAST:event_BritainRB1ActionPerformed

    private void AustriaRB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AustriaRB1ActionPerformed
       buttonActionPerformed(evt);
        
    }//GEN-LAST:event_AustriaRB1ActionPerformed

    private void AustriaRB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AustriaRB2ActionPerformed
        buttonActionPerformed(evt);
    }//GEN-LAST:event_AustriaRB2ActionPerformed

    private void BritainRB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BritainRB2ActionPerformed
       buttonActionPerformed(evt);
    }//GEN-LAST:event_BritainRB2ActionPerformed

    private void SpainRB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpainRB1ActionPerformed
        buttonActionPerformed(evt);
    }//GEN-LAST:event_SpainRB1ActionPerformed

    
    private void buttonActionPerformed (java.awt.event.ActionEvent evt) {
        AbstractButton button = (AbstractButton) evt.getSource();
        setNationFromButton(button, currentPlayer);
        
        Message msg = new Message (Message.SET_NATION, currentPlayer.getName(), currentPlayer.getNation(), "IN_ROOM");
        client.send(msg);
        
    }
    
    private void setNationFromButton(AbstractButton button, Player player){
    
        switch(button.getText()){
        case "Austria": 
           player.setNation(CardInterface.AU);
            break;
        case "France" :
            player.setNation(CardInterface.FR);
            break;
        case "Russia": 
           player.setNation(CardInterface.RU);
            break;
        case "Prussia" :
            player.setNation(CardInterface.PR);
            break;
        case "Britain": 
           player.setNation(CardInterface.BR);
            break;
        case "Spain" :
            player.setNation(CardInterface.SP);
            break;
        case "Ottoman": 
           player.setNation(CardInterface.OT);
            break;
        case "USA" :
            player.setNation(CardInterface.US);
            break;
                }
    
    }
    
    public void setButtonFromNation (int nation){
        if(currentPlayer == guestPlayer)
        switch(nation){
            case CardInterface.AU: 
                AustriaRB1.setSelected(true);
                break;
            case CardInterface.BR: 
                BritainRB1.setSelected(true);
                break;
            case CardInterface.FR: 
                FranceRB1.setSelected(true);
                break;
            case CardInterface.OT: 
                OttomanRB1.setSelected(true);
                break;
            case CardInterface.PR: 
                PrussiaRB1.setSelected(true);
                break;
            case CardInterface.RU: 
                RussiaRB1.setSelected(true);
                break;
            case CardInterface.SP: 
                SpainRB1.setSelected(true);
                break;
            case CardInterface.US: 
                USARB1.setSelected(true);
                break;
         }
        else 
        {
            switch(nation){
            case CardInterface.AU: 
                AustriaRB2.setSelected(true);
                break;
            case CardInterface.BR: 
                BritainRB2.setSelected(true);
                break;
            case CardInterface.FR: 
                FranceRB2.setSelected(true);
                break;
            case CardInterface.OT: 
                OttomanRB2.setSelected(true);
                break;
            case CardInterface.PR: 
                PrussiaRB2.setSelected(true);
                break;
            case CardInterface.RU: 
                RussiaRB2.setSelected(true);
                break;
            case CardInterface.SP: 
                SpainRB2.setSelected(true);
                break;
            case CardInterface.US: 
                USARB2.setSelected(true);
                break;
        }
        
        }
            
    }
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
         
                   
        
        //HostPlayer choice
        for (Enumeration<AbstractButton> buttons = player1Group.getElements(); buttons.hasMoreElements();) {
                                AbstractButton button = buttons.nextElement();
                                if (button.isSelected()) {
                                    setNationFromButton(button, hostPlayer);
                                    break;
                                }
                      }
         
        //Quest Player choice
       if(guestPlayer != null)
        
        for (Enumeration<AbstractButton> buttons = player2Group.getElements(); buttons.hasMoreElements();) {
                                AbstractButton button = buttons.nextElement();
                                if (button.isSelected()) {
                                     setNationFromButton(button, guestPlayer);
                                    break;
                                }
                      }
        
        
        
        Message msg = new Message(Message.START_GAME,currentPlayer.getName(), "Start Game", "SERVER");
        client.send(msg);
        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    
//                        
//                                player.generateUnits();
//                                if(windowMode == CreateRoomWindow.AS_HOST)
//                                    player.setHost(true);
//                                else 
//                                    player.setHost(false);
//                                
//                                
//                                
//                                 new GameWindow(socketClient, player).setVisible(true);
//                            
//                                setVisible(false);
//                   
//                } catch (IOException ex) {
//                    Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
    }//GEN-LAST:event_startButtonActionPerformed

    private void messageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageTextFieldActionPerformed
       
        Message msg = new Message (Message.CHAT_IN_ROOM, currentPlayer.getName(), messageTextField.getText(), "CHAT_IN_ROOM");
        
        
        messageTextField.setText("");
        client.send(msg);
        
        
        
    }//GEN-LAST:event_messageTextFieldActionPerformed

    private void USARB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USARB1ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_USARB1ActionPerformed

    private void FranceRB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FranceRB1ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_FranceRB1ActionPerformed

    private void RussiaRB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RussiaRB1ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_RussiaRB1ActionPerformed

    private void OttomanRB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OttomanRB1ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_OttomanRB1ActionPerformed

    private void USARB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USARB2ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_USARB2ActionPerformed

    private void FranceRB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FranceRB2ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_FranceRB2ActionPerformed

    private void RussiaRB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RussiaRB2ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_RussiaRB2ActionPerformed

    private void OttomanRB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OttomanRB2ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_OttomanRB2ActionPerformed

    private void PrussiaRB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrussiaRB2ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_PrussiaRB2ActionPerformed

    private void SpainRB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SpainRB2ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_SpainRB2ActionPerformed

    private void PrussiaRB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrussiaRB1ActionPerformed
    buttonActionPerformed(evt);
    }//GEN-LAST:event_PrussiaRB1ActionPerformed
    @Override
    public void printOnChat(String inString)    {
    
    mainChat.append(inString+ "\n");
    }

    public Player getHostPlayer() {
        return hostPlayer;
    }

    public void setHostPlayer(Player hostPlayer) {
        this.hostPlayer = hostPlayer;
        setBorders();
        setButtonFromNation(hostPlayer.getNation());
    }

    public Player getGuestPlayer() {
        return guestPlayer;
        
    }

    public void setGuestPlayer(Player guestPlayer) {
        this.guestPlayer = guestPlayer;
         setBorders();
         setButtonFromNation(guestPlayer.getNation());
          
    }

     public ArrayList<Player> getPlayers() {
        
        ArrayList<Player> players = new ArrayList<>();
        
        players.add(hostPlayer);
        players.add(guestPlayer);
        
        return players;
        
    }
    
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
            java.util.logging.Logger.getLogger(RoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoomWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoomWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AustriaRB1;
    private javax.swing.JRadioButton AustriaRB2;
    private javax.swing.JRadioButton BritainRB1;
    private javax.swing.JRadioButton BritainRB2;
    private javax.swing.JRadioButton FranceRB1;
    private javax.swing.JRadioButton FranceRB2;
    private javax.swing.JRadioButton OttomanRB1;
    private javax.swing.JRadioButton OttomanRB2;
    private javax.swing.JRadioButton PrussiaRB1;
    private javax.swing.JRadioButton PrussiaRB2;
    private javax.swing.JRadioButton RussiaRB1;
    private javax.swing.JRadioButton RussiaRB2;
    private javax.swing.JRadioButton SpainRB1;
    private javax.swing.JRadioButton SpainRB2;
    private javax.swing.JRadioButton USARB1;
    private javax.swing.JRadioButton USARB2;
    private javax.swing.ButtonGroup austriaSel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea mainChat;
    public javax.swing.JTextField messageTextField;
    private javax.swing.ButtonGroup player1Group;
    private javax.swing.JPanel player1Panel;
    private javax.swing.ButtonGroup player2Group;
    private javax.swing.JPanel player2Panel;
    private javax.swing.JPanel playersPanel;
    public javax.swing.JButton sendButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
