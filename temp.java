import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;     

     for(int i=0; i<apps.size(); i++) {
            if (addProcesses(apps.get(i).processName)) {
                string += " " + apps.get(i).processName + "\n";
            }
        }
        textView.setText(string);
    }

    private boolean addProcesses(String processName) {
        List <String> pNames = listOfProcesses(processName);
        if (pNames.contains(processName)) {
            return true;
        }
        return false;
    }

    private List <String> listOfProcesses(String processName) {
       List<String> validPNames = new ArrayList<String>();
       validPNames.add("com.facebook.orca");
       validPNames.add("com.google.android.youtube");
       validPNames.add("com.google.android.chrome");

        return validPNames;
    }