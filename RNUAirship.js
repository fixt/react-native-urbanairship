'use strict';

import { NativeModules } from 'react-native';
const NativeRNUAirship = NativeModules.RNUAirship;

const RNUAirship = {
  takeOff: function() {
    NativeRNUAirship.takeOff();
  }
};

module.exports = RNUAirship;
