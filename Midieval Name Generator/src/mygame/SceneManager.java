/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioNode;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.SceneGraphVisitor;
import com.jme3.scene.Spatial;
import com.jme3.texture.Texture;

/**
 *
 * @author Bob
 */
public class SceneManager extends AbstractAppState {

  private SimpleApplication app;
  private AssetManager      assetManager;
  
  @Override
  public void initialize(AppStateManager stateManager, Application app) {   
    super.initialize(stateManager, app);
    this.app          = (SimpleApplication) app;
    this.assetManager = this.app.getAssetManager();
    app.getViewPort().setBackgroundColor(ColorRGBA.Cyan);
    initScene();
    initAudio();
    }
  
  private void initScene() {
      
      Node scene = (Node) assetManager.loadModel("Scenes/Castle.j3o");
      app.getRootNode().attachChild(scene);
      app.getCamera().setLocation(scene.getChild("CameraSpot").getLocalTranslation().add(0,3,0));
      app.getFlyByCamera().setEnabled(false);
      app.getCamera().lookAt(scene.getChild("LookSpot").getLocalTranslation().add(0,0,0), new Vector3f(0,1,0));
      makeUnshaded();
      
  }
  
  private void initAudio() {
      
      AudioNode music = new AudioNode(assetManager, "Sounds/Song.ogg", false);
      music.setLooping(true);
      music.setPositional(false);
      music.setVolume(.2f);
      this.app.getRootNode().attachChild(music);
      music.play();
  }
  
  private void makeUnshaded(){
      
    SceneGraphVisitor sgv = new SceneGraphVisitor() {
 
    public void visit(Spatial spatial) {
 
      if (spatial instanceof Geometry) {
        
        Geometry geom = (Geometry) spatial;
        Material mat  = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        Material tat  = new Material(assetManager, "Common/MatDefs/Terrain/Terrain.j3md");
        
        if (geom.getMaterial().getTextureParam("DiffuseMap_1") != null) {
            
          tat.setTexture("Alpha", geom.getMaterial().getTextureParam("AlphaMap").getTextureValue());
          
          if (geom.getMaterial().getTextureParam("DiffuseMap") != null) {
           
          tat.setTexture("Tex1", geom.getMaterial().getTextureParam("DiffuseMap").getTextureValue());
          tat.getTextureParam("Tex1").getTextureValue().setWrap(Texture.WrapMode.Repeat);
          tat.setFloat("Tex1Scale", Float.valueOf(geom.getMaterial().getParam("DiffuseMap_0_scale").getValueAsString()));
          
          }
        
          if (geom.getMaterial().getTextureParam("DiffuseMap_1") != null) {
              
          tat.setTexture("Tex2", geom.getMaterial().getTextureParam("DiffuseMap_1").getTextureValue());
          tat.getTextureParam("Tex2").getTextureValue().setWrap(Texture.WrapMode.Repeat);
          tat.setFloat("Tex2Scale", Float.valueOf(geom.getMaterial().getParam("DiffuseMap_1_scale").getValueAsString()));
          
          }
        
          if (geom.getMaterial().getTextureParam("DiffuseMap_2") != null) {
              
          tat.setTexture("Tex3", geom.getMaterial().getTextureParam("DiffuseMap_2").getTextureValue());
          tat.getTextureParam("Tex3").getTextureValue().setWrap(Texture.WrapMode.Repeat);
          tat.setFloat("Tex3Scale", Float.valueOf(geom.getMaterial().getParam("DiffuseMap_2_scale").getValueAsString()));
          
          }

          geom.setMaterial(tat);
          
          }        
        
        
        else if (geom.getMaterial().getTextureParam("DiffuseMap") != null) {
          mat.setTexture("ColorMap", geom.getMaterial().getTextureParam("DiffuseMap").getTextureValue());
          geom.setMaterial(mat);
        
          }
       
        }
      
      }
    
    };
    
    app.getRootNode().depthFirstTraversal(sgv);   
    
  }
  
}
