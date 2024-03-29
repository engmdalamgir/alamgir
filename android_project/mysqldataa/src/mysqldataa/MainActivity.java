package mysqldataa;


import com.example.mysqldataa.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	LoginDataBaseAdapter loginDataBaseAdapter;
	Button btnSignIn, btnSignUp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();
        btnSignUp=(Button)findViewById(R.id.buttonSignUP);
		
	    // Set OnClick Listener on SignUp button 
    
	 
	}
    public void dataload(View V){
    	
    	   btnSignUp.setOnClickListener(new View.OnClickListener() {
    		  @Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
    				
    				/// Create Intent for SignUpActivity  and Start The Activity
    				Intent intentSignUP=new Intent(getApplicationContext(),SignUPActivity.class);
    				startActivity(intentSignUP);
    				}
    			});
    	
    }
   
    public void signInn(View V){
    	btnSignIn=(Button)findViewById(R.id.button);
    	final EditText edittextSignIn=(EditText)findViewById(R.id.editText1);
    	final EditText edittextSignInp=(EditText)findViewById(R.id.editText2);
    	btnSignIn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String userName=edittextSignIn.getText().toString();
				String password=edittextSignInp.getText().toString();
				loginDataBaseAdapter.insertEntry(userName, password);
				Toast.makeText(getApplicationContext(), "Save Successfully " + userName, Toast.LENGTH_LONG).show();
				
			}
		});
    }
 

	@Override
	protected void onDestroy() {
		super.onDestroy();
	    // Close The Database
		loginDataBaseAdapter.close();
	}
}

