'use strict';

import { NativeModules } from 'react-native';
const NativeRNUAirship = NativeModules.RNUAirship;

const RNUAirship = {
  takeOff: function(config) {
    NativeRNUAirship.takeOff(config);
  }
};

module.exports = RNUAirship;
