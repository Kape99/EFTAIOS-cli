package it.polimi.ingsw.capecchidelcoco;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	String name= "B45";
    	int x =(int)((byte)name.charAt(0) - 'A');
		String appo =""+ name.charAt(1)+name.charAt(2);
    	int y = Integer.parseInt(appo);
		
    	System.out.println(y);
    }
}
