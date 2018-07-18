/********* BCHydroCalculator.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface BCHydroCalculator : CDVPlugin {
  // Member variables go here.
}

- (void)calculate:(CDVInvokedUrlCommand*)command;
@end

@implementation BCHydroCalculator
- (void)calculate:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
	NSNumber* param1 = [[command.arguments objectAtIndex:0] valueForKey:@"param1"]; 
	NSNumber* param2 = [[command.arguments objectAtIndex:0] valueForKey:@"param2"];
	if (param1 >=0 && param2 >=0)
	{
        const double RATE_PER_KWH = 0.1065;
        const int KILOWATT_TO_WATT = 1000;
		double energyUsed = p1 * p2 / KILOWATT_TO_WATT;
        NSString* cost = @(energyUsed * RATE_PER_KWH);
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:cost];
	} 
	else 
	{
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
	}
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}
@end
