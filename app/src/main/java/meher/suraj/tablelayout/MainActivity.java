package meher.suraj.tablelayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String Date[] = {"01 OCT", "02 OCT", "03 OCT", "04 OCT", "05 OCT", "06 OCT", "07 OCT", "08 OCT", "09 OCT", "10 OCT", "11 OCT", "12 OCT", "13 OCT", "14 OCT", "15 OCT",
            "16 OCT", "17 OCT", "18 OCT", "19 OCT", "20 OCT", "21 OCT", "22 OCT", "23 OCT", "24 OCT", "25 OCT", "26 OCT", "27 OCT", "28 OCT", "29 OCT", "30 OCT"};
    String Quantity[] = {"1", "2", "1", "3", "1", "5", "1", "3", "1", "1", "2", "2", "2", "1", "1",
            "1", "2", "1", "3", "1", "5", "1", "3", "1", "1", "2", "2", "2", "1", "1"};
    String Status[] = {"delivered", "delivered", "delivered", "delivered", "delivered", "cancelled", "cancelled", "cancelled", "pending", "pending", "pending", "pending", "pending", "pending", "pending",
            "pending", "pending", "pending", "pending", "pending", "pending", "pending", "pending", "pending", "pending", "pending", "pending", "pending", "pending", "pending"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addHeaders();
        addData();
    }

    private TextView getTextView(int id, String title, int color, int typeface, int bgColor) {
        TextView tv = new TextView(this);
        tv.setId(id);
        tv.setText(title);//.toUpperCase()
        tv.setGravity(Gravity.CENTER);
        tv.setTextColor(color);
        tv.setPadding(4, 5, 4, 10);
        tv.setTypeface(Typeface.DEFAULT, typeface);
        tv.setBackgroundColor(bgColor);
        tv.setLayoutParams(getLayoutParams());
        tv.setOnClickListener(this);
        return tv;
    }

    @NonNull
    private TableRow.LayoutParams getLayoutParams() {
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(2, 0, 0, 2);
        return params;
    }

    @NonNull
    private TableLayout.LayoutParams getTblLayoutParams() {
        return new TableLayout.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
    }

    public void addHeaders() {
        TableLayout tl = findViewById(R.id.table);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "Day", Color.WHITE, Typeface.BOLD, Color.parseColor("#017BDE")));
        tr.addView(getTextView(0, "QTY", Color.WHITE, Typeface.BOLD, Color.parseColor("#017BDE")));
        tr.addView(getTextView(0, "Status", Color.WHITE, Typeface.BOLD, Color.parseColor("#017BDE")));
        tl.addView(tr, getTblLayoutParams());
    }

    public void addHeaders2() {
        TableLayout tl = findViewById(R.id.table1);
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(getLayoutParams());
        tr.addView(getTextView(0, "Day", Color.WHITE, Typeface.BOLD, Color.parseColor("#017BDE")));
        tr.addView(getTextView(0, "QTY", Color.WHITE, Typeface.BOLD, Color.parseColor("#017BDE")));
        tr.addView(getTextView(0, "Status", Color.WHITE, Typeface.BOLD, Color.parseColor("#017BDE")));
        tl.addView(tr, getTblLayoutParams());
    }

    /**
     * This function add the data to the table
     **/
    public void addData() {
        int numCompanies = Status.length;
        TableLayout tl = findViewById(R.id.table);
        TableLayout t2 = findViewById(R.id.table1);
        for (int i = 0; i < numCompanies; i++) {
            if (i < 16) {
                TableRow tr = new TableRow(this);
                tr.setLayoutParams(getLayoutParams());
                tr.addView(getTextView(i + 1, Date[i], Color.parseColor("#707070"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                tr.addView(getTextView(i + numCompanies, Quantity[i], Color.parseColor("#707070"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                if (Status[i].equals("delivered")) {
                    tr.addView(getTextView(i + numCompanies + numCompanies, Status[i], Color.parseColor("#00C448"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                } else if (Status[i].equals("cancelled")) {
                    tr.addView(getTextView(i + numCompanies + numCompanies, Status[i], Color.parseColor("#EA0F59"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                } else {
                    tr.addView(getTextView(i + numCompanies + numCompanies, Status[i], Color.parseColor("#707070"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                }
                tl.addView(tr, getTblLayoutParams());
            }
            if (i >= 16) {
                if (i == 16) {
                    addHeaders2();
                }
                TableRow tr1 = new TableRow(this);
                tr1.setLayoutParams(getLayoutParams());
                tr1.addView(getTextView(i + 1, Date[i], Color.parseColor("#707070"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                tr1.addView(getTextView(i + numCompanies, Quantity[i], Color.parseColor("#707070"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                if (Status[i].equals("delivered")) {
                    tr1.addView(getTextView(i + numCompanies + numCompanies, Status[i], Color.parseColor("#00C448"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                } else if (Status[i].equals("cancelled")) {
                    tr1.addView(getTextView(i + numCompanies + numCompanies, Status[i], Color.parseColor("#EA0F59"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                } else {
                    tr1.addView(getTextView(i + numCompanies + numCompanies, Status[i], Color.parseColor("#707070"), Typeface.NORMAL, ContextCompat.getColor(this, R.color.rowcolor)));
                }
                t2.addView(tr1, getTblLayoutParams());
            }

        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        TextView tv = findViewById(id);
        if (null != tv) {
            Log.i("onClick", "Clicked on row :: " + id);
            Toast.makeText(this, "Clicked on row :: " + id + ", Text :: " + tv.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}