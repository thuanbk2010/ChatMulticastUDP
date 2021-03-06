import java.awt.Color;
import static java.awt.event.KeyEvent.*;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author itsgnegrao
 */
public class ChatMulticastGUI extends javax.swing.JFrame {

    private static MulticastSocket mcSocket;
    private static InetAddress group;
    private ListenerThread listener;
    private static String ip;
    private static int porta;


    public ChatMulticastGUI() throws UnknownHostException {
        initComponents();
        areaMsg.setEnabled(false);
        textMsg.setEnabled(false);
        btnEnviar.setEnabled(false);
        btnSair.setEnabled(false);
    }
     public synchronized void exibeMsg(String msg){

        areaMsg.append(msg);

        textMsg.setText("");
        textMsg.requestFocus();
     }

    public synchronized void exibeMsg(String apelido, String msg){
        String msg_format = "[ "+apelido+" ]: "+msg + "\n";

        try{
            /* cria um datagrama com a msg */
            byte [] m = msg_format.getBytes();
            DatagramPacket messageOut = new DatagramPacket(m, m.length, group, Integer.parseInt(textPorta.getText()));
            /* envia o datagrama como multicast */
            mcSocket.send(messageOut);
        }catch (SocketException e){
                System.out.println("Socket: " + e.getMessage());
        }catch (IOException e){
                System.out.println("IO: " + e.getMessage());
        }

        //fazer

        textMsg.setText("");
        textMsg.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textApelido = new javax.swing.JTextField();
        textIP = new javax.swing.JTextField();
        textPorta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaMsg = new javax.swing.JTextArea();
        textMsg = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Java Multicast");

        jLabel1.setText("IP:");

        jLabel2.setText("Porta");

        jLabel3.setText("Apelido");

        textApelido.setText("Negrao");

        textIP.setEditable(false);
        textIP.setText("239.255.255.255");

        textPorta.setText("5678");

        areaMsg.setEditable(false);
        areaMsg.setColumns(20);
        areaMsg.setRows(5);
        areaMsg.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensagens", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        areaMsg.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(areaMsg);

        textMsg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textMsgKeyPressed(evt);
            }
        });

        btnEnviar.setText("ENVIAR");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair Grupo");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnEntrar.setText("Entrar Grupo");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textMsg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textApelido, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(textIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnEntrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        this.exibeMsg(textApelido.getText(),textMsg.getText());
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        try {
            mcSocket.leaveGroup(group);
            areaMsg.setEnabled(false);
            textMsg.setEnabled(false);
            textApelido.setEditable(true);
            textIP.setEditable(true);
            textPorta.setEditable(true);
            areaMsg.setText("");
            listener.interrupt();
        } catch (IOException ex) {
            Logger.getLogger(ChatMulticastGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        //Exibicao dos campos

        areaMsg.setEnabled(true);
        textMsg.setEnabled(true);
        btnEnviar.setEnabled(true);
        btnSair.setEnabled(true);
        textApelido.setEditable(false);
        textIP.setEditable(false);
        textPorta.setEditable(false);
        textMsg.setText("");
        textMsg.requestFocus();



        try {
            textMsg.requestFocus();

            ip = new String(textIP.getText());
            porta = Integer.parseInt(textPorta.getText().toString());
            group = InetAddress.getByName(ip);

            mcSocket = new MulticastSocket(porta);

            //Entra no grupo do multicast
            mcSocket.joinGroup(group);
        } catch (IOException ex) {
            Logger.getLogger(ChatMulticastGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        listener = new ListenerThread(this, mcSocket);
        listener.start();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void textMsgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMsgKeyPressed
        if (evt.getKeyCode() == VK_ENTER){
            btnEnviar.doClick();
        }
    }//GEN-LAST:event_textMsgKeyPressed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatMulticastGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatMulticastGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatMulticastGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatMulticastGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ChatMulticastGUI().setVisible(true);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(ChatMulticastGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMsg;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textApelido;
    private javax.swing.JTextField textIP;
    private static javax.swing.JTextField textMsg;
    private static javax.swing.JTextField textPorta;
    // End of variables declaration//GEN-END:variables
}
