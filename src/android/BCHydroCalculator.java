package cordova.plugin.bchydrocalculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class BCHydroCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("calculate")) {
            this.calculate(args, callbackContext);
            return true;
        }
        return false;
    }


    private void calculate(JSONArray args, CallbackContext callback) {
        if (args != null) {
            try {
                final double RATE_PER_KWH = 0.1065;
                final int KILOWATT_TO_WATT = 1000;
                double p1 = Double.parseDouble(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));
                double energyUsed = p1 * p2 / KILOWATT_TO_WATT;
                //Double energyRate = energyUsed * RATE_PER_KWH;
                //int cost = energyRate.intValue();
                double cost = energyUsed * RATE_PER_KWH;
                callback.success(cost);
            } 
            catch (Exception e) {
                callback.error("Something wrong " + e)  ;
            }

        } else {
            callback.error("Nothing to calculate!");
        }

    }
}   
