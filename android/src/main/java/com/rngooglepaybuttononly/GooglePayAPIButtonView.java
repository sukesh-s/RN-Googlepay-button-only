package com.rngooglepaybuttononly;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.wallet.button.ButtonConstants;
import com.google.android.gms.wallet.button.ButtonOptions;
import com.google.android.gms.wallet.button.PayButton;

import org.json.JSONArray;

public class GooglePayAPIButtonView extends FrameLayout {
  private ThemedReactContext context;
  private Integer type;
  private Integer appearance;
  private int borderRadius = 4; // Matches the default on iOS's ApplePayButton
  private PayButton button;

  public GooglePayAPIButtonView(Context context) {
    super(context);
    this.context = (ThemedReactContext) context;
  }

  public void initializeGooglePayButton() {
    if (button != null) {
      removeView(button);
    }

    button = configureGooglePayButton();
    System.out.println("Buttinadasdasdsds"+button);
    addView(button);
    getViewTreeObserver().addOnGlobalLayoutListener(() -> requestLayout());
  }

  private PayButton configureGooglePayButton() {
    PayButton googlePayButton = new PayButton(context);
    googlePayButton.initialize(buildButtonOptions());
    googlePayButton.setOnClickListener(v -> {
      // Call the Javascript TouchableOpacity parent where the onClick handler is set
      View parentView = (View) getParent();
      if (parentView != null) {
        parentView.performClick();
      } else {
        Log.e("RN-Googlepay-button-only", "Unable to find parent of GooglePayButtonView.");
      }
    });
    return googlePayButton;
  }

  private ButtonOptions buildButtonOptions() {

    ButtonOptions.Builder options = ButtonOptions.newBuilder();

    Integer buttonType = getButtonType();
    Log.e("Button Option Type", String.valueOf(buttonType)+"ope");
    options.setButtonType(ButtonConstants.ButtonType.DONATE);
    if (buttonType != null) {
      Log.e("Button Inside", String.valueOf(buttonType));

      options.setButtonType(ButtonConstants.ButtonType.DONATE);
    }

    Integer buttonTheme = getButtonTheme();
    if (buttonTheme != null) {
      options.setButtonTheme(buttonTheme);
    }

    options.setCornerRadius((int) PixelUtil.toPixelFromDIP(this.borderRadius));

    return options.build();
  }


  private Integer getButtonType() {
    Log.e("type", String.valueOf(this.type));
    switch (this.type) {
      case 0:
      case 1:
        return ButtonConstants.ButtonType.BUY;
      case 6:
        return ButtonConstants.ButtonType.BOOK;
      case 5:
        return ButtonConstants.ButtonType.CHECKOUT;
      case 4:
        return ButtonConstants.ButtonType.DONATE;
      case 11:
        return ButtonConstants.ButtonType.ORDER;
      case 7:
        return ButtonConstants.ButtonType.SUBSCRIBE;
      case 1000:
        return ButtonConstants.ButtonType.PAY;
      case 1001:
        return ButtonConstants.ButtonType.PLAIN;
      default:
        return null;
    }
  }

  private Integer getButtonTheme() {
    switch (this.appearance) {
      case 0:
      case 1:
        return ButtonConstants.ButtonTheme.LIGHT;
      case 2:
        return ButtonConstants.ButtonTheme.DARK;
      default:
        return null;
    }
  }

  @Override
  public void requestLayout() {
    super.requestLayout();
    post(mLayoutRunnable);
  }

  private final Runnable mLayoutRunnable = () -> {
    measure(
      MeasureSpec.makeMeasureSpec(getWidth(), MeasureSpec.EXACTLY),
      MeasureSpec.makeMeasureSpec(getHeight(), MeasureSpec.EXACTLY)
    );
    button.layout(getLeft(), getTop(), getRight(), getBottom());
  };

  public void setType(int type) {
    this.type = type;
  }

  public void setAppearance(int appearance) {
    this.appearance = appearance;
  }

  public void setBorderRadius(int borderRadius) {
    this.borderRadius = borderRadius;
  }

}
