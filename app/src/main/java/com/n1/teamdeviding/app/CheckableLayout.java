package com.n1.teamdeviding.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by aleksey on 5/21/14.
 */
public class CheckableLayout extends RelativeLayout implements Checkable {

    private Context mContext;
    private boolean mChecked;
    private ImageView mImgItem = null;
    private TextView mSelTextView;

    public CheckableLayout(Context context){
        this(context, null, 0);
    }

    public CheckableLayout(Context context, AttributeSet attrs){
        this(context, attrs, 0);
    }

    public CheckableLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.item, this);
        mImgItem = (ImageView)findViewById(R.id.imgItem);
        mSelTextView = (TextView)findViewById(R.id.textItem);

    }

    @Override
    public void setChecked(boolean checked) {
        mChecked = checked;
        mSelTextView.setBackgroundColor(checked ? getResources().getColor(R.color.cool_green) : getResources().getColor(R.color.orange));
                //setBackgroundResource(checked ? R.drawable.background_item : R.drawable.background_item2);
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    public void setTextResId(int resId){
        if(mSelTextView != null){
//            mSelTextView.setBackgroundColor(resId);
            System.out.println("hi");
        }
    }
}
