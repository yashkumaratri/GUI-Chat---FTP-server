/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp;

/**
 *
 * @author Yash Kumar Atri
 */
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;


public class FileTransferClient { 
    
    public static void main(String[] args) throws Exception{
        
        //Initialize socket
        Socket socket = new Socket(InetAddress.getByName("localhost"), 5000);
        byte[] contents = new byte[10000];
        
        //Initialize the FileOutputStream to the output file's full path.
        FileOutputStream fos = new FileOutputStream("e:\\data2.bin");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        InputStream is = socket.getInputStream();
        
        //No of bytes read in one read() call
        int bytesRead = 0; 
        
        while((bytesRead=is.read(contents))!=-1)
            bos.write(contents, 0, bytesRead); 
        
        bos.flush(); 
        socket.close(); 
        
        System.out.println("File saved successfully!");
    }
}
