
package prove15102018;

import java.util.*;
import contocorrente.SimpleDate;

public class Prove15102018
{

    public static void main(String[] args)
    {
        int[] v1 = {10,20,30,40,50,60,70,80,90,100};
        
        ArrayList lista = new ArrayList();
        for(int i = 0;i < 10;i++ )
        {
         lista.add(i*11);
        }
        
        //set an alement alla pos 1
        lista.add(1,5);
        lista.remove(4);
        lista.add(0,3.2);
        lista.add("siamo in tanti");
        System.out.println(lista.indexOf("siamo in tanti"));
        System.out.println(lista);
        System.out.println(lista.size());
       // lista.sort(null);
      //   System.out.println(lista);
        Anagrafica anagrafica1 = new Anagrafica("Alessandro1","Rovereto",new SimpleDate("17/01/1981"));
        Anagrafica anagrafica2 = new Anagrafica("Alessandro2","Rovereto",new SimpleDate("17/01/1981"));
        Anagrafica anagrafica3 = new Anagrafica("Alessandro3","Rovereto",new SimpleDate("17/01/1981"));
        Anagrafica anagrafica4 = new Anagrafica("Alessandro1","Rovereto",new SimpleDate("1/01/1981"));
         
        ArrayList lista2 = new ArrayList();
        lista2.add(anagrafica1);
        lista2.add(anagrafica2);
        lista2.add(anagrafica3);
        lista2.add(anagrafica4);
        System.out.println(lista2);
        
        Anagrafica.test();
    }
    
}

class Anagrafica
{
  private String     nominativo;
  private String     comune;
  private SimpleDate nascita;
 
  public Anagrafica(String n,String c,SimpleDate d)
  {
     nominativo = n;
     comune     = c;
     nascita    = d;
  }
   public Anagrafica(String n,String c,String d)
  {
     nominativo = n;
     comune     = c;
     nascita    = new SimpleDate(d);
  }
  
  public boolean equals(Anagrafica other)
  {
      //o con if else
   return nominativo.toLowerCase().equals(other.nominativo.toLowerCase()) && nascita.equals(other.nascita);
  }
  public int compareTo(Anagrafica other)
  {
      //potrei toglierlo
    if(this.equals(other))
    {
     return 0;
    }
    else if (nominativo.toLowerCase().equals(other.nominativo.toLowerCase()))
      {
      //controllo la data
      if(nascita.before(other.nascita))
      {
            return -1;
      }
        
        return 1;
      }
      else
      {
         return nominativo.toLowerCase().compareTo(other.nominativo.toLowerCase());
      }
  }
  
   public static void test()
   {
       Anagrafica anagrafica1 = new Anagrafica("Pippo Baudo","Catania",  "10-10-1940");
       Anagrafica anagrafica2 = new Anagrafica("Vasco Rossi","Reggio e.", "10-10-1950");
       Anagrafica anagrafica3 = new Anagrafica("Vasco Rossi","Reggio e.", "10-10-1955");
       System.out.println(anagrafica2.compareTo(anagrafica1));
        System.out.println(anagrafica2.compareTo(anagrafica3));
   }
   
    public String toString()
    {
      return "["+nominativo+"]"+"["+comune+"]"+"["+nascita+"]";
    }
    
}