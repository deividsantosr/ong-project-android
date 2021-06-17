package com.example.nogs.ui.donation;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nogs.R;
import com.example.nogs.api.Donation;
import com.example.nogs.api.Ong;
import com.example.nogs.api.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonationFragment extends Fragment {

    private DonationViewModel mViewModel;

    public static DonationFragment newInstance() {
        return new DonationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.donation_fragment, container, false);
        Spinner s = (Spinner) v.findViewById(R.id.spinner);
        Button b = (Button) v.findViewById(R.id.button);

        Call<List<Ong>> call = new RetrofitConfig().getOngs();

        final List<OngData> items = new ArrayList<>();

        call.enqueue(new Callback<List<Ong>>() {
            @Override
            public void onResponse(Call<List<Ong>> call, Response<List<Ong>> response) {
                ArrayAdapter<OngData> adapter = new ArrayAdapter<OngData>(v.getContext(), android.R.layout.simple_spinner_item, items);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                for (Ong item : response.body()) {

                    items.add(new OngData(item.getName(), item.getId()));
                }

                s.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Ong>> call, Throwable t) {

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View vButton) {
                RadioGroup radioGroup = (RadioGroup) v.findViewById(R.id.paymentMethod);
                EditText valueEditText = (EditText) v.findViewById(R.id.value);
                EditText valueObservation = (EditText) v.findViewById(R.id.observation);

                String paymentMethod = "MONEY";

                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.money:
                        paymentMethod = "MONEY";
                        break;
                    case R.id.credit_card:
                        paymentMethod = "CREDIT_CARD";
                        break;
                    case R.id.debit_card:
                        paymentMethod = "DEBIT_CARD";
                        break;
                    case R.id.transfer:
                        paymentMethod = "TRANSFER";
                        break;
                    case R.id.pix:
                        paymentMethod = "PIX";
                        break;
                }

                OngData selectedOngItem = items.stream().filter(item -> item.getSpinnerText().equals(s.getSelectedItem().toString())).findFirst().get();

                String value = valueEditText.getText().toString();

                if (value.isEmpty()) {
                    value = "0.0";
                }

                Donation donation = new Donation();
                donation.setOngId(selectedOngItem.getValue());
                donation.setOngName(selectedOngItem.getSpinnerText());
                donation.setUserId("632cf41f-f92b-4ccb-8d47-de126592e953");
                donation.setUserName("Deivid Network");
                donation.setPaymentMethod(paymentMethod);
                donation.setValue(Double.valueOf(value));
                donation.setObservations(valueObservation.getText().toString());

                Call<Donation> call = new RetrofitConfig().createDonation(donation);

                call.enqueue(new Callback<Donation>() {
                    @Override
                    public void onResponse(Call<Donation> call, Response<Donation> response) {
                        Toast.makeText(getContext().getApplicationContext(), "Doação realizada com sucesso! :)", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<Donation> call, Throwable t) {
                        Toast.makeText(getContext().getApplicationContext(), "Falha no servidor! :(", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DonationViewModel.class);
        // TODO: Use the ViewModel
    }

}


class OngData {
    public OngData(String spinnerText, String value) {
        this.spinnerText = spinnerText;
        this.value = value;
    }

    public String getSpinnerText() {
        return spinnerText;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return spinnerText;
    }

    String spinnerText;
    String value;
}