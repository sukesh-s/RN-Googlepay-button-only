import * as React from 'react';

import { StyleSheet, View, TouchableOpacity } from 'react-native';
import { GooglePayImage, GoogleAPIButton } from 'rn-google-pay-button-only';

export default function App() {
  return (
    <View style={styles.container}>
      {/* <GooglePayImage type="PAY_WITH" style={styles.box} />
      <GooglePayImage type="SHADOW_PAY_WITH" style={styles.box} />
      <GooglePayImage type="GOOGLE_PAY" style={styles.box} />
      <GooglePayImage type="SHADOW_GOOGLE_PAY" style={styles.box} />
      <GooglePayImage type="BUY_WITH" style={styles.box} />
      <GooglePayImage type="SHADOW_BUY_WITH" style={styles.box} /> */}
      {/* <GooglePayImage type="SHADOW_BUY_WITH" style={styles.box} /> */}
      <TouchableOpacity
        onPress={() => {
          console.log('clickes....');
        }}
      >
        <GoogleAPIButton
          type={5}
          appearance={2}
          borderRadius={30}
          style={styles.box}
        />
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    // flex: 1,
    alignItems: 'center',
    justifyContent: 'space-around',
  },
  box: {
    width: 338,
    height: 60,
  },
});
