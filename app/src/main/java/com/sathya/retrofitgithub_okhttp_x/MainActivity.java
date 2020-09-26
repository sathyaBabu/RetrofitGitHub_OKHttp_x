package com.sathya.retrofitgithub_okhttp_x;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sathya.retrofitgithub_okhttp_x.api.GitHubClient;
import com.sathya.retrofitgithub_okhttp_x.api.ServiceGenerator;
import com.sathya.retrofitgithub_okhttp_x.model.GitHubUser;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/*
AndroidRuntime: FATAL EXCEPTION: OkHttp Dispatcher
    Process: com.sathya.delme, PID: 21504
    java.lang.BootstrapMethodError: Exception from call site #1 bootstrap method

 compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }

 */
// to find retrofit ver https://github.com/square/retrofit
public class MainActivity extends AppCompatActivity {


    ImageView imageView1;
    Button searchBtn;
    TextView responseText;
    EditText editText;
    ProgressBar progressBar;

    GitHubClient gitHubClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchBtn     = (Button) findViewById(R.id.main_btn_lookup);
        responseText  = (TextView) findViewById(R.id.main_text_response);
        editText      = (EditText) findViewById(R.id.main_edit_username);
        progressBar   = (ProgressBar) findViewById(R.id.main_progress);

        imageView1     =(ImageView)findViewById(R.id.avatar) ;

        progressBar.setVisibility(View.INVISIBLE);


        // Create a very simple REST adapter which points the GitHub API endpoint.

        // Phase I
        gitHubClient = ServiceGenerator.getClient().create(GitHubClient.class);

        //GitHubClient service = retrofit.create(GitHubClient.class);




        //  Phase II
        // gitHubClient = OKhttp_ServiceGenerator.createService(GitHubClient.class);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchForUser();
            }
        });


    }



    public void searchForUser() {
        String user = editText.getText().toString();
        progressBar.setVisibility(View.VISIBLE);

        //Make a request to get a response
        //Get json object from GitHub server to the POJO/model class

        final Call<GitHubUser> call = gitHubClient.getFeed(user);
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
                GitHubUser gitModel = response.body();
                if( gitModel != null){
                    responseText.setText(getString(R.string.main_response_text,
                            gitModel.getName(),
                            gitModel.getBlog(),
                            gitModel.getBio(),
                            gitModel.getCompany()));
                    responseText.setTextSize(18);
                    responseText.setTextColor(Color.RED);
                  //  imageView1.setImageResource(gitModel.getAvatarUrl());
                    Picasso.get()
                            .load(gitModel.getAvatarUrl())
                            .resize(350,350)
                            .centerCrop()
                            .into(imageView1);

                }else {

                    responseText.setText("");
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.main_error_text),
                            Toast.LENGTH_SHORT).show();

                }
                //Hide progressbar when done
                progressBar.setVisibility(View.INVISIBLE);



            }


            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
//   Display error message if the request fails
                responseText.setText("Error Loading "+t.fillInStackTrace().toString()); //Error needs to be handled properly
                responseText.setTextColor(Color.RED);
                responseText.setTextSize(23);
                //Hide progressbar when done
                progressBar.setVisibility(View.INVISIBLE);

            }




        });


    }
}
