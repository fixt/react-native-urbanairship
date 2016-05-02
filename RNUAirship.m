#import "RNUAirship.h"
#import <AirshipKit/AirshipKit.h>

@implementation RNUAirship

RCT_EXPORT_MODULE()

- (dispatch_queue_t)methodQueue
{
  return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(takeOff:(NSDictionary *)config)
{
  [UAirship takeOff];
  [UAirship push].userPushNotificationsEnabled = YES;
}

@end
