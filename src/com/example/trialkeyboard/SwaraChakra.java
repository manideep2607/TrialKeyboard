package com.example.trialkeyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SwaraChakra extends View {
	private int mOuterRadius;
	private Paint mBlackPaint;
	private Paint mWhitePaint;

	public SwaraChakra(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}
	
	public SwaraChakra(Context context, AttributeSet attrs){
		super(context,attrs);
		init();
	}
	
	private void init(){
		mBlackPaint = new Paint();
		mBlackPaint.setColor(Color.BLACK);
		mWhitePaint = new Paint();
		mWhitePaint.setColor(Color.WHITE);
		mOuterRadius = (int) getResources().getDimension(R.dimen.outer_radius);
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		super.onDraw(canvas);
		canvas.drawCircle(mOuterRadius, mOuterRadius, mOuterRadius, mBlackPaint);
		canvas.drawCircle(mOuterRadius, mOuterRadius, mOuterRadius/2, mWhitePaint);
	}
	
	@Override
	protected void onMeasure(int measuredWidth, int measuredHeight){
		setMeasuredDimension(2*mOuterRadius,2*mOuterRadius);
	}
	
}
