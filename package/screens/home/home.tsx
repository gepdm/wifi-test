import { Button, NativeModules, SafeAreaView, ScrollView, StatusBar, useColorScheme, View } from "react-native";
import React from 'react';
const { WifiSwitcher } = NativeModules;

const HomeScreen = () => {
  const isDarkMode = useColorScheme() === 'dark';

  return (
    <SafeAreaView style={{ flex: 1, justifyContent: 'space-between', alignItems: 'stretch' }}>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />
      <ScrollView
        contentInsetAdjustmentBehavior="automatic"
      >
        <View>
          <Button
            title="Ligar wifi"
            color="#841584"
            onPress={() => {
              WifiSwitcher.setWifiEnabled();
            }}
          />
          <Button
            title="Desligar Wifi"
            color="#200456"
            onPress={() => {
              WifiSwitcher.setWifiDisable();
            }}
          />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
};

export {  HomeScreen} ;
