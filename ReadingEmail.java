package com.script.selenium;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

public class ReadingEmail 
{

	public static void main(String[] args) throws MessagingException 
	{
		// TODO Auto-generated method stub
		ReadingEmail email = new ReadingEmail();
	}

	public void readEmail() throws MessagingException, InterruptedException
	{
		/*String socketFactoryClass = "javax.net.ssl.SSLSocketFactory";	
		Properties props = System.getProperties();
		Properties properties = new Properties();
		properties.put("mail.pop3.host", "pop.gmail.com");
		properties.put("mail.pop3.port", "995");
		properties.put("mail.pop3.socketFactory.class" , socketFactoryClass);
		Session emailSession = Session.getDefaultInstance(properties);
		
		Store emailStore;
		emailStore = emailSession.getStore("pop3");
		emailStore.connect("ravixkumar@gmail.com","S@ranya13");
		System.out.println(emailStore); */
		
		Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "secretmail@gmail.com",
                    "qwerty!@#$%");

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);

            System.out.println("Total Message:" + folder.getMessageCount());
            System.out.println("Unread Message:"
                    + folder.getUnreadMessageCount());
            
            Message[] messages = null;
            boolean isMailFound = false;
            Message mailFromGod= null;

            //Search for mail from God
            for (int i = 0; i <= 5; i++)
            {
                messages = folder.search(new SubjectTerm("Salesforce.com login confirmation"),folder.getMessages());
                //Wait for 10 seconds
                if (messages.length == 0) {
                    Thread.sleep(10000);
                }
            }
            
            for (Message mail : messages) {
                if (!mail.isSet(Flags.Flag.SEEN)) {
                    mailFromGod = mail;
                    System.out.println("Message Count is: "
                            + mailFromGod.getMessageNumber());
                    isMailFound = true;
                }
            }
		
	}
}
