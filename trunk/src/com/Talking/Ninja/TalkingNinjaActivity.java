package com.Talking.Ninja;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;


public class TalkingNinjaActivity extends Activity {
    /** Called when the activity is first created. */

   ImageView animation;
   Button button;
   //TextView myLabel;
   View touchView;
   Animation anim;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        animation = (ImageView)findViewById(R.id.kenstance);
        animation.setBackgroundResource(R.drawable.ken_stance_animation);		// the frame-by-frame animation defined as a xml file within the drawable folder
        button = (Button) findViewById(R.id.button_id);
      
        animation.setOnTouchListener(new ImageView.OnTouchListener(){
        	public boolean onTouch(View v, MotionEvent event) {
        		float xPos = event.getX();
        		float yPos = event.getY();
                if ((xPos > 42) && (xPos < 115)&& (yPos > 51) && (yPos < 59)) {
                	Log.d("ninja", "xPos = " + xPos);
            		Log.d("ninja", "yPos = " + yPos);
            		kick(v);
                }
                return true;
        	}
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	kick(v);
            	Handler mHandler = new Handler();
            	mHandler.postDelayed(resumeStance, 1050);
            }
        });
    
    }
    
    public void animation1(float xpos, float ypos, View v){
    	if ((xpos > 42) && (xpos < 115)&& (ypos > 51) && (ypos < 59)) {
        	Log.d("ninja", "xPos = " + xpos);
    		Log.d("ninja", "yPos = " + ypos);
        	kick(v);
        }
    	
    	
    }
    
    public void kick(View view) {
    	
    	animation.setBackgroundResource(R.drawable.ken_rndhouse_animation);
    	AnimationDrawable frameAnimation = (AnimationDrawable)animation.getBackground();
    	frameAnimation.start();
    }
    
    private Runnable resumeStance = new Runnable() {
        public void run() {
        	animation.setBackgroundResource(R.drawable.ken_stance_animation);
        	AnimationDrawable frameAnimation = (AnimationDrawable)animation.getBackground();
        	frameAnimation.start();
        }
     };
    @Override
    /**
     * This method is called whenever the Activity becomes visible or invisible to the user.
     * During this method call its possible to start the animation.
     */
	public void onWindowFocusChanged (boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		AnimationDrawable frameAnimation = 
			(AnimationDrawable) animation.getBackground();
		if(hasFocus) {
			frameAnimation.start();
		} else {
			frameAnimation.stop();
		}
	}
    
    public void onTouch (MotionEvent e) {
    	super.onTouchEvent(e);	
    	
    }
}


