package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 *
 *
 * @author Mike Jake and Dave
 */
public class Main extends SimpleApplication {

    KinectInterface kinect;
    KinectSkeleton kinectskeleton;
    BulletAppState bulletAppState;
    Mocap moCap;
    //Gui stuff
    gui mygui;
    Geometry geom;

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        mygui = new gui(this);
        kinectskeleton = new KinectSkeleton(this);
        kinect = new KinectInterface(this);

        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);

        moCap = new Mocap();
        Box b = new Box(Vector3f.ZERO, 1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        if (mygui.getchanged()) {
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
        if (geom != null) {
            geom.rotate(0, 0, 5f);
        }
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
