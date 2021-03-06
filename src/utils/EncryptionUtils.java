package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Formatter;

import org.jasypt.util.password.StrongPasswordEncryptor;

import processing.core.PApplet;

public class EncryptionUtils {
	
	private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
	
	static public void createUser(PApplet sketch, String user, String pass){
		System.out.println("CREATING USER");
		
		BufferedReader uPF = sketch.createReader("usrPass.prc");
		ArrayList<String> users = new ArrayList<String>();
		ArrayList<String> passes = new ArrayList<String>();
		ArrayList<String> perms = new ArrayList<String>();
		String enPass = encryptPass(pass);
		while (true){
			String line[];
			try {
				line = PApplet.split(uPF.readLine(),'-');
				System.out.println(line);
				if(line==null){
					break;
				}
				users.add(line[0]);
				passes.add(line[1]);
				perms.add(line[2]);
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		
		Formatter output = null;
		try {
			output = new Formatter("usrPass.prc");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String perm:perms){
			int i = perms.indexOf(perm);
			System.out.println("LOOP ---- " + users.get(i) + "-" + passes.get(i) + "-" + perm);
			output.format(users.get(i) + "-" + passes.get(i) + "-" + perm);
		}
		
		System.out.println("ADD ---- " + user + "-" + enPass + "-" + "0");
		output.format(user + "-" + enPass + "-" + "0");
		
		output.flush();
		output.close();
		
	}
	
	static private String encryptPass(String pass){
		return passwordEncryptor.encryptPassword(pass);
	}
	
}
