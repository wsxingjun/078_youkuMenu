package it.oztaking.com.MyAnimationUtils;

import android.text.Layout;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2018-01-04.
 */

public class MyAnimationUtils {

    public  static int runningAnimationCount = 0;

    //旋转出去的动画
    public static void rotateOutAnim(RelativeLayout rl, int delay){
        int childCount  = rl.getChildCount();
        System.out.println("rl.getChildCount():"+childCount);
        //如果隐藏，则将所有的子View禁用；
        for (int i=0; i < childCount; i++){
            rl.getChildAt(i).setEnabled(false);
        }

        RotateAnimation ra = new RotateAnimation(
                0f, -180f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1.0f);
        ra.setFillAfter(true);
        ra.setDuration(500);
        ra.setStartOffset(delay);//设置动画开始延时
        ra.setAnimationListener(new MyAnimationListener()); //添加监听
        
        rl.startAnimation(ra);
    }

    //旋转进来的动画
    public static void rotateInAnim(RelativeLayout rl, int delay){

        int childCount  = rl.getChildCount();
        System.out.println("rl.getChildCount():"+childCount);
        //如果隐藏，则将所有的子View禁用；
        for (int i=0; i < childCount; i++){
            rl.getChildAt(i).setEnabled(true);
        }
        RotateAnimation ra = new RotateAnimation(
                -180f,0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 1.0f);
        ra.setFillAfter(true);
        ra.setDuration(500);
        ra.setStartOffset(delay);
        ra.setAnimationListener(new MyAnimationListener()); //添加监听
        rl.startAnimation(ra);
    }

    private static class MyAnimationListener implements Animation.AnimationListener {



        @Override
        public void onAnimationStart(Animation animation) {
            runningAnimationCount++;
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            runningAnimationCount--;
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
