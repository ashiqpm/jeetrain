package moh.mohart;

import java.text.NumberFormat;

import org.apache.log4j.BasicConfigurator;
import org.s2n.ddt.util.FileUtils;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        System.out.println( "Hello World!" );
        
        App a= new App();
        String r = a.formatNumer(134);
        String r1 = "1 100s 3 10s 4 1s";
        System.out.println("134 -->");
        
        System.out.println(r);
        System.out.println(r1);
        
        if (r.equals(r1) == true)
        	System.out.println("true");
        else
        	System.out.println("false");
        	
        App.StaticInnerClass sic = new App.StaticInnerClass();
        System.out.println(sic.getS());
        App.NonStaticInnerClass nsic = a.new NonStaticInnerClass();
        System.out.println(nsic.getS());
        
        
    }
    
    public App() {
    	Num nar[] = Num.values();
    	for(Num nm : nar)
    		System.out.println(nm.toString());
    	Num n = Num.ONE;
    	
    	System.out.println(Num.ONE.toString());
    	System.out.println(n.toString());
    	
    	System.out.println("\n" + n.get1().toString());
    	
    	BasicConfigurator.configure();
    	
    	HelloWorld hw = new HelloWorld() {
        	public String getMsg() {
        		return "hello world !!!!!!!";
        	}
        };
        System.out.println(hw.getMsg());
    	
    	//copyFile();

    	//System.out.println("134 --> " + formatNumer(134));
    }   
    
    interface HelloWorld {
    	public String getMsg();
    }
    
    private class NonStaticInnerClass {
    	public String getS() {
    		return "muhd ashiq " + num ;
    	}
    }
    
    static class StaticInnerClass {
    	public String getS() {
    		return "ashiq " + Num.ONE  ;
    	}
    }
    
    private Num num = Num.TWO;
    public enum Num {
    	
    	ONE (1, "one"), 
    	TWO (2, "two"), 
    	THREE (3, "three"), 
    	FOUR (4, "four"); 
    	
    	int v;
    	String n;
    	
    	Num() {
    	}
 
    	Num(int v, String n) {
    		this.v = v;
    		this.n = n;
    	}
    	
    	public String get1() { 
    		return ONE.toString() + " " +  v + " " + n; 
    	} 
    } 
    
 
    
    public boolean copyFile() {
    	System.out.println("App.copyFile");
    	FileUtils.fileCopy("c:\\java\\mytext.txt", "c:\\java\\mytext-copy.txt");
    	return false;
    }
    
    public String formatNumer(int i) {
    	//NumberFormat numberFormatter;
    	//numberFormatter = NumberFormat.getNumberInstance(currentLocale);
    	System.out.println("[In]" + i);
    	String s =  "";
    	int n = 0;
    	while (i > 0) {
    		s = " " + i%10 + " " + (int)Math.pow(10, n++) + "s" + s;
    		i = i/10;
    	}
    	
    	System.out.println("[Out]" + s);
    	return s.substring(1);
    }
    
}
