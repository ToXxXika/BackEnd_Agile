package com.example.agileup.Controller;

import com.example.agileup.Interface.PersonneRepository;
import com.example.agileup.Models.Operation;
import com.example.agileup.Models.Personne;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Properties;

@RestController
@CrossOrigin("*")
@RequestMapping("/personne")
public class PersonneController {
   /* @Bean
    public PasswordEncoder  passwordEncoder(){return  new BCryptPasswordEncoder(); }
    */

    @Autowired
    PersonneRepository PR ;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder ;
    @GetMapping(path="/login")
    public Principal user(Principal p){
        System.out.println("UserLogged"+p);
        return p ;
    }
    @GetMapping(path="/findbymail")
    public Personne findByMail(@RequestParam(name = "mail") String mail){
        Personne P1 = PR.findPersonneByMail(mail);
        if(P1!=null){
            return P1;
        }else {
            return null ;
        }
    }
    @PostMapping("/inscription")
    public boolean inscription(@RequestBody Personne p){
        try{
            String ancienmdp = p.getMotdepasse();
            p.setMotdepasse(bCryptPasswordEncoder.encode(p.getMotdepasse()));
            System.out.println("Mot de passe crypté :"+p.getMotdepasse());
            if(PR.save(p) != null) {
                sendMail(p.getMail(), ancienmdp);
            }
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false ;
        }
    }
    @PostMapping("opstart")
    public boolean startOperation(Operation o){
         return true  ;
    }
    @GetMapping("/findEmp")
    public Personne ChercherPersonne(@RequestParam(value = "matricule") String matricule){
         Personne P = new Personne() ;
        try{
             P = PR.findPersonneByMatricule(matricule);
        }catch (Exception E){
            System.out.println(E.getMessage());
            P = null ;
        }
        return P ;
    }
    public static void createQrImage(File qrFile, String qrCodeText, int size, String fileType, String mail)throws WriterException, IOException {
        try {
            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
            hintMap.put(EncodeHintType.ERROR_CORRECTION,ErrorCorrectionLevel.L);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE,size,size,hintMap);
            int matrixWidth = byteMatrix.getWidth();
            BufferedImage image =  new BufferedImage(matrixWidth,matrixWidth,BufferedImage.TYPE_INT_RGB);
            image.createGraphics();
            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setColor(Color.white);
            graphics.fillRect(0,0,matrixWidth,matrixWidth);
            graphics.setColor(Color.BLACK);
            for (int i = 0; i < matrixWidth; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ImageIO.write(image, fileType, qrFile);
           // sendMail(mail,qrFile);
        }catch (Exception E ){
            System.out.println(E.getMessage());
        }
    }
    public static  void sendMail(String mail,String mdp){
        final String username = "ikasou.666";
        final String password ="Freefallaga123"; // change with my main password  & add mailer to test FTP
        String from ="ikasou.666@gmail.com";
        String to = mail;
        String host ="localhost";
        Properties prop  = new Properties();
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        Session session =  Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            Multipart multipart = new MimeMultipart();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject("Information sur le compte");
            message.setText("Mail: "+mail+" Mot de passe :"+mdp);
            Transport.send(message);
            System.out.println("Sent message successfully");
        }catch (Exception E ){
            System.out.println(E.getMessage());
        }

    }
}
