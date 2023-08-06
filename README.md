# rn-google-pay-button-only

## Installation

```sh
npm install rn-google-pay-button-only
```

## Demo

## Usage

```js
import GooglePayImage from 'rn-google-pay-button-only';

// wrap with
<TouchableOpacity
  style={styles.container}
  onPress={() => console.log('Pressed')}
>
  <GooglePayImage type="PAY_WITH" style={styles.box} />
</TouchableOpacity>;

const styles = StyleSheet.create({
  box: {
    width: 228,
    height: 60,
  },
});
```

## Props

```js
type RnGooglePayButtonOnlyProps = {
  type: payButtonType,
  style: ViewStyle,
};
```

| **payButtonType** |
| ----------------- |
| PAY_WITH          |
| SHADOW_PAY_WITH   |
| BUY_WITH          |
| SHADOW_BUY_WITH   |
| GOOGLE_PAY        |
| SHADOW_GOOGLE_PAY |

## Caution ⚠️

- This is a button only component and does not contain any logic to handle payment process.
- Android only

## Resources

We obtained the assets from the Google Pay brand's static resources.Refer to the website link for further details.

https://developers.google.com/pay/api/android/guides/resources/payment-button-static-assets

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
