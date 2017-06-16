package www.nikunj.com.sqlitedatabasedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtNo, edtName, edtMark;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        db = openOrCreateDatabase("Student", Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists info(no varchar(255),name varchar(255),marks varchar(255))");
    }

    private void init() {
        edtNo = (EditText) A(R.id.edtno);
        edtName = (EditText) A(R.id.edtname);
        edtMark = (EditText) A(R.id.edtmark);
        A(R.id.btninsert).setOnClickListener(this);
        A(R.id.btnupdate).setOnClickListener(this);
        A(R.id.btndelete).setOnClickListener(this);
        A(R.id.btnshow).setOnClickListener(this);
    }

    private View A(int id) {
        return findViewById(id);
    }

    private void T(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btninsert:
                if (!edtNo.getText().toString().equalsIgnoreCase("")) {
                    if (!edtName.getText().toString().equalsIgnoreCase("")) {
                        if (!edtMark.getText().toString().equalsIgnoreCase("")) {
                            db.execSQL("insert into info values('" + edtNo.getText() + "','" + edtName.getText() + "','" + edtMark.getText() + "')");
                            T("insert one record..");
                            clear();
                        } else {
                            T("Enter Mark...");
                        }
                    } else {
                        T("Enter Name...");
                    }
                } else {
                    T("Enter No...");
                }
                break;
            case R.id.btnupdate:
                if (!edtNo.getText().toString().equalsIgnoreCase("")) {
                    if (!edtName.getText().toString().equalsIgnoreCase("")) {
                        if (!edtMark.getText().toString().equalsIgnoreCase("")) {
                            cursor = db.rawQuery("select * from info where no='" + edtNo.getText() + "'", null);
                            if (cursor.moveToFirst()) {
                                do {
                                    db.execSQL("update info set name='" + edtName.getText() + "',marks='" + edtMark.getText() + "' where no='" + edtNo.getText() + "'");
                                }
                                while (cursor.moveToNext());
                                T("One row update...");
                            } else {
                                T("Table is empty...");
                            }
                            clear();
                        } else {
                            T("Enter Mark...");
                        }
                    } else {
                        T("Enter Name...");
                    }
                } else {
                    T("Enter No...");
                }
                break;
            case R.id.btndelete:
                if (!edtNo.getText().toString().equalsIgnoreCase("")) {
                    cursor = db.rawQuery("select * from info where no='" + edtNo.getText() + "'", null);
                    if (cursor.moveToFirst()) {
                        do {
                            db.execSQL("delete from info where no='"+edtNo.getText()+"'");
                        }
                        while (cursor.moveToNext());
                        T("One row delete...");
                    } else {
                        T("No record found..");
                    }
                    clear();
                } else {
                    T("Enter No..");
                }
                break;
            case R.id.btnshow:
                cursor = db.rawQuery("select * from info", null);
                StringBuffer buffer = new StringBuffer();
                if (cursor.moveToFirst()) {
                    do {
                        buffer.append("No:" + cursor.getString(cursor.getColumnIndex("no")) + "\n");
                        buffer.append("Name:" + cursor.getString(cursor.getColumnIndex("name")) + "\n");
                        buffer.append("Mark:" + cursor.getString(cursor.getColumnIndex("marks")));
                    }
                    while (cursor.moveToNext());
                    T(buffer.toString());
                } else {
                    T("Table is empty...");
                }
                break;
        }
    }

    private void clear() {
        edtNo.setText("");
        edtName.setText("");
        edtMark.setText("");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
