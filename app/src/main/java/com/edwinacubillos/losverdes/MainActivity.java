package com.edwinacubillos.losverdes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //final String[] productos = new String[]{"Hamburguesa","Perro","Chuzo","Jugos"};

    private Lista_Entrada[] datos =
            new Lista_Entrada[] {
                    new Lista_Entrada(R.drawable.burguer,10000,"Hamburguesa","Deliciosa hamburguesa"),
                    new Lista_Entrada(R.drawable.perros,12000,"Perros","Perro con todo"),
                    new Lista_Entrada(R.drawable.chuzos,11000,"Chuzos","Delicioso Chuzo"),

                    new Lista_Entrada(R.drawable.jugo,15000,"Jugos","Jugo de fruta en leche")
            };
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /*    ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,productos);*/

        Adapter adaptador = new Adapter(this, datos);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adaptador);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Presiono:"+i,Toast.LENGTH_SHORT).show();
                String nombre = ((Lista_Entrada)adapterView.getItemAtPosition(i)).getNombre();
                Log.d("Producto",nombre);
                if(i==2){
                    Intent intent = new Intent(MainActivity.this,ProductosActivity.class );
                    startActivity(intent);
                }

            }
        });
    }

    class Adapter extends ArrayAdapter<Lista_Entrada>{

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.layout_item, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_item, null);

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdImagen());

            TextView tProducto = (TextView) item.findViewById(R.id.tProducto);
            tProducto.setText(datos[position].getNombre());

            TextView tDescripcion = (TextView) item.findViewById(R.id.tDescripcion);
            tDescripcion.setText(datos[position].getDescripcion());

            TextView tPrecio = (TextView) item.findViewById(R.id.tPrecio);
            tPrecio.setText(String.valueOf(datos[position].getPrecio()));

            return (item);
        }
    }
}
