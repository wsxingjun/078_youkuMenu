package it.oztaking.com.youkumenu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private Context mContext = this;


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

        switch (v.getId()) {
            case R.id.ib_home:
                if (isLevel2Display) {
                    //如果level3没有转出去，先让level3转出去
                    if (isLevel3Display){
                        MyAnimationUtils.rotateOutAnim(rl_level3);
                    }
                    MyAnimationUtils.rotateOutAnim(rl_level2);
                } else {
                    MyAnimationUtils.rotateInAnim(rl_level2);
                }
                isLevel2Display = !isLevel2Display;
                break;

            case R.id.ib_menu:
                if (isLevel3Display) {
                    MyAnimationUtils.rotateOutAnim(rl_level3);
                } else {
                    MyAnimationUtils.rotateInAnim(rl_level3);
                }
                isLevel3Display = !isLevel3Display;
                break;
            default:
                break;

        }
    }
}
