package com.think.simplekeyboard;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;


public class MyKeyBoardView extends LinearLayout {
    private EditText mEditText;

    public MyKeyBoardView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        LayoutInflater.from(context).inflate(R.layout.lyt_keyboard, this, true);

        KeyboardView kv = (KeyboardView) findViewById(R.id.kv_lyt_keyboard);
        Keyboard kb = new Keyboard(context, R.xml.qwer);
        kv.setKeyboard(kb);
        kv.setEnabled(true);
        kv.setPreviewEnabled(true);
        kv.setOnKeyboardActionListener(mListener);
    }

    public void setStrReceiver(EditText et) {
        mEditText = et;
    }

    private KeyboardView.OnKeyboardActionListener mListener = new KeyboardView.OnKeyboardActionListener() {
        @Override
        public void swipeUp() {
        }

        @Override
        public void swipeRight() {
        }

        @Override
        public void swipeLeft() {
        }

        @Override
        public void swipeDown() {
        }

        @Override
        public void onText(CharSequence text) {
        }

        @Override
        public void onRelease(int primaryCode) {
        }

        @Override
        public void onPress(int primaryCode) {
        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            Editable editable = mEditText.getText();
            int selectionPosition = mEditText.getSelectionStart();

            if (primaryCode == Keyboard.KEYCODE_DELETE) {
                if (editable != null && editable.length() > 0) {
                    if (selectionPosition > 0) {
                        editable.delete(selectionPosition - 1, selectionPosition);
                    }
                }
            } else {
                editable.insert(selectionPosition, Character.toString((char) primaryCode));
            }
        }
    };
}
