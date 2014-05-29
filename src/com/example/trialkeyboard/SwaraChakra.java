package com.example.trialkeyboard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SwaraChakra extends View {
	private float mOuterRadius;
	private Paint mCirclePaint;
	private float mCenterX;
	private float mCenterY;

	public SwaraChakra(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}
	
	public SwaraChakra(Context context, AttributeSet attrs){
		super(context,attrs);
		init();
		TypedArray a = context.getTheme().obtainStyledAttributes(
				attrs, 
				R.styleable.SwaraChakra, 
				0, 0);
		
		try{
			mOuterRadius = a.getDimension(R.styleable.SwaraChakra_outerRadius, 100);
		}
		finally{
			a.recycle();
		}
	}
	
	private void init(){
		mCirclePaint = new Paint();
		mCirclePaint.setColor(Color.DKGRAY);
		mCenterX = 0;
		mCenterY = 0;
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		mCenterX = getPaddingLeft();
		mCenterY = getPaddingTop();
		canvas.drawCircle(mCenterX, mCenterY, mOuterRadius, mCirclePaint);
	}
	

}
