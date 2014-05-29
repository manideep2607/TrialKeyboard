package com.example.trialkeyboard;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class MainKeyboardView extends KeyboardView {
	private PopupWindow mPreviewPopup;
	private View mPopupParent;
	
	public MainKeyboardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
		// TODO Auto-generated constructor stub
	}
	
	public MainKeyboardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize(context);
		// TODO Auto-generated constructor stub
	}
	

	private void initialize(Context context) {
		// TODO Auto-generated method stub
		super.setPreviewEnabled(false);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View v = inflater.inflate(R.layout.preview_layout, null);
		
		mPreviewPopup = new PopupWindow(context);
		mPreviewPopup.setContentView(v);
		mPreviewPopup.setTouchable(false);
		mPreviewPopup.setWindowLayoutMode(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		mPreviewPopup.setWidth((int) getResources().getDimension(R.dimen.popupheight));
		mPreviewPopup.setHeight((int) getResources().getDimension(R.dimen.popupheight));
		mPreviewPopup.setBackgroundDrawable(null);
		mPopupParent = this;
	}

	public void showPreviewAt(int posX, int posY) {
		// TODO Auto-generated method stub
		final PopupWindow previewPopup = mPreviewPopup;
		previewPopup.showAtLocation(mPopupParent, Gravity.NO_GRAVITY, posX, posY);
	}
	
	public void dismissPreview(){
		final PopupWindow previewPopup = mPreviewPopup;
		previewPopup.dismiss();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent me){
		int action = me.getAction();
		if(action == MotionEvent.ACTION_DOWN){
			int x = (int) me.getX();
			int y = (int) me.getY();
			showPreviewAt(x,y);
		}
		else if(action == MotionEvent.ACTION_UP){
			dismissPreview();
		}
		
		return super.onTouchEvent(me);
	}
}
