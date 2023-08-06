import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import GooglePayImage from 'rn-google-pay-button-only';

export default function App() {
  return (
    <View style={styles.container}>
      <GooglePayImage type="PAY_WITH" style={styles.box} />
      <GooglePayImage type="SHADOW_PAY_WITH" style={styles.box} />
      <GooglePayImage type="GOOGLE_PAY" style={styles.box} />
      <GooglePayImage type="SHADOW_GOOGLE_PAY" style={styles.box} />
      <GooglePayImage type="BUY_WITH" style={styles.box} />
      <GooglePayImage type="SHADOW_BUY_WITH" style={styles.box} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'space-around',
  },
  box: {
    width: 228,
    height: 60,
  },
});
