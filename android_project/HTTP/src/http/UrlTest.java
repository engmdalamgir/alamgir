package http;

import java.net.*;

public class UrlTest {
	public static void main(String[] args) {
		System.out.println("" + args.length);
		if (args.length == 0) {
		 
			try {
				// URL url = new URL(args[0]);
				URL url = new URL(
						"ftp://www.irs.gov/mission/#squeezing-them-dry");
				System.out.println(" URL: " + url.toExternalForm() + "\n"
						+ " File: " + url.getFile() + "\n" 
						+ " Host: "+ url.getHost() + "\n" 
						+ " Port: " + url.getPort()+ "\n" 
						+ " Protocol: " + url.getProtocol() + "\n"
						+ " Reference: " + url.getRef());
			} catch (MalformedURLException mue) {
				System.out.println("Bad URL.");
			}
		} else
			System.out.println("Usage:UrlTest <URL>");
	}
}