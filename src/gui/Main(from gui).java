package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * test
 *
 * @author normenhansen
 */
public class somethingelse extends SimpleApplication {

    gui mygui;
    Geometry geom;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        mygui = new gui(this);
        


        //////////////////////////////////////BOX

    }

    @Override
    public void simpleUpdate(float tpf) {
        if(mygui.getchanged()){
        if ("green".equals(mygui.s)) {
            rootNode.detachAllChildren();
            Box b = new Box(Vector3f.ZERO, 1, 1, 1);
            geom = new Geometry("Box", b);

            Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Green);
            geom.setMaterial(mat);

            rootNode.attachChild(geom);
        }
        if ("blue".equals(mygui.s)) {
            rootNode.detachAllChildren();
            Box b = new Box(Vector3f.ZERO, 2, 2, 2);
            geom = new Geometry("Box", b);

            Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Blue);
            geom.setMaterial(mat);

            rootNode.attachChild(geom);
        }
        geom.rotate(0, 0, 5f);
        mygui.resetchanged();
        }
        if(geom!=null){
        geom.rotate(0, 0, 5f);
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }

     public void initLights() {
        /**
         * A white ambient light source.
         */
        //AmbientLight ambient = new AmbientLight();
        //ambient.setColor(ColorRGBA.White);
        //rootNode.addLight(ambient);
        /**
         * A white, directional light source
         */
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection((new Vector3f(-0.3f, -0.4f, -0.5f)).normalizeLocal());
        sun.setColor(ColorRGBA.White);
        rootNode.addLight(sun);
    }
}
