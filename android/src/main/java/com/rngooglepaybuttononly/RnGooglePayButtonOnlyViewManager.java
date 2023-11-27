package com.rngooglepaybuttononly;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;


import androidx.annotation.NonNull;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;

public class RnGooglePayButtonOnlyViewManager extends SimpleViewManager<RelativeLayout> {
  public static final String REACT_CLASS = "RnGooglePayButtonOnlyView";
  private static final String TYPE_PAY="PAY_WITH";
  private static final String TYPE_PAY_SHADOW="SHADOW_PAY_WITH";
  private static final String TYPE_BUY="BUY_WITH";
  private static final String TYPE_BUY_SHADOW="SHADOW_BUY_WITH";
  private static final String TYPE_GOOGLE_PAY="GOOGLE_PAY";
  private static final String TYPE_GOOGLE_PAY_SHADOW="SHADOW_GOOGLE_PAY";
  private static final String TYPE_GOOGLE_PAY_PLAIN_DARK="GOOGLE_PAY_PLAIN_DARK";
  public LayoutInflater layoutInflater;

  @Override
  @NonNull
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  @NonNull
  public RelativeLayout createViewInstance(ThemedReactContext reactContext) {
    this.layoutInflater=LayoutInflater.from(reactContext);
    return new RelativeLayout(reactContext);
  }


  @ReactProp(name="type")
  public void setColor(RelativeLayout view, String type) {
    switch (type){
      case TYPE_PAY:
        view.addView(layoutInflater.inflate(R.layout.pay_with_googlepay_button_no_shadow, null));
        break;
      case TYPE_PAY_SHADOW:
        view.addView(layoutInflater.inflate(R.layout.pay_with_googlepay_button, null));
        break;
      case TYPE_BUY:
        view.addView(layoutInflater.inflate(R.layout.buy_with_googlepay_button_no_shadow, null));
        break;
      case TYPE_BUY_SHADOW:
        view.addView(layoutInflater.inflate(R.layout.buy_with_googlepay_button, null));
        break;
      case TYPE_GOOGLE_PAY_SHADOW:
        view.addView(layoutInflater.inflate(R.layout.googlepay_button, null));
        break;
      case TYPE_GOOGLE_PAY_PLAIN_DARK:
        view.addView(layoutInflater.inflate(R.layout.googlepay_button_dark,null));
        break;
      default:
        view.addView(layoutInflater.inflate(R.layout.googlepay_button_no_shadow, null));
        break;
    }
    view.invalidate();
  }

}
