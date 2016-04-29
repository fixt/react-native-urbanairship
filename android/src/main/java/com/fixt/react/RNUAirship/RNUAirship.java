package co.fixt.react.RNUAirship;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNUAirship extends ReactContextBaseJavaModule {
  private ReactApplicationContext appContext;

  public RNUAirship(ReactApplicationContext reactContext) {
    appContext = reactContext;
    super(reactContext);
  }

  @Override
  public String getName() {
    return "RNUAirship";
  }

  @ReactMethod
  public void takeOff() {
    UAirship.takeOff(appContext.getApplication(), new UAirship.OnReadyCallback() {
      @Override
      public void onAirshipReady(UAirship airship) {
        airship.getPushManager().setUserNotificationsEnabled(true);
      }
    });
  }
}
