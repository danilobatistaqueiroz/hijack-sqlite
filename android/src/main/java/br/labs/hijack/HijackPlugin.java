package br.labs.hijack;

import android.util.Log;

public class HijackPlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
