package br.labs.hijack;

import android.util.Log;
import java.io.File;
import android.os.Environment;
import java.nio.channels.FileChannel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HijackSqlite {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    public boolean deleteDatabase(String appID, String dbName){
      File db = new File("/data/user/0/"+appID+"/databases/"+dbName+"SQLite.db");
      if(db.delete()){
        Log.i("SQLITE", "database deleted successfully");
        return true;
      } else {
        Log.i("SQLITE", "error deleting database!!");
        return false;
      }
    }

    public boolean copyToDocuments(String appID, String dbName) {
        File src = new File("/data/user/0/"+appID+"/databases/"+dbName+"SQLite.db");
        if(src.exists()==false){
          Log.i("COPY SQLITE", "database doesnt exists on user data folder!");
          return false;
        } else {
          Log.i("COPY SQLITE", "database exists on user data!");
        }
        File documents = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File dst = new File(documents.getAbsolutePath()+"/"+dbName+"SQLite.db");
        try {
          Log.i("COPY SQLITE", "checking if database exists on Documents folder!");
            if(dst.exists()) {
              Log.i("COPY SQLITE", "deleting database!");
                var del = dst.delete();
                System.out.println(del);
            } else {
              Log.i("COPY SQLITE", "database doesnt exists on Documents!");
            }
            Log.i("COPY SQLITE", "copying to Documents folder!");
            Log.i("SQLITE SRC", src.getAbsolutePath());
            Log.i("SQLITE DST", dst.getAbsolutePath());
          try (FileChannel source = new FileInputStream(src).getChannel(); FileChannel destination = new FileOutputStream(dst).getChannel()) {
            destination.transferFrom(source, 0, source.size());
          }
          Log.i("COPY SQLITE", "Database copied with success!");
          return true;
        } catch (IOException ex) {
          ex.printStackTrace();
          return false;
        }
    }

    public boolean copyToUserData(String appID, String dbName) {
        File documents = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File src = new File(documents.getAbsolutePath()+"/"+dbName+"SQLite.db");
        if(src.exists()==false){
          Log.i("COPY SQLITE", "database doesnt exists on Documents folder!");
          return false;
        } else {
          Log.i("COPY SQLITE", "database exists on Documents!");
        }
        File dst = new File("/data/user/0/"+appID+"/databases/"+dbName+"SQLite.db");
        try {
          Log.i("COPY SQLITE", "checking if database exists on user data folder!");
            if(dst.exists()) {
              Log.i("COPY SQLITE", "deleting database!");
                var del = dst.delete();
                System.out.println(del);
            } else {
              Log.i("COPY SQLITE", "database doesnt exists on user data!");
            }
            Log.i("COPY SQLITE", "copying to user data folder!");
          try (FileChannel source = new FileInputStream(src).getChannel(); FileChannel destination = new FileOutputStream(dst).getChannel()) {
            destination.transferFrom(source, 0, source.size());
          }
          Log.i("COPY SQLITE", "Database copied to User Data with success!");
          return true;
        } catch (IOException ex) {
          ex.printStackTrace();
          return false;
        }
    }
}
