package org.ayo.robot.anim.propertyanim;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import org.ayo.robot.anim.DemoBase;

/**
 * Created by Administrator on 2017/1/8 0008.
 */

public class DemoTranslateY extends DemoBase{
    public static void startForResult(Activity a){
        Intent intent = new Intent(a, DemoTranslateY.class);
        a.startActivityForResult(intent, 205);
    }
    @Override
    protected String getType() {
        return "translationY";
    }
    @Override
    protected float getFrom() {
        return -distance;
    }

    @Override
    protected float getTo() {
        return 0;
    }
    int distance = 0;
    @Override
    protected Animator createAnimator(View v){

        v.setPivotX(getCustomPivotX()/100 * v.getWidth());
        v.setPivotY(getCustomPivotY()/100 * v.getHeight());

        ViewGroup parent = (ViewGroup) v.getParent();
        distance = parent.getHeight() - v.getTop();
        ObjectAnimator o = ObjectAnimator.ofFloat(v, "translationY", -distance, 0);
        return o;
//        AnimatorSet mAnimatorSet = new AnimatorSet();
//        mAnimatorSet.playTogether(
//
//        );
    }


    @Override
    protected View createTestView() {
        return null;
    }
}
