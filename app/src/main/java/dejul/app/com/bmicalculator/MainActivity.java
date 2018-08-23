package dejul.app.com.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText height, weight;
    Button button;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        button = (Button) findViewById(R.id.btncalculate);
        result = (TextView) findViewById(R.id.bmiResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

    }

    private void calculateBMI() {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if(heightStr != null && !"".equals(heightStr) && weightStr != null && !"".equals(weightStr)){

            float heightvalue = Float.parseFloat(heightStr) / 100;
            float weightvalue = Float.parseFloat(weightStr);

            float bmi = weightvalue / (heightvalue * heightvalue);

            displayBmi(bmi);


        }
    }

    private void displayBmi(float bmi) {
        String bmilabel = "";

        if (Float.compare(bmi, 15f) <= 0){
            bmilabel = "very severely underweight";
        }
        else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0){
            bmilabel = "severely underweight";
        }
        else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0){
            bmilabel = "Underweight";
        }
        else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0){
            bmilabel = "Normal weight";
        }
        else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0){
            bmilabel = "Overwight";
        }
        else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0){
            bmilabel = "Obese class I";
        }
        else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0){
            bmilabel = "Obese class II";
        } else{
            bmilabel = "Obese class III";
        }

        bmilabel = bmi + "\n" + bmilabel;

        result.setText(bmilabel);
    }


}
