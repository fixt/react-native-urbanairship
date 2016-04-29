#import "RNUAirship.h"
#import <AirshipKit/AirshipKit.h>

@implementation RNUAirship

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(takeOff)
{
  [UAirship takeOff];
  [UAirship push].userPushNotificationsEnabled = YES;
}

@end
