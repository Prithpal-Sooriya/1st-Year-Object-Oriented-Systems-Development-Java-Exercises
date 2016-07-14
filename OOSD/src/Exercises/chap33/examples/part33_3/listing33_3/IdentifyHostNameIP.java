/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_3.listing33_3;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Prithpal Sooriya
 */
public class IdentifyHostNameIP {

    //main method to run code
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                System.out.println("Input: " + args[i]);
                InetAddress address = InetAddress.getByName(args[i]);
                System.out.println("HostName: " + address.getHostName() + " "
                        + "| IP address: " + address.getHostAddress());
            } catch (UnknownHostException ex) {
                System.err.println(ex);
            }
        }
    }
}
