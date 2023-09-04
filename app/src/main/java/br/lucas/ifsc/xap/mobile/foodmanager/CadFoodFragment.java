package br.lucas.ifsc.xap.mobile.foodmanager;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import br.lucas.ifsc.xap.mobile.foodmanager.model.Food;

public class CadFoodFragment extends Fragment implements View.OnClickListener {
    private View view;

    private EditText etName;
    private EditText etDescription;
    private EditText etPrice ;
    private CheckBox cbCombo;
    private CheckBox cbFrete;
    private Button btSalvar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.etName = (EditText) view.findViewById(R.id.etNome);
        this.etDescription = (EditText) view.findViewById(R.id.etDescription);
        this.etPrice = (EditText) view.findViewById(R.id.etPrice);
        this.cbCombo = (CheckBox) view.findViewById(R.id.cbCombo);
        this.cbFrete = (CheckBox) view.findViewById(R.id.cbFreteGratis);
        this.btSalvar = (Button) view.findViewById(R.id.btSalvar);

        this.view = inflater.inflate(R.layout.fragment_cad_food, container, false);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btSalvar:

                 Food f = new Food();

                f.setName(this.etName.getText().toString());
                f.setDescription(this.etDescription.getText().toString());
                f.setPrice(Float.parseFloat(this.etPrice.getText().toString()));
                f.setFreteGratis(this.cbFrete.isChecked());
                f.setCombo(this.cbCombo.isChecked());

                //mensagem de sucesso
                Context context = view.getContext();
                CharSequence text = "salvo com sucesso!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                break;
        }
    }

}