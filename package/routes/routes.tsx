import {NavigationContainer} from '@react-navigation/native';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import {Icon} from 'react-native-elements';
import {SafeAreaProvider, SafeAreaView} from 'react-native-safe-area-context';
import React from 'react';
import HomeScreen from '../screens/home';
import SettingsScreen from '../screens/settings';

const Tab = createBottomTabNavigator();

const Routes = () => (
	<SafeAreaProvider>
		<NavigationContainer>
			<SafeAreaView
				style={{
					flex: 1,
					justifyContent: 'space-between',
					alignItems: 'stretch',
				}}>
				<Tab.Navigator
					screenOptions={({route}) => ({
						tabBarIcon: ({color}) => {
							const iconName = route.name === 'Home' ? 'home' : 'settings';
							return (
								<Icon
									tvParallaxProperties={{}}
									name={iconName}
									color={color}
									size={22}
								/>
							);
						},
						tabBarActiveTintColor: '#8257E5',
						tabBarInactiveTintColor: '#111111',
						headerShown: false,
						tabBarLabelStyle: {
							fontSize: 14,
							paddingBottom: 5,
						},
						tabBarStyle: {
							paddingTop: 5,
						},
					})}>
					<Tab.Screen name="Home" component={HomeScreen} />
					<Tab.Screen name="Settings" component={SettingsScreen} />
				</Tab.Navigator>
			</SafeAreaView>
		</NavigationContainer>
	</SafeAreaProvider>
);

export default Routes;
