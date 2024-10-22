package com.example.internaciondomiciliaria.ui.visita;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internaciondomiciliaria.R;
import com.example.internaciondomiciliaria.data.remote.models.Visitas;
import com.example.internaciondomiciliaria.databinding.ItemVisitaBinding;
import com.example.internaciondomiciliaria.data.remote.models.Registro;

import java.util.List;

public class VisitasAdapter extends RecyclerView.Adapter<VisitasAdapter.VisitasViewHolder>{
    private final Context context;
    private final List<Visitas> list;
    private final LayoutInflater inflater;

    public VisitasAdapter(Context context, List<Visitas> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public VisitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemVisitaBinding binding= ItemVisitaBinding.inflate(inflater,parent,false);
        return new VisitasViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitasViewHolder holder, int position) {
        Visitas visita = list.get(position);
        holder.binding.tvIdVisita.setText("Visita "+visita.getId());
        if(visita.isEstado()) {
            holder.binding.tvEstado.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_ejecutada, 0);
            holder.binding.tvEstado.setText("Ejecutada ");
        } else {
            holder.binding.tvEstado.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_pendiente, 0);
            holder.binding.tvEstado.setText("Pendiente ");
        }
        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("id", visita.getId());
            bundle.putString("paciente", visita.getPacientes());
            Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main)
                    .navigate(R.id.nav_registros, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class VisitasViewHolder extends RecyclerView.ViewHolder {
        private final ItemVisitaBinding binding;

        public VisitasViewHolder(ItemVisitaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
