//
//  CDVBackgroundGeoLocation.h
//
//  Created by Chris Scott <chris@transistorsoft.com>
//

#import <Cordova/CDVPlugin.h>
#import <TwitterKit/TwitterKit.h>

@interface TwitterManager : CDVPlugin <CLLocationManagerDelegate>

- (void) logout:(CDVInvokedUrlCommand*)command;

@end

