#import "RNUAirship.h"
#import <AirshipKit/AirshipKit.h>

@implementation RNUAirship

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(takeOff:(NSDictionary *)customConfig)
{
  UAConfig *config = [UAConfig defaultConfig];

  config.developmentAppKey = [customConfig objectForKey:@"developmentAppKey"];
  config.developmentAppSecret = [customConfig objectForKey:@"developmentAppSecret"];
  config.productionAppKey = [customConfig objectForKey:@"productionAppKey"];
  config.productionAppSecret = [customConfig objectForKey:@"productionAppSecret"];
  config.detectProvisioningMode = YES;

  [UAirship takeOff:config];
  [UAirship push].userPushNotificationsEnabled = YES;
}

@end
