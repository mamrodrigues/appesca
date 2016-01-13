package br.org.unesco.appesca.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.org.unesco.appesca.R;
import br.org.unesco.appesca.control.QuestaoDetailFragment;
import br.org.unesco.appesca.dao.FormularioDAO;
import br.org.unesco.appesca.model.Formulario;

public class FormCamRegActivityNew extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static Formulario formulario = new Formulario();

    View cabecalhoNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formcamreg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        cabecalhoNavigationView = navigationView.getHeaderView(0);

        //TODO if(insert){
            inicializaFormulario();
        //}else{//TODO Update{

        //}
    }

    public void inicializaFormulario(){
        Date dtCriacaoFormulario = new Date();

        TextView txtDataPesquisa = (TextView) cabecalhoNavigationView.findViewById(R.id.txtDataPesquisa);
        txtDataPesquisa.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dtCriacaoFormulario));

        formulario = new Formulario();
        formulario.setIdTipoFormulario(1);
        formulario.setIdUsuario(1);
        formulario.setDataAplicacao(dtCriacaoFormulario);
        formulario.setNome("Formulário Camarão Regional");
        formulario.setIsEnviado(false);

        FormularioDAO formularioDAO = new FormularioDAO(this);
        formulario = formularioDAO.insertFormulario(formulario);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.b1_q1) {
            Bundle arguments = new Bundle();
            arguments.putString(QuestaoDetailFragment.ARG_ITEM_ID, String.valueOf(R.layout.fcrj_b1_q3));
            QuestaoDetailFragment fragment = new QuestaoDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.questao_detail_container, fragment)
                    .commit();
        }

        //else if (id == R.id.nav_gallery) {

//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {

//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {

//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}