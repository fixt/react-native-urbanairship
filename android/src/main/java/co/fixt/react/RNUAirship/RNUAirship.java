package co.fixt.react.RNUAirship;

import android.app.Activity;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.urbanairship.UAirship;

public class RNUAirship extends ReactContextBaseJavaModule {
  private Activity mActivity;

  public RNUAirship(ReactApplicationContext reactContext, Activity activity) {
    super(reactContext);
    mActivity = activity;
  }

  @Override
  public String getName() {
    return "RNUAirship";
  }

  @ReactMethod
  public void takeOff() {
    UAirship.takeOff(mActivity.getApplication(), new UAirship.OnReadyCallback() {
      @Override
      public void onAirshipReady(UAirship airship) {
        airship.getPushManager().setUserNotificationsEnabled(true);
      }
    });
  }
}
