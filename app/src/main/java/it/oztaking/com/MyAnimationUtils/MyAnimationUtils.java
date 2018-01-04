package it.oztaking.com.MyAnimationUtils;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2018-01-04.
 */

public class MyAnimationUtils {

    //旋转出去的动画
    public static void rotateOutAnim(RelativeLayout rl){
        RotateAnimation ra = new RotateAnimation(
                0f, -180f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1.0f);
        ra.setFillAfter(true);
        ra.setDuration(500);
        rl.startAnimation(ra);
    }

    //旋转进来的动画
    public static void rotateInAnim(RelativeLayout rl){
        RotateAnimation ra = new RotateAnimation(
                -180f,0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1.0f);
        ra.setFillAfter(true);
        ra.setDuration(500);
        rl.startAnimation(ra);
    }
}
