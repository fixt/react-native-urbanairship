package co.fixt.react.RNUAirship;

import android.app.Activity;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

import com.urbanairship.UAirship;
import com.urbanairship.AirshipConfigOptions;

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
  public void takeOff(ReadableMap config) {
    AirshipConfigOptions options = new AirshipConfigOptions.Builder()
      .setDevelopmentAppKey(config.getString("devAppKey"))
      .setDevelopmentAppSecret(config.getString("devAppSecret"))
      .setProductionAppKey(config.getString("prodAppKey"))
      .setProductionAppSecret(config.getString("prodAppSecret"))
      .setInProduction(config.getBoolean("isProd"))
      .setGcmSender(config.getString("gcmSender"))
      .build();

    UAirship.takeOff(mActivity.getApplication(), options, new UAirship.OnReadyCallback() {
      @Override
      public void onAirshipReady(UAirship airship) {
        airship.getPushManager().setUserNotificationsEnabled(true);
      }
    });
  }
}
