package com.rngooglepaybuttononly;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNGooglePayButtonAPIManager extends SimpleViewManager<GooglePayAPIButtonView> {
  public static final String REACT_CLASS = "RnGooglePayButtonOnlyAPIView";
  @NonNull
  @Override
  public String getName() {
    return REACT_CLASS;
  }

  @Override
  protected void onAfterUpdateTransaction(GooglePayAPIButtonView view) {
    super.onAfterUpdateTransaction(view);
    view.initializeGooglePayButton();
  }

  @ReactProp(name = "type")
  public void setType(GooglePayAPIButtonView view, int buttonType) {
    view.setType(buttonType);
    Log.e("ASP", String.valueOf(buttonType));
  }

  @ReactProp(name = "appearance")
  public void setAppearance(GooglePayAPIButtonView view, int appearance) {
    view.setAppearance(appearance);
  }

  @ReactProp(name = "borderRadius")
  public void setBorderRadius(GooglePayAPIButtonView view, int borderRadius) {
    view.setBorderRadius(borderRadius);
  }

  @NonNull
  @Override
  protected GooglePayAPIButtonView createViewInstance(@NonNull ThemedReactContext themedReactContext) {
    return new GooglePayAPIButtonView(themedReactContext);
  }
}
