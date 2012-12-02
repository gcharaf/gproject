package UC;

import java.awt.Frame;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Vector;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

import node.Node;

public class Simple3DMap extends Applet {
    SimpleUniverse simpleU; // this is the SimpleUniverse Class that is used for Java3D
	
    Vector<Node> gridNodes;
    
	public Simple3DMap (){  // this constructor is sometimes needed, even when empty as in here    
	}    

	public Vector<Node> createRandomNodes(){
		Vector<Node> nodes = new Vector<Node>(50);
		Random generator = new Random();
	    for (int i = 0; i < 50; i++) {
	    	float x = (float)(generator.nextFloat() * generator.nextGaussian());
	    	float y = (float)(generator.nextFloat() * generator.nextGaussian());
	    	float z = (float)(generator.nextFloat() * generator.nextGaussian());
	    	
	      nodes.add(new Node(x,y,z));
	    }
		return nodes;
	}
	
	
	
	public void init() { 
	// this function will be called by both applications and applets
	//this is usually the first function to write        
	setLayout(new BorderLayout()); // standard Java code for BorderLayout

	// Canvas3D is where all the action will be taking place, don't worry, after adding it
	// to your layout, you don't have to touch it.    	
	Canvas3D c = new Canvas3D(SimpleUniverse.getPreferredConfiguration()); 

	// add Canvas3D to center of BorderLayout
    	add("Center", c);    

	simpleU= new SimpleUniverse(c); // setup the SimpleUniverse, attach the Canvas3D

	
	//This is very important, the SceneGraph (where all the action takes place) is created
	//by calling a function which here is called 'createSceneGraph'.
	//The function is not necessary, you can put all your code here, but it is a 
	//standard in Java3D to create your SceneGraph contents in the function 'createSceneGraph'

    	BranchGroup scene = createSceneGraph(); 

    	setLight(scene);
    	
	//set the ViewingPlatform (where the User is) to nominal, more on this in the next lesson
        simpleU.getViewingPlatform().setNominalViewingTransform();

	// this will optimize your SceneGraph, not necessary, but it will allow your program to run faster.
        scene.compile(); 
        simpleU.addBranchGraph(scene); //add your SceneGraph to the SimpleUniverse   
    }

    public BranchGroup createSceneGraph() {      

	// This BranchGroup is the root of the SceneGraph, 'objRoot' is the name I use,
	// and it is typically the standard name for it, but can be named anything.
   	BranchGroup objRoot = new BranchGroup(); 
	
   	gridNodes = createRandomNodes();
   	
	for (int i = 0; i < gridNodes.size();i++)
	   {
		Node node = gridNodes.get(i);
		
	      Sphere sphere = new Sphere(0.01f);
	      TransformGroup tg = new TransformGroup();
	      Transform3D transform = new Transform3D();
	      Vector3f vector = new Vector3f( node.x, node.y, node.z);
	      transform.setTranslation(vector);
	      tg.setTransform(transform);
	      tg.addChild(sphere);
	      objRoot.addChild(tg);
	   }
	
	// return Scene Graph
	return objRoot;
	}

	public void setLight(BranchGroup objRoot) {
		Color3f light1Color = new Color3f(1.4f, .1f, .1f); // green light

		   BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
		   Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);
		   DirectionalLight light1 = new DirectionalLight(light1Color, light1Direction);
		   light1.setInfluencingBounds(bounds);
		   objRoot.addChild(light1);
	}

    public void destroy() {	// this function will allow Java3D to clean up upon quiting
	simpleU.removeAllLocales();    
    }  

    public static void main(String[] args) {
	// if called as an application, a 600x600 window will be opened    
        Frame frame = new MainFrame(new Simple3DMap(), 600, 600);    
    }
}