package cs.com.toolslibrary

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

import com.google.android.material.snackbar.Snackbar

class SnackBarBuilder(private val c: Context, private val parent: View) {

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

    fun buildLoadingSnackBar() {
        val bar = Snackbar.make(parent, c.getString(R.string.cargando), Snackbar.LENGTH_INDEFINITE)
        val contentLay = bar.view.findViewById<View>(com.google.android.material.R.id.snackbar_text).parent as ViewGroup
        val item = ProgressBar(c)
        contentLay.addView(item, 0)
        bar.show()
    }

}
