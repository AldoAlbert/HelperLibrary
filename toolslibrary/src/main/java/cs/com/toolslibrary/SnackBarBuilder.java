package cs.com.toolslibrary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;

public class SnackBarBuilder {

    private View parent;
    private Context c;

    public SnackBarBuilder(Context c, View parent){
        this.parent = parent;
        this.c = c;
    }

    private void makeSnackBar(String message){
        Snackbar.make(parent, message, Snackbar.LENGTH_SHORT).show();
    }

    public void buildSnackBar(String message){
        makeSnackBar(message);
    }

    public void buildErrorSnackBar(){
        makeSnackBar(c.getString(R.string.error_generico));
    }

    public void buildNetworkErrorSnackBar(){
        makeSnackBar(c.getString(R.string.error_intenet));
    }

    public void buildCardErrorSnackBar(){
        makeSnackBar(c.getString(R.string.error_procesar_tarjeta));
    }

    public void buildInvalidFilesSnackBar(){
        makeSnackBar(c.getString(R.string.error_archivos_vacios));
    }

    public void buildUnavalibleFilesSnackBar(){
        makeSnackBar(c.getString(R.string.error_archivos_faltantes));
    }

    public void buildLoadingSnackBar(){
        Snackbar bar = Snackbar.make(parent, c.getString(R.string.cargando), Snackbar.LENGTH_INDEFINITE);
        ViewGroup contentLay = (ViewGroup) bar.getView().findViewById(com.google.android.material.R.id.snackbar_text).getParent();
        ProgressBar item = new ProgressBar(c);
        contentLay.addView(item,0);
        bar.show();
    }

}
