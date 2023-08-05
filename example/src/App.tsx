import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import GooglePayImage from 'rn-google-pay-button-only';

export default function App() {
  return (
    <View style={styles.container}>
      <GooglePayImage type="PAY_WITH" style={styles.box} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 228,
    height: 60,
  },
});
