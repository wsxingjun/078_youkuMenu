package it.oztaking.com.youkumenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import it.oztaking.com.MyAnimationUtils.MyAnimationUtils;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private RelativeLayout rl_level1;
    private RelativeLayout rl_level2;
    private RelativeLayout rl_level3;
    private ImageButton ib_home;
    private ImageButton ib_menu;

    private boolean isLevel3Display = true;
    private boolean isLevel2Display = true;
    private boolean isLevel1Display = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //动画的初始化
        initAnimator();

    }

    private void initAnimator() {
        rl_level1 = (RelativeLayout) findViewById(R.id.rl_level1);
        rl_level2 = (RelativeLayout) findViewById(R.id.rl_level2);
        rl_level3 = (RelativeLayout) findViewById(R.id.rl_level3);


        ib_home = (ImageButton) findViewById(R.id.ib_home);
        ib_menu = (ImageButton) findViewById(R.id.ib_menu);

        ib_home.setOnClickListener(this);
        ib_menu.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        //如果有动画执行，则直接返回
        if (MyAnimationUtils.runningAnimationCount > 0){
            return;
        }

        switch (v.getId()) {
            case R.id.ib_home:
                if (isLevel2Display) {
                    int delay = 0;
                    //如果level3没有转出去，先让level3转出去
                    if (isLevel3Display){
                        MyAnimationUtils.rotateOutAnim(rl_level3,delay);
                        isLevel3Display = false;
                    }
                    delay += 200;
                    MyAnimationUtils.rotateOutAnim(rl_level2,delay);
                } else {
                    MyAnimationUtils.rotateInAnim(rl_level2,0);
                }
                isLevel2Display = !isLevel2Display;
                break;

            case R.id.ib_menu:
                if (isLevel3Display) {
                    MyAnimationUtils.rotateOutAnim(rl_level3,0);
                } else {
                    MyAnimationUtils.rotateInAnim(rl_level3,0);
                }
                isLevel3Display = !isLevel3Display;
                break;
            default:
                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("AAA:keycode = "+keyCode);
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (MyAnimationUtils.runningAnimationCount > 0){
                return true;
            }
            //如果按下的是菜单按钮
            if (isLevel1Display){
                int delay = 0;
                //隐藏三级菜单
                if (isLevel3Display){
                    MyAnimationUtils.rotateOutAnim(rl_level3,0);
                    isLevel3Display = false;
                    delay += 200;
                }
                //隐藏二级菜单
                if (isLevel2Display){
                    MyAnimationUtils.rotateOutAnim(rl_level2,delay);
                    isLevel3Display = false;
                    delay += 200;
                }

                //隐藏一级菜单
                MyAnimationUtils.rotateOutAnim(rl_level1,delay);
            }else {
                MyAnimationUtils.rotateInAnim(rl_level1,0);
                MyAnimationUtils.rotateInAnim(rl_level2,200);
                MyAnimationUtils.rotateInAnim(rl_level3,400);

                isLevel3Display = true;
                isLevel2Display = true;
            }
            isLevel1Display = !isLevel1Display;

            return true;//消费了当前事件
        }


        return super.onKeyDown(keyCode, event);
    }
}
