package cs.com.toolslibrary

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

import com.google.android.material.snackbar.Snackbar

class SnackBarBuilder {

    private lateinit var c: Context
    private lateinit var parent: View

    constructor(c: Context, parent: View){
        this.c = c
        this.parent = parent
    }

    private fun makeSnackBar(message: String) {
       Snackbar.make(parent, message, Snackbar.LENGTH_SHORT).show()
    }

    fun buildSnackBar(message: String) {
        makeSnackBar(message)
    }

    fun buildErrorSnackBar() {
        makeSnackBar(c.getString(R.string.error_generico))
    }

    fun buildNetworkErrorSnackBar() {
        makeSnackBar(c.getString(R.string.error_intenet))
    }

    fun buildCardErrorSnackBar() {
        makeSnackBar(c.getString(R.string.error_procesar_tarjeta))
    }

    fun buildInvalidFilesSnackBar() {
        makeSnackBar(c.getString(R.string.error_archivos_vacios))
    }

    fun buildUnavalibleFilesSnackBar() {
        makeSnackBar(c.getString(R.string.error_archivos_faltantes))
    }

    /**
     * @return Snackbar with progressBar inside
     */
    fun buildLoadingSnackBar(): Snackbar {
        val bar = Snackbar.make(parent, c.getString(R.string.cargando), Snackbar.LENGTH_INDEFINITE)
        val contentLay = bar.view.findViewById<View>(com.google.android.material.R.id.snackbar_text)?.parent as ViewGroup
        val item = ProgressBar(c)
        contentLay.addView(item, 0)
        return bar
    }

}
