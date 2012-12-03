
package tests;

import org.junit.Before;
import org.junit.Test;

import node.Node1;
import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Mohamed
 *
 */
public class Nodetest extends TestCase {
  double x,y,z;
  double x2,y2,z2=0;
  double x1,y1,z1=0;
	public Nodetest(String string) {
	// TODO Auto-generated constructor stub
}

	/** Création de noeuds dans la méthode SetUp:
	un noeud de référence et d'autres noeuds variables (x,y,z) ou  
	l'on remplace ces variables par nos valeurs**/
  
 
public  void main(String[] args) {       
 junit.textui.TestRunner.run(Nodetest.class);  }
  
 @Before
  public void SetUp() throws Exception{
try{
	Node1 n1 = new Node1(x1,y1,z1);
	Node1 n2 = new Node1(x,y,z);
	
	n2.setX(x2);
	n2.setY(y2);
	n2.setZ(z2);
	
}catch(Exception e){
	throw new Exception("",e);
}
 } 

 /** on vérifie si tous les noeuds ne sont pas vide. Si oui, on asservit jusque l'on ait des noeuds pas vide**/
 
  public static boolean testnode(Node1 n2){
		if((n2) == null ){
          Assert.assertNotNull(n2);
		  return false;
		}
		else{
         return true;
		}
	}
  
  
@Test
public void testdistance(double distanceCalculate){
	double distanceChecked = (double) Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2)+ Math.pow((z2-z1),2));
	if(distanceCalculate != distanceChecked){
			System.out.println("valeur fausse");
			Assert.assertEquals(distanceChecked, distanceCalculate);
	}
	else if(distanceCalculate == distanceChecked){
			System.out.println("Ok");
	}

  
/** Nous lancons le test**/
   TestCase test = new Nodetest("testnode");
   test.run ();

}

public static Test suite() {
	TestSuite suite = new TestSuite();
    suite.addTest(new Nodetest("testnode"));
    suite.addTest(new Nodetest("testdistance"));
    return (Test) suite;
}
}


