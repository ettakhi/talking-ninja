package com.Talking.Ninja;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.view.MotionEvent;
import android.widget.ImageView;

public class TalkingNinjaActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
   ImageView animation;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        animation = (ImageView)findViewById(R.id.imageAnimation);
        animation.setBackgroundResource(R.drawable.animation);		// the frame-by-frame animation defined as a xml file within the drawable folder
    }
    
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


