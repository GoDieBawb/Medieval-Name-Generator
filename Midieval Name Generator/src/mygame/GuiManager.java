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
import com.jme3.font.BitmapFont;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.math.Vector2f;
import com.jme3.scene.Node;
import tonegod.gui.controls.buttons.ButtonAdapter;
import tonegod.gui.controls.extras.android.Keyboard;
import tonegod.gui.controls.text.TextField;
import tonegod.gui.core.Screen;

/**
 *
 * @author Bob
 */
public class GuiManager extends AbstractAppState {

  private SimpleApplication app;
  private AssetManager      assetManager;
  private TextField         nameBox;
  private Screen            screen;
  private ButtonAdapter     translateButton;
  private NameGenerator     nameGen;
  private Keyboard          keyboard;
  private String            prevName;
  
  @Override
  public void initialize(AppStateManager stateManager, Application app) {
      
      super.initialize(stateManager, app);
      this.app          = (SimpleApplication) app;
      assetManager      = this.app.getAssetManager();
      screen            = new Screen(app, "tonegod/gui/style/atlasdef/style_map.gui.xml");
      nameGen           = new NameGenerator();
      prevName          = "randomtext";
      screen.setUseTextureAtlas(true,"tonegod/gui/style/atlasdef/atlas.png");
      this.app.getGuiNode().addControl(screen);
      screen.setUseMultiTouch(true);
      initNameBox();
      initTranslateButton();
      initKeyboard();
      
  }
  
  private void initNameBox() {
  
      nameBox = new TextField(screen, new Vector2f(25,25), new Vector2f(25,2f)) {
      
          @Override
          public void onKeyPress(KeyInputEvent evt) {
              
              if (nameBox.getText().toLowerCase().contains("enter")) {
                  nameBox.setText("");
              }
              
              else if (nameBox.getText().toLowerCase().contains(prevName.toLowerCase())) {
                  nameBox.setText("");
              }
              
              super.onKeyPress(evt);
              evt.setConsumed();
          
          }
          
      };
      
      screen.addElement(nameBox);
      nameBox.setDimensions(screen.getWidth() / 1.2f, screen.getHeight()/6);
      nameBox.setPosition(screen.getWidth()/2 - nameBox.getWidth()/2, screen.getHeight()/2);
      nameBox.setText("Enter Your Name");
      nameBox.setTextAlign(BitmapFont.Align.Center);
      nameBox.setFont("Interface/Fonts/PlainBlack.fnt");
      nameBox.setFontSize(35);
      nameBox.setTabFocus();
      
  }
  
  private void initTranslateButton() {
  
      translateButton = new ButtonAdapter(screen, new Vector2f(25,25), new Vector2f(25,25)){
  
          @Override
          public void onButtonMouseLeftUp(MouseButtonEvent evt, boolean toggled) {
              
              if (!nameBox.getText().equals(prevName)) {
                  
                  String newName = nameGen.generateName(nameBox.getText());
                  prevName       = newName;
                  nameBox.setText(newName);
                  
              }
              
              nameBox.setTabFocus();
  
          }
  
      };
      
      screen.addElement(translateButton);
      translateButton.setDimensions(screen.getWidth()/5, screen.getHeight()/5);
      translateButton.setPosition(0, screen.getHeight() - translateButton.getHeight()*1.5f);
      translateButton.setMaterial(assetManager.loadMaterial("Materials/Paper.j3m"));
      translateButton.setFont("Interface/Fonts/PlainBlack.fnt");
      translateButton.setText("Translate");
      
  }
  
  private void initKeyboard() {
    
      keyboard = new Keyboard(screen);
      screen.addElement(keyboard);
      keyboard.setDimensions(0,0);
      setKeyMat(keyboard);
      
  }
  
  private void setKeyMat(Node check) {
  
  for (int i = 0 ; i < check.getChildren().size(); i++) {
      
    if (check.getChild(i) instanceof ButtonAdapter) {
        
        ButtonAdapter key   = (ButtonAdapter) check.getChild(i);
        String        label = key.getText();
        
        check.getChild(i).setMaterial(assetManager.loadMaterial("Materials/Paper.j3m")); 
        key.setFont("Interface/Fonts/PlainBlack.fnt");
        key.setText(label);
        
    } 
    
    else if (check.getChild(i) instanceof Node) {
    
        setKeyMat(((Node)check.getChild(i)));
    
    }
      
    }     
      
  }
  
  }
