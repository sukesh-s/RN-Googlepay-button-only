import React from 'react';
import {
  type StyleProp,
  type ViewStyle,
  requireNativeComponent,
  UIManager,
  Platform,
} from 'react-native';

const LINKING_ERROR =
  `The package 'rn-google-pay-button-only' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

export interface NativeProps {
  style?: StyleProp<ViewStyle>;
  type?: number;
  appearance?: number;
  borderRadius?: number;
}
const ComponentName = 'RnGooglePayButtonOnlyAPIView';

const RnGooglePayButtonOnlyAPIView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<NativeProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };

const GooglePayAPIButtonNative: React.FC<NativeProps> = ({ ...props }) => {
  if (Platform.OS !== 'android') {
    return null;
  }
  return <RnGooglePayButtonOnlyAPIView {...props} />;
};

export default GooglePayAPIButtonNative;
