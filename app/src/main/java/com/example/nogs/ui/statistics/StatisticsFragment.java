package com.example.nogs.ui.statistics;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nogs.R;
import com.example.nogs.api.Donation;
import com.example.nogs.api.Ong;
import com.example.nogs.api.RetrofitConfig;
import com.example.nogs.ui.entities.MyEntitiesRecyclerViewAdapter;
import com.example.nogs.ui.entities.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatisticsFragment extends Fragment {

    private StatisticsViewModel mViewModel;

    public static StatisticsFragment newInstance() {
        return new StatisticsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.statistics_fragment, container, false);
        TextView textView = v.findViewById(R.id.statistic_info);

        Call<List<Donation>> call = new RetrofitConfig().getDonations();

        call.enqueue(new Callback<List<Donation>>() {
            @Override
            public void onResponse(Call<List<Donation>> call, Response<List<Donation>> response) {
                List<DummyContent.DummyItem> items = new ArrayList<>();

                textView.setText("Doações em tempo real:\n\n");

                for (Donation item : response.body()) {
                    String paymentMethod = "Dinheiro";

                    switch (item.getPaymentMethod()) {
                        case "MONEY":
                            paymentMethod = "Dinheiro";
                            break;
                        case "CREDIT_CARD":
                            paymentMethod = "Cartão de Crédito";
                            break;
                        case "DEBIT_CARD":
                            paymentMethod = "cartão de Débito";
                            break;
                        case "TRANSFER":
                            paymentMethod = "Transferência";
                            break;
                        case "PIX":
                            paymentMethod = "PIX";
                            break;
                    }

                    textView.setText(textView.getText() + String.format("ONG: %s\nValor: %s\nUsuário: %s\nPagamento: %s\nData: %s\n\n", item.getOngName(), item.getValue(), item.getUserName(), paymentMethod, item.getCreatedDate()));
                }
            }

            @Override
            public void onFailure(Call<List<Donation>> call, Throwable t) {

            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(StatisticsViewModel.class);
        // TODO: Use the ViewModel
    }

}