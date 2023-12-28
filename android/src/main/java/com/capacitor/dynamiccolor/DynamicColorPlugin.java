package com.capacitor.dynamiccolor;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import android.R.color;
import android.os.Build;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

@CapacitorPlugin(name = "Example")
public class ExamplePlugin extends Plugin {

    private Example implementation = new Example();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void getDynamicColor(PluginCall call) {
        String colorName = call.getString("colorName");
        if (colorName == null) {
            call.reject("Color name is required");
            return;
        }
        Integer color = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            color = getDynamicColorByName(colorName);
        }
        if (color == null) {
            call.reject("Invalid color name");
            return;
        }
        String colorCode = colorToHex(color);
        JSObject result = new JSObject();
        result.put("value", colorCode);
        call.resolve(result);
    }

    @PluginMethod
    public void getDynamicColors(PluginCall call) throws JSONException {
        JSONObject colors = new JSONObject();
        String[] colorNames = {"accent1-0", "accent1-10", "accent1-50", "accent1-100", "accent1-400", "accent1-700", "accent1-800", "accent1-900", "accent1-1000", "accent2", "accent3", "neutral1", "neutral2"};
        for (String colorName : colorNames) {
            Integer color = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
                color = getDynamicColorByName(colorName);
            }
            if (color == null) {
                continue;
            }
            String colorCode = colorToHex(color);
            colors.put(colorName, colorCode);
        }
        JSObject result = new JSObject();
        result.put("value", colors);
        Log.i("Colors", String.valueOf(result));
        call.resolve(result);
    }

    @RequiresApi(api = Build.VERSION_CODES.S)
    private Integer getDynamicColorByName(String colorName) {
        Context context = bridge.getActivity();
        Resources resources = context.getResources();
        switch (colorName) {
            case "accent1-0":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent1_0, null);
            case "accent1-10":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent1_10, null);
            case "accent1-50":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent1_50, null);
            case "accent1-100":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent1_100, null);
            case "accent1-400":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent1_400, null);
            case "accent1-700":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent1_700, null);
            case "accent1-800":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent1_800, null);
            case "accent1-900":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent1_900, null);
            case "accent1-1000":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent1_1000, null);
            case "accent2":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent2_100, null);
            case "accent3":
                return ResourcesCompat.getColor(resources, android.R.color.system_accent3_100, null);
            case "neutral1":
                return ResourcesCompat.getColor(resources, android.R.color.system_neutral1_100, null);
            case "neutral2":
                return ResourcesCompat.getColor(resources, android.R.color.system_neutral2_100, null);
            default:
                return null;
        }
    }

    private String colorToHex(int color) {
        return String.format("#%06X", 0xFFFFFF & color);
    }
}
