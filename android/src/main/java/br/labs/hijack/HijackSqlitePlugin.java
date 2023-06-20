package br.labs.hijack;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "HijackSqlite")
public class HijackSqlitePlugin extends Plugin {

    private HijackSqlite implementation = new HijackSqlite();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void deleteDatabase(PluginCall call) {
      String appID = call.getString("appID");
      String name = call.getString("name");
      JSObject ret = new JSObject();
      ret.put("result", implementation.deleteDatabase(appID,name));
      call.resolve(ret);
    }

    @PluginMethod
    public void copyToDocuments(PluginCall call) {
      String appID = call.getString("appID");
      String name = call.getString("name");
      JSObject ret = new JSObject();
      ret.put("result", implementation.copyToDocuments(appID,name));
      call.resolve(ret);
    }

    @PluginMethod
    public void copyToUserData(PluginCall call) {
      String appID = call.getString("appID");
      String name = call.getString("name");
      JSObject ret = new JSObject();
      ret.put("result", implementation.copyToUserData(appID,name));
      call.resolve(ret);
    }
}
