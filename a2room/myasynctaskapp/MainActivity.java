package a2room.myasynctaskapp;


/*
Created by Alexis Garcia Pagan
*/

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.lang.String;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private Button access_button;
    private EditText name_user;
    private TextView showResults;
    private ArrayListDataSource access = new ArrayListDataSource();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init the UI Thread
        access_button = (Button) findViewById(R.id.button);
        name_user = (EditText) findViewById(R.id.user_name);
        showResults = (TextView) findViewById(R.id.test);

        //init button action
        access_button.setOnClickListener(this);
    }

    public class DoMathOnBackground extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... voids) {
            String user = name_user.getText().toString();

            access.getDatasource();

            for (int i = 0; i < access.getDatasource().size(); i += 1) {

                if (access.getDatasource().contains(user)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            if(result) {
                startActivity(goToNextActivity());
            }
        }
    }

    @Override
    public void onClick(View view) {
        passToBackgroundThread();
    }

    private Intent goToNextActivity() {
        Context context = MainActivity.this;
        Class success_activity = SuccessActivity.class;
        Intent i = new Intent(context, success_activity);
        return i;
    }

    public void passToBackgroundThread() {
        new DoMathOnBackground().execute();
    }
}
