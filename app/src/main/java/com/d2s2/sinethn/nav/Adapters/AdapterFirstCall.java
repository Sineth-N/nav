package com.d2s2.sinethn.nav.Adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.d2s2.sinethn.nav.Database.DBHelper;
import com.d2s2.sinethn.nav.R;
import com.d2s2.sinethn.nav.SelectedLead;
import com.d2s2.sinethn.nav.TaskNotify;

import java.util.ArrayList;

/**
 * Created by Sineth N on 8/17/2015.
 */
public class AdapterFirstCall extends RecyclerView.Adapter<AdapterFirstCall.viewHolderFirstCall> {
    private ArrayList<TaskNotify> ArrayList_Scheduled = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private DBHelper dbHelper;
    private Context context;
    public TaskNotify current;

    public AdapterFirstCall(Context context) {
        layoutInflater = LayoutInflater.from(context);
        dbHelper = new DBHelper(context);
        current = new TaskNotify();
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        String[] col = {DBHelper.NAME, DBHelper.TITLE, DBHelper.DESCRIPTION, DBHelper.TIME, DBHelper.DATE, DBHelper.TYPE};
        int status = 0;
        Cursor cursor = database.query(DBHelper.TASKS_TABLE, col, DBHelper.TYPE + " = '" + status + "'", null, null, null, null);
        while (cursor.moveToNext()) {
            current.setDate(cursor.getString(cursor.getColumnIndex(DBHelper.DATE)));
            current.setName(cursor.getString(cursor.getColumnIndex(DBHelper.NAME)));
            current.setTitle(cursor.getString(cursor.getColumnIndex(DBHelper.TITLE)));
            current.setDescription(cursor.getString(cursor.getColumnIndex(DBHelper.DESCRIPTION)));
            current.setTime(cursor.getString(cursor.getColumnIndex(DBHelper.TIME)));
            current.setType(cursor.getString(cursor.getColumnIndex(DBHelper.TYPE)));
            ArrayList_Scheduled.add(current);
        }
        cursor.close();
        this.context = context;
    }


    public TaskNotify getLeadFromArrayList(int i) {
        return ArrayList_Scheduled.get(i);
    }

    public void setArrayList_Scheduled(ArrayList<TaskNotify> ArrayList_Scheduled) {
        this.ArrayList_Scheduled = ArrayList_Scheduled;
        notifyItemRangeChanged(0, ArrayList_Scheduled.size());
    }

    public ArrayList<TaskNotify> getArrayList_Scheduled() {
        return ArrayList_Scheduled;
    }

    @Override

    public viewHolderFirstCall onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.lead_first_call_list, parent, false);
        viewHolderFirstCall viewHolderFirstCall = new viewHolderFirstCall(view);
        return viewHolderFirstCall;
    }

    @Override
    public void onBindViewHolder(viewHolderFirstCall holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(new Intent(context, SelectedLead.class));
                intent.putExtra("ArrayScheduled", getArrayList_Scheduled());
                intent.putExtra("Lead", position);
                intent.putExtra("Num", 1);
                context.startActivity(intent);
            }
        });
        TaskNotify currentLead = ArrayList_Scheduled.get(position);
        holder.notifyNameTV.setText(currentLead.getName());
        holder.timeTV.setText(String.valueOf(currentLead.getTime()));
        holder.titleTV.setText(currentLead.getTitle());
        holder.imageIM.setImageResource(getImage(Integer.parseInt(currentLead.getPriority())));
    }

    private int getImage(int type) {
        if (type == 1) {
            return R.mipmap.ic_urgent;
        } else return R.mipmap.ic_cloud;
    }

    @Override
    public int getItemCount() {
        return ArrayList_Scheduled.size();
    }

    public static class viewHolderFirstCall extends RecyclerView.ViewHolder {

        private TextView notifyNameTV, timeTV, titleTV;
        private ImageView imageIM;

        public viewHolderFirstCall(View itemView) {
            super(itemView);
            notifyNameTV = (TextView) itemView.findViewById(R.id.notifyNameTV);
            timeTV = (TextView) itemView.findViewById(R.id.timeTV);
            titleTV = (TextView) itemView.findViewById(R.id.titleTV);
            imageIM = (ImageView) itemView.findViewById(R.id.imageIM);


        }

    }
}

