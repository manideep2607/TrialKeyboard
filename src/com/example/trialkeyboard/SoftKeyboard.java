package com.example.trialkeyboard;


import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.view.View;
import android.widget.RelativeLayout;

public class SoftKeyboard extends InputMethodService implements
		OnKeyboardActionListener {
	private MainKeyboardView mKeyboardView;
	private Keyboard mKeyboard;
	
	
	@Override
	public View onCreateInputView(){
		final RelativeLayout layout = ( RelativeLayout)getLayoutInflater().inflate(R.layout.layout, null);
		mKeyboard = new Keyboard(this, R.xml.test);
		mKeyboardView = (MainKeyboardView) layout.findViewById(R.id.keyboard);
		mKeyboardView.setKeyboard(mKeyboard);
		mKeyboardView.setOnKeyboardActionListener(this);
		return layout;
		}
	

	@Override
	public void onKey(int arg0, int[] arg1) {
		// TODO Auto-generated method stub
		getCurrentInputConnection().commitText(String.valueOf((char) arg0), 1);
	}
	
	@Override
	public void onPress(int arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onRelease(int arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onText(CharSequence arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void swipeDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void swipeLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void swipeRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void swipeUp() {
		// TODO Auto-generated method stub

	}

}
