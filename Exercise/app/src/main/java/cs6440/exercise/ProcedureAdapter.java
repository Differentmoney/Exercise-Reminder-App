package cs6440.exercise;

import android.annotation.SuppressLint;
import android.graphics.fonts.Font;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProcedureAdapter extends RecyclerView.Adapter {
    private List procedureList;
    public ProcedureAdapter(List procedureList) {
        this.procedureList = procedureList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.procedure_table, parent, false);

        return new RowViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;
        int rowPos = rowViewHolder.getAdapterPosition();
        if (rowPos == 0) {
            rowViewHolder.procedurename.setBackgroundResource(R.drawable.ic_launcher_background);
            rowViewHolder.status.setBackgroundResource(R.drawable.ic_launcher_background);
            rowViewHolder.performeddate.setBackgroundResource(R.drawable.ic_launcher_background);
            rowViewHolder.outcome.setBackgroundResource(R.drawable.ic_launcher_background);

            rowViewHolder.procedurename.setText("Procedure Name");
            rowViewHolder.status.setText("Status");
            rowViewHolder.performeddate.setText("Performed Date");
            rowViewHolder.outcome.setText("Outcome");




        } else {
            ProcedureModel model = (ProcedureModel) procedureList.get(rowPos - 1);



            rowViewHolder.procedurename.setText(model.getProcedurename() + "");
            rowViewHolder.status.setText(model.getStatus());
            rowViewHolder.performeddate.setText(model.getPerformeddate() + "");
            rowViewHolder.outcome.setText(model.getOutcome() + "");
        }



    }
    @SuppressLint("SetTextI18n")
    @Override
    public int getItemCount() {
        return procedureList.size() + 1;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView procedurename;
        TextView status;
        TextView performeddate;
        TextView outcome;

        RowViewHolder(View itemView) {
            super(itemView);
            procedurename = itemView.findViewById(R.id.procedurename);
            status = itemView.findViewById(R.id.status);
            performeddate = itemView.findViewById(R.id.performeddate);
            outcome = itemView.findViewById(R.id.outcome);
        }
    }

}
