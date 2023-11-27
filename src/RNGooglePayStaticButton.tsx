import React from 'react';
import {
  requireNativeComponent,
  UIManager,
  Platform,
  type ViewStyle,
} from 'react-native';

const LINKING_ERROR =
  `The package 'rn-google-pay-button-only' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

type payButtonType =
  | 'PAY_WITH'
  | 'SHADOW_PAY_WITH'
  | 'BUY_WITH'
  | 'SHADOW_BUY_WITH'
  | 'GOOGLE_PAY'
  | 'SHADOW_GOOGLE_PAY';

type RnGooglePayButtonOnlyProps = {
  type: payButtonType;
  style: ViewStyle;
};

const ComponentName = 'RnGooglePayButtonOnlyView';

const RnGooglePayButtonOnlyView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<RnGooglePayButtonOnlyProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };

const GooglePayButtonImageOnly: React.FC<RnGooglePayButtonOnlyProps> = ({
  ...props
}) => {
  if (Platform.OS !== 'android') {
    return null;
  }
  return <RnGooglePayButtonOnlyView {...props} />;
};
export default GooglePayButtonImageOnly;
